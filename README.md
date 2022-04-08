
## Requirements

Building the person service:
1. Java 11+
2. Gradle

## Installation
#These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

1)Copy the project from git repository - https://github.com/liza-seledtsova/citizen-person-service.git

2)To run the application, run the following command in a terminal window (in the complete) directory:

```
```
//Build the project with Gradle
gradle bootJar
```
```
//Run the project
cd build/distribution/bin
start.sh
```
```
//Run the project with "java" command
cd build/distribution/libs
java -jar access-provider-{app-version}.jar --port=8081
``
3)Open swagger ui - http://localhost:8081/swagger-ui/index.html#/person-controller/getPersonsFiltered

 
 
## Documentation for API Endpoints


Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*PersonService* | [**getAllPerson**](gen/docs/PersonApi.md#getAllPerson) | **GET** /person | Get all person and generate filter data for providing sorting and/or filtering entry
*PersonService* | [**getPersonsFiltered**](gen/docs/PersonApi.md#getPersonsFiltered) | **POST** /person | The sorting and/or filtering options person data


## Documentation for Models

 - [Address](gen/docs/Address.md)
 - [City](gen/docs/City.md)
 - [Country](gen/docs/Country.md)
 - [FilterDataDto](gen/docs/FilterDataDto.md)
 - [FilterDto](gen/docs/FilterDto.md)
 - [ModelApiResponse](gen/docs/ModelApiResponse.md)
 - [Person](gen/docs/Person.md)
 - [State](gen/docs/State.md)

## Future improvements
<ul>
  <li>Create NoSql Database(MongoDb, ELK) to improve the efficiency of filtering nested objects.</li>
  <li>Generate a filterName from entity </li>
  <li>Decompose creteria and spefication to various iterfaces</li>
<ul>
