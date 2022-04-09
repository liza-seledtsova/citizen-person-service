# OpenapiClient::FilterDto

## Properties

| Name | Type | Description | Notes |
| ---- | ---- | ----------- | ----- |
| **result** | [**PageImplPerson**](PageImplPerson.md) |  | [optional] |
| **filter_data_dto** | [**Array&lt;FilterDataDto&gt;**](FilterDataDto.md) | list of filter properties for each field in entry | [optional] |
| **selected_field** | **String** |  | [optional] |

## Example

```ruby
require 'openapi_client'

instance = OpenapiClient::FilterDto.new(
  result: null,
  filter_data_dto: null,
  selected_field: null
)
```

