package edu.hcmus.gradeservice.domainmodel.section.impl;

import edu.hcmus.gradeservice.domainmodel.question.IQuestion;
import edu.hcmus.gradeservice.domainmodel.section.ISection;
import edu.hcmus.gradeservice.domainmodel.template.Template;

import java.util.Map;

public class BaseSection implements ISection {

    protected Integer id;
    protected Integer index;
    protected Map<Integer, Template> templates;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public Integer getIndex() {
        return index;
    }

    @Override
    public Map<Integer, Template> getTemplates() {
        return templates;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public void setIndex(Integer index) {
        this.index = index;
    }

    @Override
    public void setTemplates(Map<Integer, Template> templates) {
        this.templates = templates;
    }

    @Override
    public Integer getMaxScore() {
        Integer score = 0;
        for (Map.Entry<Integer, Template> templateEntry: templates.entrySet()) {
            Template template = templateEntry.getValue();
            for (Map.Entry<Integer, IQuestion> questionEntry: template.getQuestions().entrySet()) {
                IQuestion question = questionEntry.getValue();
                score += question.getQuestionScore();
            }
        }

        return score;
    }
}
