=begin
#Person API

#Person Information Service

The version of the OpenAPI document: 1.0

Generated by: https://openapi-generator.tech
OpenAPI Generator version: 5.4.0

=end

require 'cgi'

module OpenapiClient
  class PersonApi
    attr_accessor :api_client

    def initialize(api_client = ApiClient.default)
      @api_client = api_client
    end
    # Create Person
    # @param person_dto [PersonDto] 
    # @param [Hash] opts the optional parameters
    # @return [String]
    def create_person(person_dto, opts = {})
      data, _status_code, _headers = create_person_with_http_info(person_dto, opts)
      data
    end

    # Create Person
    # @param person_dto [PersonDto] 
    # @param [Hash] opts the optional parameters
    # @return [Array<(String, Integer, Hash)>] String data, response status code and response headers
    def create_person_with_http_info(person_dto, opts = {})
      if @api_client.config.debugging
        @api_client.config.logger.debug 'Calling API: PersonApi.create_person ...'
      end
      # verify the required parameter 'person_dto' is set
      if @api_client.config.client_side_validation && person_dto.nil?
        fail ArgumentError, "Missing the required parameter 'person_dto' when calling PersonApi.create_person"
      end
      # resource path
      local_var_path = '/api/v1/persons'

      # query parameters
      query_params = opts[:query_params] || {}

      # header parameters
      header_params = opts[:header_params] || {}
      # HTTP header 'Accept' (if needed)
      header_params['Accept'] = @api_client.select_header_accept(['*/*'])
      # HTTP header 'Content-Type'
      content_type = @api_client.select_header_content_type(['application/json'])
      if !content_type.nil?
          header_params['Content-Type'] = content_type
      end

      # form parameters
      form_params = opts[:form_params] || {}

      # http body (model)
      post_body = opts[:debug_body] || @api_client.object_to_http_body(person_dto)

      # return_type
      return_type = opts[:debug_return_type] || 'String'

      # auth_names
      auth_names = opts[:debug_auth_names] || []

      new_options = opts.merge(
        :operation => :"PersonApi.create_person",
        :header_params => header_params,
        :query_params => query_params,
        :form_params => form_params,
        :body => post_body,
        :auth_names => auth_names,
        :return_type => return_type
      )

      data, status_code, headers = @api_client.call_api(:POST, local_var_path, new_options)
      if @api_client.config.debugging
        @api_client.config.logger.debug "API called: PersonApi#create_person\nData: #{data.inspect}\nStatus code: #{status_code}\nHeaders: #{headers}"
      end
      return data, status_code, headers
    end

    # Delete person
    # @param persons_id [Integer] 
    # @param [Hash] opts the optional parameters
    # @return [String]
    def delete_person(persons_id, opts = {})
      data, _status_code, _headers = delete_person_with_http_info(persons_id, opts)
      data
    end

    # Delete person
    # @param persons_id [Integer] 
    # @param [Hash] opts the optional parameters
    # @return [Array<(String, Integer, Hash)>] String data, response status code and response headers
    def delete_person_with_http_info(persons_id, opts = {})
      if @api_client.config.debugging
        @api_client.config.logger.debug 'Calling API: PersonApi.delete_person ...'
      end
      # verify the required parameter 'persons_id' is set
      if @api_client.config.client_side_validation && persons_id.nil?
        fail ArgumentError, "Missing the required parameter 'persons_id' when calling PersonApi.delete_person"
      end
      # resource path
      local_var_path = '/api/v1/persons/{personsId}'.sub('{' + 'personsId' + '}', CGI.escape(persons_id.to_s))

      # query parameters
      query_params = opts[:query_params] || {}

      # header parameters
      header_params = opts[:header_params] || {}
      # HTTP header 'Accept' (if needed)
      header_params['Accept'] = @api_client.select_header_accept(['*/*'])

      # form parameters
      form_params = opts[:form_params] || {}

      # http body (model)
      post_body = opts[:debug_body]

      # return_type
      return_type = opts[:debug_return_type] || 'String'

      # auth_names
      auth_names = opts[:debug_auth_names] || []

      new_options = opts.merge(
        :operation => :"PersonApi.delete_person",
        :header_params => header_params,
        :query_params => query_params,
        :form_params => form_params,
        :body => post_body,
        :auth_names => auth_names,
        :return_type => return_type
      )

      data, status_code, headers = @api_client.call_api(:DELETE, local_var_path, new_options)
      if @api_client.config.debugging
        @api_client.config.logger.debug "API called: PersonApi#delete_person\nData: #{data.inspect}\nStatus code: #{status_code}\nHeaders: #{headers}"
      end
      return data, status_code, headers
    end

    # Get all person
    # @param page_number [Integer] 
    # @param page_size [Integer] 
    # @param [Hash] opts the optional parameters
    # @return [String]
    def get_all_persons(page_number, page_size, opts = {})
      data, _status_code, _headers = get_all_persons_with_http_info(page_number, page_size, opts)
      data
    end

    # Get all person
    # @param page_number [Integer] 
    # @param page_size [Integer] 
    # @param [Hash] opts the optional parameters
    # @return [Array<(String, Integer, Hash)>] String data, response status code and response headers
    def get_all_persons_with_http_info(page_number, page_size, opts = {})
      if @api_client.config.debugging
        @api_client.config.logger.debug 'Calling API: PersonApi.get_all_persons ...'
      end
      # verify the required parameter 'page_number' is set
      if @api_client.config.client_side_validation && page_number.nil?
        fail ArgumentError, "Missing the required parameter 'page_number' when calling PersonApi.get_all_persons"
      end
      # verify the required parameter 'page_size' is set
      if @api_client.config.client_side_validation && page_size.nil?
        fail ArgumentError, "Missing the required parameter 'page_size' when calling PersonApi.get_all_persons"
      end
      # resource path
      local_var_path = '/api/v1/persons'

      # query parameters
      query_params = opts[:query_params] || {}
      query_params[:'pageNumber'] = page_number
      query_params[:'pageSize'] = page_size

      # header parameters
      header_params = opts[:header_params] || {}
      # HTTP header 'Accept' (if needed)
      header_params['Accept'] = @api_client.select_header_accept(['*/*'])

      # form parameters
      form_params = opts[:form_params] || {}

      # http body (model)
      post_body = opts[:debug_body]

      # return_type
      return_type = opts[:debug_return_type] || 'String'

      # auth_names
      auth_names = opts[:debug_auth_names] || []

      new_options = opts.merge(
        :operation => :"PersonApi.get_all_persons",
        :header_params => header_params,
        :query_params => query_params,
        :form_params => form_params,
        :body => post_body,
        :auth_names => auth_names,
        :return_type => return_type
      )

      data, status_code, headers = @api_client.call_api(:GET, local_var_path, new_options)
      if @api_client.config.debugging
        @api_client.config.logger.debug "API called: PersonApi#get_all_persons\nData: #{data.inspect}\nStatus code: #{status_code}\nHeaders: #{headers}"
      end
      return data, status_code, headers
    end

    # @param persons_id [Integer] 
    # @param [Hash] opts the optional parameters
    # @return [String]
    def get_person_by_id(persons_id, opts = {})
      data, _status_code, _headers = get_person_by_id_with_http_info(persons_id, opts)
      data
    end

    # @param persons_id [Integer] 
    # @param [Hash] opts the optional parameters
    # @return [Array<(String, Integer, Hash)>] String data, response status code and response headers
    def get_person_by_id_with_http_info(persons_id, opts = {})
      if @api_client.config.debugging
        @api_client.config.logger.debug 'Calling API: PersonApi.get_person_by_id ...'
      end
      # verify the required parameter 'persons_id' is set
      if @api_client.config.client_side_validation && persons_id.nil?
        fail ArgumentError, "Missing the required parameter 'persons_id' when calling PersonApi.get_person_by_id"
      end
      # resource path
      local_var_path = '/api/v1/persons/{personsId}'.sub('{' + 'personsId' + '}', CGI.escape(persons_id.to_s))

      # query parameters
      query_params = opts[:query_params] || {}

      # header parameters
      header_params = opts[:header_params] || {}
      # HTTP header 'Accept' (if needed)
      header_params['Accept'] = @api_client.select_header_accept(['*/*'])

      # form parameters
      form_params = opts[:form_params] || {}

      # http body (model)
      post_body = opts[:debug_body]

      # return_type
      return_type = opts[:debug_return_type] || 'String'

      # auth_names
      auth_names = opts[:debug_auth_names] || []

      new_options = opts.merge(
        :operation => :"PersonApi.get_person_by_id",
        :header_params => header_params,
        :query_params => query_params,
        :form_params => form_params,
        :body => post_body,
        :auth_names => auth_names,
        :return_type => return_type
      )

      data, status_code, headers = @api_client.call_api(:GET, local_var_path, new_options)
      if @api_client.config.debugging
        @api_client.config.logger.debug "API called: PersonApi#get_person_by_id\nData: #{data.inspect}\nStatus code: #{status_code}\nHeaders: #{headers}"
      end
      return data, status_code, headers
    end

    # Operation to filter and sort data on any filed (firstName, address1, countryCode, state), select multiple values for sampling
    # @param filter_dto [FilterDto] 
    # @param [Hash] opts the optional parameters
    # @return [String]
    def get_persons_filtered(filter_dto, opts = {})
      data, _status_code, _headers = get_persons_filtered_with_http_info(filter_dto, opts)
      data
    end

    # Operation to filter and sort data on any filed (firstName, address1, countryCode, state), select multiple values for sampling
    # @param filter_dto [FilterDto] 
    # @param [Hash] opts the optional parameters
    # @return [Array<(String, Integer, Hash)>] String data, response status code and response headers
    def get_persons_filtered_with_http_info(filter_dto, opts = {})
      if @api_client.config.debugging
        @api_client.config.logger.debug 'Calling API: PersonApi.get_persons_filtered ...'
      end
      # verify the required parameter 'filter_dto' is set
      if @api_client.config.client_side_validation && filter_dto.nil?
        fail ArgumentError, "Missing the required parameter 'filter_dto' when calling PersonApi.get_persons_filtered"
      end
      # resource path
      local_var_path = '/api/v1/persons/filter'

      # query parameters
      query_params = opts[:query_params] || {}

      # header parameters
      header_params = opts[:header_params] || {}
      # HTTP header 'Accept' (if needed)
      header_params['Accept'] = @api_client.select_header_accept(['*/*'])
      # HTTP header 'Content-Type'
      content_type = @api_client.select_header_content_type(['application/json'])
      if !content_type.nil?
          header_params['Content-Type'] = content_type
      end

      # form parameters
      form_params = opts[:form_params] || {}

      # http body (model)
      post_body = opts[:debug_body] || @api_client.object_to_http_body(filter_dto)

      # return_type
      return_type = opts[:debug_return_type] || 'String'

      # auth_names
      auth_names = opts[:debug_auth_names] || []

      new_options = opts.merge(
        :operation => :"PersonApi.get_persons_filtered",
        :header_params => header_params,
        :query_params => query_params,
        :form_params => form_params,
        :body => post_body,
        :auth_names => auth_names,
        :return_type => return_type
      )

      data, status_code, headers = @api_client.call_api(:POST, local_var_path, new_options)
      if @api_client.config.debugging
        @api_client.config.logger.debug "API called: PersonApi#get_persons_filtered\nData: #{data.inspect}\nStatus code: #{status_code}\nHeaders: #{headers}"
      end
      return data, status_code, headers
    end

    # Merge person data from dto to entity
    # @param person_dto [PersonDto] 
    # @param [Hash] opts the optional parameters
    # @return [String]
    def update_person(person_dto, opts = {})
      data, _status_code, _headers = update_person_with_http_info(person_dto, opts)
      data
    end

    # Merge person data from dto to entity
    # @param person_dto [PersonDto] 
    # @param [Hash] opts the optional parameters
    # @return [Array<(String, Integer, Hash)>] String data, response status code and response headers
    def update_person_with_http_info(person_dto, opts = {})
      if @api_client.config.debugging
        @api_client.config.logger.debug 'Calling API: PersonApi.update_person ...'
      end
      # verify the required parameter 'person_dto' is set
      if @api_client.config.client_side_validation && person_dto.nil?
        fail ArgumentError, "Missing the required parameter 'person_dto' when calling PersonApi.update_person"
      end
      # resource path
      local_var_path = '/api/v1/persons'

      # query parameters
      query_params = opts[:query_params] || {}

      # header parameters
      header_params = opts[:header_params] || {}
      # HTTP header 'Accept' (if needed)
      header_params['Accept'] = @api_client.select_header_accept(['*/*'])
      # HTTP header 'Content-Type'
      content_type = @api_client.select_header_content_type(['application/json'])
      if !content_type.nil?
          header_params['Content-Type'] = content_type
      end

      # form parameters
      form_params = opts[:form_params] || {}

      # http body (model)
      post_body = opts[:debug_body] || @api_client.object_to_http_body(person_dto)

      # return_type
      return_type = opts[:debug_return_type] || 'String'

      # auth_names
      auth_names = opts[:debug_auth_names] || []

      new_options = opts.merge(
        :operation => :"PersonApi.update_person",
        :header_params => header_params,
        :query_params => query_params,
        :form_params => form_params,
        :body => post_body,
        :auth_names => auth_names,
        :return_type => return_type
      )

      data, status_code, headers = @api_client.call_api(:PUT, local_var_path, new_options)
      if @api_client.config.debugging
        @api_client.config.logger.debug "API called: PersonApi#update_person\nData: #{data.inspect}\nStatus code: #{status_code}\nHeaders: #{headers}"
      end
      return data, status_code, headers
    end
  end
end