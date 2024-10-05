package in.pwskills.ambuj.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.pwskills.ambuj.consumer.CartConsumer;

@RestController
@RequestMapping("/v1/api/order")
public class OrderRestController {
	
	@Autowired 
	CartConsumer consumer ; 
	
	@GetMapping("/place")
	public String placeOrder() {
		return "ORDER PLACED WITH => "+consumer.getCartService() ;
	}
	

}
