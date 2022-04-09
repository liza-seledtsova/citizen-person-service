# OpenapiClient::AddressDto

## Properties

| Name | Type | Description | Notes |
| ---- | ---- | ----------- | ----- |
| **id** | **Integer** |  | [optional] |
| **address1** | **String** |  | [optional] |
| **address2** | **String** |  | [optional] |
| **post_code** | **String** |  | [optional] |
| **city** | [**CityDto**](CityDto.md) |  | [optional] |

## Example

```ruby
require 'openapi_client'

instance = OpenapiClient::AddressDto.new(
  id: null,
  address1: null,
  address2: null,
  post_code: null,
  city: null
)
```

