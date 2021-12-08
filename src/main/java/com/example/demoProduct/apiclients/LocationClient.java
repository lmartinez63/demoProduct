package com.example.demoProduct.apiclients;

import com.example.demoProduct.entity.Location;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "location-client", url = "${location-client.base-url}")
public interface LocationClient {
    @GetMapping(path = "${location-client.sub-url}", produces = "application/json")
    List<Location> getLocations();

}
