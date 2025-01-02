package com.example.aopv1.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService {
    @Override
    public String getFortune() {

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Unlucky, traffic";
    }

    @Override
    public String getFortune(boolean breakCode) {

        if (breakCode) throw new RuntimeException("Runtime error");

        return getFortune();
    }
}
