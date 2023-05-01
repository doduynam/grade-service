package edu.hcmus.gradeservice.service.impl;

import edu.hcmus.gradeservice.entity.QuestionEntity;
import edu.hcmus.gradeservice.repository.QuestionRepository;
import edu.hcmus.gradeservice.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

  private final QuestionRepository questionRepository;

  @Override
  public QuestionEntity findQuestionById(long id) {
    return questionRepository
        .findById(id)
        .orElse(
            // Mock data
            new QuestionEntity()
                .setId(1)
                .setQuestionIndex(1)
                .setContent("Test")
                .setOptions("Test")
                .setScore(10));
  }
}
