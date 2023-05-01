package edu.hcmus.gradeservice.repository;

import edu.hcmus.gradeservice.entity.ParagraphEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParagraphRepository extends JpaRepository<ParagraphEntity, Long>{}
