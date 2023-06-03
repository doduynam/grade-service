package edu.hcmus.gradeservice.query.response;

import edu.hcmus.gradeservice.query.response.type.SectionResult;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SubmitResponse {

    private Integer score;
    private List<SectionResult> sectionResults;
}
