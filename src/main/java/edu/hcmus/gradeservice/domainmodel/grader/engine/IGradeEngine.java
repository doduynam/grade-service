package edu.hcmus.gradeservice.domainmodel.grader.engine;

import edu.hcmus.gradeservice.domainmodel.grader.result.impl.ResultComparison;
import edu.hcmus.gradeservice.domainmodel.question.IQuestion;
import edu.hcmus.gradeservice.domainmodel.template.Template;

import java.util.Map;

public interface IGradeEngine extends IGradable {

    public Template getUserSubmissionTemplate();
    public Template getCorrectTemplate();

    public void setUserSubmissionTemplate(Template template);
    public void setCorrectTemplate(Template template);

    public Map<Integer, ResultComparison> getResultComparisons();

    //Execute to grading
    public Integer beforeExecute();
    public Integer executeComparison(IQuestion questionHasCorrectAnswer, IQuestion questionHasUserSubmission);
    public Integer afterExecute();
}
