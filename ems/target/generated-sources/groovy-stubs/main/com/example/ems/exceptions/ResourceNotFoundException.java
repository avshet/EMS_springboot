package com.example.ems.exceptions;

@org.springframework.web.bind.annotation.ResponseStatus(value=org.springframework.http.HttpStatus.NOT_FOUND) public class ResourceNotFoundException
  extends java.lang.RuntimeException  implements
    groovy.lang.GroovyObject {
;
public ResourceNotFoundException
(java.lang.String resourceName, java.lang.String fieldName, java.lang.Object fieldValue) {
super ();
}
@groovy.transform.Generated() @groovy.transform.Internal() @java.beans.Transient() public  groovy.lang.MetaClass getMetaClass() { return (groovy.lang.MetaClass)null;}
@groovy.transform.Generated() @groovy.transform.Internal() public  void setMetaClass(groovy.lang.MetaClass mc) { }
public  java.lang.String getResourceName() { return (java.lang.String)null;}
public  java.lang.String getFieldName() { return (java.lang.String)null;}
public  java.lang.Object getFieldValue() { return (java.lang.Object)null;}
}
