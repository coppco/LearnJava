package com.coppco;


import org.springframework.stereotype.Service;

@Service
public class FunctionService {

    public void sayHello(String word) {
        System.out.println("Hello " + word + "!");
    }

}
