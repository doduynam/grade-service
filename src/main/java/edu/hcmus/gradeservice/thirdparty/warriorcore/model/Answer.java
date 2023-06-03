package edu.hcmus.gradeservice.thirdparty.warriorcore.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Answer {

    @JsonProperty("answer_id")
    private Integer id;

    @JsonProperty("question_id")
    private Integer questionId;

    @JsonProperty("content")
    private String content;

    @JsonProperty("options")
    private String options;

}
