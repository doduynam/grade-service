package edu.hcmus.gradeservice.entity;

import edu.hcmus.gradeservice.domainmodel.question.IQuestion;
import edu.hcmus.gradeservice.domainmodel.template.Template;
import edu.hcmus.gradeservice.domainmodel.templatetype.TemplateType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Entity
@Table(name = "template")
@Data
@Getter
@Setter
public class TemplateEntity implements IHasDomainModel {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "template_id")
    private Integer id;

    @Basic
    @Column(name = "template_type_id")
    private Integer templateTypeId;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "template_type_id", insertable=false, updatable=false)
    private TemplateTypeEntity templateType;

    @Basic
    @Column(name = "section_id")
    private Integer sectionId;

    @Basic
    @Column(name = "template_index")
    private Integer templateIndex;

    @Basic
    @Column(name = "title")
    private String title;

    @Basic
    @Column(name = "content")
    private String content;

    @Basic
    @Column(name = "expand_column")
    private String expandColumn;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JoinColumn(name="template_id")
    private List<QuestionEntity> questions;

    public Template parse() {

        Template template = new Template();
        template.setId(id);
        template.setIndex(templateIndex);
        template.setContent(content);

        if (null != templateType) {
            TemplateType templateTypeDomainModel = templateType.parse();
            template.setTemplateType(templateTypeDomainModel);
        }

        Map<Integer, IQuestion> questionMap = new TreeMap<>();
        for (QuestionEntity questionEntity: questions) {
              Integer index = questionEntity.getQuestionIndex();
              IQuestion question = questionEntity.parse();
              questionMap.put(index, question);
        }
        template.setQuestions(questionMap);

        return template;
    }
}
