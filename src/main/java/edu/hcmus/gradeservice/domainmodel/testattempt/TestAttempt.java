package edu.hcmus.gradeservice.domainmodel.testattempt;

import edu.hcmus.gradeservice.domainmodel.attempt.IAttempt;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestAttempt {

    private Integer id;
    private Integer userId;
    private Integer originalTestId;
    private IAttempt attempt;

    private Integer state;
    private java.sql.Timestamp startedAt;
    private java.sql.Timestamp endedAt;
}
