package edu.hcmus.gradeservice.domainmodel.question;

import java.util.ArrayList;

public interface IQuestion<T> {

    public int getId();
    public String getContent();
    public ArrayList<T> getAnswers();

    public void setId(int id);
    public void setContent(String content);
    public void setAnswers(T answers);
}
