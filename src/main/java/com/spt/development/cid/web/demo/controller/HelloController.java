package com.spt.development.cid.web.demo.controller;

import com.spt.development.cid.CorrelationId;
import com.spt.development.cid.web.demo.exception.UnknownUserException;
import com.spt.development.cid.web.demo.service.HelloService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api/v1.0/hello")
public class HelloController {
    private final HelloService helloService;

    @GetMapping
    public ResponseEntity<String> helloAll() {
        log.info("[{}] Processing request for /hello", CorrelationId.get());

        return ResponseEntity.ok(helloService.hello());
    }

    @GetMapping("/{userId:\\d+}")
    public ResponseEntity<String> helloUser(@PathVariable long userId) throws UnknownUserException {
        log.info("[{}] Processing request for /hello/{}", CorrelationId.get(), userId);

        return ResponseEntity.ok(helloService.hello(userId));
    }
}
