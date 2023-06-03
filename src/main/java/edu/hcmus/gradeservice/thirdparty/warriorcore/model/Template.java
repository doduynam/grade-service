package edu.hcmus.gradeservice.thirdparty.warriorcore.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Getter
@Setter
public class Template implements IHasMapperization {

    @JsonProperty("template_id")
    private Integer id;

    @JsonProperty("template_type_id")
    private Integer templateTypeId;

    @JsonProperty("section_id")
    private Integer sectionId;

    @JsonProperty("template_index")
    private Integer templateIndex;

    @JsonProperty("title")
    private String title;

    @JsonProperty("content")
    private String content;

    @JsonProperty("expand_column")
    private String expandColumn;

    @JsonProperty("questions")
    private List<Question> questions;

    private Map<Integer, Question> questionMap = new TreeMap<>();

    @Override
    public void mapperize() {
        for (Question question: questions) {
            questionMap.put(question.getQuestionIndex(), question);
        }
    }
}
