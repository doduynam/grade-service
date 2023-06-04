package edu.hcmus.gradeservice.domainmodel.question.impl;

import edu.hcmus.gradeservice.domainmodel.answer.impl.MultipleChoiceAnswer;
import edu.hcmus.gradeservice.domainmodel.answer.impl.ShortAnswer;

public class ShortAnswerQuestion extends BaseQuestion {

    public ShortAnswer getAnswer() {
        return (ShortAnswer) this.answers.get(0);
    }

    public void setAnswer(ShortAnswer answer) {
        this.answers.set(0, answer);
    }
}
