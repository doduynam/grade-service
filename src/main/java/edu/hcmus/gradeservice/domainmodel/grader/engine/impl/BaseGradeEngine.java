package edu.hcmus.gradeservice.domainmodel.grader.engine.impl;

import edu.hcmus.gradeservice.domainmodel.grader.engine.IGradeEngine;
import edu.hcmus.gradeservice.domainmodel.grader.result.impl.ResultComparison;
import edu.hcmus.gradeservice.domainmodel.question.IQuestion;
import edu.hcmus.gradeservice.domainmodel.template.Template;
import edu.hcmus.gradeservice.thirdparty.warriorcore.model.Question;

import java.util.Map;

public class BaseGradeEngine implements IGradeEngine {

    protected Template userSubmissionTemplate;
    protected edu.hcmus.gradeservice.thirdparty.warriorcore.model.Template correctTemplate;

    protected Integer totalScore;
    protected Map<Integer, ResultComparison> resultComparisons;
    @Override
    public Integer getTotalScore() {
        return totalScore;
    };

    @Override
    public Map<Integer, ResultComparison> getResultComparisons() {
        return resultComparisons;
    };

    @Override
    public Template getUserSubmissionTemplate() {
        return userSubmissionTemplate;
    }

    @Override
    public edu.hcmus.gradeservice.thirdparty.warriorcore.model.Template getCorrectTemplate() {
        return correctTemplate;
    }

    @Override
    public void setUserSubmissionTemplate(Template template) {
        this.userSubmissionTemplate = template;
    }

    @Override
    public void setCorrectTemplate(edu.hcmus.gradeservice.thirdparty.warriorcore.model.Template template) {
        this.correctTemplate = template;
    }

    @Override
    public Integer beforeExecute() {
        return 0;
    }
    @Override
    public Integer executeComparison(Question questionHasCorrectAnswer, IQuestion questionHasUserSubmission) {
        return 0;
    }
    @Override
    public Integer afterExecute() {
        return 0;
    }

    @Override
    public Integer executeGrading() {
        Integer errorCode = 0;

        //Handling preprocess
        errorCode = beforeExecute();
        if (0 != errorCode) {
            return errorCode;
        }

        //Handling main process
        for (Map.Entry<Integer, Question> questionEntry: correctTemplate.getQuestionMap().entrySet()) {

            //Both question has correct answer and question has user submission
            //  has the same index
            Question questionHasCorrectAnswer = questionEntry.getValue();
            Integer questionIndex = questionHasCorrectAnswer.getQuestionIndex();
            IQuestion questionHasUserSubmission = userSubmissionTemplate.getQuestions().get(questionIndex);

            //Execute to compare the correct answer with user answer
            errorCode = executeComparison(questionHasCorrectAnswer, questionHasUserSubmission);
            if (0 != errorCode) {
                return errorCode;
            }
        }

        //Handling post process
        errorCode = afterExecute();

        return errorCode;
    };

}
