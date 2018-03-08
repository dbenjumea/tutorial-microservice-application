package com.dbenjumea.tutorial_microservices.counterservice.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * This is a basic controller which will be the endpoint which manages everything related with the
 * count of request made
 */
@RestController
public class CounterController {

    // We use AtomicLong for making count thread-safe
    private static AtomicLong counter = new AtomicLong(0);

    /**
     * This method will return a counter which collects how many times the endpoint
     * has been called.
     *
     * It is going to be used GetMapping instead of Request-Mapping
     *
     * @return count
     */
    @GetMapping(path = "/count")
    public long getCount(){
        return counter.getAndIncrement();
    }

}
