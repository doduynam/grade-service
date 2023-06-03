package edu.hcmus.gradeservice.query.type;

import edu.hcmus.gradeservice.domainmodel.attempt.AttemptFactory;
import edu.hcmus.gradeservice.domainmodel.attempt.IAttempt;
import edu.hcmus.gradeservice.domainmodel.section.ISection;
import edu.hcmus.gradeservice.entity.AttemptEntity;
import edu.hcmus.gradeservice.entity.IHasDomainModel;
import edu.hcmus.gradeservice.entity.SectionEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Getter
@Setter
public class AttemptQuery implements IHasEntity {

      private Integer id;

      private String title;
      private Integer testType;

      private Integer testLevel;

      private List<SectionQuery> sections;

      public AttemptEntity parse() {
          AttemptEntity entity = new AttemptEntity();
          entity.setId(id);
          entity.setTitle(title);
          entity.setTestLevel(testLevel);
          entity.setTestType(testType);

          List<SectionEntity> buffer = new ArrayList<>();
          for (SectionQuery sectionQuery: sections) {
              SectionEntity sectionEntity = sectionQuery.parse();
              buffer.add(sectionEntity);
          }
          entity.setSections(buffer);

          return entity;
      }
}
