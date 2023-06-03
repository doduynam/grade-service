package edu.hcmus.gradeservice.thirdparty.warriorcore.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import edu.hcmus.gradeservice.thirdparty.warriorcore.model.Test;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetCorrectTestResponse {

    @JsonProperty("code")
    private Integer code;

    @JsonProperty("message")
    private String message;

    @JsonProperty("data")
    private Test data;

}
