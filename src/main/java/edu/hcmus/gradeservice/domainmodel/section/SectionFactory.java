package edu.hcmus.gradeservice.domainmodel.section;

import edu.hcmus.gradeservice.domainmodel.IFactory;
import edu.hcmus.gradeservice.domainmodel.attempt.IAttempt;
import edu.hcmus.gradeservice.domainmodel.attempt.impl.BaseAttempt;
import edu.hcmus.gradeservice.domainmodel.section.impl.ReadingSection;

import java.util.HashMap;
import java.util.Map;

public enum SectionFactory implements IFactory<ISection> {

    INSTANCE;

    private Map<Integer, ISection> prototypes = new HashMap<>() {
        {
            put(0, new ReadingSection());
        }
    };


    @Override
    public ISection get(Object key) {

        if (!prototypes.containsKey(key)) {
            return null;
        }

        return prototypes.get(key);
    }
}
