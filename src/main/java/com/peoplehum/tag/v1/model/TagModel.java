package com.peoplehum.tag.v1.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(doNotUseGetters = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class TagModel {

  private Long id;
  private Long customerId;
  private String tagName;
  private String tagCategory;

  public TagModel(Long customerId, String tagName, String tagCategory) {
    this.customerId = customerId;
    this.tagName = tagName;
    this.tagCategory = tagCategory;
  }

}