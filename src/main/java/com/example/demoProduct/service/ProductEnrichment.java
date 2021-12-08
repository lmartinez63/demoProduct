package com.example.demoProduct.service;

import com.example.demoProduct.apiclients.LocationClient;
import com.example.demoProduct.entity.Location;
import com.example.demoProduct.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductEnrichment {
    @Autowired
    LocationClient locationClient;

    List<Location> locationList;
    Map<String, List<Location>> locationMap;

    @PostConstruct
    private void initializeLocations(){
        log.info("action=initializeLocations");
        locationList = locationClient.getLocations();
        locationMap = locationList.stream().collect(Collectors.groupingBy(Location::getLocationCode));
        log.info("locationList", locationList);
    }

    public void enrichProduct(Product product){
        log.info("action=enrichProduct");
        String locationCode = product.getLocationCode();
        List<Location> locations = locationMap.containsKey(locationCode) ? locationMap.get(locationCode) : Collections.emptyList();
        if(!locations.isEmpty()){
            product.setLocation(locations.get(0));
        }
    }
}
