package edu.hcmus.gradeservice.domainmodel.grader.engine;

import edu.hcmus.gradeservice.domainmodel.grader.result.impl.ResultComparison;
import edu.hcmus.gradeservice.domainmodel.question.IQuestion;
import edu.hcmus.gradeservice.domainmodel.template.Template;
import edu.hcmus.gradeservice.nodeapi.model.Question;

import java.util.Map;

public interface IGradeEngine extends IGradable {

    public Template getUserSubmissionTemplate();
    public edu.hcmus.gradeservice.nodeapi.model.Template getCorrectTemplate();

    public void setUserSubmissionTemplate(Template template);
    public void setCorrectTemplate(edu.hcmus.gradeservice.nodeapi.model.Template template);

    public Map<Integer, ResultComparison> getResultComparisons();

    //Execute to grading
    public Integer beforeExecute();
    public Integer executeComparison(Question questionHasCorrectAnswer, IQuestion questionHasUserSubmission);
    public Integer afterExecute();
}
