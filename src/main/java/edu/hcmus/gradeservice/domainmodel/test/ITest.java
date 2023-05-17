package edu.hcmus.gradeservice.domainmodel.test;

import edu.hcmus.gradeservice.domainmodel.section.ISection;

import java.util.Map;

public interface ITest {

    public Integer getId();
    public Map<Integer, ISection> getSections();

    public void setId(Integer id);
    public void setSections(Map<Integer, ISection> sections);

    public Integer getMaxScore();
}
