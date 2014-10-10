package org.bura.simple.spring

import groovy.json.JsonOutput

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
class HelloWorldController {

    @RequestMapping(value = '/hello', method = RequestMethod.GET)
    def helloWorld() {
        new ResponseEntity<String>(JsonOutput.toJson([message: 'Hello world, I am a Spring MVC controller!']), HttpStatus.OK)
    }
}
