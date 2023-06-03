package edu.hcmus.gradeservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.hcmus.gradeservice.service.WarriorCoreService;
import edu.hcmus.gradeservice.thirdparty.warriorcore.model.Test;
import edu.hcmus.gradeservice.thirdparty.warriorcore.response.GetCorrectTestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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
            URL endpoint = new URL(nodeJsApiUrl);
            ObjectMapper mapper = new ObjectMapper();
            GetCorrectTestResponse responseBody = mapper.readValue(endpoint, GetCorrectTestResponse.class);
            result = responseBody.getData();

        } catch (Exception error) {
            error.printStackTrace();
        }

        return result;
    };
}
