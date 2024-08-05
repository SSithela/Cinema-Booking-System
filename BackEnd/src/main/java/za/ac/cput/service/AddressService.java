
package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Address;
import za.ac.cput.repository.AddressRepository;

import java.util.List;

@Service
public class AddressService implements IAddressService{
    private AddressRepository repository;

    @Autowired
    private AddressService(AddressRepository addressRepository){
        this.repository = addressRepository;
    }

    @Override
    public Address create(Address address){
        return this.repository.save(address);
    }

    public Address read(String id){
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Address update(Address address){
        return null;
    }

    @Override
    public boolean delete(String id){
        if (this.repository.existsById(id)){
            this.repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Address> getAll(){
        return this.repository.findAll();
    }
}
