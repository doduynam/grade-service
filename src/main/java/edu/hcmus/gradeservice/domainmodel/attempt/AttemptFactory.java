package edu.hcmus.gradeservice.domainmodel.attempt;

import edu.hcmus.gradeservice.domainmodel.IFactory;
import edu.hcmus.gradeservice.domainmodel.attempt.impl.BaseAttempt;

import java.util.HashMap;
import java.util.Map;

public enum AttemptFactory implements IFactory<IAttempt> {

    INSTANCE;

    @Override
    public IAttempt get(Object key) {

        IAttempt prototype = null;
        if (key.equals(0)) {
            prototype = new BaseAttempt();
        }

        return prototype;
    }
}
