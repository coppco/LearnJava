package com.coppco.service;

import com.coppco.domain.Dict;

import java.util.List;

public interface DictService {
    List<Dict> findByCode(String dict_type_code);
}
