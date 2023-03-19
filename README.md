# Blog Application
This is a Spring Boot application built with Spring Security, Spring MVC, MySQL, and Thymeleaf. The application allows users to create, read, update, and delete blog posts, as well as log in/out.

## Prerequisites
* Java 17 or higher
* Maven
* MySQL

## Getting Started
1. Clone the repository to your local machine.
2. Open the application.properties file and configure the MySQL database settings according to your environment.
4. Run the 'BlogApplication.java'
5. Open a web browser and navigate to http://localhost:8080 to access the application.
6. Log in as a BLOGGER using 'john' and 'password123' or as a READER using 'susan' and 'password123'

## Features
* **Login:** Users can log in/out.
* **Create, Read, Update, Delete Posts:** Logged-in users can create new posts, view existing posts, edit posts they have created, and delete posts they have created.
* **Role-based Access Control:** Users with the BLOGGER authority can create, read, update, and delete all posts, while users with the READER authority can only view posts.

## Architecture
The application is built using the Spring MVC architecture with the following components:

* **Model:** This component contains the classes that represent the data of the application. It includes entities for the blog posts and user details.
* **View:** This component contains the Thymeleaf templates that render the HTML pages for the user interface.
* **Controller:** This component contains the classes that handle HTTP requests and responses. It interacts with the service layer to retrieve data and returns the appropriate view to the user.

In addition, the application has the following layers:

* **Repository Layer:** This layer contains interfaces that define the CRUD operations for the blog posts and user details. It interacts with the database through JPA.
* **Service Layer:** This layer contains classes that implement the business logic of the application. It interacts with the repository layer to perform CRUD operations and returns data to the controller layer.

## Technologies Used
* Spring Boot
* Spring Security
* Spring MVC
* MySQL
* Thymeleaf
* Maven

## Credits
The HTML and CSS template used in this project was obtained from html5up.net.
