package edu.hcmus.gradeservice.domainmodel.grader.engine;

import edu.hcmus.gradeservice.domainmodel.IFactory;
import edu.hcmus.gradeservice.domainmodel.answer.impl.MultipleChoiceAnswer;
import edu.hcmus.gradeservice.domainmodel.answer.impl.YesNoAnswer;
import edu.hcmus.gradeservice.domainmodel.grader.engine.impl.*;

import java.util.HashMap;
import java.util.Map;

public enum EngineFactory implements IFactory<IGradeEngine> {

    //Using enum for singleton
    INSTANCE;

    @Override
    public IGradeEngine get(Object key) {

        IGradeEngine prototype = null;
        if (key.equals(1)) {
            prototype = new YesNoTemplateGradeEngine();
        } else if (key.equals(2)) {
            prototype = new MultipleChoiceGradeEngine();
        } else if (key.equals(3)) {
            prototype = new ShortAnswerGradeEngine();
        } else if (key.equals(4)) {
            prototype = new SentenceCompletionGradeEngine();
        } else if (key.equals(5)) {
            prototype = new MatchingHeadingGradeEngine();
        }

        return prototype;
    }

}
