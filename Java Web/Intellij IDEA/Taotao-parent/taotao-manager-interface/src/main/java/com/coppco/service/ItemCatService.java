package com.coppco.service;

import com.coppco.common.pojo.EasyTreeNode;

import java.util.List;

public interface ItemCatService {

    List<EasyTreeNode> getCatList(Long parentId);

}
