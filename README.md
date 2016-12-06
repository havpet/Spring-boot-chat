# Spring-boot-chat
A chat application made using Spring Boot. Currently made to compile with Maven.
## Features
* One chatroom, unlimited number of participants
* Users need to register and log in
* Chatting happens in realtime using sockets in Javascript
* Some built-in features of Spring Boot like metrics
## Implementation
* Repositories with entities as models
* Data connection with JPA
* Standard web controllers
* View controllers
* Thymeleaf as view framework
## How to run
* Compile the application with Maven in IntelliJ or other IDE
* Setup a SQL database and change settings in application.properties in src/main/resources
* Import JDBC driver into the project
* All tables are created automatically when the application starts
* Access the application at http://localhost:8080/ (if using IntelliJ)
