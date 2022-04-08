# PersonApi

All URIs are relative to *http://localhost/person.swagger.io/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getAllPerson**](PersonApi.md#getAllPerson) | **GET** /person | Get all person and generate filter data for providing sorting and/or filtering entry
[**getPersonsFiltered**](PersonApi.md#getPersonsFiltered) | **POST** /person | The sorting and/or filtering options person data


<a name="getAllPerson"></a>
# **getAllPerson**
> List&lt;FilterDto&gt; getAllPerson(page, size, sort)

Get all person and generate filter data for providing sorting and/or filtering entry

### Example
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

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **Integer**| Results page you want to retrieve (0..N) |
 **size** | **Integer**| Number of records per page. |
 **sort** | **String**| Sorting criteria | [enum: ASC, DESC]

### Return type

[**List&lt;FilterDto&gt;**](FilterDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | successful operation |  -  |

<a name="getPersonsFiltered"></a>
# **getPersonsFiltered**
> List&lt;FilterDto&gt; getPersonsFiltered(page, size, sort, filterDto)

The sorting and/or filtering options person data

Provides sorting and/or filtering options

### Example
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
    FilterDto filterDto = new FilterDto(); // FilterDto | Filter data for parsing parament filter query
    try {
      List<FilterDto> result = apiInstance.getPersonsFiltered(page, size, sort, filterDto);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PersonApi#getPersonsFiltered");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **Integer**| Results page you want to retrieve (0..N) |
 **size** | **Integer**| Number of records per page. |
 **sort** | **String**| Sorting criteria | [enum: ASC, DESC]
 **filterDto** | [**FilterDto**](FilterDto.md)| Filter data for parsing parament filter query |

### Return type

[**List&lt;FilterDto&gt;**](FilterDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | successful operation |  -  |

