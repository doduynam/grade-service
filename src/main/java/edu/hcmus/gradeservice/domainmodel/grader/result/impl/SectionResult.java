package edu.hcmus.gradeservice.domainmodel.grader.result.impl;

import edu.hcmus.gradeservice.domainmodel.grader.engine.IGradable;
import edu.hcmus.gradeservice.domainmodel.grader.result.IResultComparable;
import edu.hcmus.gradeservice.domainmodel.section.ISection;
import edu.hcmus.gradeservice.domainmodel.template.Template;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Getter
@Setter
public class SectionResult implements IGradable, IResultComparable<TemplateResult> {

    protected Map<Integer, TemplateResult> templateResults;
    protected ISection userSubmission;
    protected ISection correctSolution;

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
        for (Map.Entry<Integer, Template> templateEntry: correctSolution.getTemplates().entrySet()) {
            Template templateHasCorrectAnswer = templateEntry.getValue();
            Integer templateIndex = templateHasCorrectAnswer.getIndex();
            Template templateHasUserSubmission = userSubmission.getTemplates().get(templateIndex);

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
