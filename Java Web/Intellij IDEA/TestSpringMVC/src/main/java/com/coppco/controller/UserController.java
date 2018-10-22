package com.coppco.controller;

import com.coppco.pojo.User;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public Map validUser(@Validated User user, @Validated @Length(min = 1, max = 2, message = "性别不对") @RequestParam(value = "gender", required = true) String gender, BindingResult result) {
        HashMap<String, String> map = new HashMap<>();
        if(result.hasErrors()){
            for (ObjectError error : result.getAllErrors()) {
                map.put("error", error.getDefaultMessage());
            }
        } else {
            map.put("name", user.getUsername());
        }
        return map;
    }
}
