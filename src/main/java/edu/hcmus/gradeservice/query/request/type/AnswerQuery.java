package edu.hcmus.gradeservice.query.request.type;

import edu.hcmus.gradeservice.entity.AnswerEntity;
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
