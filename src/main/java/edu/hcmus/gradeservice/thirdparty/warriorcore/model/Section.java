package edu.hcmus.gradeservice.thirdparty.warriorcore.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Getter
@Setter
public class Section implements IHasMapperization {

    @JsonProperty("section_id")
    private Integer id;

    @JsonProperty("attempt_id")
    private Integer attemptId;

    @JsonProperty("section_index")
    private Integer sectionIndex;

    @JsonProperty("section_type")
    private Integer sectionType;

    @JsonProperty("templates")
    private List<Template> templates;

    private Map<Integer, Template> templateMap = new TreeMap<>();

    @Override
    public void mapperize() {
        for (Template template: templates) {
            template.mapperize();
            templateMap.put(template.getTemplateIndex(), template);
        }
    }
}
