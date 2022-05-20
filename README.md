# javapro18_team_backend
Дипломный проект группы 18 Skillbox 

Основные участники со строны бэка:
<a href="https://github.com/Shkiller">Shkiller</a>
<a href="https://github.com/Folko85">Folko85</a>
<a href="https://github.com/KronCosta">KronCosta</a>
<a href="https://github.com/Brosha">Brosha</a>
<a href="https://github.com/Artemk70">Artemk70</a>
 
 Что это:

Я являлся участником команды по разработке социальной сети под руководством тимлида. Работа велась в Gitlab. Для взаимодействия используются ежедневные онлайн-встречи, VCS Git и Swagger. Нашей задачей было создать backend-составляющую приложения. Решение – используется архитектурный стиль REST, а само приложение реализуется с помощью Spring Boot Framework. Моё участие: написание сущностей; создание миграций БД с помощью Liquibase; написание контроллеров, сервисов к ним, response- и request-классов для функционирования методов контроллеров; написание тестов к контроллерам и сервисам; работа с Docker; настройка и работа SocketIO.
 
Как это посмотреть:  
**mvn clean package** - чтобы сбилдить jar-файлы(модуль microservice может долго билдится,  
так как под капотом идёт загрузка библиотек с помощью npm)  
**docker-compose up -d** - чтобы проект поднялся  
(P.S. Обычно поднимается долго, так как контейнеры зависят друг от друга.  
Нужно дождаться загрузки проекта cloud-config) 
Для полноценного использования Графаны нужно дополнительно _обработать её напильником_, 
а именно - Добавить источники данных: 
Prometheus по адресу http://prometheus:9090 
Loki по адресу http://loki:3100 
а также импортировать панели из папки scripts/dashboard  
**Россыпь технологий:** 
Spring Boot, Spring Security, Spring Cloud Config, Hibernate, Liquibase,  
RabbitMQ, Redis, SocketIO, Vaadin, Junit, Grafana, Prometheus, Loki, Promtail,  
Lombok, Docker Compose, Maven  

ToDo:
1. Сделать шедулер для периодической очистки сессий в редисе  
2. <s>Убрать вторую базу mySQL (пусть данные хранятся в mongoDB)</s>
3. Добавить в проект кафку для обратного ответа от микросервиса  
4. Увеличить покрытие тестами
