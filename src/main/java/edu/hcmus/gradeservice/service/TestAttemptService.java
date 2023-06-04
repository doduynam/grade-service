package edu.hcmus.gradeservice.service;

import edu.hcmus.gradeservice.entity.QuestionEntity;
import edu.hcmus.gradeservice.entity.TestAttemptEntity;
import edu.hcmus.gradeservice.query.request.SubmitRequest;
import edu.hcmus.gradeservice.query.response.SubmitResponse;

public interface TestAttemptService {

	SubmitResponse submit(TestAttemptEntity entity);
}
