package edu.hcmus.gradeservice.service.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.hcmus.gradeservice.service.WarriorCoreService;
import edu.hcmus.gradeservice.thirdparty.warriorcore.model.Test;
import edu.hcmus.gradeservice.thirdparty.warriorcore.response.GetCorrectTestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
@RequiredArgsConstructor
public class WarriorCoreServiceImpl implements WarriorCoreService {

    @Value("${warrior.nodejs-api-url}")
    private String nodeJsApiUrl;
    @Override
    public Test getTestHasCorrectAnswerById(Integer id) {

        Test result = null;

        try {
            String url = nodeJsApiUrl + "/reading-skill/admin/test/" + id;
            URL endpoint = new URL(url);

            HttpURLConnection conn = (HttpURLConnection) endpoint.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

//            if (200 != conn.getResponseCode()) {
//                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
//            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); //ignore the undeclared property
            GetCorrectTestResponse responseBody = mapper.readValue(br, GetCorrectTestResponse.class);
            result = responseBody.getData();

        } catch (Exception error) {
            error.printStackTrace();
        }

        return result;
    };
}
