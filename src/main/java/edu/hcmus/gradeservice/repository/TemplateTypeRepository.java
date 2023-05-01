package edu.hcmus.gradeservice.repository;

import edu.hcmus.gradeservice.entity.TemplateTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateTypeRepository extends JpaRepository<TemplateTypeEntity, Long> {}
