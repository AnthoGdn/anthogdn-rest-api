# AnthoGdn API
Its a simple API with Spring Boot and Spring Data JPA. 
## Getting Started
### Requirements
* Mysql

You should create one user in your database. Execute this command : 
```sh
$ mysql -u root -p < src/main/resources/db/anthogdn.sql
```
or change configuration in `src/main/resources/application.properties` 
### Building the project
Execute this commande in the root directory to build maven project.
```sh
$ mvn clean install
```
### Deploy the project
Execute this commande in the root directory to deploy Spring Boot project.
```sh
$ mvn spring-boot:run
```
Navigate to [http://localhost:8080](http://localhost:8080)

## Contributor
* Anthony GODIN <gdn.anthony@gmail.com>