package edu.hcmus.gradeservice.query.request;

import edu.hcmus.gradeservice.query.request.type.TestAttemptQuery;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubmitRequest {
    private TestAttemptQuery testAttempt;
}
