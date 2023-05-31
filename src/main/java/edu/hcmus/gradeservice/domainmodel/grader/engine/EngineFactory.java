package edu.hcmus.gradeservice.domainmodel.grader.engine;

import edu.hcmus.gradeservice.domainmodel.IFactory;
import edu.hcmus.gradeservice.domainmodel.grader.engine.impl.YesNoTemplateGradeEngine;

import java.util.HashMap;
import java.util.Map;

public enum EngineFactory implements IFactory<IGradeEngine> {

    //Using enum for singleton
    INSTANCE;

    private Map<String, IGradeEngine> enginePrototypes = new HashMap<>() {
        {
            put("yes-no-type", new YesNoTemplateGradeEngine());
        }
    };


    @Override
    public IGradeEngine get(Object key) {

        if (!enginePrototypes.containsKey(key)) {
            return null;
        }

        IGradeEngine engine = enginePrototypes.get(key);
        return engine;
    }

}
