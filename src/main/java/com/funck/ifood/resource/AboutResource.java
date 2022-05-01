package com.funck.ifood.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("about")
public class AboutResource {

    @GetMapping
    public Mono<String> about() {
        return Mono.just("Server status is: OK");
    }

}
