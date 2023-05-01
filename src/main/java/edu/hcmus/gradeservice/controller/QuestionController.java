package edu.hcmus.gradeservice.controller;

import edu.hcmus.gradeservice.entity.QuestionEntity;
import edu.hcmus.gradeservice.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class QuestionController {

  private final QuestionService questionService;

  @QueryMapping
  public QuestionEntity questionById(@Argument long id) {
    return questionService.findQuestionById(id);
  }
}
