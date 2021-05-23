package com.example.onlinesportshopee.services;

import com.example.onlinesportshopee.entities.PaymentEntity;
import com.example.onlinesportshopee.exception.PaymentNotFoundException;
import com.example.onlinesportshopee.model.Payment;

import java.util.List;

public interface IPaymentService {
	
	public Payment addPayment(Payment payment);
	public Payment removePayment(Long id);
	public Payment updatePayment(Long id, Payment payment);
	public Payment getPaymentDetails(Long paymentID) throws PaymentNotFoundException;	
	public List<Payment> getAllPaymentDetails();
}
