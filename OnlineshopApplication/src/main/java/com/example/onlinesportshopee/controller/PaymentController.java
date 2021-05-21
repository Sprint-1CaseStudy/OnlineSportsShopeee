package com.example.onlinesportshopee.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.onlinesportshopee.entities.PaymentEntity;
import com.example.onlinesportshopee.exception.PaymentNotFoundException;
import com.example.onlinesportshopee.model.Order;
import com.example.onlinesportshopee.model.Payment;
import com.example.onlinesportshopee.services.IPaymentService;
import com.example.onlinesportshopee.services.PaymentServiceImpl;

@RestController
@RequestMapping("/payments")

public class PaymentController {
	
	static final Logger LOGGER = LoggerFactory.getLogger(PaymentController.class);
	
	@Autowired
	private IPaymentService iPaymentService;
	
	@PostMapping("/addPayment")
	public ResponseEntity<Object> addPayment(@RequestBody PaymentEntity payment)
	{
		LOGGER.info("add-payment URL is opened");
		LOGGER.info("addpayment() is initiated");
		Payment paymentDTO = null;
		paymentDTO = iPaymentService.addPayment(payment);
		LOGGER.info("addpayment() has executed");
		return new ResponseEntity<>(paymentDTO, HttpStatus.ACCEPTED); 
	}
	
	@DeleteMapping("/removePayment/payment/{paymentId}")
	public ResponseEntity<Object> removePayment(@PathVariable long paymentId) throws PaymentNotFoundException
	{
		LOGGER.info("delete-payment URL is opened");
		LOGGER.info("deletePayment() is initiated");
		Payment paymentDTO = null;
		ResponseEntity<Object> paymentResponse = null;
		paymentDTO = iPaymentService.removePayment(paymentId);
		paymentResponse = new ResponseEntity<>(paymentDTO, HttpStatus.ACCEPTED);
		LOGGER.info("deletePayment() has executed");
		return paymentResponse;
		}
	
	@PutMapping("/updatePayment/{paymentId}")
	public ResponseEntity<Object> updatePayment(@PathVariable long paymentId, @RequestBody PaymentEntity paymentEntity)  throws PaymentNotFoundException
	{
		LOGGER.info("update-payment URL is opened");
		LOGGER.info("updatePayment() is initiated");
		Payment paymentDTO = null;
		ResponseEntity<Object> paymentResponse = null;
		paymentDTO = iPaymentService.updatePayment(paymentId,paymentEntity);
		paymentResponse = new ResponseEntity<>(paymentDTO, HttpStatus.ACCEPTED);
		LOGGER.info("updatePayment() has executed");
		return paymentResponse;
	}
	
	@GetMapping("/getPaymentDetails/{paymentId}")
	public ResponseEntity<Object> getPaymentDetails(@PathVariable long paymentId) throws PaymentNotFoundException
	{
		LOGGER.info("getPaymentDetails URL is opened");
		LOGGER.info("getPaymentDetails() is initiated");
		Payment paymentDTO =null;
		ResponseEntity<Object> paymentResponse = null;
		paymentDTO = iPaymentService.getPaymentDetails(paymentId);;
		paymentResponse = new ResponseEntity<>(paymentDTO, HttpStatus.ACCEPTED);
		LOGGER.info("getPaymentDetails() has executed");
		return paymentResponse;
		}
	@GetMapping("/payment/{name}")
	public List<Payment> getAllPaymentByName(@PathVariable String name)
	{
		LOGGER.info("getPaymentbyname URL is opened");
		LOGGER.info("getPaymentbyname() is initiated");
		return iPaymentService.getAllPaymentDetails(name); 		
	}
	
}
