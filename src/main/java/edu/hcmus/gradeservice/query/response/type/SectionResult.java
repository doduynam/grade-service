package edu.hcmus.gradeservice.query.response.type;

import edu.hcmus.gradeservice.domainmodel.grader.result.impl.TestResult;
import edu.hcmus.gradeservice.query.response.SubmitResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class SectionResult {

    private Integer sectionIndex;
    private Integer score;
    private List<TemplateResult> templateResults;

    public static SectionResult parse(edu.hcmus.gradeservice.domainmodel.grader.result.impl.SectionResult sectionResult) {
        SectionResult container = new SectionResult();
        container.setScore(sectionResult.getTotalScore());
        container.setSectionIndex(sectionResult.getUserSubmission().getIndex());

        List<TemplateResult> templateResults = new ArrayList<>();
        for(Map.Entry<Integer, edu.hcmus.gradeservice.domainmodel.grader.result.impl.TemplateResult> entry: sectionResult.getResultComparables().entrySet()) {
            edu.hcmus.gradeservice.domainmodel.grader.result.impl.TemplateResult templateResult = entry.getValue();
            TemplateResult buffer = TemplateResult.parse(templateResult);
            templateResults.add(buffer);
        }
        container.setTemplateResults(templateResults);

        return container;
    }
}
