# OpenapiClient::FilterDataDto

## Properties

| Name | Type | Description | Notes |
| ---- | ---- | ----------- | ----- |
| **sorting** | **String** | enum to sort value | [optional] |
| **value** | **Array&lt;String&gt;** | list of avaliable value filed to sample data from entry | [optional] |
| **select** | **Array&lt;String&gt;** | list of selected value from list of value for building query | [optional] |
| **filter_name** | **String** | name of field to filter data on this field | [optional] |
| **filter_type** | **
String** | filter depends on the data format.Select - string value(name, surname). Range - number format(price, date) | [optional] |
| **group_by** | **Boolean** |  | [optional] |

## Example

```ruby
require 'openapi_client'

instance = OpenapiClient::FilterDataDto.new(
  sorting: null,
  value: [&quot;Glasgow&quot;,&quot;Southend&quot;],
  select: [&quot;Glasgow&quot;,&quot;Southend&quot;],
  filter_name: CITY,
  filter_type: SELECT,
  group_by: false
)
```

