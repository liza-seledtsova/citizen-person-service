
## Requirements

Building the person service:
1. Java 1.7+
2. Gradle

## Installation
At first generate the JAR by executing:

```shell
```

Then manually install the following JARs:
 
 
## Documentation for API Endpoints

All URIs are relative to *http://localhost/person.swagger.io/v1*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*PersonApi* | [**getAllPerson**](gen/docs/PersonApi.md#getAllPerson) | **GET** /person | Get all person and generate filter data for providing sorting and/or filtering entry
*PersonApi* | [**getPersonsFiltered**](gen/docs/PersonApi.md#getPersonsFiltered) | **POST** /person | The sorting and/or filtering options person data


## Documentation for Models

 - [Address](gen/docs/Address.md)
 - [City](gen/docs/City.md)
 - [Country](gen/docs/Country.md)
 - [FilterDataDto](gen/docs/FilterDataDto.md)
 - [FilterDto](gen/docs/FilterDto.md)
 - [ModelApiResponse](gen/docs/ModelApiResponse.md)
 - [Person](gen/docs/Person.md)
 - [State](gen/docs/State.md)

