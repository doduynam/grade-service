package edu.hcmus.gradeservice.domainmodel.grader.result.impl;

import edu.hcmus.gradeservice.domainmodel.grader.engine.IGradable;
import edu.hcmus.gradeservice.domainmodel.grader.result.IResultComparable;
import edu.hcmus.gradeservice.domainmodel.section.ISection;
import edu.hcmus.gradeservice.domainmodel.attempt.IAttempt;
import edu.hcmus.gradeservice.nodeapi.model.Section;
import edu.hcmus.gradeservice.nodeapi.model.Test;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.TreeMap;

@Getter
@Setter
public class TestResult implements IGradable, IResultComparable<SectionResult> {

    protected Map<Integer, SectionResult> sectionResults;
    protected IAttempt userSubmission;
    protected Test correctSolution;

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
        for (Map.Entry<Integer, Section> sectionEntry: correctSolution.getSectionMap().entrySet()) {
            Section sectionHasCorrectAnswer = sectionEntry.getValue();
            Integer sectionIndex = sectionHasCorrectAnswer.getSectionIndex();
            ISection sectionHasUserSubmission = userSubmission.getSections().get(sectionIndex);

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
