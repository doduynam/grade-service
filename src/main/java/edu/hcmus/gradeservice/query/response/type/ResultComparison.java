package edu.hcmus.gradeservice.query.response.type;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ResultComparison {

    private Integer questionIndex;
    private Integer score;
    private Boolean isCorrect;
    private String userSubmissionAnswer;
    private List<String> correctAnswers;

    public static ResultComparison parse(edu.hcmus.gradeservice.domainmodel.grader.result.impl.ResultComparison resultComparison) {
        ResultComparison container = new ResultComparison();
        container.setScore(resultComparison.getScore());
        container.setScore(resultComparison.getScore());
        container.setIsCorrect(resultComparison.getIsCorrect());
        container.setQuestionIndex(resultComparison.getQuestionHasUserSubmissionAnswer().getIndex());

        //Fetch user's answer
        List<String> userSubmissionAnswers = resultComparison.
                getQuestionHasUserSubmissionAnswer()
                .getAnswers()
                .stream()
                .map(answer -> answer.getAnswer())
                .toList();

        String userAnswer = userSubmissionAnswers.get(0);
        container.setUserSubmissionAnswer(userAnswer);

        //Fetch correct answers
        List<String> allCorrectAnswers = resultComparison
                .getQuestionHasCorrectAnswer()
                .getAnswers()
                .stream()
                .map(answer -> answer.getContent())
                .toList();
        container.setCorrectAnswers(allCorrectAnswers);

        return container;
    }
}
