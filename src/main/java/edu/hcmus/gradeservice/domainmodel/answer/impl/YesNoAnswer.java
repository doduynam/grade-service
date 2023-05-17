package edu.hcmus.gradeservice.domainmodel.answer.impl;

import edu.hcmus.gradeservice.domainmodel.answer.IAnswer;

public class YesNoAnswer implements IAnswer {

    private String answer;
    public static enum YES_NO_ANSWER_SELECTION {
            YES, NO, NOT_GIVEN
    }

    @Override
    public String getAnswer() {
        return answer;
    }

    @Override
    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
