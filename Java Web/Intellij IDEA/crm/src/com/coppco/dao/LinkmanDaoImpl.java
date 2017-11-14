package com.coppco.dao;

import com.coppco.domain.Linkman;
import org.springframework.stereotype.Repository;

@Repository(value = "linkmanDao")
public class LinkmanDaoImpl extends BaseDaoImpl<Linkman> implements LinkmanDao {
}
