# OpenapiClient::PageableObject

## Properties

| Name | Type | Description | Notes |
| ---- | ---- | ----------- | ----- |
| **page_number** | **Integer** |  | [optional] |
| **page_size** | **Integer** |  | [optional] |
| **sort** | [**Sort**](Sort.md) |  | [optional] |
| **paged** | **Boolean** |  | [optional] |
| **unpaged** | **Boolean** |  | [optional] |
| **offset** | **Integer** |  | [optional] |

## Example

```ruby
require 'openapi_client'

instance = OpenapiClient::PageableObject.new(
  page_number: null,
  page_size: null,
  sort: null,
  paged: null,
  unpaged: null,
  offset: 0
)
```

