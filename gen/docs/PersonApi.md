# OpenapiClient::PersonApi

All URIs are relative to *http://localhost:8081*

| Method | HTTP request | Description |
| ------ | ------------ | ----------- |
| [**create_person**](PersonApi.md#create_person) | **POST** /api/v1/persons |  |
| [**delete_person**](PersonApi.md#delete_person) | **DELETE** /api/v1/persons/{personsId} |  |
| [**get_all_persons**](PersonApi.md#get_all_persons) | **GET** /api/v1/persons |  |
| [**get_person_by_id**](PersonApi.md#get_person_by_id) | **GET** /api/v1/persons/{personsId} |  |
| [**get_persons_filtered**](PersonApi.md#get_persons_filtered) | **POST** /api/v1/persons/filter |  |
| [**update_person**](PersonApi.md#update_person) | **PUT** /api/v1/persons |  |

## create_person

> String create_person(person_dto)



Create Person

### Examples

```ruby
require 'time'
require 'openapi_client'

api_instance = OpenapiClient::PersonApi.new
person_dto = OpenapiClient::PersonDto.new # PersonDto | 

begin
  
  result = api_instance.create_person(person_dto)
  p result
rescue OpenapiClient::ApiError => e
  puts "Error when calling PersonApi->create_person: #{e}"
end
```

#### Using the create_person_with_http_info variant

This returns an Array which contains the response data, status code and headers.

> <Array(String, Integer, Hash)> create_person_with_http_info(person_dto)

```ruby
begin
  
  data, status_code, headers = api_instance.create_person_with_http_info(person_dto)
  p status_code # => 2xx
  p headers # => { ... }
  p data # => String
rescue OpenapiClient::ApiError => e
  puts "Error when calling PersonApi->create_person_with_http_info: #{e}"
end
```

### Parameters

| Name | Type | Description | Notes |
| ---- | ---- | ----------- | ----- |
| **person_dto** | [**PersonDto**](PersonDto.md) |  |  |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*

## delete_person

> String delete_person(persons_id)



Delete person

### Examples

```ruby
require 'time'
require 'openapi_client'

api_instance = OpenapiClient::PersonApi.new
persons_id = 789 # Integer | 

begin
  
  result = api_instance.delete_person(persons_id)
  p result
rescue OpenapiClient::ApiError => e
  puts "Error when calling PersonApi->delete_person: #{e}"
end
```

#### Using the delete_person_with_http_info variant

This returns an Array which contains the response data, status code and headers.

> <Array(String, Integer, Hash)> delete_person_with_http_info(persons_id)

```ruby
begin
  
  data, status_code, headers = api_instance.delete_person_with_http_info(persons_id)
  p status_code # => 2xx
  p headers # => { ... }
  p data # => String
rescue OpenapiClient::ApiError => e
  puts "Error when calling PersonApi->delete_person_with_http_info: #{e}"
end
```

### Parameters

| Name | Type | Description | Notes |
| ---- | ---- | ----------- | ----- |
| **persons_id** | **Integer** |  |  |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

## get_all_persons

> String get_all_persons(page_number, page_size)



Get all person

### Examples

```ruby
require 'time'
require 'openapi_client'

api_instance = OpenapiClient::PersonApi.new
page_number = 56 # Integer | 
page_size = 56 # Integer | 

begin
  
  result = api_instance.get_all_persons(page_number, page_size)
  p result
rescue OpenapiClient::ApiError => e
  puts "Error when calling PersonApi->get_all_persons: #{e}"
end
```

#### Using the get_all_persons_with_http_info variant

This returns an Array which contains the response data, status code and headers.

> <Array(String, Integer, Hash)> get_all_persons_with_http_info(page_number, page_size)

```ruby
begin
  
  data, status_code, headers = api_instance.get_all_persons_with_http_info(page_number, page_size)
  p status_code # => 2xx
  p headers # => { ... }
  p data # => String
rescue OpenapiClient::ApiError => e
  puts "Error when calling PersonApi->get_all_persons_with_http_info: #{e}"
end
```

### Parameters

| Name | Type | Description | Notes |
| ---- | ---- | ----------- | ----- |
| **page_number** | **Integer** |  |  |
| **page_size** | **Integer** |  |  |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

## get_person_by_id

> String get_person_by_id(persons_id)

### Examples

```ruby
require 'time'
require 'openapi_client'

api_instance = OpenapiClient::PersonApi.new
persons_id = 789 # Integer | 

begin
  
  result = api_instance.get_person_by_id(persons_id)
  p result
rescue OpenapiClient::ApiError => e
  puts "Error when calling PersonApi->get_person_by_id: #{e}"
end
```

#### Using the get_person_by_id_with_http_info variant

This returns an Array which contains the response data, status code and headers.

> <Array(String, Integer, Hash)> get_person_by_id_with_http_info(persons_id)

```ruby
begin
  
  data, status_code, headers = api_instance.get_person_by_id_with_http_info(persons_id)
  p status_code # => 2xx
  p headers # => { ... }
  p data # => String
rescue OpenapiClient::ApiError => e
  puts "Error when calling PersonApi->get_person_by_id_with_http_info: #{e}"
end
```

### Parameters

| Name | Type | Description | Notes |
| ---- | ---- | ----------- | ----- |
| **persons_id** | **Integer** |  |  |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

## get_persons_filtered

> String get_persons_filtered(filter_dto)



Operation to filter and sort data on any filed (firstName, address1, countryCode, state), select multiple values for
sampling

### Examples

```ruby
require 'time'
require 'openapi_client'

api_instance = OpenapiClient::PersonApi.new
filter_dto = OpenapiClient::FilterDto.new # FilterDto | 

begin
  
  result = api_instance.get_persons_filtered(filter_dto)
  p result
rescue OpenapiClient::ApiError => e
  puts "Error when calling PersonApi->get_persons_filtered: #{e}"
end
```

#### Using the get_persons_filtered_with_http_info variant

This returns an Array which contains the response data, status code and headers.

> <Array(String, Integer, Hash)> get_persons_filtered_with_http_info(filter_dto)

```ruby
begin
  
  data, status_code, headers = api_instance.get_persons_filtered_with_http_info(filter_dto)
  p status_code # => 2xx
  p headers # => { ... }
  p data # => String
rescue OpenapiClient::ApiError => e
  puts "Error when calling PersonApi->get_persons_filtered_with_http_info: #{e}"
end
```

### Parameters

| Name | Type | Description | Notes |
| ---- | ---- | ----------- | ----- |
| **filter_dto** | [**FilterDto**](FilterDto.md) |  |  |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*

## update_person

> String update_person(person_dto)



Merge person data from dto to entity

### Examples

```ruby
require 'time'
require 'openapi_client'

api_instance = OpenapiClient::PersonApi.new
person_dto = OpenapiClient::PersonDto.new # PersonDto | 

begin
  
  result = api_instance.update_person(person_dto)
  p result
rescue OpenapiClient::ApiError => e
  puts "Error when calling PersonApi->update_person: #{e}"
end
```

#### Using the update_person_with_http_info variant

This returns an Array which contains the response data, status code and headers.

> <Array(String, Integer, Hash)> update_person_with_http_info(person_dto)

```ruby
begin
  
  data, status_code, headers = api_instance.update_person_with_http_info(person_dto)
  p status_code # => 2xx
  p headers # => { ... }
  p data # => String
rescue OpenapiClient::ApiError => e
  puts "Error when calling PersonApi->update_person_with_http_info: #{e}"
end
```

### Parameters

| Name | Type | Description | Notes |
| ---- | ---- | ----------- | ----- |
| **person_dto** | [**PersonDto**](PersonDto.md) |  |  |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*

