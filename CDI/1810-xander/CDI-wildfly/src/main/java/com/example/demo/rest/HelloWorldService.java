package com.example.demo.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;


@ApplicationScoped
public class HelloWorldService {

  @Inject
  private HelloWorldPerson person;

  public HelloWorldPerson getPerson() {
    person.populate("xander", 19, "dev");
    return person;
  }
}
