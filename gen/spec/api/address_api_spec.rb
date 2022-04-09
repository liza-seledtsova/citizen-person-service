=begin
#Person API

#Person Information Service

The version of the OpenAPI document: 1.0

Generated by: https://openapi-generator.tech
OpenAPI Generator version: 5.4.0

=end

require 'spec_helper'
require 'json'

# Unit tests for OpenapiClient::AddressApi
# Automatically generated by openapi-generator (https://openapi-generator.tech)
# Please update as you see appropriate
describe 'AddressApi' do
  before do
    # run before each test
    @api_instance = OpenapiClient::AddressApi.new
  end

  after do
    # run after each test
  end

  describe 'test an instance of AddressApi' do
    it 'should create an instance of AddressApi' do
      expect(@api_instance).to be_instance_of(OpenapiClient::AddressApi)
    end
  end

  # unit tests for create_address
  # Create address
  # @param address_dto 
  # @param [Hash] opts the optional parameters
  # @return [String]
  describe 'create_address test' do
    it 'should work' do
      # assertion here. ref: https://www.relishapp.com/rspec/rspec-expectations/docs/built-in-matchers
    end
  end

  # unit tests for delete_address
  # Delete adress by id
  # @param address_id 
  # @param [Hash] opts the optional parameters
  # @return [String]
  describe 'delete_address test' do
    it 'should work' do
      # assertion here. ref: https://www.relishapp.com/rspec/rspec-expectations/docs/built-in-matchers
    end
  end

  # unit tests for get_address_by_id
  # Get address by id
  # @param address_id 
  # @param [Hash] opts the optional parameters
  # @return [String]
  describe 'get_address_by_id test' do
    it 'should work' do
      # assertion here. ref: https://www.relishapp.com/rspec/rspec-expectations/docs/built-in-matchers
    end
  end

  # unit tests for get_all_address
  # Get all address
  # @param [Hash] opts the optional parameters
  # @return [String]
  describe 'get_all_address test' do
    it 'should work' do
      # assertion here. ref: https://www.relishapp.com/rspec/rspec-expectations/docs/built-in-matchers
    end
  end

  # unit tests for update_address
  # Merge address data from dto to entity
  # @param address_dto 
  # @param [Hash] opts the optional parameters
  # @return [String]
  describe 'update_address test' do
    it 'should work' do
      # assertion here. ref: https://www.relishapp.com/rspec/rspec-expectations/docs/built-in-matchers
    end
  end

end
