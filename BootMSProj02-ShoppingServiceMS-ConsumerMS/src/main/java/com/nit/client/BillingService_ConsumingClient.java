package com.nit.client;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BillingService_ConsumingClient {

	@Autowired
	private DiscoveryClient client;

	public String getBillingInfo() { // get provider MS service instance
		List<ServiceInstance> list = client.getInstances("Billing-Service");
		// get the First Instance
		ServiceInstance si = list.get(0); // manually selecting instance
		// get URI of provider MS
		URI uri = si.getUri();
		// prepare the URL from URI pointing b.method of the Provider MS
		String url = uri.toString() + "/billing-api/billing";
		// invoke the provider MS b.method using RestTemplate
		RestTemplate template = new RestTemplate();
		ResponseEntity<String> resp = template.getForEntity(url, String.class);
		String result = resp.getBody();
		return result;

	}

}
