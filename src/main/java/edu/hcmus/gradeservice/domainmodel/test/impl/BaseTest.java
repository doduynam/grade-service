package edu.hcmus.gradeservice.domainmodel.test.impl;

import edu.hcmus.gradeservice.domainmodel.question.IQuestion;
import edu.hcmus.gradeservice.domainmodel.section.ISection;
import edu.hcmus.gradeservice.domainmodel.test.ITest;

import java.util.Map;

public class BaseTest implements ITest {

    protected Integer id;
    protected Map<Integer, ISection> sections;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public Map<Integer, ISection> getSections() {
        return sections;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public void setSections(Map<Integer, ISection> sections) {
        this.sections = sections;
    }

    @Override
    public Integer getMaxScore() {
        Integer score = 0;
        for (Map.Entry<Integer, ISection> entry: sections.entrySet()) {
            ISection section = entry.getValue();
            score += section.getMaxScore();
        }

        return score;
    }
}
