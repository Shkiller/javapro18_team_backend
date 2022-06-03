package com.skillbox.socialnetwork.controller;

import com.skillbox.socialnetwork.AbstractTest;
import com.skillbox.socialnetwork.NetworkApplication;
import com.skillbox.socialnetwork.entity.Dialog;
import com.skillbox.socialnetwork.entity.Person;
import com.skillbox.socialnetwork.entity.Person2Dialog;
import com.skillbox.socialnetwork.repository.DialogRepository;
import com.skillbox.socialnetwork.repository.Person2DialogRepository;
import com.skillbox.socialnetwork.repository.PersonRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest(classes = {NetworkApplication.class})
public class DialogControllerTest extends AbstractTest {


    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private DialogRepository dialogRepository;

    @Autowired
    private Person2DialogRepository person2DialogRepository;


    @BeforeEach
    public void setup() {
        super.setup();
    }

    @AfterEach
    public void cleanup() {
        dialogRepository.deleteAll();
        person2DialogRepository.deleteAll();
        personRepository.deleteAll();
    }

    @Test
    @WithMockUser(username = "test@test.ru", authorities = "user:write")
    void testGetDialogs() throws Exception {
        Person person1 = getPerson("user", "test@test.ru");
        Person person2 = getPerson("user2", "test2@test.ru");

        Dialog dialog = new Dialog();
        dialog.setTitle("new title");
        dialog = dialogRepository.save(dialog);
        dialog.setPersons(Set.of(person1, person2));

        Person2Dialog person2Dialog1 = new Person2Dialog();
        person2Dialog1.setPerson(person1).setDialog(dialog);
        person2DialogRepository.save(person2Dialog1);
        Person2Dialog person2Dialog2 = new Person2Dialog();
        person2Dialog2.setDialog(dialog).setPerson(person2);
        person2DialogRepository.save(person2Dialog2);
        dialogRepository.save(dialog);


        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/dialogs")
                        .principal(() -> "test@test.ru")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.total").value(1));

    }

    private Person getPerson(String firstName, String email) {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setEMail(email);
        person.setPassword("password");
        person.setDateAndTimeOfRegistration(LocalDateTime.now().minusDays(5));
        person.setLastOnlineTime(LocalDateTime.now().minusDays(3));
        return personRepository.save(person);

    }

}
