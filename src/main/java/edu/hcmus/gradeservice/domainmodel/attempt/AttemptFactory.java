package edu.hcmus.gradeservice.domainmodel.attempt;

import edu.hcmus.gradeservice.domainmodel.IFactory;
import edu.hcmus.gradeservice.domainmodel.attempt.impl.BaseAttempt;

import java.util.HashMap;
import java.util.Map;

public enum AttemptFactory implements IFactory<IAttempt> {

    INSTANCE;

    private Map<Integer, IAttempt> prototypes = new HashMap<>() {
        {
            put(0, new BaseAttempt());
        }
    };

    @Override
    public IAttempt get(Object key) {

        if (!prototypes.containsKey(key)) {
            return null;
        }

        return prototypes.get(key);
    }
}
