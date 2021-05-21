package com.example.onlinesportshopee.services;

import com.example.onlinesportshopee.entities.PaymentEntity;
import com.example.onlinesportshopee.exception.PaymentNotFoundException;
import com.example.onlinesportshopee.model.Payment;

import java.util.List;

public interface IPaymentService {
	
	public Payment addPayment(PaymentEntity payment);
	public Payment removePayment(long id);
	public Payment updatePayment(long id, PaymentEntity payment);
	public Payment getPaymentDetails(long paymentID) throws PaymentNotFoundException;	
	public List<Payment> getAllPaymentDetails(String name);
}
