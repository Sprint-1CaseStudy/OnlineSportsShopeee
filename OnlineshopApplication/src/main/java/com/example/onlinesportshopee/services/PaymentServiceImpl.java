package com.example.onlinesportshopee.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinesportshopee.dao.IPaymentRepository;
import com.example.onlinesportshopee.entities.PaymentEntity;
import com.example.onlinesportshopee.exception.PaymentNotFoundException;
import com.example.onlinesportshopee.model.Payment;
import com.example.onlinesportshopee.util.*;

@Service
public class PaymentServiceImpl implements IPaymentService{
	
    static final Logger LOGGER = LoggerFactory.getLogger(PaymentServiceImpl.class);
    
    static String paymentNotFound = "Payment not found for given Id";
    
    static String validateSuccessful = "Validation Succesful";
     
	@Autowired
	private IPaymentRepository iPaymentRepository;
	//ghhh
	@Override
	public Payment addPayment(PaymentEntity paymentPayment) {
		LOGGER.info("addPayment() service is initiated");
		PaymentEntity paymentEntity=iPaymentRepository.save(paymentPayment);
		LOGGER.info("addPayment() service has executed");
		return PaymentUtils.convertToPayment(paymentEntity);
	}

	@Override
	public Payment removePayment(long paymentID) {
		LOGGER.info("removePayment() service is initiated");
		PaymentEntity paymentEntity=iPaymentRepository.findById(paymentID).get();
		iPaymentRepository.delete(paymentEntity);
		LOGGER.info("removePayment() service has executed");
		return PaymentUtils.convertToPayment(paymentEntity);
		
	}

	@Override
	public Payment updatePayment(long paymentID, PaymentEntity payment) {
		LOGGER.info("updatePayment() service is initiated");
		PaymentEntity paymentEntity=iPaymentRepository.findById(paymentID).get();
		iPaymentRepository.save(paymentEntity);
		LOGGER.info("updatePayment() service has executed");
		return PaymentUtils.convertToPayment(paymentEntity);
		
	}

	@Override
	public Payment getPaymentDetails(long paymentID) throws PaymentNotFoundException {
		LOGGER.info("getPaymentDetails() service is initiated");
		PaymentEntity getPaymentDetails= iPaymentRepository.findById(paymentID).get();
		if (paymentID == 0)
			throw new PaymentNotFoundException("orderNotFound");
		LOGGER.info("getPaymentDetails() service has executed");
		return PaymentUtils.convertToPayment(getPaymentDetails);
		
	}

	@Override
	public List<Payment> getAllPaymentDetails(String name) {
		LOGGER.info("getAllPaymentDetails() service is initiated");
		List<PaymentEntity> getAllPaymentDetails = iPaymentRepository.findAll();
		LOGGER.info("getAllPaymentDetails() service has executed");
		return PaymentUtils.convertToPaymentList(getAllPaymentDetails);
	}

}
