package com.example.onlinesportshopee.util;

import com.example.onlinesportshopee.entities.AddressEntity;
import com.example.onlinesportshopee.model.Address;

public class AddressUtils {
	//
	private AddressUtils()
	{
		
	}
	public static AddressEntity convertToAddressEntity(Address address) {
		AddressEntity addressentity = new AddressEntity();
		addressentity.setId(address.getID());
		addressentity.setStreet(address.getStreet());
		addressentity.setArea(address.getArea());
		addressentity.setCity(address.getCity());
		addressentity.setState(address.getState());
		addressentity.setPincode(address.getPincode());
		addressentity.setCustomerEntity(address.getCustomerEntity());
		return addressentity;
	}		
	
	public static Address convertToAddress(AddressEntity addressentity) {
		Address address = new Address();
		address.setID(addressentity.getId());
		address.setStreet(addressentity.getStreet());
		address.setArea(addressentity.getArea());
		address.setCity(addressentity.getCity());
		address.setState(addressentity.getState());
		address.setPincode(addressentity.getPincode());
		address.setCustomerEntity(addressentity.getCustomerEntity());
		return address;
	}

}
