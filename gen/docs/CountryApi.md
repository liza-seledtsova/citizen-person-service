# OpenapiClient::CountryApi

All URIs are relative to *http://localhost:8081*

| Method | HTTP request | Description |
| ------ | ------------ | ----------- |
| [**create_country**](CountryApi.md#create_country) | **POST** /api/v1/country |  |
| [**delete_country**](CountryApi.md#delete_country) | **DELETE** /api/v1/country/{countyId} |  |
| [**get_all_country**](CountryApi.md#get_all_country) | **GET** /api/v1/country |  |
| [**get_country_by_id**](CountryApi.md#get_country_by_id) | **GET** /api/v1/country/{countryId} |  |
| [**update_country**](CountryApi.md#update_country) | **PUT** /api/v1/country |  |

## create_country

> String create_country(country_dto)



Create country

### Examples

```ruby
require 'time'
require 'openapi_client'

api_instance = OpenapiClient::CountryApi.new
country_dto = OpenapiClient::CountryDto.new # CountryDto | 

begin
  
  result = api_instance.create_country(country_dto)
  p result
rescue OpenapiClient::ApiError => e
  puts "Error when calling CountryApi->create_country: #{e}"
end
```

#### Using the create_country_with_http_info variant

This returns an Array which contains the response data, status code and headers.

> <Array(String, Integer, Hash)> create_country_with_http_info(country_dto)

```ruby
begin
  
  data, status_code, headers = api_instance.create_country_with_http_info(country_dto)
  p status_code # => 2xx
  p headers # => { ... }
  p data # => String
rescue OpenapiClient::ApiError => e
  puts "Error when calling CountryApi->create_country_with_http_info: #{e}"
end
```

### Parameters

| Name | Type | Description | Notes |
| ---- | ---- | ----------- | ----- |
| **country_dto** | [**CountryDto**](CountryDto.md) |  |  |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*

## delete_country

> String delete_country(county_id)



Delete country by id

### Examples

```ruby
require 'time'
require 'openapi_client'

api_instance = OpenapiClient::CountryApi.new
county_id = 789 # Integer | 

begin
  
  result = api_instance.delete_country(county_id)
  p result
rescue OpenapiClient::ApiError => e
  puts "Error when calling CountryApi->delete_country: #{e}"
end
```

#### Using the delete_country_with_http_info variant

This returns an Array which contains the response data, status code and headers.

> <Array(String, Integer, Hash)> delete_country_with_http_info(county_id)

```ruby
begin
  
  data, status_code, headers = api_instance.delete_country_with_http_info(county_id)
  p status_code # => 2xx
  p headers # => { ... }
  p data # => String
rescue OpenapiClient::ApiError => e
  puts "Error when calling CountryApi->delete_country_with_http_info: #{e}"
end
```

### Parameters

| Name | Type | Description | Notes |
| ---- | ---- | ----------- | ----- |
| **county_id** | **Integer** |  |  |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

## get_all_country

> String get_all_country



Get All country

### Examples

```ruby
require 'time'
require 'openapi_client'

api_instance = OpenapiClient::CountryApi.new

begin
  
  result = api_instance.get_all_country
  p result
rescue OpenapiClient::ApiError => e
  puts "Error when calling CountryApi->get_all_country: #{e}"
end
```

#### Using the get_all_country_with_http_info variant

This returns an Array which contains the response data, status code and headers.

> <Array(String, Integer, Hash)> get_all_country_with_http_info

```ruby
begin
  
  data, status_code, headers = api_instance.get_all_country_with_http_info
  p status_code # => 2xx
  p headers # => { ... }
  p data # => String
rescue OpenapiClient::ApiError => e
  puts "Error when calling CountryApi->get_all_country_with_http_info: #{e}"
end
```

### Parameters

This endpoint does not need any parameter.

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

## get_country_by_id

> String get_country_by_id(country_id)



get dountry by id

### Examples

```ruby
require 'time'
require 'openapi_client'

api_instance = OpenapiClient::CountryApi.new
country_id = 789 # Integer | 

begin
  
  result = api_instance.get_country_by_id(country_id)
  p result
rescue OpenapiClient::ApiError => e
  puts "Error when calling CountryApi->get_country_by_id: #{e}"
end
```

#### Using the get_country_by_id_with_http_info variant

This returns an Array which contains the response data, status code and headers.

> <Array(String, Integer, Hash)> get_country_by_id_with_http_info(country_id)

```ruby
begin
  
  data, status_code, headers = api_instance.get_country_by_id_with_http_info(country_id)
  p status_code # => 2xx
  p headers # => { ... }
  p data # => String
rescue OpenapiClient::ApiError => e
  puts "Error when calling CountryApi->get_country_by_id_with_http_info: #{e}"
end
```

### Parameters

| Name | Type | Description | Notes |
| ---- | ---- | ----------- | ----- |
| **country_id** | **Integer** |  |  |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

## update_country

> String update_country(country_dto)



Merge country data from dto to entity

### Examples

```ruby
require 'time'
require 'openapi_client'

api_instance = OpenapiClient::CountryApi.new
country_dto = OpenapiClient::CountryDto.new # CountryDto | 

begin
  
  result = api_instance.update_country(country_dto)
  p result
rescue OpenapiClient::ApiError => e
  puts "Error when calling CountryApi->update_country: #{e}"
end
```

#### Using the update_country_with_http_info variant

This returns an Array which contains the response data, status code and headers.

> <Array(String, Integer, Hash)> update_country_with_http_info(country_dto)

```ruby
begin
  
  data, status_code, headers = api_instance.update_country_with_http_info(country_dto)
  p status_code # => 2xx
  p headers # => { ... }
  p data # => String
rescue OpenapiClient::ApiError => e
  puts "Error when calling CountryApi->update_country_with_http_info: #{e}"
end
```

### Parameters

| Name | Type | Description | Notes |
| ---- | ---- | ----------- | ----- |
| **country_dto** | [**CountryDto**](CountryDto.md) |  |  |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*

