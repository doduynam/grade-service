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
@Table(name = "test")
@Data
public class TestEntity {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "test_id")
  private long id;

  @Basic
  @Column(name = "title")
  private String title;

  @Basic
  @Column(name = "test_type")
  private Integer testType;

  @Basic
  @Column(name = "test_level")
  private Integer testLevel;

}
