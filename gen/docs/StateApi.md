# OpenapiClient::StateApi

All URIs are relative to *http://localhost:8081*

| Method | HTTP request | Description |
| ------ | ------------ | ----------- |
| [**create_state**](StateApi.md#create_state) | **POST** /api/v1/state |  |
| [**delete_state**](StateApi.md#delete_state) | **DELETE** /api/v1/state/{stateId} |  |
| [**get_all_state**](StateApi.md#get_all_state) | **GET** /api/v1/state |  |
| [**get_state_by_id**](StateApi.md#get_state_by_id) | **GET** /api/v1/state/{stateId} |  |
| [**update_state**](StateApi.md#update_state) | **PUT** /api/v1/state |  |

## create_state

> String create_state(state_dto)



Create state

### Examples

```ruby
require 'time'
require 'openapi_client'

api_instance = OpenapiClient::StateApi.new
state_dto = OpenapiClient::StateDto.new # StateDto | 

begin
  
  result = api_instance.create_state(state_dto)
  p result
rescue OpenapiClient::ApiError => e
  puts "Error when calling StateApi->create_state: #{e}"
end
```

#### Using the create_state_with_http_info variant

This returns an Array which contains the response data, status code and headers.

> <Array(String, Integer, Hash)> create_state_with_http_info(state_dto)

```ruby
begin
  
  data, status_code, headers = api_instance.create_state_with_http_info(state_dto)
  p status_code # => 2xx
  p headers # => { ... }
  p data # => String
rescue OpenapiClient::ApiError => e
  puts "Error when calling StateApi->create_state_with_http_info: #{e}"
end
```

### Parameters

| Name | Type | Description | Notes |
| ---- | ---- | ----------- | ----- |
| **state_dto** | [**StateDto**](StateDto.md) |  |  |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*

## delete_state

> String delete_state(state_id)



Delete state by id

### Examples

```ruby
require 'time'
require 'openapi_client'

api_instance = OpenapiClient::StateApi.new
state_id = 789 # Integer | 

begin
  
  result = api_instance.delete_state(state_id)
  p result
rescue OpenapiClient::ApiError => e
  puts "Error when calling StateApi->delete_state: #{e}"
end
```

#### Using the delete_state_with_http_info variant

This returns an Array which contains the response data, status code and headers.

> <Array(String, Integer, Hash)> delete_state_with_http_info(state_id)

```ruby
begin
  
  data, status_code, headers = api_instance.delete_state_with_http_info(state_id)
  p status_code # => 2xx
  p headers # => { ... }
  p data # => String
rescue OpenapiClient::ApiError => e
  puts "Error when calling StateApi->delete_state_with_http_info: #{e}"
end
```

### Parameters

| Name | Type | Description | Notes |
| ---- | ---- | ----------- | ----- |
| **state_id** | **Integer** |  |  |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

## get_all_state

> String get_all_state



Get All entry of state

### Examples

```ruby
require 'time'
require 'openapi_client'

api_instance = OpenapiClient::StateApi.new

begin
  
  result = api_instance.get_all_state
  p result
rescue OpenapiClient::ApiError => e
  puts "Error when calling StateApi->get_all_state: #{e}"
end
```

#### Using the get_all_state_with_http_info variant

This returns an Array which contains the response data, status code and headers.

> <Array(String, Integer, Hash)> get_all_state_with_http_info

```ruby
begin
  
  data, status_code, headers = api_instance.get_all_state_with_http_info
  p status_code # => 2xx
  p headers # => { ... }
  p data # => String
rescue OpenapiClient::ApiError => e
  puts "Error when calling StateApi->get_all_state_with_http_info: #{e}"
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

## get_state_by_id

> String get_state_by_id(state_id)



Get state by id

### Examples

```ruby
require 'time'
require 'openapi_client'

api_instance = OpenapiClient::StateApi.new
state_id = 789 # Integer | 

begin
  
  result = api_instance.get_state_by_id(state_id)
  p result
rescue OpenapiClient::ApiError => e
  puts "Error when calling StateApi->get_state_by_id: #{e}"
end
```

#### Using the get_state_by_id_with_http_info variant

This returns an Array which contains the response data, status code and headers.

> <Array(String, Integer, Hash)> get_state_by_id_with_http_info(state_id)

```ruby
begin
  
  data, status_code, headers = api_instance.get_state_by_id_with_http_info(state_id)
  p status_code # => 2xx
  p headers # => { ... }
  p data # => String
rescue OpenapiClient::ApiError => e
  puts "Error when calling StateApi->get_state_by_id_with_http_info: #{e}"
end
```

### Parameters

| Name | Type | Description | Notes |
| ---- | ---- | ----------- | ----- |
| **state_id** | **Integer** |  |  |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

## update_state

> String update_state(state_dto)



Merge data from dto to entity

### Examples

```ruby
require 'time'
require 'openapi_client'

api_instance = OpenapiClient::StateApi.new
state_dto = OpenapiClient::StateDto.new # StateDto | 

begin
  
  result = api_instance.update_state(state_dto)
  p result
rescue OpenapiClient::ApiError => e
  puts "Error when calling StateApi->update_state: #{e}"
end
```

#### Using the update_state_with_http_info variant

This returns an Array which contains the response data, status code and headers.

> <Array(String, Integer, Hash)> update_state_with_http_info(state_dto)

```ruby
begin
  
  data, status_code, headers = api_instance.update_state_with_http_info(state_dto)
  p status_code # => 2xx
  p headers # => { ... }
  p data # => String
rescue OpenapiClient::ApiError => e
  puts "Error when calling StateApi->update_state_with_http_info: #{e}"
end
```

### Parameters

| Name | Type | Description | Notes |
| ---- | ---- | ----------- | ----- |
| **state_dto** | [**StateDto**](StateDto.md) |  |  |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*

