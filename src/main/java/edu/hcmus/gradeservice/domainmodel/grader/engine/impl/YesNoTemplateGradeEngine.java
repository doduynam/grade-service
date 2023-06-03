package edu.hcmus.gradeservice.domainmodel.grader.engine.impl;

import edu.hcmus.gradeservice.domainmodel.answer.impl.YesNoAnswer;
import edu.hcmus.gradeservice.domainmodel.grader.result.impl.ResultComparison;
import edu.hcmus.gradeservice.domainmodel.question.IQuestion;
import edu.hcmus.gradeservice.domainmodel.question.impl.YesNoQuestion;
import edu.hcmus.gradeservice.thirdparty.warriorcore.model.Answer;
import edu.hcmus.gradeservice.thirdparty.warriorcore.model.Question;

import java.util.TreeMap;

public class YesNoTemplateGradeEngine extends BaseGradeEngine {

    @Override
    public Integer beforeExecute() {
        this.totalScore = 0;
        this.resultComparisons = new TreeMap<>();
        return 0;
    }

    @Override
    public Integer executeComparison(Question questionHasCorrectAnswer, IQuestion questionHasUserSubmission) {
        //Fetch the correct answer and user's answer to compare
        Answer correctAnswer = questionHasCorrectAnswer.getAnswers().get(0);
        YesNoAnswer userAnswer = ((YesNoQuestion) questionHasUserSubmission).getAnswer();

        //Building the result comparison
        ResultComparison resultComparison = new ResultComparison();
        resultComparison.setQuestionHasCorrectAnswer(questionHasCorrectAnswer);
        resultComparison.setQuestionHasUserSubmissionAnswer(questionHasUserSubmission);

        //Comparing....
        if (userAnswer.checkAnswer(correctAnswer)) {
            Integer score = questionHasCorrectAnswer.getScore();
            this.totalScore += score;
            resultComparison.setIsCorrect(true);
            resultComparison.setScore(score);
        } else {
            resultComparison.setIsCorrect(false);
            resultComparison.setScore(0);
        }

        //User submission and correct one has the same questionIndex
        Integer questionIndex = questionHasCorrectAnswer.getQuestionIndex();
        this.resultComparisons.put(questionIndex, resultComparison);

        return 0;
    }

    @Override
    public Integer afterExecute() {
        //do nothing

        return 0;
    }

}
