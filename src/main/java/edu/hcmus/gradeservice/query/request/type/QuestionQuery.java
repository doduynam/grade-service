package edu.hcmus.gradeservice.query.request.type;

import edu.hcmus.gradeservice.entity.AnswerEntity;
import edu.hcmus.gradeservice.entity.QuestionEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class QuestionQuery implements IHasEntity {

    private Integer id;
    private Integer templateId;
    private Integer questionIndex;
    private String content;

    private String options;

    private Integer score;
    private List<AnswerQuery> answers;

    @Override
    public QuestionEntity parse() {
        QuestionEntity entity = new QuestionEntity();
        entity.setId(id);
        entity.setTemplateId(templateId);
        entity.setQuestionIndex(questionIndex);
        entity.setContent(content);
        entity.setOptions(options);
        entity.setScore(score);

        //Convert answer to entity
        List<AnswerEntity> buffer = new ArrayList<>();
        for (AnswerQuery answer: answers) {
            AnswerEntity answerEntity = answer.parse();
            answerEntity.setQuestion(entity);
            buffer.add(answerEntity);
        }

        return entity;
    }
}
