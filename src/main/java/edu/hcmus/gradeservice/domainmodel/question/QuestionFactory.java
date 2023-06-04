package edu.hcmus.gradeservice.domainmodel.question;

import edu.hcmus.gradeservice.domainmodel.IFactory;
import edu.hcmus.gradeservice.domainmodel.answer.impl.MultipleChoiceAnswer;
import edu.hcmus.gradeservice.domainmodel.attempt.IAttempt;
import edu.hcmus.gradeservice.domainmodel.attempt.impl.BaseAttempt;
import edu.hcmus.gradeservice.domainmodel.grader.engine.impl.MultipleChoiceGradeEngine;
import edu.hcmus.gradeservice.domainmodel.grader.engine.impl.YesNoTemplateGradeEngine;
import edu.hcmus.gradeservice.domainmodel.question.impl.MultipleChoiceQuestion;
import edu.hcmus.gradeservice.domainmodel.question.impl.ShortAnswerQuestion;
import edu.hcmus.gradeservice.domainmodel.question.impl.YesNoQuestion;

import java.util.HashMap;
import java.util.Map;

public enum QuestionFactory implements IFactory<IQuestion> {

    INSTANCE;

    @Override
    public IQuestion get(Object key) {
        IQuestion prototype = null;

        if (key.equals(1)) {
            prototype = new YesNoQuestion();
        } else if (key.equals(2)) {
            prototype = new MultipleChoiceQuestion();
        } else if (key.equals(3)) {
            prototype = new ShortAnswerQuestion();
        }


        return prototype;
    }
}
