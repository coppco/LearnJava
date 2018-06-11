package com.coppco;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"com.coppco", "com.coppco.main"})
public class Config {

}
