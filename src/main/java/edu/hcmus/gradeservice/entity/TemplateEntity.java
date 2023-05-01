package edu.hcmus.gradeservice.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "template")
@Data
public class TemplateEntity {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "template_id")
  private long id;

  @Basic
  @Column(name = "template_type_id")
  private Integer templateTypeId;

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
}
