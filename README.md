# Doodle coding challenge

### Motivation behind technology choices

- Spring Boot: I've chosen this framework as it is mainly used for easy and rapid creation of functional and running 
microservices. Everything that Spring encapsulates fastens the development process (especially for POC like projects).
Beside that, I wanted to recall my knowledge of spring, as I haven't used it in last few years.
- MongoDB: I decided to use this NoSQL database because of the given data format. As the data format is json, it was 
easier and faster to implement the service using NoSQL database instead of the relational one.

### Task tackling

When I got the text of the assignment, I was thinking about technologies I am about to use for the task solution.
As stated in the section above, I decided to go with Spring Boot and MongoDB.
The first step in service development was creating dummy application which would be runnable and which would have one 
dummy endpoint. 
When I finished with setup, I switched to data loading. In this step, I temporarily added embedded MongoDB to be 
able to test the data loading more easily. Once I implemented the data loading, I replaced dummy endpoint with the one 
that, in fact, returns what was expected. There I ran into a problem - I was getting the exceptions when I tried to 
filter polls by some of the given parameters. After little research, I found out that the MongoDB indices have to be 
  initialized on application startup. When I figured it out and fixed it, finding the polls started working as it should.
In that point I had the application that is runnable and works what it needs to, but with the embedded db. So, the 
logical next step was to replace the embedded MongoDB with the one ran as Docker container. And, after extracting 
MongoDB, the application itself had to be dockerized. The application dockerizing took me a little more than I expected - it 
turned out that the order of maven plugins was not correct (spring-boot-maven-plugin was executed after 
dockerfile-maven-plugin, so Main-Class was not in the MANIFEST from Docker image's jar) and I learned it the hard way :)
Once I wriggled out of it, I added API documentation and implemented pagination.

### If I had more time, I would...

- Make certain classes more testable
- Focus on testing - both unit, and integration
- Implement authentication and authorization
- Document every single field used in API
- Try out Spring Data REST

## Running the application

#### Prerequisites

- maven
- docker 

#### Steps to run

- mvn install -P docker-build
- docker-compose up -d

#### REST endpoints

```
Find the polls by given attributes
GET http://localhost:8080/api/1/polls?fromDate=2016-01-27&title=Marvel
```

#### API documentation

Swagger documentation can be found here:

```
http://localhost:8080/swagger-ui.html
```


##### Postman collection

Postman collection is located under the project's root.