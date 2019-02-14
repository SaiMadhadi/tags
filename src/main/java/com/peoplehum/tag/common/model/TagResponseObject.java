package com.peoplehum.tag.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

/**
 * Created by peoplehum on 21/11/18.
 */
@Slf4j
@ToString(doNotUseGetters = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class TagResponseObject<T> {
  private T responseObject;
  private TagStatusCode status;

  @JsonIgnore
  private HttpStatus statusCode;

  public TagResponseObject() {
    this.statusCode = HttpStatus.OK;
  }

  public TagResponseObject(TagStatusCode status) {
    this();
    this.status = status;
  }

  public TagResponseObject(TagStatusCode status, T responseObject) {
    this(status);
    this.responseObject = responseObject;
  }

}
