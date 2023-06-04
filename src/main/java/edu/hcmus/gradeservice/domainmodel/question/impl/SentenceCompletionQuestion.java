package edu.hcmus.gradeservice.domainmodel.question.impl;

import edu.hcmus.gradeservice.domainmodel.answer.impl.SentenceCompletionAnswer;
import edu.hcmus.gradeservice.domainmodel.answer.impl.ShortAnswer;

public class SentenceCompletionQuestion extends BaseQuestion {

    public SentenceCompletionAnswer getAnswer() {
        return (SentenceCompletionAnswer) this.answers.get(0);
    }

    public void setAnswer(SentenceCompletionAnswer answer) {
        this.answers.set(0, answer);
    }
}
