package edu.hcmus.gradeservice.entity;

import edu.hcmus.gradeservice.domainmodel.templatetype.TemplateType;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "template_type")
@Data
@Getter
@Setter
public class TemplateTypeEntity implements IHasDomainModel{

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "template_type_id")
  private Integer id;

  @Basic
  @Column(name = "name")
  private String name;

  @Basic
  @Column(name = "template_key")
  private String templateKey;

  @Basic
  @Column(name = "description")
  private String description;

  @Override
  public TemplateType parse() {

    TemplateType templateType = new TemplateType();
    templateType.setId(id);
    templateType.setKey(templateKey);
    templateType.setDescription(description);
    templateType.setName(name);

    return templateType;
  }
}
