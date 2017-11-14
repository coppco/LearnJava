package com.coppco.service;

import com.coppco.dao.VisitDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Transactional
@Service(value = "visitService")
public class VisitServiceImpl implements VisitService {

    @Resource(name = "visitDao")
    private VisitDao visitDao;
}
