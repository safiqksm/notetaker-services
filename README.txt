Spring Boot App. Simple note taker web service. RESTful API's to retrieve all notes, add a new one and delete existing one.

There is no security as of now. Simply run the Boot app and use curl to interact with the RESTful API (JSON payload).

# To run the app
mvn spring-boot:run

# Add new note from command line
curl http://localhost:8080/notes/add -X POST -d '{"message":"note1", "createdOnDate": "01/01/2015"}' -H "Content-Type: application/json"

# Get all notes
curl -XGET  http://localhost:8080/notes/

# Delete a note. Replace {noteid} with the actual id.
curl -XDELETE  http://localhost:8080/notes/{noteid}

# Actuator endpoint
curl http://localhost:8081/health 
curl http://localhost:8081/env
curl http://localhost:8081/info
curl http://localhost:8081/metrics
