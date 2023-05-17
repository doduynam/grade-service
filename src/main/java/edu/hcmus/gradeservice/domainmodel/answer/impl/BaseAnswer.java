package edu.hcmus.gradeservice.domainmodel.answer.impl;

import edu.hcmus.gradeservice.domainmodel.answer.IAnswer;

public class BaseAnswer implements IAnswer {

    private String answer;
    @Override
    public String getAnswer() {
        return answer;
    }

    @Override
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public boolean compareAnswer(IAnswer answer) {
        return this.getAnswer().equals(answer.getAnswer());
    }
}
