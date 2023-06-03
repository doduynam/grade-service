package edu.hcmus.gradeservice.entity;

import edu.hcmus.gradeservice.domainmodel.answer.AnswerFactory;
import edu.hcmus.gradeservice.domainmodel.answer.IAnswer;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "answer")
@Data
@Getter
@Setter
public class AnswerEntity implements IHasDomainModel {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "answer_id")
  private Integer id;

  @Basic
  @Column(name = "question_id")
  private Integer questionId;

  @Basic
  @Column(name = "content")
  private String content;

  @Basic
  @Column(name = "options")
  private String options;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "question_id")
  private QuestionEntity question;

  @Override
  public IAnswer parse() {
      Integer templateTypeId = question.getTemplate().getTemplateTypeId();
      IAnswer answer = AnswerFactory.INSTANCE.get(templateTypeId);

      answer.setAnswer(content);
      answer.setOptions(options);

      return null;
  }
}
