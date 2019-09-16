package com.reactive.SpringReactive.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;

import java.util.Random;

@RestController
@RequestMapping("/carro")
public class CarroController {

    @GetMapping
    private Flux<String> getString(){
        return new Flux<String>() {
            @Override
            public void subscribe(CoreSubscriber<? super String> coreSubscriber) {
                coreSubscriber.onNext("goooo");
            }
        };
    }
}
