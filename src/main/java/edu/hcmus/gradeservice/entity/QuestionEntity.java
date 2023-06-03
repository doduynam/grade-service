package edu.hcmus.gradeservice.entity;

import edu.hcmus.gradeservice.domainmodel.answer.IAnswer;
import edu.hcmus.gradeservice.domainmodel.question.IQuestion;
import edu.hcmus.gradeservice.domainmodel.question.QuestionFactory;
import edu.hcmus.gradeservice.domainmodel.template.Template;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Entity
@Table(name = "question")
@Data
@Getter
@Setter
public class QuestionEntity implements IHasDomainModel{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "question_id")
    private Integer id;

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

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JoinColumn(name="answer_id")
    private List<AnswerEntity> answers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "template_id", insertable = false, updatable = false)
    private TemplateEntity template;

    @Override
    public IQuestion parse() {
        Integer templateTypeId = template.getTemplateTypeId();
        IQuestion question = QuestionFactory.INSTANCE.get(templateTypeId);
        question.setId(id);
        question.setQuestionScore(score);
        question.setContent(content);
        question.setIndex(questionIndex);

        List<IAnswer> answerList = new ArrayList<>();
        for (AnswerEntity answer: answers) {
          answerList.add(answer.parse());
        }
        question.setAnswers(answerList);

        return question;
    }
}
