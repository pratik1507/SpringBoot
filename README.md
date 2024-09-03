# SpringBoot
This repository belongs to the spring boot course. 

# Project - 1 : EmployeeApplication ( CRUD Operations )
This project is to understand the basics of CRUD operations and understanding of the different annotations such as @Autowired, @RequestMapping, @RestController, @Controller, @GetMapping, @PostMapping, @PutMapping, @DeleteMapping, @Service . <br> <br>
The APIs included in the project are: <br>
![image](https://github.com/user-attachments/assets/13af6bc4-196b-4cf4-8637-aa22fa4aa936)
<br>
# Project - 2 : EmployeeApplication2 ( H2 - in-memory database ) 
This project is updated EmployeeAplication project in which we connected our application with in-memory database (H2) : <br>
Also in this project we learned about JPA repository and multiple new annotations. <br> <br>
What is in-memory database ? <br>
In-memory database is a database which uses memory to store data as opposed to the disk space. <br><br>
Steps to be followed : <br>
1. Run the application <br>
2. On browser hit the url "http://localhost:8080/h2-console" <br>
3. Change the jdbc url with the url which is given in the application.properties. <br>
4. Add username and password and login. <br>
5. You can see Employee table is already been created there. <br>
6. Now hit the APIs through Postman and observe the changes in the database. <br> <br>

Some reference images : <br> <br>
![image](https://github.com/user-attachments/assets/125f5360-df3c-4943-af2f-37e0e67b38bd)  <br>
![image](https://github.com/user-attachments/assets/c8bd0bd3-3bb0-4f8c-b521-8231bd8037f8)  <br>
![image](https://github.com/user-attachments/assets/8ede2fee-62b1-408a-a8b4-e057ffb33921)  <br>

# Project - 3 : EmployeeApplication3 (Database mapping and Cascading)
This project focuses mainly on Database Mappings and Cascading. The database mapping and cascading concepts are being explained in the form on comments . <br> 
This project is the upadated EmployeeApplication project. <br><br>
The employee creation payload : <br><br>
{
    "employeeName":"1st emp",
    "employeeCity":"Kolhapur",
    "spouse":{
        "name":"First employee spouse",
        "mobno": "9330339272",
        "age":30
    },
    "addresses":[
        {
        "line1":"line1",
        "line2":"line2",
        "zipCode":"zipCode",
        "city":"city",
        "state":"state",
        "country":"country"
        },
        {
        "line1":"line1",
        "line2":"line2",
        "zipCode":"zipCode",
        "city":"city",
        "state":"state",
        "country":"country"
        }
    ],
    "projects":[
        {
            "name":"name1",
            "clientName":"clientName1"
        },
        {
            "name":"name2",
            "clientName":"clientName2"
        }
    ]
}

# Project - 4 : Added Fetch and it's Types :
In this project I have updated the previous EmployeeApplication project and explained the concepts of fetch and it's types ( Eager and Lazy ). <br>
Please look at the Bean meathod added in EmployeeApplication class also check for the code written in application.properties to see the sql query in the console.

