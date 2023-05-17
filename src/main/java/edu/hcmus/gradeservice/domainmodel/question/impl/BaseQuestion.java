package edu.hcmus.gradeservice.domainmodel.question.impl;

import edu.hcmus.gradeservice.constants.CommonConstant;
import edu.hcmus.gradeservice.domainmodel.answer.IAnswer;
import edu.hcmus.gradeservice.domainmodel.question.IQuestion;

import java.util.List;

public class BaseQuestion implements IQuestion {

    protected Integer id;
    protected Integer index;
    protected String content;
    protected List<IAnswer> answers;
    protected Integer score = CommonConstant.DEFAULT_QUESTION_POINT;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public Integer getIndex() {return index;}

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public List<IAnswer> getAnswers() {
        return answers;
    }

    @Override
    public Integer getQuestionScore() {
        return score;
    }
    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public void setIndex(Integer index) {
        this.index = index;
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public void setAnswers(List<IAnswer> answers) {
        this.answers = answers;
    }

    public void setQuestionScore(Integer score) {
        this.score = score;
    }
}
