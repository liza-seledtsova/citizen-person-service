package com.citizen.person.enums;

import static com.citizen.person.enums.Type.NESTED;
import static com.citizen.person.enums.Type.NON_NESTED;

/**
 * The enum Filter name.
 */
public enum FilterName {
    FIRST_NAME("firstName", NON_NESTED),
    SURNAME("surname", NON_NESTED),
    ADDRESS1("address_address1", NESTED),
    ADDRESS2("address_address2", NESTED),
    CITY("address_city_name", NESTED),
    STATE("address_city_country_state", NESTED),
    POSTCODE("address_postcode", NESTED),
    COUNTRY_CODE("person_address_city_country_countryCode", NESTED),
    GENDER("gender", NON_NESTED),
    DATE_OF_BIRTH("dateofbirth", NON_NESTED);


    private final String name;
    private final Type type;

    FilterName(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public String getValue() {
        return this.name;
    }

    public Type getType() {
        return this.type;
    }

}
