package com.example.onlinesportshopee.services;

import com.example.onlinesportshopee.entities.AddressEntity;
import com.example.onlinesportshopee.exception.AddressNotFoundException;
import com.example.onlinesportshopee.model.Address;

public interface IAddressService {
	public Address addAddress(AddressEntity address) throws AddressNotFoundException;
	public Address removeAddress(long custId) throws AddressNotFoundException;
	public Address updateAddress(long custId,AddressEntity address) throws AddressNotFoundException;
	public Address getAddress(long custId) throws AddressNotFoundException;

}
//