package edu.hcmus.gradeservice.query.type;

import edu.hcmus.gradeservice.domainmodel.answer.AnswerFactory;
import edu.hcmus.gradeservice.domainmodel.answer.IAnswer;
import edu.hcmus.gradeservice.entity.AnswerEntity;
import edu.hcmus.gradeservice.entity.IHasDomainModel;
import edu.hcmus.gradeservice.entity.QuestionEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerQuery implements IHasEntity{

  private Integer id;
  private Integer questionId;
  private String content;
  private String options;

  @Override
  public AnswerEntity parse() {
      AnswerEntity answer = new AnswerEntity();
      answer.setId(id);
      answer.setQuestionId(questionId);
      answer.setContent(content);
      answer.setOptions(options);

      return answer;
  }
}
