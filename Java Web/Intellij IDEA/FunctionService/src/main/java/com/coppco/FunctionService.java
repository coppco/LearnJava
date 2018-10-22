package com.coppco;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FunctionService {

    @Value("${HELLO}")
    private String HELLO;

    public void sayHello(String word) {
        System.out.println(HELLO + word + "!");
    }

}
