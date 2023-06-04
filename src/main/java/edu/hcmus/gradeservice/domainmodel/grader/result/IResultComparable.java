package edu.hcmus.gradeservice.domainmodel.grader.result;

import java.util.Map;

public interface IResultComparable<T> {
    public Map<Integer, T> getResultComparables();
}
