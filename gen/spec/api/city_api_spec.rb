=begin
#Person API

#Person Information Service

The version of the OpenAPI document: 1.0

Generated by: https://openapi-generator.tech
OpenAPI Generator version: 5.4.0

=end

require 'spec_helper'
require 'json'

# Unit tests for OpenapiClient::CityApi
# Automatically generated by openapi-generator (https://openapi-generator.tech)
# Please update as you see appropriate
describe 'CityApi' do
  before do
    # run before each test
    @api_instance = OpenapiClient::CityApi.new
  end

  after do
    # run after each test
  end

  describe 'test an instance of CityApi' do
    it 'should create an instance of CityApi' do
      expect(@api_instance).to be_instance_of(OpenapiClient::CityApi)
    end
  end

  # unit tests for create_city
  # Create city
  # @param city_dto 
  # @param [Hash] opts the optional parameters
  # @return [String]
  describe 'create_city test' do
    it 'should work' do
      # assertion here. ref: https://www.relishapp.com/rspec/rspec-expectations/docs/built-in-matchers
    end
  end

  # unit tests for delete_city
  # Delete city by id
  # @param city_id 
  # @param [Hash] opts the optional parameters
  # @return [String]
  describe 'delete_city test' do
    it 'should work' do
      # assertion here. ref: https://www.relishapp.com/rspec/rspec-expectations/docs/built-in-matchers
    end
  end

  # unit tests for get_all_city
  # Get All city
  # @param [Hash] opts the optional parameters
  # @return [String]
  describe 'get_all_city test' do
    it 'should work' do
      # assertion here. ref: https://www.relishapp.com/rspec/rspec-expectations/docs/built-in-matchers
    end
  end

  # unit tests for get_city_by_id
  # get city by id
  # @param city_id 
  # @param [Hash] opts the optional parameters
  # @return [String]
  describe 'get_city_by_id test' do
    it 'should work' do
      # assertion here. ref: https://www.relishapp.com/rspec/rspec-expectations/docs/built-in-matchers
    end
  end

  # unit tests for update_city
  # Merge  city a from dto to entity
  # @param city_dto 
  # @param [Hash] opts the optional parameters
  # @return [String]
  describe 'update_city test' do
    it 'should work' do
      # assertion here. ref: https://www.relishapp.com/rspec/rspec-expectations/docs/built-in-matchers
    end
  end

end