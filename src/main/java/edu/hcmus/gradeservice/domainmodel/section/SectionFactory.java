package edu.hcmus.gradeservice.domainmodel.section;

import edu.hcmus.gradeservice.domainmodel.IFactory;
import edu.hcmus.gradeservice.domainmodel.attempt.IAttempt;
import edu.hcmus.gradeservice.domainmodel.attempt.impl.BaseAttempt;
import edu.hcmus.gradeservice.domainmodel.question.IQuestion;
import edu.hcmus.gradeservice.domainmodel.question.impl.MultipleChoiceQuestion;
import edu.hcmus.gradeservice.domainmodel.question.impl.YesNoQuestion;
import edu.hcmus.gradeservice.domainmodel.section.impl.ReadingSection;

import java.util.HashMap;
import java.util.Map;

public enum SectionFactory implements IFactory<ISection> {

    INSTANCE;

    @Override
    public ISection get(Object key) {

        ISection prototype = null;

        if (key.equals(0)) {
            prototype = new ReadingSection();
        }

        return prototype;
    }
}
