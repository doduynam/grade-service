package edu.hcmus.gradeservice.domainmodel.template;

import edu.hcmus.gradeservice.domainmodel.question.IQuestion;
import edu.hcmus.gradeservice.domainmodel.templatetype.TemplateType;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class Template {

    protected Integer id;
    protected Integer index;
    protected TemplateType templateType;
    protected Map<Integer, IQuestion> questions;
    protected String content;

}
