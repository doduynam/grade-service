package edu.hcmus.gradeservice.domainmodel.answer;

import edu.hcmus.gradeservice.nodeapi.model.Answer;

public interface IAnswer {
    public String getAnswer();
    public String options();
    public void setAnswer(String answer);
    public void setOptions(String options);
    public boolean checkAnswer(Answer correctAnswer);
}
