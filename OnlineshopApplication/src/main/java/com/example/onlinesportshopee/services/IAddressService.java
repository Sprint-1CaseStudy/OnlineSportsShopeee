package com.example.onlinesportshopee.services;

import com.example.onlinesportshopee.entities.AddressEntity;
import com.example.onlinesportshopee.exception.AddressNotFoundException;
import com.example.onlinesportshopee.model.Address;

public interface IAddressService {
	public Address addAddress(Address address) throws AddressNotFoundException;
	public Address removeAddress(Long custId) throws AddressNotFoundException;
	public Address updateAddress(Long custId,Address address) throws AddressNotFoundException;
	public Address getAddress(Long custId) throws AddressNotFoundException;

}
//