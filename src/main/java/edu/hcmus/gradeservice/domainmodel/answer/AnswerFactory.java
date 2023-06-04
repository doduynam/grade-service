package edu.hcmus.gradeservice.domainmodel.answer;

import edu.hcmus.gradeservice.domainmodel.IFactory;
import edu.hcmus.gradeservice.domainmodel.answer.impl.MultipleChoiceAnswer;
import edu.hcmus.gradeservice.domainmodel.answer.impl.SentenceCompletionAnswer;
import edu.hcmus.gradeservice.domainmodel.answer.impl.ShortAnswer;
import edu.hcmus.gradeservice.domainmodel.answer.impl.YesNoAnswer;
import edu.hcmus.gradeservice.domainmodel.question.IQuestion;
import edu.hcmus.gradeservice.domainmodel.question.impl.YesNoQuestion;

import java.util.HashMap;
import java.util.Map;

public enum AnswerFactory implements IFactory<IAnswer> {

    INSTANCE;

    @Override
    public IAnswer get(Object key) {

        IAnswer prototype = null;
        if (key.equals(1)) {
            prototype = new YesNoAnswer();
        } else if (key.equals(2)) {
            prototype = new MultipleChoiceAnswer();
        } else if (key.equals(3)) {
            prototype = new ShortAnswer();
        } else if (key.equals(4)) {
            prototype = new SentenceCompletionAnswer();
        }

        return prototype;
    }
}
