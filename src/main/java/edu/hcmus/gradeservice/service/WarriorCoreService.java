package edu.hcmus.gradeservice.service;

import edu.hcmus.gradeservice.thirdparty.warriorcore.model.Test;

public interface WarriorCoreService {

    public Test getTestHasCorrectAnswerById(Integer id);
}
