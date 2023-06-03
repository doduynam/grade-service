package edu.hcmus.gradeservice.domainmodel.grader.result.impl;

import edu.hcmus.gradeservice.domainmodel.grader.engine.EngineFactory;
import edu.hcmus.gradeservice.domainmodel.grader.engine.IGradeEngine;
import edu.hcmus.gradeservice.domainmodel.grader.engine.IGradable;
import edu.hcmus.gradeservice.domainmodel.grader.result.IResultComparable;
import edu.hcmus.gradeservice.domainmodel.template.Template;
import lombok.Getter;

import java.util.Map;

@Getter
public class TemplateResult implements IGradable, IResultComparable<ResultComparison> {

    protected Template templateHasCorrectAnswer;
    protected Template templateHasUserSubmission;
    protected IGradeEngine gradeEngine;
    protected EngineFactory engineFactory;

    public TemplateResult() {
        engineFactory = EngineFactory.INSTANCE;
    }

    @Override
    public Integer getTotalScore() {
        return gradeEngine.getTotalScore();
    }

    @Override
    public Map<Integer, ResultComparison> getResultComparables() {
        return gradeEngine.getResultComparisons();
    }

    public void setTemplateHasCorrectAnswer(Template template) {
        this.templateHasCorrectAnswer = template;
        gradeEngine.setCorrectTemplate(template);
    }

    public void setTemplateHasUserSubmission(Template template) {
        this.templateHasUserSubmission = template;
        gradeEngine.setUserSubmissionTemplate(template);
    }

    private String chooseEngine() {
        String engineKey = this.templateHasCorrectAnswer.getTemplateType().getKey();
        IGradeEngine engine = engineFactory.get(engineKey);
        this.gradeEngine = engine;

        if (null == engine) {
            return null;
        }

        return engineKey;
    }

    @Override
    public Integer executeGrading() {

        Integer errorCode = 1;  //Default errorCode is error

        //Set engine base on the type of template first
        String engineKey = chooseEngine();
        if (null == engineKey) {
            return errorCode;
        }

        gradeEngine.setCorrectTemplate(templateHasCorrectAnswer);
        gradeEngine.setUserSubmissionTemplate(templateHasUserSubmission);
        errorCode = gradeEngine.executeGrading();

        return errorCode;
    }

}
