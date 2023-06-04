package edu.hcmus.gradeservice.domainmodel.question;

import edu.hcmus.gradeservice.domainmodel.answer.IAnswer;

import java.util.ArrayList;
import java.util.List;

public interface IQuestion {

    public Integer getId();
    public Integer getIndex();
    public String getContent();
    public List<IAnswer> getAnswers();
    public Integer getQuestionScore();

    public void setId(Integer id);
    public void setIndex(Integer index);
    public void setContent(String content);
    public void setAnswers(List<IAnswer> answers);
    public void setQuestionScore(Integer score);
}
