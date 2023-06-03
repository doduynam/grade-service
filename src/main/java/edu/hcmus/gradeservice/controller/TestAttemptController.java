package edu.hcmus.gradeservice.controller;

import edu.hcmus.gradeservice.entity.QuestionEntity;
import edu.hcmus.gradeservice.query.request.SubmitRequest;
import edu.hcmus.gradeservice.query.request.type.TestAttemptQuery;
import edu.hcmus.gradeservice.query.response.SubmitResponse;
import edu.hcmus.gradeservice.service.QuestionService;
import edu.hcmus.gradeservice.service.TestAttemptService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class TestAttemptController {

    private final TestAttemptService testAttemptService;

    @QueryMapping
    public SubmitResponse submit (SubmitRequest request) {

        TestAttemptQuery testAttempt = request.getTestAttempt();
        SubmitResponse response = testAttemptService.submit(testAttempt.parse());

        return response;
    }


}
