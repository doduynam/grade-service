package edu.hcmus.gradeservice.service.impl;

import edu.hcmus.gradeservice.entity.QuestionEntity;
import edu.hcmus.gradeservice.entity.TestAttemptEntity;
import edu.hcmus.gradeservice.query.request.SubmitRequest;
import edu.hcmus.gradeservice.query.response.SubmitResponse;
import edu.hcmus.gradeservice.repository.QuestionRepository;
import edu.hcmus.gradeservice.repository.TestAttemptRepository;
import edu.hcmus.gradeservice.service.QuestionService;
import edu.hcmus.gradeservice.service.TestAttemptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestAttemptServiceImpl implements TestAttemptService {

  private final TestAttemptRepository testAttemptRepository;

//  @Override
//  public QuestionEntity findQuestionById(long id) {
//    return questionRepository
//        .findById(id)
//        .orElse(
//            // Mock data
//            new QuestionEntity()
//                .setId(1)
//                .setQuestionIndex(1)
//                .setContent("Test")
//                .setOptions("Test")
//                .setScore(10));
//  }


  @Override
  public SubmitResponse submit(TestAttemptEntity entity) {

    //Save the user submission into database
    testAttemptRepository.save(entity);

    return ..;
  }
}
