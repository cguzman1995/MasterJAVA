# Dice Roller

A RESTful service built using [Spring Boot](https://spring.io/projects/spring-boot) that mimics the rolling of Logacta dice when determining the outcome of a football game.

To build and run the service locally via [Maven](https://maven.apache.org/):

    mvn spring-boot:run &

This builds a jar file and then launches the basic service, by default accessible on port 9001.

## Sample dice-rolling commands using `curl`
A series of GET endpoints are included, each representing the roll of a specific Logacta dice:

    curl localhost:9001/dice/roll

## Actuator-based commands using curl
The health endpoint has been made visible to allow you to determine if the service is active and reachable.

    curl localhost:9001/actuator/health

## Docker
A Dockerfile has been created and can be run locally: 

    docker build -t dice-roller .

    docker run -d -p 9001:9001 dice-roller

A Github actions file packages the image and stores it within an ECR repository. 
