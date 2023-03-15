# PersonRegistrationSystem

![cover](https://user-images.githubusercontent.com/94359346/224974234-daee636d-e91f-4fdb-ab99-d28883398416.png)

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)

## General info
People registration system build with Java, Gradle, SpringBoot, Bootstrap and Thymeleaf, where you can add, edit and delete person objects and attributes, one of which is a photo file. You can browse through differente pages (now is setup for just three entrys/page). There is an easy and intuitive form to save new people.



![Captura de pantalla 2023-03-15 150330](https://user-images.githubusercontent.com/94359346/225333115-2c9f9908-c942-44fb-a8ae-bcb5fb27fddc.png)



All these fields are validated according to certain conditions:


![Captura de pantalla 2023-03-15 150642](https://user-images.githubusercontent.com/94359346/225333824-c38458cd-f9be-4f01-a3d5-ac0f1da4deb3.png)


The system adapts the currency depending on the country and can be translated to english, french and catalan. Ex:


![Captura de pantalla 2023-03-15 151506](https://user-images.githubusercontent.com/94359346/225336126-a68829ca-18ea-4cf4-aeb1-dea1ce311fda.png)


 And also has a feature to import a CSV file in zip format to add the information automatically, no matter the number of entrys. For this feature you will have to tweak the parse method in the Person class and the PersonService to adjust the parameters to your needs.

![Captura de pantalla 2023-03-15 151636](https://user-images.githubusercontent.com/94359346/225336694-6775d3ab-cc43-468d-b6e3-a38a90d356a2.png)


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
