# OpenapiClient::PageImplPerson

## Properties

| Name | Type | Description | Notes |
| ---- | ---- | ----------- | ----- |
| **content** | [**Array&lt;Person&gt;**](Person.md) | filtering and sorting result | [optional] |
| **number** | **Integer** |  | [optional] |
| **size** | **Integer** |  | [optional] |
| **pageable** | [**PageableObject**](PageableObject.md) |  | [optional] |
| **total_elements** | **Integer** |  | [optional] |
| **last** | **Boolean** |  | [optional] |
| **total_pages** | **Integer** |  | [optional] |
| **first** | **Boolean** |  | [optional] |
| **sort** | [**Sort**](Sort.md) |  | [optional] |
| **number_of_elements** | **Integer** |  | [optional] |
| **empty** | **Boolean** |  | [optional] |

## Example

```ruby
require 'openapi_client'

instance = OpenapiClient::PageImplPerson.new(
  content: null,
  number: 1,
  size: 1,
  pageable: null,
  total_elements: null,
  last: null,
  total_pages: null,
  first: null,
  sort: null,
  number_of_elements: null,
  empty: null
)
```

