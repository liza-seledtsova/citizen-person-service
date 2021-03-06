=begin
#Person API

#Person Information Service

The version of the OpenAPI document: 1.0

Generated by: https://openapi-generator.tech
OpenAPI Generator version: 5.4.0

=end

require 'cgi'

module OpenapiClient
  class StateApi
    attr_accessor :api_client

    def initialize(api_client = ApiClient.default)
      @api_client = api_client
    end
    # Create state
    # @param state_dto [StateDto] 
    # @param [Hash] opts the optional parameters
    # @return [String]
    def create_state(state_dto, opts = {})
      data, _status_code, _headers = create_state_with_http_info(state_dto, opts)
      data
    end

    # Create state
    # @param state_dto [StateDto] 
    # @param [Hash] opts the optional parameters
    # @return [Array<(String, Integer, Hash)>] String data, response status code and response headers
    def create_state_with_http_info(state_dto, opts = {})
      if @api_client.config.debugging
        @api_client.config.logger.debug 'Calling API: StateApi.create_state ...'
      end
      # verify the required parameter 'state_dto' is set
      if @api_client.config.client_side_validation && state_dto.nil?
        fail ArgumentError, "Missing the required parameter 'state_dto' when calling StateApi.create_state"
      end
      # resource path
      local_var_path = '/api/v1/state'

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
      post_body = opts[:debug_body] || @api_client.object_to_http_body(state_dto)

      # return_type
      return_type = opts[:debug_return_type] || 'String'

      # auth_names
      auth_names = opts[:debug_auth_names] || []

      new_options = opts.merge(
        :operation => :"StateApi.create_state",
        :header_params => header_params,
        :query_params => query_params,
        :form_params => form_params,
        :body => post_body,
        :auth_names => auth_names,
        :return_type => return_type
      )

      data, status_code, headers = @api_client.call_api(:POST, local_var_path, new_options)
      if @api_client.config.debugging
        @api_client.config.logger.debug "API called: StateApi#create_state\nData: #{data.inspect}\nStatus code: #{status_code}\nHeaders: #{headers}"
      end
      return data, status_code, headers
    end

    # Delete state by id
    # @param state_id [Integer] 
    # @param [Hash] opts the optional parameters
    # @return [String]
    def delete_state(state_id, opts = {})
      data, _status_code, _headers = delete_state_with_http_info(state_id, opts)
      data
    end

    # Delete state by id
    # @param state_id [Integer] 
    # @param [Hash] opts the optional parameters
    # @return [Array<(String, Integer, Hash)>] String data, response status code and response headers
    def delete_state_with_http_info(state_id, opts = {})
      if @api_client.config.debugging
        @api_client.config.logger.debug 'Calling API: StateApi.delete_state ...'
      end
      # verify the required parameter 'state_id' is set
      if @api_client.config.client_side_validation && state_id.nil?
        fail ArgumentError, "Missing the required parameter 'state_id' when calling StateApi.delete_state"
      end
      # resource path
      local_var_path = '/api/v1/state/{stateId}'.sub('{' + 'stateId' + '}', CGI.escape(state_id.to_s))

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
        :operation => :"StateApi.delete_state",
        :header_params => header_params,
        :query_params => query_params,
        :form_params => form_params,
        :body => post_body,
        :auth_names => auth_names,
        :return_type => return_type
      )

      data, status_code, headers = @api_client.call_api(:DELETE, local_var_path, new_options)
      if @api_client.config.debugging
        @api_client.config.logger.debug "API called: StateApi#delete_state\nData: #{data.inspect}\nStatus code: #{status_code}\nHeaders: #{headers}"
      end
      return data, status_code, headers
    end

    # Get All entry of state
    # @param [Hash] opts the optional parameters
    # @return [String]
    def get_all_state(opts = {})
      data, _status_code, _headers = get_all_state_with_http_info(opts)
      data
    end

    # Get All entry of state
    # @param [Hash] opts the optional parameters
    # @return [Array<(String, Integer, Hash)>] String data, response status code and response headers
    def get_all_state_with_http_info(opts = {})
      if @api_client.config.debugging
        @api_client.config.logger.debug 'Calling API: StateApi.get_all_state ...'
      end
      # resource path
      local_var_path = '/api/v1/state'

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
        :operation => :"StateApi.get_all_state",
        :header_params => header_params,
        :query_params => query_params,
        :form_params => form_params,
        :body => post_body,
        :auth_names => auth_names,
        :return_type => return_type
      )

      data, status_code, headers = @api_client.call_api(:GET, local_var_path, new_options)
      if @api_client.config.debugging
        @api_client.config.logger.debug "API called: StateApi#get_all_state\nData: #{data.inspect}\nStatus code: #{status_code}\nHeaders: #{headers}"
      end
      return data, status_code, headers
    end

    # Get state by id
    # @param state_id [Integer] 
    # @param [Hash] opts the optional parameters
    # @return [String]
    def get_state_by_id(state_id, opts = {})
      data, _status_code, _headers = get_state_by_id_with_http_info(state_id, opts)
      data
    end

    # Get state by id
    # @param state_id [Integer] 
    # @param [Hash] opts the optional parameters
    # @return [Array<(String, Integer, Hash)>] String data, response status code and response headers
    def get_state_by_id_with_http_info(state_id, opts = {})
      if @api_client.config.debugging
        @api_client.config.logger.debug 'Calling API: StateApi.get_state_by_id ...'
      end
      # verify the required parameter 'state_id' is set
      if @api_client.config.client_side_validation && state_id.nil?
        fail ArgumentError, "Missing the required parameter 'state_id' when calling StateApi.get_state_by_id"
      end
      # resource path
      local_var_path = '/api/v1/state/{stateId}'.sub('{' + 'stateId' + '}', CGI.escape(state_id.to_s))

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
        :operation => :"StateApi.get_state_by_id",
        :header_params => header_params,
        :query_params => query_params,
        :form_params => form_params,
        :body => post_body,
        :auth_names => auth_names,
        :return_type => return_type
      )

      data, status_code, headers = @api_client.call_api(:GET, local_var_path, new_options)
      if @api_client.config.debugging
        @api_client.config.logger.debug "API called: StateApi#get_state_by_id\nData: #{data.inspect}\nStatus code: #{status_code}\nHeaders: #{headers}"
      end
      return data, status_code, headers
    end

    # Merge data from dto to entity
    # @param state_dto [StateDto] 
    # @param [Hash] opts the optional parameters
    # @return [String]
    def update_state(state_dto, opts = {})
      data, _status_code, _headers = update_state_with_http_info(state_dto, opts)
      data
    end

    # Merge data from dto to entity
    # @param state_dto [StateDto] 
    # @param [Hash] opts the optional parameters
    # @return [Array<(String, Integer, Hash)>] String data, response status code and response headers
    def update_state_with_http_info(state_dto, opts = {})
      if @api_client.config.debugging
        @api_client.config.logger.debug 'Calling API: StateApi.update_state ...'
      end
      # verify the required parameter 'state_dto' is set
      if @api_client.config.client_side_validation && state_dto.nil?
        fail ArgumentError, "Missing the required parameter 'state_dto' when calling StateApi.update_state"
      end
      # resource path
      local_var_path = '/api/v1/state'

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
      post_body = opts[:debug_body] || @api_client.object_to_http_body(state_dto)

      # return_type
      return_type = opts[:debug_return_type] || 'String'

      # auth_names
      auth_names = opts[:debug_auth_names] || []

      new_options = opts.merge(
        :operation => :"StateApi.update_state",
        :header_params => header_params,
        :query_params => query_params,
        :form_params => form_params,
        :body => post_body,
        :auth_names => auth_names,
        :return_type => return_type
      )

      data, status_code, headers = @api_client.call_api(:PUT, local_var_path, new_options)
      if @api_client.config.debugging
        @api_client.config.logger.debug "API called: StateApi#update_state\nData: #{data.inspect}\nStatus code: #{status_code}\nHeaders: #{headers}"
      end
      return data, status_code, headers
    end
  end
end
