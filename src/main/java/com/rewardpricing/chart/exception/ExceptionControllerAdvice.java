package com.rewardpricing.chart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.rewardpricing.chart.dto.ErrorMessageDto;

@ControllerAdvice
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {

  @ExceptionHandler(MaxUploadSizeExceededException.class)
  public ResponseEntity handleMaxSizeException(MaxUploadSizeExceededException exc) {
    return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
        .body(new ErrorMessageDto("File too large!"));
  }
  
  @ExceptionHandler(InvalidFileTypeException.class)
  public ResponseEntity handleInvalidFileTypeException(InvalidFileTypeException exc) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(new ErrorMessageDto(exc.getMessage()));
  }
  
  @ExceptionHandler(FileUploadException.class)
  public ResponseEntity handleFileUploadException(FileUploadException exc) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(new ErrorMessageDto(exc.getMessage()));
  }
  
}
