package edu.hcmus.gradeservice.domainmodel.question.impl;

import edu.hcmus.gradeservice.domainmodel.answer.impl.YesNoAnswer;
import edu.hcmus.gradeservice.domainmodel.question.IQuestion;

import java.util.ArrayList;

public class YesNoQuesion implements IQuestion<YesNoAnswer> {



    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getContent() {
        return null;
    }

    @Override
    public ArrayList<YesNoAnswer> getAnswers() {
        return null;
    }

    @Override
    public void setId(int id) {

    }

    @Override
    public void setContent(String content) {

    }

    @Override
    public void setAnswers(YesNoAnswer answers) {

    }
}
