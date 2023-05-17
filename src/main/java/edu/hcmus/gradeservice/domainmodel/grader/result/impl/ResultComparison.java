package edu.hcmus.gradeservice.domainmodel.grader.result.impl;

import edu.hcmus.gradeservice.domainmodel.answer.IAnswer;
import edu.hcmus.gradeservice.domainmodel.grader.result.IResultComparable;
import edu.hcmus.gradeservice.domainmodel.question.IQuestion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ResultComparison implements IResultComparable<ResultComparison> {

    protected IQuestion questionHasCorrectAnswer;
    protected IQuestion questionHasUserSubmissionAnswer;
    protected Integer score;
    protected Boolean isCorrect;

    //Dummy function, we do not use this method in only this class
    @Override
    public Map<Integer, ResultComparison> getResultComparables() {
        return null;
    }
}
