package edu.hcmus.gradeservice.domainmodel.question.impl;

import edu.hcmus.gradeservice.domainmodel.answer.impl.MatchingHeadingAnswer;
import edu.hcmus.gradeservice.domainmodel.answer.impl.SentenceCompletionAnswer;

public class MatchingHeadingQuestion extends BaseQuestion {

    public MatchingHeadingAnswer getAnswer() {
        return (MatchingHeadingAnswer) this.answers.get(0);
    }

    public void setAnswer(MatchingHeadingAnswer answer) {
        this.answers.set(0, answer);
    }
}
