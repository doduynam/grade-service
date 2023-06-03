package edu.hcmus.gradeservice.query.type;

import edu.hcmus.gradeservice.domainmodel.testattempt.TestAttempt;
import edu.hcmus.gradeservice.entity.AttemptEntity;
import edu.hcmus.gradeservice.entity.IHasDomainModel;
import edu.hcmus.gradeservice.entity.TestAttemptEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestAttemptQuery implements IHasEntity {

  private Integer id;

  private Integer userId;

  private Integer originalTestId;

  private Integer state;

  private java.sql.Timestamp startedAt;

  private java.sql.Timestamp endedAt;

  private AttemptQuery attemptQuery;

  @Override
  public TestAttemptEntity parse() {
    TestAttemptEntity entity = new TestAttemptEntity();
    entity.setId(id);
    entity.setUserId(userId);
    entity.setOriginalTestId(originalTestId);
    entity.setState(state);
    entity.setStartedAt(startedAt);
    entity.setEndedAt(endedAt);

    AttemptEntity attemptEntity = attemptQuery.parse();
    entity.setAttemptEntity(attemptEntity);

    return entity;
  }
}
