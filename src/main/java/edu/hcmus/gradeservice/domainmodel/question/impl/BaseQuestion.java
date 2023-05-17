package edu.hcmus.gradeservice.domainmodel.question.impl;

import edu.hcmus.gradeservice.constants.CommonConstant;
import edu.hcmus.gradeservice.domainmodel.answer.IAnswer;
import edu.hcmus.gradeservice.domainmodel.question.IQuestion;

import java.util.List;

public class BaseQuestion implements IQuestion {

    protected int id;
    protected String content;
    protected List<IAnswer> answers;
    protected int score = CommonConstant.DEFAULT_QUESTION_POINT;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public List<IAnswer> getAnswers() {
        return answers;
    }

    @Override
    public int getQuestionScore() {
        return score;
    }
    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public void setAnswers(List<IAnswer> answers) {
        this.answers = answers;
    }

    public void setQuestionScore(int score) {
        this.score = score;
    }
}
