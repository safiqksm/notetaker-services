#
# To run the app
mvn spring-boot:run

#
# Add new note from command line
curl http://localhost:8080/notes/add -X POST -d '{"message":"note1", "createdOnDate": "01/01/2015"}' -H "Content-Type: application/json"


# Actuator endpoint
curl http://localhost:8081/health 
curl http://localhost:8081/env
curl http://localhost:8081/info
curl http://localhost:8081/metrics
