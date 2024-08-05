
package za.ac.cput.service;

import za.ac.cput.domain.Address;

import java.util.List;
import java.util.Set;

public interface IAddressService extends IService<Address, String>{
    List<Address> getAll();

}
