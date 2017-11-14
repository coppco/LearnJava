package com.coppco.service;

import com.coppco.dao.DictDao;
import com.coppco.domain.Dict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Service(value = "dictService")
public class DictServiceImpl implements DictService {

    @Resource(name = "dictDao")
    private DictDao dictDao;

    @Override
    public List<Dict> findByCode(String dict_type_code) {
        return dictDao.findByCode(dict_type_code);
    }
}
