package edu.hcmus.gradeservice.repository;

import edu.hcmus.gradeservice.entity.AttemptEntity;
import edu.hcmus.gradeservice.entity.TestAttemptEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestAttemptRepository extends JpaRepository<TestAttemptEntity, Long> {
}
