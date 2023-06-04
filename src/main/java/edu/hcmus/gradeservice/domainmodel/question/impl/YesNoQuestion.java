package edu.hcmus.gradeservice.domainmodel.question.impl;

import edu.hcmus.gradeservice.domainmodel.answer.impl.YesNoAnswer;

public class YesNoQuestion extends BaseQuestion {

    public YesNoAnswer getAnswer() {
        return (YesNoAnswer) this.answers.get(0);
    }

    public void setAnswer(YesNoAnswer answer) {
        this.answers.set(0, answer);
    }
}
