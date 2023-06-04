package edu.hcmus.gradeservice.domainmodel.grader;

import edu.hcmus.gradeservice.domainmodel.grader.result.impl.TestResult;
import edu.hcmus.gradeservice.domainmodel.attempt.IAttempt;
import edu.hcmus.gradeservice.thirdparty.warriorcore.model.Test;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Getter
@Setter
public class Grader {

    protected IAttempt userSubmission;
    protected Test correctSolution;
    protected TestResult testResult;

    public Integer executeGrading() {
        testResult = new TestResult();
        testResult.setUserSubmission(userSubmission);
        testResult.setCorrectSolution(correctSolution);

        Integer errorCode = testResult.executeGrading();

        return errorCode;
    }
}
