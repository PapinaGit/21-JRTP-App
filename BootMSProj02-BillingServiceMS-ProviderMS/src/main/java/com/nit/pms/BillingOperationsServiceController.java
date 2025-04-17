package com.nit.pms;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billing-api")
public class BillingOperationsServiceController {
	
	@GetMapping("/billing")
	public ResponseEntity<String> showBillingInfo(){
		return new ResponseEntity<String>("we accept UPI Payments, DebitCards, CreditCards etc...",HttpStatus.OK);
	}

}
