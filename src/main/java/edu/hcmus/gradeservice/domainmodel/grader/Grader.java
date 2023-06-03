package edu.hcmus.gradeservice.domainmodel.grader;

import edu.hcmus.gradeservice.domainmodel.grader.result.impl.TestResult;
import edu.hcmus.gradeservice.domainmodel.attempt.IAttempt;
import edu.hcmus.gradeservice.nodeapi.model.Test;

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
