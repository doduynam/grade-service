package edu.hcmus.gradeservice.domainmodel;

import java.util.List;

public interface IFactory<T> {
    public T get(Object key);
}
