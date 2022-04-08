
## Requirements

Building the person service:
1. Java 1.7+
2. Gradle

## Installation
At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:


## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PersonApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/person.swagger.io/v1");

    PersonApi apiInstance = new PersonApi(defaultClient);
    Integer page = 56; // Integer | Results page you want to retrieve (0..N)
    Integer size = 56; // Integer | Number of records per page.
    String sort = "sort_example"; // String | Sorting criteria
    try {
      List<FilterDto> result = apiInstance.getAllPerson(page, size, sort);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PersonApi#getAllPerson");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

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

