package edu.hcmus.gradeservice.entity;

import edu.hcmus.gradeservice.domainmodel.attempt.AttemptFactory;
import edu.hcmus.gradeservice.domainmodel.attempt.IAttempt;
import edu.hcmus.gradeservice.domainmodel.attempt.impl.BaseAttempt;
import edu.hcmus.gradeservice.domainmodel.section.ISection;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Entity
@Table(name = "attempt")
@Data
@Getter
@Setter
public class AttemptEntity implements IHasDomainModel {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "attempt_id")
    private Integer id;

    @Basic
    @Column(name = "test_attempt_id")
    private Integer testAttemptId;

    @Basic
    @Column(name = "title")
    private String title;

    @Basic
    @Column(name = "test_type")
    private Integer testType;

    @Basic
    @Column(name = "test_level")
    private Integer testLevel;

    @OneToMany(
          fetch = FetchType.LAZY,
          cascade = CascadeType.ALL,
          orphanRemoval = true)
    @JoinColumn(name="attempt_id")
    private List<SectionEntity> sections;

    @Override
    public IAttempt parse() {
        IAttempt obj = AttemptFactory.INSTANCE.get(testType);
        if (null == obj) {
          return null;
        }

        obj.setId(id);

        //Build the section map
        Map<Integer, ISection> sectionMap = new TreeMap<>();
        for (SectionEntity sectionEntity: sections) {
          Integer index = sectionEntity.getSectionIndex();
          ISection section = sectionEntity.parse();
          sectionMap.put(index, section);
        }

        obj.setSections(sectionMap);

        return obj;
    }
}
