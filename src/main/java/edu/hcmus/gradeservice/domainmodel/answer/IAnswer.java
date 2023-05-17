package edu.hcmus.gradeservice.domainmodel.answer;

public interface IAnswer {
    public String getAnswer();
    public void setAnswer(String answer);
    public default boolean compareAnswer(IAnswer answer) {
        return this.getAnswer().equals(answer.getAnswer());
    }
}
