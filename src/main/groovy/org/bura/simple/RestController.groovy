package org.bura.simple
import groovy.json.JsonOutput


class RestController {
    private final UserService service

    RestController(UserService service) {
        this.service = service
    }

    String users() {
        serialize(service.getAll())
    }

    String user(long id) {
        User user = service.get(id)
        if (user) {
            serialize(user)
        } else {
            null
        }
    }

    String error(String message) {
        serialize([error: message])
    }

    private String serialize(resp) {
        JsonOutput.toJson(resp)
    }
}
