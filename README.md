
## The REST-ful web service with CRUD, filter, sort anf groping operation.

## Requirements

Building the person service:
1. Java 11+
2. Gradle 7.3+

## Installation
### These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

#### 1) Copy the project from git repository - https://github.com/liza-seledtsova/citizen-person-service.git

#### 2) To run the application, run the following command in a terminal window (in the complete) directory:

```
//Build the project with Gradle

gradle bootJar
```

```
//Run the project with "java" command

cd build//libs

java -jar citizen-person-service-0.0.1-SNAPSHOT.jar --port=8081
```
#### 3) Open swagger ui - http://localhost:8081/swagger-ui/index.html#/person-controller/getPersonsFiltered



## Documentation for API Endpoints

All URIs are relative to *http://localhost:8081*

Class | Method                                                             | HTTP request | Description
------------ |--------------------------------------------------------------------| ------------- | -------------
*OpenapiClient::AddressApi* | [**create_address**](gen/docs/AddressApi.md#create_address)        | **POST** /api/v1/address |
*OpenapiClient::AddressApi* | [**delete_address**](gen/docs/AddressApi.md#delete_address)            | **DELETE** /api/v1/address/{addressId} |
*OpenapiClient::AddressApi* | [**get_address_by_id**](gen/docs/AddressApi.md#get_address_by_id)      | **GET** /api/v1/address/{addressId} |
*OpenapiClient::AddressApi* | [**get_all_address**](gen/docs/AddressApi.md#get_all_address)          | **GET** /api/v1/address |
*OpenapiClient::AddressApi* | [**update_address**](gen/docs/AddressApi.md#update_address)            | **PUT** /api/v1/address |
*OpenapiClient::CityApi* | [**create_city**](gen/docs/CityApi.md#create_city)                     | **POST** /api/v1/city |
*OpenapiClient::CityApi* | [**delete_city**](gen/docs/CityApi.md#delete_city)                     | **DELETE** /api/v1/city/{cityId} |
*OpenapiClient::CityApi* | [**get_all_city**](gen/docs/CityApi.md#get_all_city)                   | **GET** /api/v1/city |
*OpenapiClient::CityApi* | [**get_city_by_id**](gen/docs/CityApi.md#get_city_by_id)               | **GET** /api/v1/city/{cityId} |
*OpenapiClient::CityApi* | [**update_city**](gen/docs/CityApi.md#update_city)                     | **PUT** /api/v1/city |
*OpenapiClient::CountryApi* | [**create_country**](gen/docs/CountryApi.md#create_country)            | **POST** /api/v1/country |
*OpenapiClient::CountryApi* | [**delete_country**](gen/docs/CountryApi.md#delete_country)            | **DELETE** /api/v1/country/{countyId} |
*OpenapiClient::CountryApi* | [**get_all_country**](gen/docs/CountryApi.md#get_all_country)          | **GET** /api/v1/country |
*OpenapiClient::CountryApi* | [**get_country_by_id**](gen/docs/CountryApi.md#get_country_by_id)      | **GET** /api/v1/country/{countryId} |
*OpenapiClient::CountryApi* | [**update_country**](gen/docs/CountryApi.md#update_country)            | **PUT** /api/v1/country |
*OpenapiClient::PersonApi* | [**create_person**](dgen/ocs/PersonApi.md#create_person)               | **POST** /api/v1/persons |
*OpenapiClient::PersonApi* | [**delete_person**](gen/docs/PersonApi.md#delete_person)               | **DELETE** /api/v1/persons/{personsId} |
*OpenapiClient::PersonApi* | [**get_all_persons**](gen/docs/PersonApi.md#get_all_persons)           | **GET** /api/v1/persons |
*OpenapiClient::PersonApi* | [**get_person_by_id**](gen/docs/PersonApi.md#get_person_by_id)         | **GET** /api/v1/persons/{personsId} |
*OpenapiClient::PersonApi* | [**get_persons_filtered**](gen/docs/PersonApi.md#get_persons_filtered) | **POST** /api/v1/persons/filter |
*OpenapiClient::PersonApi* | [**update_person**](gen/docs/PersonApi.md#update_person)               | **PUT** /api/v1/persons |
*OpenapiClient::StateApi* | [**create_state**](gen/docs/StateApi.md#create_state)                  | **POST** /api/v1/state |
*OpenapiClient::StateApi* | [**delete_state**](gen/docs/StateApi.md#delete_state)                  | **DELETE** /api/v1/state/{stateId} |
*OpenapiClient::StateApi* | [**get_all_state**](gen/docs/StateApi.md#get_all_state)                | **GET** /api/v1/state |
*OpenapiClient::StateApi* | [**get_state_by_id**](gen/docs/StateApi.md#get_state_by_id)            | **GET** /api/v1/state/{stateId} |
*OpenapiClient::StateApi* | [**update_state**](gen/docs/StateApi.md#update_state)                  | **PUT** /api/v1/state |


## Documentation for Models

- [OpenapiClient::Address](gen/docs/Address.md)
- [OpenapiClient::AddressDto](gen/docs/AddressDto.md)
- [OpenapiClient::City](gen/docs/City.md)
- [OpenapiClient::CityDto](gen/docs/CityDto.md)
- [OpenapiClient::Country](gen/docs/Country.md)
- [OpenapiClient::CountryDto](gen/docs/CountryDto.md)
- [OpenapiClient::ErrorMessage](gen/docs/ErrorMessage.md)
- [OpenapiClient::FilterDataDto](gen/docs/FilterDataDto.md)
- [OpenapiClient::FilterDto](gen/docs/FilterDto.md)
- [OpenapiClient::PageImplPerson](gen/docs/PageImplPerson.md)
- [OpenapiClient::Pageable](gen/docs/Pageable.md)
- [OpenapiClient::PageableObject](gen/docs/PageableObject.md)
- [OpenapiClient::Person](gen/docs/Person.md)
- [OpenapiClient::PersonDto](gen/docs/PersonDto.md)
- [OpenapiClient::Sort](gen/docs/Sort.md)
- [OpenapiClient::State](gen/docs/State.md)
- [OpenapiClient::StateDto](gen/docs/StateDto.md)


## Documentation for Authorization

All endpoints do not require authorization.

