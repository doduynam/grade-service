package edu.hcmus.gradeservice.domainmodel.question;

import edu.hcmus.gradeservice.domainmodel.answer.IAnswer;

import java.util.ArrayList;
import java.util.List;

public interface IQuestion {

    public int getId();
    public String getContent();
    public List<IAnswer> getAnswers();
    public int getQuestionScore();

    public void setId(int id);
    public void setContent(String content);
    public void setAnswers(List<IAnswer> answers);
    public void setQuestionScore(int score);
}
