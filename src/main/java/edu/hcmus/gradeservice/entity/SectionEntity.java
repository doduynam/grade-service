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
@Table(name = "section")
@Data
public class SectionEntity {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "section_id")
  private long id;

  @Basic
  @Column(name = "test_id")
  private Integer testId;

  @Basic
  @Column(name = "section_index")
  private Integer sectionIndex;

  @Basic
  @Column(name = "section_type")
  private Integer sectionType;

}
