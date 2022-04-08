
## Requirements

Building the person service:
1. Java 1.7+
2. Gradle

## Installation
1)Cloning a repository - https://github.com/liza-seledtsova/citizen-person-service.git

2)To run the application, run the following command in a terminal window (in the complete) directory:

```shell
./gradlew bootRun
```
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
  <li>-Create NoSql Database(MongoDb, ELK) to improve the efficiency of filtering nested objects.</li>
  <li>-Generate a filterName from entity </li>
  <li>-Decompose creteria and spefication to various iterfaces</li>
  <li>-Add validation inputDate</li>
  <li>-Generate messages in responce based on the type of error</li>
<ul>
