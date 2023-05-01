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
@Table(name = "question")
@Data
public class QuestionEntity {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "question_id")
  private long id;

  @Basic
  @Column(name = "template_id")
  private Integer templateId;

  @Basic
  @Column(name = "question_index")
  private Integer questionIndex;

  @Basic
  @Column(name = "content")
  private String content;

  @Basic
  @Column(name = "options")
  private String options;

  @Basic
  @Column(name = "score")
  private Integer score;

}
