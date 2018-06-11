package com.coppco.controller;

import com.coppco.pojo.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class DateController {

    @RequestMapping(value = "/date", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Teacher date(@RequestBody Teacher teacher){
        return teacher;
    }
}
