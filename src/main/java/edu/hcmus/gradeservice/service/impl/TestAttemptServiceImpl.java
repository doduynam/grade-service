package edu.hcmus.gradeservice.service.impl;

import edu.hcmus.gradeservice.domainmodel.grader.Grader;
import edu.hcmus.gradeservice.domainmodel.grader.result.impl.TestResult;
import edu.hcmus.gradeservice.entity.QuestionEntity;
import edu.hcmus.gradeservice.entity.TestAttemptEntity;
import edu.hcmus.gradeservice.query.request.SubmitRequest;
import edu.hcmus.gradeservice.query.response.SubmitResponse;
import edu.hcmus.gradeservice.repository.QuestionRepository;
import edu.hcmus.gradeservice.repository.TestAttemptRepository;
import edu.hcmus.gradeservice.service.QuestionService;
import edu.hcmus.gradeservice.service.TestAttemptService;
import edu.hcmus.gradeservice.service.WarriorCoreService;
import edu.hcmus.gradeservice.thirdparty.warriorcore.model.Section;
import edu.hcmus.gradeservice.thirdparty.warriorcore.model.Test;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class TestAttemptServiceImpl implements TestAttemptService {

    private final TestAttemptRepository testAttemptRepository;
    private final WarriorCoreService warriorCoreService;

    @Override
    public SubmitResponse submit(TestAttemptEntity entity) {

        //Save the user submission into database
        testAttemptRepository.save(entity);

        //Get the correct answer from the Warrior Core (The nodejs backend);
        Integer testHasCorrectAnswerId = entity.getOriginalTestId();
        Test testHasCorrectAnswer = warriorCoreService.getTestHasCorrectAnswerById(testHasCorrectAnswerId);
        testHasCorrectAnswer.mapperize();

        //Start grading
        Grader grader = new Grader();
        grader.setCorrectSolution(testHasCorrectAnswer);
        grader.setUserSubmission(entity.getAttemptEntity().parse());
        grader.executeGrading();

        return SubmitResponse.parse(grader.getTestResult());
    }
}
