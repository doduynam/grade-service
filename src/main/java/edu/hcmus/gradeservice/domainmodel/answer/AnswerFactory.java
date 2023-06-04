package edu.hcmus.gradeservice.domainmodel.answer;

import edu.hcmus.gradeservice.domainmodel.IFactory;
import edu.hcmus.gradeservice.domainmodel.answer.impl.YesNoAnswer;
import edu.hcmus.gradeservice.domainmodel.question.IQuestion;
import edu.hcmus.gradeservice.domainmodel.question.impl.YesNoQuestion;

import java.util.HashMap;
import java.util.Map;

public enum AnswerFactory implements IFactory<IAnswer> {

    INSTANCE;

    private Map<Integer, IAnswer> prototypes = new HashMap<>() {
        {
            put(1, new YesNoAnswer());
        }
    };

    @Override
    public IAnswer get(Object key) {
        if (!prototypes.containsKey(key)) {
            return null;
        }

        return prototypes.get(key);
    }
}
