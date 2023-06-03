package edu.hcmus.gradeservice.query.type;

import edu.hcmus.gradeservice.domainmodel.question.IQuestion;
import edu.hcmus.gradeservice.domainmodel.template.Template;
import edu.hcmus.gradeservice.domainmodel.templatetype.TemplateType;
import edu.hcmus.gradeservice.entity.IHasDomainModel;
import edu.hcmus.gradeservice.entity.QuestionEntity;
import edu.hcmus.gradeservice.entity.TemplateEntity;
import edu.hcmus.gradeservice.entity.TemplateTypeEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Getter
@Setter
public class TemplateQuery implements IHasEntity {

    private Integer id;

    private Integer templateTypeId;

    private Integer sectionId;

    private Integer templateIndex;

    private String title;

    private String content;

    private String expandColumn;

    private List<QuestionQuery> questions;

    public TemplateEntity parse() {
        TemplateEntity entity = new TemplateEntity();
        entity.setId(id);
        entity.setTemplateTypeId(id);
        entity.setSectionId(sectionId);
        entity.setTemplateIndex(templateIndex);
        entity.setTitle(title);
        entity.setContent(content);
        entity.setExpandColumn(expandColumn);

        List<QuestionEntity> buffer = new ArrayList<>();
        for (QuestionQuery questionQuery: questions) {
            QuestionEntity questionEntity = questionQuery.parse();
            questionEntity.setTemplate(entity);
            buffer.add(questionEntity);
        }
        entity.setQuestions(buffer);

        return entity;
    }
}
