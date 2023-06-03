package edu.hcmus.gradeservice.query.request.type;

import edu.hcmus.gradeservice.entity.QuestionEntity;
import edu.hcmus.gradeservice.entity.TemplateEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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
