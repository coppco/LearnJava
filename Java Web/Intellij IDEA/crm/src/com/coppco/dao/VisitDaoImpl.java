package com.coppco.dao;

import com.coppco.domain.Visit;
import org.springframework.stereotype.Repository;

@Repository(value = "visitDao")
public class VisitDaoImpl extends BaseDaoImpl<Visit> implements VisitDao {

}
