package edu.hcmus.gradeservice.domainmodel.section;

import edu.hcmus.gradeservice.domainmodel.template.Template;

import java.util.Map;

public interface ISection {

    public Integer getId();
    public Integer getIndex();
    public Map<Integer, Template> getTemplates();

    public void setId(Integer id);
    public void setIndex(Integer index);
    public void setTemplates(Map<Integer, Template> templates);

    public Integer getMaxScore();

}
