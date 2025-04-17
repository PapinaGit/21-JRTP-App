package com.nit.cms;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nit.client.BillingService_ConsumingClient;

@RestController
@RequestMapping("/shopping-api")
public class ShoppingServiceOperationsController {

	@Autowired
	private BillingService_ConsumingClient clientComp;
	
	@GetMapping("/info")
	public ResponseEntity<String> shoppingInfo(){
		//use the Provider MS
		String billingInfo = clientComp.getBillingInfo();
		//get shopping MS result
		String shoppingInfo = "The shopping billamount is:"+new Random().nextInt(20000);
		//combine the final result
		String finalResult = shoppingInfo+"..."+billingInfo;
		return new ResponseEntity<String>(finalResult,HttpStatus.OK);
	}
	
}
