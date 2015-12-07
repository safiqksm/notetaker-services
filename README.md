Spring Boot App. Simple note taker web service. RESTful API's to retrieve all notes, add a new one and delete existing one. There is no security as of now. Simply run the Boot app and use curl to interact with the RESTful API (JSON payload).

# Pre-Requsites (do this only once)
## Run a local Eureka Service Registry
Retrieve a copy of the Eureka server project and run that localy to stand up a local instance.
    git clone https://github.com/thomasma/eureka-service-registry
    mvn clean spring-boot:run
    http://localhost:8761
    http://localhost:8761/eureka/apps (XML feed from Eureka)

## Run a local Hysterix Dashboard
Retrieve a copy of the hystrix-dashboard sample server project and run that localy to stand up a local server.
    git clone https://github.com/spring-cloud-samples/hystrix-dashboard.git
    mvn clean spring-boot:run
    From your browser go to http://localhost:7979/

## To run the app
Download and run Mongodb. 
    mongod --dbpath ~/data/mongodata/

# Run Application
Run this API application using
    mvn spring-boot:run

## Interact with app using curl
### Add new note
    curl http://localhost:8080/notes/add -X POST -d '{"message":"note1", "createdOnDate": "01/01/2015"}' -H "Content-Type: application/json"

### Get all notes
    curl -XGET  http://localhost:8080/notes/

### Delete a note. Replace {noteid} with the actual id.
    curl -XDELETE  http://localhost:8080/notes/{noteid}

## Actuator endpoint
    curl http://localhost:8080/health 
    curl http://localhost:8080/env
    curl http://localhost:8080/info
    curl http://localhost:8080/metrics
    
