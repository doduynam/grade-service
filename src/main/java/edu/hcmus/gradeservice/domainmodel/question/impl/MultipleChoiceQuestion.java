package edu.hcmus.gradeservice.domainmodel.question.impl;

import edu.hcmus.gradeservice.domainmodel.answer.impl.MultipleChoiceAnswer;
import edu.hcmus.gradeservice.domainmodel.answer.impl.YesNoAnswer;

public class MultipleChoiceQuestion extends BaseQuestion {

    public MultipleChoiceAnswer getAnswer() {
        return (MultipleChoiceAnswer) this.answers.get(0);
    }
    public void setAnswer(MultipleChoiceAnswer answer) {
        this.answers.set(0, answer);
    }
}
