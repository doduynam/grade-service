package edu.hcmus.gradeservice.domainmodel.grader.result.impl;

import edu.hcmus.gradeservice.domainmodel.grader.result.IResultComparable;
import edu.hcmus.gradeservice.domainmodel.question.IQuestion;
import edu.hcmus.gradeservice.thirdparty.warriorcore.model.Question;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ResultComparison implements IResultComparable<ResultComparison> {

    protected Question questionHasCorrectAnswer;
    protected IQuestion questionHasUserSubmissionAnswer;
    protected Integer score;
    protected Boolean isCorrect;

    //Dummy function, we do not use this method in only this class
    @Override
    public Map<Integer, ResultComparison> getResultComparables() {
        return null;
    }
}
