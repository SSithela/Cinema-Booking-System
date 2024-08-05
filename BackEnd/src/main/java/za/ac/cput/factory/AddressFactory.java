
package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.util.Helper;

public class AddressFactory {
    public static Address createAddress(String street, String city, String province, int postalCode, String country){
        if (Helper.isNullOrEmpty(street) || Helper.isNullOrEmpty(city) || Helper.isNullOrEmpty(province) || Helper.isNullOrEmpty(postalCode) || Helper.isNullOrEmpty(country))
            return null;
        return new Address.Builder().setStreet(street)
                .setCity(city)
                .setProvince(province)
                .setPostalCode(postalCode)
                .setCountry(country)
                .build();
    }
}
