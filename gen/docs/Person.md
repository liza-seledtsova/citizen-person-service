# OpenapiClient::Person

## Properties

| Name | Type | Description | Notes |
| ---- | ---- | ----------- | ----- |
| **id** | **Integer** |  | [optional] |
| **first_name** | **String** |  | [optional] |
| **surname** | **String** |  | [optional] |
| **gender** | **String** |  | [optional] |
| **date_of_birth** | **Time** |  | [optional] |
| **address** | [**Array&lt;Address&gt;**](Address.md) |  | [optional] |

## Example

```ruby
require 'openapi_client'

instance = OpenapiClient::Person.new(
  id: null,
  first_name: null,
  surname: null,
  gender: null,
  date_of_birth: null,
  address: null
)
```

