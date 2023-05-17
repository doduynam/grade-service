package edu.hcmus.gradeservice.domainmodel.grader.engine;

import edu.hcmus.gradeservice.domainmodel.grader.engine.impl.YesNoTemplateGradeEngine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum EngineFactory {

    //Using enum for singleton
    INSTANCE;

    private Map<String, IGradeEngine> enginePrototypes = new HashMap<>() {
        {
            put("yes-no-type", new YesNoTemplateGradeEngine());
        }
    };


    public IGradeEngine getEngine(String key) {

        if (!enginePrototypes.containsKey(key)) {
            return null;
        }

        IGradeEngine engine = enginePrototypes.get(key);
        return engine;
    }


}
