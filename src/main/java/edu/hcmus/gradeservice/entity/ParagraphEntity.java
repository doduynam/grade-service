package edu.hcmus.gradeservice.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "paragraph")
@Data
@Getter
@Setter
public class ParagraphEntity {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "paragraph_id")
  private long id;

  @Basic
  @Column(name = "section_id")
  private Integer sectionId;

  @Basic
  @Column(name = "wallpaper")
  private String wallpaper;

  @Basic
  @Column(name = "title")
  private String title;

  @Basic
  @Column(name = "content")
  private String content;

}
