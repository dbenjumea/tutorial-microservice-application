package com.dbenjumea.tutorial_microservices.counterservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * This is a basic controller which will be the endpoint which manages everything related with the
 * count of request made
 */
@RestController
@RefreshScope
public class CounterController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value(value = "${counter.prefixMessage}")
    private String prefixMessage;

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
    public String getCount(){
        return prefixMessage + counter.getAndIncrement();
    }

    @RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }
}
