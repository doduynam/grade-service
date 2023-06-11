package edu.hcmus.gradeservice.query.request.type;

import edu.hcmus.gradeservice.entity.AttemptEntity;
import edu.hcmus.gradeservice.entity.SectionEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AttemptQuery implements IHasEntity {

      private Integer id;

      private Integer testAttemptId;
      private String title;
      private Integer testType;

      private Integer testLevel;

      private List<SectionQuery> sections;

      public AttemptEntity parse() {
          AttemptEntity entity = new AttemptEntity();
          entity.setId(id);
          entity.setTestAttemptId(testAttemptId);
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
