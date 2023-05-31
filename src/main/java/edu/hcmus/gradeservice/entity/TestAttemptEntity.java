package edu.hcmus.gradeservice.entity;

import edu.hcmus.gradeservice.domainmodel.testattempt.TestAttempt;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "test_attempt")
@Data
@Getter
@Setter
public class TestAttemptEntity implements IHasDomainModel {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "test_attempt_id")
  private Integer id;

  @Basic
  @Column(name = "user_id")
  private Integer userId;

  @Basic
  @Column(name = "attempt_id")
  private Integer attemptId;

  @Basic
  @Column(name = "original_test_id")
  private Integer originalTestId;

  @Basic
  @Column(name = "state")
  private Integer state;

  @Basic
  @Column(name = "started_at")
  private java.sql.Timestamp startedAt;

  @Basic
  @Column(name = "ended_at")
  private java.sql.Timestamp endedAt;

  @Override
  public TestAttempt parse() {
    TestAttempt obj = new TestAttempt();
    obj.setId(id);
    obj.setUserId(userId);
    obj.setOriginalTestId(originalTestId);
    obj.setState(state);
    obj.setStartedAt(startedAt);
    obj.setEndedAt(endedAt);
    return obj;
  }
}
