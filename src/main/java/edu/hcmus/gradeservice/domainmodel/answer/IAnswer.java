package edu.hcmus.gradeservice.domainmodel.answer;

public interface IAnswer {
    public String getAnswer();
    public String options();
    public void setAnswer(String answer);
    public void setOptions(String options);
    public boolean compareAnswer(IAnswer answer);
}
