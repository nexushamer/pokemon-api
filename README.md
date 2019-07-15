POKEMON API
==========================================

The service is implemented in Java using Spring Boot, Data and Docker with DynamoDB
The implementation is exposing a REST API.


Technologies
------------

- Java 8
- Spring Boot
- Spring Data
- Docker

How To Compile
--------------

This must be done inside the following projects:
 - pokedex

The service can be compiled with:
```
gradlew clean build
```

How To Run
----------

You must run the command in the IT folder

Run the following command
```
sh start.sh
```

How To Test
----------

The service can be tested with Postman or any Rest client, the endpoints of the service are the following:

http://localhost:DynamicPorFromDocker/pokedex/pokemon
