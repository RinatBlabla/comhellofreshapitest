package client;

import configuration.MainConfiguration;
import constants.ChangeValues;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Rinat on 22.11.2019.
 */
public class HttpSpringClient {

    private static Logger log = LoggerFactory.getLogger(HttpSpringClient.class);

    public static  <T> ResponseEntity<T> sendHttpRequest(String url,
                                                         HttpMethod httpMethod,
                                                         HttpEntity entity,
                                                         Class<T> t) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<T> response = null;
        try {
            response = restTemplate.exchange(url, httpMethod, entity, t);
            log.debug("HTTP response = " + response.getBody());
        } catch (HttpClientErrorException e){
            log.error("Request was not sent or didn't receive a response.");
        }
        return response;
    }

    public static String getUri(String url) {
        String siteAdress = "";
        if (MainConfiguration.getPort() != null && MainConfiguration.getSiteAdress() != null) {
            siteAdress = "https://" + MainConfiguration.getSiteAdress() + ":" + MainConfiguration.getPort() + "/" + url;
        }
        if (MainConfiguration.getPort() == null && MainConfiguration.getSiteAdress() != null) {
            siteAdress = "https://" + MainConfiguration.getSiteAdress() + "/" + url;
        }
        log.debug("siteAdress: " + siteAdress);
        return siteAdress;
    }
}
