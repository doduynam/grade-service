package edu.hcmus.gradeservice.domainmodel.section.impl;

import edu.hcmus.gradeservice.domainmodel.paragraph.IParagraph;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReadingSection extends BaseSection {
    protected IParagraph paragraph;
}
