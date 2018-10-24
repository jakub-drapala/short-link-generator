# short-link-generator

## Technologies:
* Java 8
* Spring Boot 2.0.5
* Hibernate/JPA
* HTML + CSS
* Thymeleaf

## Description:

**If app is running homepage's url is  http://localhost:8080/short-link-generator**

Main goal was obtain similar behavior like many *shorter* which exists on the internet.

On the homepage there is input field, where client can paste any text. After click submit button, web browser will display *short link*. If client use this *short link* as url, he will redirected to url, which has been pasted in input field. 

All necessarry data are stored in database. If client paste link, which already exists in database, he get it from db. If link doesn't exist, he will generated and added to db.

If you want check how new *short links* are created, you need uncomment class *com.drapala.shortlinkgenerator.fillDb.Filler* and then look to database.

## Database:

If app work, database is available in url: http://localhost:8080/h2-console/
