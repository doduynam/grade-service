package edu.hcmus.gradeservice.query.response;

import edu.hcmus.gradeservice.domainmodel.grader.result.impl.TestResult;
import edu.hcmus.gradeservice.query.response.type.SectionResult;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class SubmitResponse {

    private Integer score;
    private List<SectionResult> sectionResults;

    public static SubmitResponse parse(TestResult testResult) {
        SubmitResponse response = new SubmitResponse();

        response.setScore(testResult.getTotalScore());

        List<SectionResult> sectionResults = new ArrayList<>();
        for(Map.Entry<Integer, edu.hcmus.gradeservice.domainmodel.grader.result.impl.SectionResult> entry: testResult.getResultComparables().entrySet()) {
            edu.hcmus.gradeservice.domainmodel.grader.result.impl.SectionResult sectionResult = entry.getValue();
            SectionResult buffer = SectionResult.parse(sectionResult);
            sectionResults.add(buffer);
        }
        response.setSectionResults(sectionResults);

        return response;
    }

}
