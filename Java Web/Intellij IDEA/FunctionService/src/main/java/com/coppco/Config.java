package com.coppco;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"com.coppco", "com.coppco.main"})
@PropertySource(value = {"classpath:jdbc.properties", "abc.properties"}, ignoreResourceNotFound = true)
//@ImportResource(value = "classpath:application.xml")
public class Config {




}
