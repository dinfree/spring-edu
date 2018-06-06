package com.dinfree.spring.edu.restclient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class RestClientBike {
    public RestClientBike() {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://apis.data.go.kr/B552061/frequentzoneBicycle/getRestFrequentzoneBicycle?servicekey=WSee%2F0CdkoONJab8fkRpCS3HzErmkJOGAqerFnaqsUCYqqXK%2B4q20PLTe3tZcvGZHi7eInNvzmXKEjPfggVSgA%3D%3D&searchYearCd=2017050&sido=11&gugun=";
        String url = null;
        // url Key 값에 url encoding 되어 있으므로 이를 decode 해야 정상적으로 동작함.
        try {
            url = URLDecoder.decode(resourceUrl, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        System.out.println(response.getBody());

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = null;
        try {
            root = mapper.readTree(response.getBody());
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonNode node = root.path("searchResult").path("frequentzone").get(0);
        System.out.println(node.get("spot").textValue());
    }

    public static void main(String[] args) {
        RestClientBike app = new RestClientBike();
    }
}
