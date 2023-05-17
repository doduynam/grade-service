package edu.hcmus.gradeservice.domainmodel.grader.result.impl;

import edu.hcmus.gradeservice.domainmodel.grader.engine.IGradable;
import edu.hcmus.gradeservice.domainmodel.grader.result.IResultComparable;
import edu.hcmus.gradeservice.domainmodel.section.ISection;
import edu.hcmus.gradeservice.domainmodel.test.ITest;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Getter
@Setter
public class TestResult implements IGradable, IResultComparable<SectionResult> {

    protected Map<Integer, SectionResult> sectionResults;
    protected ITest userSubmission;
    protected ITest correctSolution;

    public TestResult() {
        sectionResults = new TreeMap<>();
    }
    @Override
    public Integer getTotalScore() {
        Integer score = 0;
        for (Map.Entry<Integer, SectionResult> sectionResult: sectionResults.entrySet()) {
            SectionResult result = sectionResult.getValue();
            score += result.getTotalScore();
        }

        return score;
    }

    @Override
    public Map<Integer, SectionResult> getResultComparables() {
        return sectionResults;
    }

    @Override
    public Integer executeGrading() {
        for (Map.Entry<Integer, ISection> sectionEntry: correctSolution.getSections().entrySet()) {
            ISection sectionHasCorrectAnswer = sectionEntry.getValue();
            Integer sectionIndex = sectionHasCorrectAnswer.getIndex();
            ISection sectionHasUserSubmission = correctSolution.getSections().get(sectionIndex);

            //Build and run the section result
            SectionResult sectionResult = new SectionResult();
            sectionResult.setCorrectSolution(sectionHasCorrectAnswer);
            sectionResult.setUserSubmission(sectionHasUserSubmission);
            sectionResult.executeGrading();
            sectionResults.put(sectionIndex, sectionResult);
        }
        return 0;
    }
}
