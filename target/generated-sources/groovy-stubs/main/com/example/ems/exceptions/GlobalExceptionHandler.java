package com.example.ems.exceptions;

@org.springframework.web.bind.annotation.ControllerAdvice() public class GlobalExceptionHandler
  extends org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler  implements
    groovy.lang.GroovyObject {
;
@groovy.transform.Generated() @groovy.transform.Internal() @java.beans.Transient() public  groovy.lang.MetaClass getMetaClass() { return (groovy.lang.MetaClass)null;}
@groovy.transform.Generated() @groovy.transform.Internal() public  void setMetaClass(groovy.lang.MetaClass mc) { }
@org.springframework.web.bind.annotation.ExceptionHandler(value=org.springframework.web.bind.MethodArgumentNotValidException.class) public  org.springframework.http.ResponseEntity<java.util.Map<java.lang.String, java.lang.String>> handleValidationExceptions(org.springframework.web.bind.MethodArgumentNotValidException ex) { return (org.springframework.http.ResponseEntity<java.util.Map<java.lang.String, java.lang.String>>)null;}
}
