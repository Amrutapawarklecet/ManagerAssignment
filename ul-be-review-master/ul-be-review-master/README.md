# Assignment for java backend engineer

Thanks for taking your time to complete our coding assignment.

Please commit and push your solution when you finish.

We hope you will enjoy this assignment and should you have any questions please reach out to us.

## Purpose

The main purpose of the assignment is to test practical skills of designing, coding, testing and building java applications.

## Requirements

* The assignment should be completed in around 4 hours
  *  if you are running out of time, please add comments in README file where you can describe the steps that you were planning to do in order to complete the assignment.

* Preferred technology stack:
  * Java 11
  * Spring Boot
  * JUnit 5  
  * Maven

* The application should be covered with unit tests and api endpoint tests

* The application should run with a single command

* For simplicity use an in-memory database

* Provide documentation of the implemented functionality and instructions on how to run the application (consider adding javadocs and editing this README file)

* Do this assignment on your own

* Do not disclose any detail of this assignment

## Assignment

Implement an application which represents basic project management flow. It will store all records in database (preferably in-memory
database).

**Project** model should be used when implementing endpoints. Project status can be *IN_PROGRESS* or *FINISHED*.


```
Long id;
String name;
StatusEnum status;
LocalDateTime dateCreated;
boolean archived;
```


### Endpoints

The following table describes the endpoints that should be implemented.



|Endpoint|Description|Request body|Response body|
|--------|-----------|------------|-------------|
|POST /projects|Create new project|```{"name":"test", "status":"IN_PROGRESS"}```|```{"id": "234", "name": "test", "status":"IN_PROGRESS", "dateCreated":"2021-08-03T17:33", "archived":false}```
|GET /projects|Get all projects that are NOT archived| |```[{"id":"234", "name":"test", "status":"IN_PROGRESS", "dateCreated":"2021-03-16T17:33", "archived":false}, {"id":"112", "name":"demo", "status":"FINISHED", "dateCreated":"2021-02-23T11:32", "archived":false}]```|
|PUT /projects/{id}|Archive project| |```{"id":"234", "name":"test", "status":"IN_PROGRESS", "dateCreated":"2021-03-16T17:33", "archived":true}```|


Thanks again for your interest and good luck!
