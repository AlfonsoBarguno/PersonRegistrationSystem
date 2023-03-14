# PersonRegistrationSystem

![cover](https://user-images.githubusercontent.com/94359346/224974234-daee636d-e91f-4fdb-ab99-d28883398416.png)

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)

## General info
People registration system build with Java, Gradle, SpringBoot, Bootstrap and Thymeleaf, where you can add, edit and delete person objects and attributes, one of which is a photo file. All these fields are validated. The system can be translated to english, french and catalan. You can browse through differente pages (now is setup for just three entrys).


![Captura de pantalla 2023-03-14 113931](https://user-images.githubusercontent.com/94359346/224975921-c017f235-74e2-400d-acdf-d38503193e6d.png)


There is an easy and intuitive form to save new people:


![Captura de pantalla 2023-03-14 114248](https://user-images.githubusercontent.com/94359346/224976305-cd38334e-7128-4986-890a-49f8a4450bcc.png)


And also has a feature to import a CSV file in zip format to add the information automatically, no matter the number of entrys:


![Captura de pantalla 2023-03-14 114445](https://user-images.githubusercontent.com/94359346/224976899-ed87aa66-54f5-4a7d-ae6f-af244609219a.png)


For this feature you wil have to tweak the parse method in the Person class and the PersonService to adjust the parameters to your needs.


## Technologies
Project is created with:
- Java 18
- Spring Boot
- Gradle
- Hibernate
- Spring Data JPA
- Spring Web
- Spring Boot DevTools
- Bootstrap
- Thymeleaf


	
## Setup
To run this project, download it using the git command *git clone* to the folder you want:
    ```
    C:\User\User> D:
    ```
    ```
    D:\ cd myProject
    ```
    ```
    D:\ myProject>git clone https://github.com/AlfonsoBarguno/PersonRegistrationSystem.git
    ```





## Running locally 
```
localhost:9000/
```
Remember to set the password in application.properties.




### Author
<li><a href="https://github.com/AlfonsoBarguno">Alfonso Barguñó</a></li>
