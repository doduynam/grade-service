package edu.hcmus.gradeservice.thirdparty.warriorcore.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class Question {

    @JsonProperty("question_id")
    private Integer id;

    @JsonProperty("template_id")
    private Integer templateId;

    @JsonProperty("question_index")
    private Integer questionIndex;

    @JsonProperty("content")
    private String content;

    @JsonProperty("options")
    private String options;

    @JsonProperty("score")
    private Integer score;

    @JsonProperty("answer")
    private List<Answer> answers;

}
