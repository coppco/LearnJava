package com.coppco.web.action;

import com.coppco.domain.Visit;
import com.coppco.service.VisitService;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller(value = "visitAction")
@Scope(value = "prototype")
public class VisitAction extends BaseAction implements ModelDriven<Visit> {
    private Visit visit = new Visit();
    @Override
    public Visit getModel() {
        return visit;
    }

    @Resource(name = "visitService")
    private VisitService visitService;



}
