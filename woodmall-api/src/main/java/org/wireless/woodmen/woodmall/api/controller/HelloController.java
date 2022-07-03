package org.wireless.woodmen.woodmall.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping(path = {"/", "/hello"})
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("hello");
    }
}
