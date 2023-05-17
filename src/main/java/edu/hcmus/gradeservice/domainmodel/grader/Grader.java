package edu.hcmus.gradeservice.domainmodel.grader;

import edu.hcmus.gradeservice.domainmodel.grader.result.impl.TestResult;
import edu.hcmus.gradeservice.domainmodel.test.ITest;

public class Grader {

    protected ITest userSubmission;
    protected ITest correctSolution;
    protected TestResult testResult;


    public Integer executeGrading() {
        testResult = new TestResult();
        testResult.setUserSubmission(userSubmission);
        testResult.setCorrectSolution(correctSolution);


        testResult.executeGrading();

        return 0;
    }
}
