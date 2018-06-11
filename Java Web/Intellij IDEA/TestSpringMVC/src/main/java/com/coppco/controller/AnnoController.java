package com.coppco.controller;

import com.coppco.pojo.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/anno")
public class AnnoController {

    @RequestMapping(produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String index(HttpServletRequest request) {
        return "URL: " + request.getRequestURL() + "can access";
    }

    @RequestMapping(value = "/private/{str}")
    @ResponseBody
    public String patchVar(@PathVariable("str") String string, HttpServletRequest request) {
        return "URL: " + request.getRequestURL() + "can access, string: " + string;
    }


    @RequestMapping(value = "/requestParam", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String passParam(HttpServletRequest request, Long id) {
        return "URL: " + request.getRequestURL() + "can access, id: " + id;
    }

    @RequestMapping(value = {"/name1", "/name2"}, produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String mutiable(HttpServletRequest request) {
        return "URL: " + request.getRequestURL() + "can access";
    }

    @RequestMapping(value = "/json", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Teacher json(HttpServletRequest request, @ModelAttribute("name") String name) {
        Teacher teacher = new Teacher();
        teacher.setAge(45);
        teacher.setName(name);
        teacher.setSchoolName("前楼小学");
        teacher.setSex("男");
        return teacher;
    }

    @RequestMapping(value = "/getJson", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public Teacher getJson(HttpServletRequest request, @RequestBody Teacher teacher) {
        return teacher;
    }

}

