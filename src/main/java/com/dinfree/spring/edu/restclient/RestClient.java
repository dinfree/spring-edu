package com.dinfree.spring.edu.restclient;

import com.dinfree.spring.edu.simpledata.SimpleData;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.ArrayType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RestClient {
    /**
     * 공공 데이터 포탈의 자전거 사고 조회 api 이용 예.
     */
    public void getBikeAccident() {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://apis.data.go.kr/B552061/frequentzoneBicycle/getRestFrequentzoneBicycle?servicekey=WSee/0CdkoONJab8fkRpCS3HzErmkJOGAqerFnaqsUCYqqXK+4q20PLTe3tZcvGZHi7eInNvzmXKEjPfggVSgA==&searchYearCd=2017050&sido=11&gugun=";


        /* url decode 되지 않은 키 값을 사용하는 경우
        String resourceUrl = "http://apis.data.go.kr/B552061/frequentzoneBicycle/getRestFrequentzoneBicycle?servicekey=WSee%2F0CdkoONJab8fkRpCS3HzErmkJOGAqerFnaqsUCYqqXK%2B4q20PLTe3tZcvGZHi7eInNvzmXKEjPfggVSgA%3D%3D&searchYearCd=2017050&sido=11&gugun=";
        String url = null;
        // url Key 값에 url encoding 되어 있으므로 이를 decode 해야 정상적으로 동작함.
        try {
            url = URLDecoder.decode(resourceUrl, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        */

        ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl, String.class);

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

    /**
     * spring edu 프로젝트의 simple data api 사용 예.
     */
    public void getSimpleData() {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://localhost:9090/simple/list";
        ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl, String.class);

        ObjectMapper mapper = new ObjectMapper();

        // Object Mapper 를 이용해 List 형태의 Object 로 json array 를 매핑하는 예제.
        try {
            List<SimpleData> datas = mapper.readValue(response.getBody(), new TypeReference<List<SimpleData>>(){});
            for(SimpleData data : datas) {
                System.out.printf("id:%d, 이름:%s, 이메일:%s\n",data.getAid(), data.getName(), data.getEmail());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* JsonNode 구조로 json 메시지를 핸들링 하는 예.
        JsonNode root = null;
        try {
            root = mapper.readTree(response.getBody());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Iterator iter = root.iterator();

        while(iter.hasNext()){
            JsonNode node = (JsonNode) iter.next();
            System.out.println(node.get("email").textValue());
        }
        */
    }

    public static void main(String[] args) {
        RestClient app = new RestClient();
        //app.getBikeAccident();
        app.getSimpleData();
    }
}
