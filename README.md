# Spring MVC Movie Ranker App
This project aims to demonstrate the development process of Spring Framework (a powerful, feature-rich Java framework) and Hibernate (Java Persistence API), by building a simple MVC application.

At its core, it is simply a table displaying records of Movies and their ranking (in descending order) according to a ranking - assigned by the user, which is defined between 0 and 100. The user can visualize the records ranked by Ranking, they can add new records, edit existing records and delete them as well.

Although the app is simple, there are many features of MVC applications at play.

## Features
### On the Front End:
* Creation of Models inside the view with the Create action to add records
* Displaying of Model data within the Views

### On the Back End:
* Spring Core, Spring WebMVC, Hibernate, MySQL dependencies added via Maven
* Spring/Hibernate annotation-driven development during the proof of concept
* Added beans in servlet.xml to pipeline the project with the database
* Creation of relevant actions for GET and POST scenarios (Add, Update, Delete)
* The use of Add, Update and Delete to impact records in the database in the respective actions within the `Movie Controller`
* Implemented design patterns like Abstract Factory Method, Service Layer Pattern, MVC

### Screenshots:
![list](https://user-images.githubusercontent.com/123747958/219455927-3f8ccf2c-b9d0-4fc7-ae18-d34b17c381b3.png)

![save_movie](https://user-images.githubusercontent.com/123747958/219456015-4d6ea43b-13c7-4753-9297-42f5dfbcc865.png)
