package edu.hcmus.gradeservice.query.response.type;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SectionResult {

    private Integer sectionIndex;
    private Integer score;
    private List<TemplateResult> templateResults;

}
