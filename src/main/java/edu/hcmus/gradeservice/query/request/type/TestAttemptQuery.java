package edu.hcmus.gradeservice.query.request.type;

import edu.hcmus.gradeservice.entity.AttemptEntity;
import edu.hcmus.gradeservice.entity.TestAttemptEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class TestAttemptQuery implements IHasEntity {

  private Integer id;

  private Integer userId;

  private Integer originalTestId;

  private Integer state;

  private Long startedAt;

  private Long endedAt;

  private AttemptQuery attempt;

  @Override
  public TestAttemptEntity parse() {
    TestAttemptEntity entity = new TestAttemptEntity();
    entity.setId(id);
    entity.setUserId(userId);
    entity.setOriginalTestId(originalTestId);
    entity.setState(state);

    entity.setStartedAt(java.sql.Timestamp.from(Instant.ofEpochSecond(startedAt)));
    entity.setEndedAt(java.sql.Timestamp.from(Instant.ofEpochSecond(endedAt)));

    AttemptEntity attemptEntity = attempt.parse();
    entity.setAttempt(attemptEntity);

    return entity;
  }
}
