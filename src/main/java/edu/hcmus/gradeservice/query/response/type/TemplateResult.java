package edu.hcmus.gradeservice.query.response.type;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class TemplateResult {

    private Integer templateIndex;
    private Integer score;
    private List<ResultComparison> resultComparisons;

    public static TemplateResult parse(edu.hcmus.gradeservice.domainmodel.grader.result.impl.TemplateResult templateResult) {
        TemplateResult container = new TemplateResult();
        container.setScore(templateResult.getTotalScore());
        container.setTemplateIndex(templateResult.getTemplateHasUserSubmission().getIndex());

        List<ResultComparison> resultComparisons = new ArrayList<>();
        for(Map.Entry<Integer, edu.hcmus.gradeservice.domainmodel.grader.result.impl.ResultComparison> entry: templateResult.getResultComparables().entrySet()) {
            edu.hcmus.gradeservice.domainmodel.grader.result.impl.ResultComparison resultComparison = entry.getValue();
            ResultComparison buffer = ResultComparison.parse(resultComparison);
            resultComparisons.add(buffer);
        }
        container.setResultComparisons(resultComparisons);

        return container;
    }
}
