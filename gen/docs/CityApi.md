# OpenapiClient::CityApi

All URIs are relative to *http://localhost:8081*

| Method | HTTP request | Description |
| ------ | ------------ | ----------- |
| [**create_city**](CityApi.md#create_city) | **POST** /api/v1/city |  |
| [**delete_city**](CityApi.md#delete_city) | **DELETE** /api/v1/city/{cityId} |  |
| [**get_all_city**](CityApi.md#get_all_city) | **GET** /api/v1/city |  |
| [**get_city_by_id**](CityApi.md#get_city_by_id) | **GET** /api/v1/city/{cityId} |  |
| [**update_city**](CityApi.md#update_city) | **PUT** /api/v1/city |  |

## create_city

> String create_city(city_dto)



Create city

### Examples

```ruby
require 'time'
require 'openapi_client'

api_instance = OpenapiClient::CityApi.new
city_dto = OpenapiClient::CityDto.new # CityDto | 

begin
  
  result = api_instance.create_city(city_dto)
  p result
rescue OpenapiClient::ApiError => e
  puts "Error when calling CityApi->create_city: #{e}"
end
```

#### Using the create_city_with_http_info variant

This returns an Array which contains the response data, status code and headers.

> <Array(String, Integer, Hash)> create_city_with_http_info(city_dto)

```ruby
begin
  
  data, status_code, headers = api_instance.create_city_with_http_info(city_dto)
  p status_code # => 2xx
  p headers # => { ... }
  p data # => String
rescue OpenapiClient::ApiError => e
  puts "Error when calling CityApi->create_city_with_http_info: #{e}"
end
```

### Parameters

| Name | Type | Description | Notes |
| ---- | ---- | ----------- | ----- |
| **city_dto** | [**CityDto**](CityDto.md) |  |  |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*

## delete_city

> String delete_city(city_id)



Delete city by id

### Examples

```ruby
require 'time'
require 'openapi_client'

api_instance = OpenapiClient::CityApi.new
city_id = 789 # Integer | 

begin
  
  result = api_instance.delete_city(city_id)
  p result
rescue OpenapiClient::ApiError => e
  puts "Error when calling CityApi->delete_city: #{e}"
end
```

#### Using the delete_city_with_http_info variant

This returns an Array which contains the response data, status code and headers.

> <Array(String, Integer, Hash)> delete_city_with_http_info(city_id)

```ruby
begin
  
  data, status_code, headers = api_instance.delete_city_with_http_info(city_id)
  p status_code # => 2xx
  p headers # => { ... }
  p data # => String
rescue OpenapiClient::ApiError => e
  puts "Error when calling CityApi->delete_city_with_http_info: #{e}"
end
```

### Parameters

| Name | Type | Description | Notes |
| ---- | ---- | ----------- | ----- |
| **city_id** | **Integer** |  |  |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

## get_all_city

> String get_all_city



Get All city

### Examples

```ruby
require 'time'
require 'openapi_client'

api_instance = OpenapiClient::CityApi.new

begin
  
  result = api_instance.get_all_city
  p result
rescue OpenapiClient::ApiError => e
  puts "Error when calling CityApi->get_all_city: #{e}"
end
```

#### Using the get_all_city_with_http_info variant

This returns an Array which contains the response data, status code and headers.

> <Array(String, Integer, Hash)> get_all_city_with_http_info

```ruby
begin
  
  data, status_code, headers = api_instance.get_all_city_with_http_info
  p status_code # => 2xx
  p headers # => { ... }
  p data # => String
rescue OpenapiClient::ApiError => e
  puts "Error when calling CityApi->get_all_city_with_http_info: #{e}"
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

## get_city_by_id

> String get_city_by_id(city_id)



get city by id

### Examples

```ruby
require 'time'
require 'openapi_client'

api_instance = OpenapiClient::CityApi.new
city_id = 789 # Integer | 

begin
  
  result = api_instance.get_city_by_id(city_id)
  p result
rescue OpenapiClient::ApiError => e
  puts "Error when calling CityApi->get_city_by_id: #{e}"
end
```

#### Using the get_city_by_id_with_http_info variant

This returns an Array which contains the response data, status code and headers.

> <Array(String, Integer, Hash)> get_city_by_id_with_http_info(city_id)

```ruby
begin
  
  data, status_code, headers = api_instance.get_city_by_id_with_http_info(city_id)
  p status_code # => 2xx
  p headers # => { ... }
  p data # => String
rescue OpenapiClient::ApiError => e
  puts "Error when calling CityApi->get_city_by_id_with_http_info: #{e}"
end
```

### Parameters

| Name | Type | Description | Notes |
| ---- | ---- | ----------- | ----- |
| **city_id** | **Integer** |  |  |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

## update_city

> String update_city(city_dto)



Merge city a from dto to entity

### Examples

```ruby
require 'time'
require 'openapi_client'

api_instance = OpenapiClient::CityApi.new
city_dto = OpenapiClient::CityDto.new # CityDto | 

begin
  
  result = api_instance.update_city(city_dto)
  p result
rescue OpenapiClient::ApiError => e
  puts "Error when calling CityApi->update_city: #{e}"
end
```

#### Using the update_city_with_http_info variant

This returns an Array which contains the response data, status code and headers.

> <Array(String, Integer, Hash)> update_city_with_http_info(city_dto)

```ruby
begin
  
  data, status_code, headers = api_instance.update_city_with_http_info(city_dto)
  p status_code # => 2xx
  p headers # => { ... }
  p data # => String
rescue OpenapiClient::ApiError => e
  puts "Error when calling CityApi->update_city_with_http_info: #{e}"
end
```

### Parameters

| Name | Type | Description | Notes |
| ---- | ---- | ----------- | ----- |
| **city_dto** | [**CityDto**](CityDto.md) |  |  |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*

