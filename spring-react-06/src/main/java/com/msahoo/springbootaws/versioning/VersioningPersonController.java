package com.msahoo.springbootaws.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping("/v1/person")
    public Person1 getUrlVersionFirstPerson() {
        return new Person1("Bob Charlie");
    }

    @GetMapping("/v2/person")
    public Person2 getUrlVersionSecondPerson() {
        return new Person2(new Name("Bob", "Charlie"));
    }

    @GetMapping(path="/person", params = "version=1")
    public Person1 getFirstVersionOfPersonRequestParameter() {
        return new Person1("Bob Charlie");
    }

    @GetMapping(path="/person", params = "version=2")
    public Person2 getSecondVersionOfPersonRequestParameter() {
        return new Person2(new Name("Bob", "Charlie"));
    }

    @GetMapping(path="/person", headers = "X-API-VERSION=1")
    public Person1 getFirstVersionOfPersonRequestHeader() {
        return new Person1("Bob Charlie");
    }

    @GetMapping(path="/person", headers = "X-API-VERSION=2")
    public Person2 getSecondVersionOfPersonRequestHeader() {
        return new Person2(new Name("Bob", "Charlie"));
    }

    @GetMapping(path="/person", produces = "application/vnd.app-v1+json")
    public Person1 getFirstVersionOfPersonAcceptHeader() {
        return new Person1("Bob Charlie");
    }

    @GetMapping(path="/person", produces = "application/vnd.app-v2+json")
    public Person2 getSecondVersionOfPersonAcceptHeader() {
        return new Person2(new Name("Bob", "Charlie"));
    }
}
