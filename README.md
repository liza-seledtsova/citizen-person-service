
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
*PersonApi* | [**getAllPerson**](docs/PersonApi.md#getAllPerson) | **GET** /person | Get all person and generate filter data for providing sorting and/or filtering entry
*PersonApi* | [**getPersonsFiltered**](docs/PersonApi.md#getPersonsFiltered) | **POST** /person | The sorting and/or filtering options person data


## Documentation for Models

 - [Address](docs/Address.md)
 - [City](docs/City.md)
 - [Country](docs/Country.md)
 - [FilterDataDto](docs/FilterDataDto.md)
 - [FilterDto](docs/FilterDto.md)
 - [ModelApiResponse](docs/ModelApiResponse.md)
 - [Person](docs/Person.md)
 - [State](docs/State.md)

