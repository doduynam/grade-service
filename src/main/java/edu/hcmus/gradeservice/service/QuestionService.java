package edu.hcmus.gradeservice.service;

import edu.hcmus.gradeservice.entity.QuestionEntity;

public interface QuestionService {

	QuestionEntity findQuestionById(long id);
}
