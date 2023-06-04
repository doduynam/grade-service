package edu.hcmus.gradeservice.domainmodel.grader.engine;

public interface IGradable {

    public Integer getTotalScore();
    public Integer executeGrading();
}
