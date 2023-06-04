package edu.hcmus.gradeservice.domainmodel.answer.impl;

import edu.hcmus.gradeservice.domainmodel.answer.IAnswer;
import edu.hcmus.gradeservice.thirdparty.warriorcore.model.Answer;

public class BaseAnswer implements IAnswer {

    private String answer;
    private String options;
    @Override
    public String getAnswer() {
        return answer;
    }

    @Override
    public String options() {return options;}

    @Override
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public void setOptions(String options) {this.options = options;}

    @Override
    public boolean checkAnswer(Answer answer) {
        return this.getAnswer().equals(answer.getContent());
    }
}
