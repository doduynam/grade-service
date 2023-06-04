package edu.hcmus.gradeservice.entity;

import edu.hcmus.gradeservice.domainmodel.section.ISection;
import edu.hcmus.gradeservice.domainmodel.section.SectionFactory;
import edu.hcmus.gradeservice.domainmodel.section.impl.ReadingSection;
import edu.hcmus.gradeservice.domainmodel.template.Template;
import edu.hcmus.gradeservice.domainmodel.testattempt.TestAttempt;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JoinFormula;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Entity
@Table(name = "section")
@Data
@Getter
@Setter
public class SectionEntity implements IHasDomainModel {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "section_id")
    private Integer id;

    @Basic
    @Column(name = "attempt_id")
    private Integer attemptId;

    @Basic
    @Column(name = "section_index")
    private Integer sectionIndex;

    @Basic
    @Column(name = "section_type")
    private Integer sectionType;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JoinColumn(name="section_id")
    private List<TemplateEntity> templates;

    @Override
    public ISection parse() {

      ISection obj = SectionFactory.INSTANCE.get(sectionType);
      if (null == obj) {
          return null;
      }

      obj.setId(id);
      obj.setIndex(sectionIndex);

      //Build the map
      Map<Integer, Template> templateMap = new TreeMap<>();

      for (TemplateEntity templateEntity: templates) {
        Integer index = templateEntity.getTemplateIndex();
        Template template = templateEntity.parse();
        templateMap.put(index, template);
      }
      obj.setTemplates(templateMap);

      return obj;
    }
}
