package in.pwskills.ambuj.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.pwskills.ambuj.consumer.ICartConsumer;
import in.pwskills.ambuj.response.Cart;

@RestController
@RequestMapping("/v1/api/order")
public class OrderRestController {
	
	@Autowired
	ICartConsumer consumer ;
	
	@GetMapping("/fetch/{id}")
	public ResponseEntity<Cart> fetchOrderWithCart(@PathVariable Integer id) {
		Cart cart = consumer.getCart(id).getBody();
		return ResponseEntity.ok(cart) ;
	}
	
	@GetMapping("/place")
	public ResponseEntity<String> getMethodName() {
		String fetchProduct = consumer.fetchProduct().getBody();
		return ResponseEntity.ok(fetchProduct) ;
	}
	
	
	@PostMapping("/addToCart")
	public ResponseEntity<String> postMethodName(@RequestBody Cart cart) {
		String cartResp = consumer.addCart(cart).getBody();
		
		return ResponseEntity.ok("ORDER WITH => " + cartResp);
	}
	
	
}
