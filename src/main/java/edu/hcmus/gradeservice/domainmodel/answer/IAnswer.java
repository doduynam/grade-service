package edu.hcmus.gradeservice.domainmodel.answer;

public interface IAnswer {
    public String getAnswer();
    public void setAnswer(String answer);
    public boolean compareAnswer(IAnswer answer);
}
