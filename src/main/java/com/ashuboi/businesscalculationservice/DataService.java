package com.ashuboi.businesscalculationservice;

import org.springframework.stereotype.Component;

@Component
public interface DataService {
    int[] retrieveData();
}