# RESTfull API TEST

#Technology Stack
The project uses the following technologies: <br/>
- **Java Version**: 1.8
- **web/REST**: [Spring](http://www.springsource.org/) 4.3.11 <br/>
- **persistence**: [Spring Data JPA](http://www.springsource.org/spring-data/jpa) and [Hibernate](http://www.hibernate.org/) <br/>
- **persistence providers**: MySQL
- **Dependency Management**:[Maven](https://maven.apache.org/) 

# Quick Start
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.
## Getting and running the app
Creating database, user with password in MySql console:
```
CREATE DATABASE technodom;
CREATE USER 'technodom'@'localhost' IDENTIFIED BY 'technodom123';
GRANT ALL PRIVILEGES * . * TO 'technodom'@'localhost';

```
Get the app and run:
```
git clone https://github.com/ardak90/userapp.git
mvn tomcat7:run
```
Path:
```
http://localhost:8080/userapp

```
#REST API

**ADD USER**
----
  Returns json data of created user.

* **URL**

  users/user/ 

* **Method:**

  `POST`
  
*  **URL Params**

   None

* **Data Params**
  Json Data
  {"personalId":"ardak90", "name":"Ardak", "email":"ardak90@gmail.com", "imageUrl":"eminem.jpg"}

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** ` {"id": 3, "personalId":"ardak90", "name":"Ardak", "email":"ardak90@gmail.com", "imageUrl":"eminem.jpg"}`
 
* **Error Response:**

  * **Code:** 400 BAD REQUEST <br />
  
**GET USER BY ID**
----
  Returns json data about a single user.

* **URL**

  users/user/{userId}

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:**
    
                `userId=[String]`

* **Data Params**
  
                None
  
* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{
                      "id": 3,
                      "personalId": "ardak90",
                      "name": "Ardak",
                      "email": "ardak90@gmail.com",
                      "imageUrl": "eminem.jpg"
                  }`
 
* **Error Response:**

  * **Code:** 400 BAD REQUEST <br />
   **Content:** `{ "User not found" }`

**SET STATUS OF USER BY ID**
----
  Returns json data about created status and previous status of a user.

* **URL**

  status/{status}/{userId}

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:**
    
                `status=[String]`     online/offline
                `userId=[String]` 

* **Data Params**
  
                None
  
* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{
                      "id": 3,
                      "createdDate": 1506501043839,
                      "condition": "ONLINE",
                      "userDto": {
                          "id": 1,
                          "personalId": "shady90",
                          "name": "Ardak",
                          "email": "ardak90@gmail.com",
                          "imageUrl": "eminem.jpg"
                      },
                      "previousStatus": {
                          "id": 2,
                          "createdDate": 1506494556000,
                          "condition": "ONLINE",
                          "userDto": {
                              "id": 1,
                              "personalId": "shady90",
                              "name": "Ardak",
                              "email": "ardak90@gmail.com",
                              "imageUrl": "eminem.jpg"
                          },
                          "previousStatus": null
                      }
                  }`
 
* **Error Response:**

  * **Code:** 400 BAD REQUEST <br />
   **Content:** `{"Something Wrong. User not found or u gave wrong status"}`

**GET LIST OF STATUSES BY STATUS(ONLINE/OFFLINE)**
----
  Returns json list of statuses and users by online/offline condition.

* **URL**

  status/{status}/

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:**
    
                `status=[String]`     online/offline
                 
* **Data Params**
  
                None
  
* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `[
                      {
                          "id": 3,
                          "createdDate": 1506501043000,
                          "condition": "ONLINE",
                          "userDto": {
                              "id": 1,
                              "personalId": "shady90",
                              "name": "Ardak",
                              "email": null,
                              "imageUrl": null
                          },
                          "previousStatus": null
                      },
                      {
                          "id": 2,
                          "createdDate": 1506494556000,
                          "condition": "ONLINE",
                          "userDto": {
                              "id": 1,
                              "personalId": "shady90",
                              "name": "Ardak",
                              "email": null,
                              "imageUrl": null
                          },
                          "previousStatus": null
                      }
                  ]`
 
* **Error Response:**

  * **Code:** 400 BAD REQUEST <br />
   **Content:** `{"Nothind found"}`

**GET ALL STATUSES**
----
  Returns json list of statuses and users(online and offline).

* **URL**

  status/

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:**
    
                None
                 
* **Data Params**
  
                None
  
* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `[
                      {
                          "id": 3,
                          "createdDate": 1506501043000,
                          "condition": "ONLINE",
                          "userDto": {
                              "id": 1,
                              "personalId": "shady90",
                              "name": "Ardak",
                              "email": null,
                              "imageUrl": null
                          },
                          "previousStatus": null
                      },
                      {
                          "id": 2,
                          "createdDate": 1506494556000,
                          "condition": "OFFLINE",
                          "userDto": {
                              "id": 1,
                              "personalId": "shady90",
                              "name": "Ardak",
                              "email": null,
                              "imageUrl": null
                          },
                          "previousStatus": null
                      }
                  ]`
 
* **Error Response:**

  * **Code:** 400 BAD REQUEST <br />
   **Content:** `{"Nothind found"}`
