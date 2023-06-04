package edu.hcmus.gradeservice.query.request.type;

import edu.hcmus.gradeservice.entity.SectionEntity;
import edu.hcmus.gradeservice.entity.TemplateEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class SectionQuery implements IHasEntity {
    private Integer id;

    private Integer attemptId;
    private Integer sectionIndex;

    private Integer sectionType;

    private List<TemplateQuery> templates;

    @Override
    public SectionEntity parse() {
        SectionEntity entity = new SectionEntity();
        entity.setId(id);
        entity.setAttemptId(attemptId);
        entity.setSectionIndex(sectionIndex);
        entity.setSectionType(sectionType);

        List<TemplateEntity> buffer = new ArrayList<>();
        for (TemplateQuery templateQuery: templates) {
            TemplateEntity templateEntity = templateQuery.parse();
            buffer.add(templateEntity);
        }
        entity.setTemplates(buffer);

        return entity;
    }
}
