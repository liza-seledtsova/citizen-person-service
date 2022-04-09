=begin
#Person API

#Person Information Service

The version of the OpenAPI document: 1.0

Generated by: https://openapi-generator.tech
OpenAPI Generator version: 5.4.0

=end

require 'cgi'

module OpenapiClient
  class AddressApi
    attr_accessor :api_client

    def initialize(api_client = ApiClient.default)
      @api_client = api_client
    end
    # Create address
    # @param address_dto [AddressDto] 
    # @param [Hash] opts the optional parameters
    # @return [String]
    def create_address(address_dto, opts = {})
      data, _status_code, _headers = create_address_with_http_info(address_dto, opts)
      data
    end

    # Create address
    # @param address_dto [AddressDto] 
    # @param [Hash] opts the optional parameters
    # @return [Array<(String, Integer, Hash)>] String data, response status code and response headers
    def create_address_with_http_info(address_dto, opts = {})
      if @api_client.config.debugging
        @api_client.config.logger.debug 'Calling API: AddressApi.create_address ...'
      end
      # verify the required parameter 'address_dto' is set
      if @api_client.config.client_side_validation && address_dto.nil?
        fail ArgumentError, "Missing the required parameter 'address_dto' when calling AddressApi.create_address"
      end
      # resource path
      local_var_path = '/api/v1/address'

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
      post_body = opts[:debug_body] || @api_client.object_to_http_body(address_dto)

      # return_type
      return_type = opts[:debug_return_type] || 'String'

      # auth_names
      auth_names = opts[:debug_auth_names] || []

      new_options = opts.merge(
        :operation => :"AddressApi.create_address",
        :header_params => header_params,
        :query_params => query_params,
        :form_params => form_params,
        :body => post_body,
        :auth_names => auth_names,
        :return_type => return_type
      )

      data, status_code, headers = @api_client.call_api(:POST, local_var_path, new_options)
      if @api_client.config.debugging
        @api_client.config.logger.debug "API called: AddressApi#create_address\nData: #{data.inspect}\nStatus code: #{status_code}\nHeaders: #{headers}"
      end
      return data, status_code, headers
    end

    # Delete adress by id
    # @param address_id [Integer] 
    # @param [Hash] opts the optional parameters
    # @return [String]
    def delete_address(address_id, opts = {})
      data, _status_code, _headers = delete_address_with_http_info(address_id, opts)
      data
    end

    # Delete adress by id
    # @param address_id [Integer] 
    # @param [Hash] opts the optional parameters
    # @return [Array<(String, Integer, Hash)>] String data, response status code and response headers
    def delete_address_with_http_info(address_id, opts = {})
      if @api_client.config.debugging
        @api_client.config.logger.debug 'Calling API: AddressApi.delete_address ...'
      end
      # verify the required parameter 'address_id' is set
      if @api_client.config.client_side_validation && address_id.nil?
        fail ArgumentError, "Missing the required parameter 'address_id' when calling AddressApi.delete_address"
      end
      # resource path
      local_var_path = '/api/v1/address/{addressId}'.sub('{' + 'addressId' + '}', CGI.escape(address_id.to_s))

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
        :operation => :"AddressApi.delete_address",
        :header_params => header_params,
        :query_params => query_params,
        :form_params => form_params,
        :body => post_body,
        :auth_names => auth_names,
        :return_type => return_type
      )

      data, status_code, headers = @api_client.call_api(:DELETE, local_var_path, new_options)
      if @api_client.config.debugging
        @api_client.config.logger.debug "API called: AddressApi#delete_address\nData: #{data.inspect}\nStatus code: #{status_code}\nHeaders: #{headers}"
      end
      return data, status_code, headers
    end

    # Get address by id
    # @param address_id [Integer] 
    # @param [Hash] opts the optional parameters
    # @return [String]
    def get_address_by_id(address_id, opts = {})
      data, _status_code, _headers = get_address_by_id_with_http_info(address_id, opts)
      data
    end

    # Get address by id
    # @param address_id [Integer] 
    # @param [Hash] opts the optional parameters
    # @return [Array<(String, Integer, Hash)>] String data, response status code and response headers
    def get_address_by_id_with_http_info(address_id, opts = {})
      if @api_client.config.debugging
        @api_client.config.logger.debug 'Calling API: AddressApi.get_address_by_id ...'
      end
      # verify the required parameter 'address_id' is set
      if @api_client.config.client_side_validation && address_id.nil?
        fail ArgumentError, "Missing the required parameter 'address_id' when calling AddressApi.get_address_by_id"
      end
      # resource path
      local_var_path = '/api/v1/address/{addressId}'.sub('{' + 'addressId' + '}', CGI.escape(address_id.to_s))

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
        :operation => :"AddressApi.get_address_by_id",
        :header_params => header_params,
        :query_params => query_params,
        :form_params => form_params,
        :body => post_body,
        :auth_names => auth_names,
        :return_type => return_type
      )

      data, status_code, headers = @api_client.call_api(:GET, local_var_path, new_options)
      if @api_client.config.debugging
        @api_client.config.logger.debug "API called: AddressApi#get_address_by_id\nData: #{data.inspect}\nStatus code: #{status_code}\nHeaders: #{headers}"
      end
      return data, status_code, headers
    end

    # Get all address
    # @param [Hash] opts the optional parameters
    # @return [String]
    def get_all_address(opts = {})
      data, _status_code, _headers = get_all_address_with_http_info(opts)
      data
    end

    # Get all address
    # @param [Hash] opts the optional parameters
    # @return [Array<(String, Integer, Hash)>] String data, response status code and response headers
    def get_all_address_with_http_info(opts = {})
      if @api_client.config.debugging
        @api_client.config.logger.debug 'Calling API: AddressApi.get_all_address ...'
      end
      # resource path
      local_var_path = '/api/v1/address'

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
        :operation => :"AddressApi.get_all_address",
        :header_params => header_params,
        :query_params => query_params,
        :form_params => form_params,
        :body => post_body,
        :auth_names => auth_names,
        :return_type => return_type
      )

      data, status_code, headers = @api_client.call_api(:GET, local_var_path, new_options)
      if @api_client.config.debugging
        @api_client.config.logger.debug "API called: AddressApi#get_all_address\nData: #{data.inspect}\nStatus code: #{status_code}\nHeaders: #{headers}"
      end
      return data, status_code, headers
    end

    # Merge address data from dto to entity
    # @param address_dto [AddressDto] 
    # @param [Hash] opts the optional parameters
    # @return [String]
    def update_address(address_dto, opts = {})
      data, _status_code, _headers = update_address_with_http_info(address_dto, opts)
      data
    end

    # Merge address data from dto to entity
    # @param address_dto [AddressDto] 
    # @param [Hash] opts the optional parameters
    # @return [Array<(String, Integer, Hash)>] String data, response status code and response headers
    def update_address_with_http_info(address_dto, opts = {})
      if @api_client.config.debugging
        @api_client.config.logger.debug 'Calling API: AddressApi.update_address ...'
      end
      # verify the required parameter 'address_dto' is set
      if @api_client.config.client_side_validation && address_dto.nil?
        fail ArgumentError, "Missing the required parameter 'address_dto' when calling AddressApi.update_address"
      end
      # resource path
      local_var_path = '/api/v1/address'

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
      post_body = opts[:debug_body] || @api_client.object_to_http_body(address_dto)

      # return_type
      return_type = opts[:debug_return_type] || 'String'

      # auth_names
      auth_names = opts[:debug_auth_names] || []

      new_options = opts.merge(
        :operation => :"AddressApi.update_address",
        :header_params => header_params,
        :query_params => query_params,
        :form_params => form_params,
        :body => post_body,
        :auth_names => auth_names,
        :return_type => return_type
      )

      data, status_code, headers = @api_client.call_api(:PUT, local_var_path, new_options)
      if @api_client.config.debugging
        @api_client.config.logger.debug "API called: AddressApi#update_address\nData: #{data.inspect}\nStatus code: #{status_code}\nHeaders: #{headers}"
      end
      return data, status_code, headers
    end
  end
end