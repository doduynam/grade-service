package edu.hcmus.gradeservice.domainmodel.grader.result.impl;

import edu.hcmus.gradeservice.domainmodel.grader.engine.IGradable;
import edu.hcmus.gradeservice.domainmodel.grader.result.IResultComparable;
import edu.hcmus.gradeservice.domainmodel.section.ISection;
import edu.hcmus.gradeservice.domainmodel.template.Template;
import edu.hcmus.gradeservice.thirdparty.warriorcore.model.Section;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.TreeMap;

@Getter
@Setter
public class SectionResult implements IGradable, IResultComparable<TemplateResult> {

    protected Map<Integer, TemplateResult> templateResults;
    protected ISection userSubmission;
    protected Section correctSolution;

    public SectionResult() {
        templateResults = new TreeMap<>();
    }

    @Override
    public Integer getTotalScore() {
        Integer score = 0;
        for (Map.Entry<Integer, TemplateResult> templateEntry: templateResults.entrySet()) {
            TemplateResult result = templateEntry.getValue();
            score += result.getTotalScore();
        }

        return score;
    }

    @Override
    public Map<Integer, TemplateResult> getResultComparables() {
        return templateResults;
    }

    @Override
    public Integer executeGrading() {

//        System.out.println(correctSolution.getTemplateMap());

        for (Map.Entry<Integer, edu.hcmus.gradeservice.thirdparty.warriorcore.model.Template> templateEntry: correctSolution.getTemplateMap().entrySet()) {
            edu.hcmus.gradeservice.thirdparty.warriorcore.model.Template templateHasCorrectAnswer = templateEntry.getValue();
            Integer templateIndex = templateHasCorrectAnswer.getTemplateIndex();
            Template templateHasUserSubmission = userSubmission.getTemplates().get(templateIndex);

//            System.out.println(templateIndex);
//            System.out.println(userSubmission.getTemplates());

            //Build and run the template result
            TemplateResult templateResult = new TemplateResult();
            templateResult.setTemplateHasCorrectAnswer(templateHasCorrectAnswer);
            templateResult.setTemplateHasUserSubmission(templateHasUserSubmission);
            templateResult.executeGrading();
            templateResults.put(templateIndex, templateResult);
        }

        return 0;
    }
}
