

# FilterDataDto

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**sorting** | [**SortingEnum**](#SortingEnum) | sort query |  [optional]
**value** | **List&lt;String&gt;** |  |  [optional]
**select** | **List&lt;String&gt;** |  |  [optional]
**filterName** | [**FilterNameEnum**](#FilterNameEnum) | name field to filter entry |  [optional]
**filterType** | [**FilterTypeEnum**](#FilterTypeEnum) | type of filer for building query |  [optional]
**groupBy** | **Boolean** |  |  [optional]



## Enum: SortingEnum

Name | Value
---- | -----
ASC | &quot;ASC&quot;
DESC | &quot;DESC&quot;



## Enum: FilterNameEnum

Name | Value
---- | -----
FIRST_NAME | &quot;FIRST_NAME&quot;
SURNAME | &quot;SURNAME&quot;
ADDRESS1 | &quot;ADDRESS1&quot;
ADDRESS2 | &quot;ADDRESS2&quot;
CITY | &quot;CITY&quot;
STATE | &quot;STATE&quot;
POSTCODE | &quot;POSTCODE&quot;
COUNTRY_CODE | &quot;COUNTRY_CODE&quot;
GENDER | &quot;GENDER&quot;
DATE_OF_BIRTH | &quot;DATE_OF_BIRTH&quot;



## Enum: FilterTypeEnum

Name | Value
---- | -----
SELECT | &quot;SELECT&quot;
RANGE | &quot;RANGE&quot;



