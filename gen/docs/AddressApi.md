# OpenapiClient::AddressApi

All URIs are relative to *http://localhost:8081*

| Method | HTTP request | Description |
| ------ | ------------ | ----------- |
| [**create_address**](AddressApi.md#create_address) | **POST** /api/v1/address |  |
| [**delete_address**](AddressApi.md#delete_address) | **DELETE** /api/v1/address/{addressId} |  |
| [**get_address_by_id**](AddressApi.md#get_address_by_id) | **GET** /api/v1/address/{addressId} |  |
| [**get_all_address**](AddressApi.md#get_all_address) | **GET** /api/v1/address |  |
| [**update_address**](AddressApi.md#update_address) | **PUT** /api/v1/address |  |

## create_address

> String create_address(address_dto)



Create address

### Examples

```ruby
require 'time'
require 'openapi_client'

api_instance = OpenapiClient::AddressApi.new
address_dto = OpenapiClient::AddressDto.new # AddressDto | 

begin
  
  result = api_instance.create_address(address_dto)
  p result
rescue OpenapiClient::ApiError => e
  puts "Error when calling AddressApi->create_address: #{e}"
end
```

#### Using the create_address_with_http_info variant

This returns an Array which contains the response data, status code and headers.

> <Array(String, Integer, Hash)> create_address_with_http_info(address_dto)

```ruby
begin
  
  data, status_code, headers = api_instance.create_address_with_http_info(address_dto)
  p status_code # => 2xx
  p headers # => { ... }
  p data # => String
rescue OpenapiClient::ApiError => e
  puts "Error when calling AddressApi->create_address_with_http_info: #{e}"
end
```

### Parameters

| Name | Type | Description | Notes |
| ---- | ---- | ----------- | ----- |
| **address_dto** | [**AddressDto**](AddressDto.md) |  |  |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*

## delete_address

> String delete_address(address_id)



Delete adress by id

### Examples

```ruby
require 'time'
require 'openapi_client'

api_instance = OpenapiClient::AddressApi.new
address_id = 789 # Integer | 

begin
  
  result = api_instance.delete_address(address_id)
  p result
rescue OpenapiClient::ApiError => e
  puts "Error when calling AddressApi->delete_address: #{e}"
end
```

#### Using the delete_address_with_http_info variant

This returns an Array which contains the response data, status code and headers.

> <Array(String, Integer, Hash)> delete_address_with_http_info(address_id)

```ruby
begin
  
  data, status_code, headers = api_instance.delete_address_with_http_info(address_id)
  p status_code # => 2xx
  p headers # => { ... }
  p data # => String
rescue OpenapiClient::ApiError => e
  puts "Error when calling AddressApi->delete_address_with_http_info: #{e}"
end
```

### Parameters

| Name | Type | Description | Notes |
| ---- | ---- | ----------- | ----- |
| **address_id** | **Integer** |  |  |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

## get_address_by_id

> String get_address_by_id(address_id)



Get address by id

### Examples

```ruby
require 'time'
require 'openapi_client'

api_instance = OpenapiClient::AddressApi.new
address_id = 789 # Integer | 

begin
  
  result = api_instance.get_address_by_id(address_id)
  p result
rescue OpenapiClient::ApiError => e
  puts "Error when calling AddressApi->get_address_by_id: #{e}"
end
```

#### Using the get_address_by_id_with_http_info variant

This returns an Array which contains the response data, status code and headers.

> <Array(String, Integer, Hash)> get_address_by_id_with_http_info(address_id)

```ruby
begin
  
  data, status_code, headers = api_instance.get_address_by_id_with_http_info(address_id)
  p status_code # => 2xx
  p headers # => { ... }
  p data # => String
rescue OpenapiClient::ApiError => e
  puts "Error when calling AddressApi->get_address_by_id_with_http_info: #{e}"
end
```

### Parameters

| Name | Type | Description | Notes |
| ---- | ---- | ----------- | ----- |
| **address_id** | **Integer** |  |  |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

## get_all_address

> String get_all_address



Get all address

### Examples

```ruby
require 'time'
require 'openapi_client'

api_instance = OpenapiClient::AddressApi.new

begin
  
  result = api_instance.get_all_address
  p result
rescue OpenapiClient::ApiError => e
  puts "Error when calling AddressApi->get_all_address: #{e}"
end
```

#### Using the get_all_address_with_http_info variant

This returns an Array which contains the response data, status code and headers.

> <Array(String, Integer, Hash)> get_all_address_with_http_info

```ruby
begin
  
  data, status_code, headers = api_instance.get_all_address_with_http_info
  p status_code # => 2xx
  p headers # => { ... }
  p data # => String
rescue OpenapiClient::ApiError => e
  puts "Error when calling AddressApi->get_all_address_with_http_info: #{e}"
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

## update_address

> String update_address(address_dto)



Merge address data from dto to entity

### Examples

```ruby
require 'time'
require 'openapi_client'

api_instance = OpenapiClient::AddressApi.new
address_dto = OpenapiClient::AddressDto.new # AddressDto | 

begin
  
  result = api_instance.update_address(address_dto)
  p result
rescue OpenapiClient::ApiError => e
  puts "Error when calling AddressApi->update_address: #{e}"
end
```

#### Using the update_address_with_http_info variant

This returns an Array which contains the response data, status code and headers.

> <Array(String, Integer, Hash)> update_address_with_http_info(address_dto)

```ruby
begin
  
  data, status_code, headers = api_instance.update_address_with_http_info(address_dto)
  p status_code # => 2xx
  p headers # => { ... }
  p data # => String
rescue OpenapiClient::ApiError => e
  puts "Error when calling AddressApi->update_address_with_http_info: #{e}"
end
```

### Parameters

| Name | Type | Description | Notes |
| ---- | ---- | ----------- | ----- |
| **address_dto** | [**AddressDto**](AddressDto.md) |  |  |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*

