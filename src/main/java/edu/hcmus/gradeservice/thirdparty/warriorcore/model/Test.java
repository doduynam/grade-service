package edu.hcmus.gradeservice.thirdparty.warriorcore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Getter
@Setter
public class Test implements IHasMapperization {

    @JsonProperty("test_id")
    private Integer id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("test_type")
    private Integer testType;

    @JsonProperty("test_level")
    private Integer testLevel;

    @JsonProperty("sections")
    private List<Section> sections;

    @JsonIgnore
    private Map<Integer, Section> sectionMap = new TreeMap<>();

    @Override
    public void mapperize() {
        for (Section section: sections) {
            section.mapperize();
            sectionMap.put(section.getSectionIndex(), section);
        }
    }
}
