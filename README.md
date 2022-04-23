# mail-notification-telegram-bot
Telegram Bot for mail notifications implemented with java spring boot, Telegram Bot API and SMTP

# Tools & Tech Used
  * Spring Boot - 2.2.2.RELEASE
  * JDK - 1.8 
  * Maven - 3.6.3
  * Code Editor - Visual Studio Code (with Spring Boot plug-in)
  * PostgreSQL - 9.3
  * pgAdmin-1.18
  
# Database Configuration
  1. Download and install PostgreSQL - 9.3. Put "postgres" as username and password
  1. Create database with name botdb in PostgreSQL and restore botdb.backup on it. 
  1. Take a look at src/main/resource/application.propperties file. It should has next properties: 
    1. spring.propspring.datasource.driver-class-name=org.postgresql.Driver
    1. spring.datasource.url=jdbc:postgresql://localhost:5432/botdb
    1. spring.datasource.username=postgres
    1. spring.datasource.password=postgres
  
# Running the project
   1. Download and install maven 
   1. Download and install jdk 1.8 
   1. Open console on path of pom.xml file for downloading dependencies with maven. Use command "mvn clean install". 
   Then command "mvn package"
   1. cd on /target/ folder and  use command "java -jar telegrambot-0.0.1-SANPSHOT.war"
   1. open http://localhost:8080. You can authenticate with user "dbadmin" and password "123". It's not needed for interacting with Bot
   
# Interaction with bot 
  Open http://t.me/mail_notification_bot in your browser and write anything. You will get a reply
   



