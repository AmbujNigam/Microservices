package in.pwskills.ambuj.services;



import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FetchLatestDataFromProps {
	@Scheduled(cron = "10 * * * * *")
	public void fetch(){
		HttpHeaders headers = new HttpHeaders() ;
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity httpEntity = new HttpEntity("{}", headers); 
		RestTemplate template = new RestTemplate() ;
		ResponseEntity<String> output = template.exchange("http://localhost:9993/actuator/refresh", HttpMethod.POST, httpEntity, String.class) ;
		System.out.println(output) ;
	}
}
