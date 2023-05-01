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
@Table(name = "answer")
@Data
public class AnswerEntity {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "answer_id")
  private long id;

  @Basic
  @Column(name = "question_id")
  private Integer questionId;

  @Basic
  @Column(name = "content")
  private String content;

  @Basic
  @Column(name = "options")
  private String options;

}
