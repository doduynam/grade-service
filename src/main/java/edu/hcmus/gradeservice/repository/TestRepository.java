package edu.hcmus.gradeservice.repository;

import edu.hcmus.gradeservice.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<TestEntity, Long> {}
