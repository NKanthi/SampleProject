package com.example.demo.rest;
import jdk.nashorn.internal.objects.annotations.Property;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HelloWorldPerson {

  String name;
  int age;
  String occupation;

  public void populate(String name, int age, String occupation) {
    this.name = name;
    this.age = age;
    this.occupation = occupation;
  }

  @Override
  public String toString() {
    return  "name: " + name + "\n" +
            "age: " + age + "\n" +
            "occupation: " + occupation;
  }
}
