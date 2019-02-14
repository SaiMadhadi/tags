package com.peoplehum.tag.common.exception;

import com.nethum.errorhandling.exception.NethumBaseException;
import com.nethum.errorhandling.exception.error.AppErrorObject;
import com.peoplehum.tag.common.model.TagStatusCode;
import org.springframework.http.HttpStatus;

/**
 * Created by peoplehum on 22/11/18.
 */
public class TagException extends NethumBaseException {

  /**
   * @param statusCode
   */
  public TagException(TagStatusCode statusCode) {
    super(new AppErrorObject.Builder().appCode(statusCode).HttpStatus(HttpStatus.OK).build());
  }

  /**
   * @param statusCode
   * @param httpStatus
   */
  public TagException(TagStatusCode statusCode, HttpStatus httpStatus) {
    super(new AppErrorObject.Builder().appCode(statusCode).HttpStatus(httpStatus).build());
  }

  public TagException(TagStatusCode code, Throwable throwable) {
    super(new AppErrorObject.Builder().throwable(throwable).HttpStatus(HttpStatus.OK).appCode(code)
        .build());
  }
}
