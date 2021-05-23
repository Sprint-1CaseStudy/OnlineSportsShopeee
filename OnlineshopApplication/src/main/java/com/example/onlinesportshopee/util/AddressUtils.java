package com.example.onlinesportshopee.util;

import java.util.ArrayList;
import java.util.List;

import com.example.onlinesportshopee.entities.AddressEntity;
import com.example.onlinesportshopee.entities.CustomerEntity;
import com.example.onlinesportshopee.model.Address;
import com.example.onlinesportshopee.model.Customer;

public class AddressUtils {
	//
	private AddressUtils()
	{
		
	}
	
	public static List<Address> convertToAddressList(List<AddressEntity> list){
		List<Address> addList = new ArrayList<>();
		for(AddressEntity address : list) 
			addList.add(convertToAddress(address));
		return addList;
	}
	
	public static AddressEntity convertToAddressEntity(Address address) {
		AddressEntity addressentity = new AddressEntity();
		addressentity.setId(Long.parseLong(address.getDoorNo()));
		addressentity.setStreet(address.getStreet());
		addressentity.setArea(address.getArea());
		addressentity.setCity(address.getCity());
		addressentity.setState(address.getState());
		addressentity.setPincode(address.getPincode());
		return addressentity;
	}		
	
	public static Address convertToAddress(AddressEntity addressentity) {
		Address address = new Address();
		address.setDoorNo(addressentity.getId().toString());
		address.setStreet(addressentity.getStreet());
		address.setArea(addressentity.getArea());
		address.setCity(addressentity.getCity());
		address.setState(addressentity.getState());
		address.setPincode(addressentity.getPincode());
		return address;
	}

}
