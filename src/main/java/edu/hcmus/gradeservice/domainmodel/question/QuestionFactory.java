package edu.hcmus.gradeservice.domainmodel.question;

import edu.hcmus.gradeservice.domainmodel.IFactory;
import edu.hcmus.gradeservice.domainmodel.attempt.IAttempt;
import edu.hcmus.gradeservice.domainmodel.attempt.impl.BaseAttempt;
import edu.hcmus.gradeservice.domainmodel.question.impl.YesNoQuestion;

import java.util.HashMap;
import java.util.Map;

public enum QuestionFactory implements IFactory<IQuestion> {

    INSTANCE;

    private Map<Integer, IQuestion> prototypes = new HashMap<>() {
        {
            put(1, new YesNoQuestion());
        }
    };

    @Override
    public IQuestion get(Object key) {
        if (!prototypes.containsKey(key)) {
            return null;
        }

        return prototypes.get(key);
    }
}
