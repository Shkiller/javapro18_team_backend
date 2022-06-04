package com.skillbox.socialnetwork.controller;

import com.skillbox.socialnetwork.AbstractTest;
import com.skillbox.socialnetwork.NetworkApplication;
import com.skillbox.socialnetwork.api.request.DialogRequest;
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
import java.util.List;
import java.util.Set;

@SpringBootTest(classes = {NetworkApplication.class})
public class DialogControllerTest extends AbstractTest {


    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private DialogRepository dialogRepository;

    @Autowired
    private Person2DialogRepository person2DialogRepository;

    Person person1;
    Person person2;

    @BeforeEach
    public void setup() {
        super.setup();
        person1 = getPerson("user", "test@test.ru");
        person2 = getPerson("user2", "test2@test.ru");
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


        Dialog dialog = new Dialog();
        dialog.setTitle("new title");
        dialog = dialogRepository.save(dialog);

        Person2Dialog person2Dialog1 = new Person2Dialog();
        person2Dialog1.setPerson(person1).setDialog(dialog);
        person2DialogRepository.save(person2Dialog1);
        Person2Dialog person2Dialog2 = new Person2Dialog();
        person2Dialog2.setDialog(dialog).setPerson(person2);
        person2DialogRepository.save(person2Dialog2);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/dialogs")
                        .principal(() -> "test@test.ru")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.total").value(1));

    }

    @Test
    @WithMockUser(username = "test@test.ru", authorities = "user:write")
    void testPostDialog() throws Exception {
        DialogRequest dialogRequest = new DialogRequest();
        dialogRequest.setUsersIds(List.of(2));
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/v1/dialogs")
                        .principal(() -> "test@test.ru")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(dialogRequest))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.recipient_id.id").value(2));
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
