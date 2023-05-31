package edu.hcmus.gradeservice.repository;

import edu.hcmus.gradeservice.entity.AttemptEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttemptRepository extends JpaRepository<AttemptEntity, Long> {

}
