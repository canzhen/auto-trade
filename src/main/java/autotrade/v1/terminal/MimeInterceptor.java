package autotrade.v1.terminal;

import java.io.IOException;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
 
public class MimeInterceptor implements ClientHttpRequestInterceptor {
 
    private final Logger log = LoggerFactory.getLogger(this.getClass());
 
  //  @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        
    	HttpHeaders headers = request.getHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);

    	return execution.execute(request, body);
    }
 
    private void logRequest(HttpRequest request, byte[] body) throws IOException {
        log.debug("  request begin ");

        log.debug("URI: "+ request.getURI());
        log.debug("Method      : {}"+ request.getMethod());
        log.debug("Headers     : {}"+ request.getHeaders());
        log.debug("Request body: {}"+ new String(body, "UTF-8"));
        log.debug("  request end ");
    }
 
    private void logResponse(ClientHttpResponse response) throws IOException {
        if (log.isDebugEnabled()) {
            log.debug("Status code  :", response.getStatusCode());
            log.debug("Status text  :", response.getStatusText());
            
           // BufferedReader br =  new BufferedReader(response.getBody());
            
        }
    }
}
