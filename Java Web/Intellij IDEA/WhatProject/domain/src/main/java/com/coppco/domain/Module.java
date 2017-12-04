package com.coppco.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 角色
 * @author Administrator
 *
 */
public class Module extends BaseEntity {
	/**
	 * 模块id
	 */
	private String id;
	/**
	 * 模块与角色关系: 多对多
	 */
	private Set<Role> roles = new HashSet<Role>(0);
	/**
	 * 父模块id编号
	 */
	private String parentId;
	/**
	 * 父模块名称
	 */
	private String parentName;
	/**
	 * 模块名
	 */
	private String name;
	/**
	 * 层数
	 */
	private Integer layerNum;
	/**
	 * 是否叶子(顶端)
	 */
	private Integer isLeaf;
	/**
	 * 图片
	 */
	private String ico;
	/**
	 * 权限
	 */
	private String cpermission;
	/**
	 * 跳转路径
	 */
	private String curl;
	/**
	 * 菜单类型: 主菜单、左侧菜单、按钮
	 */
	private Integer ctype;
	/**
	 * 状态
	 */
	private Integer state;
	/**
	 * 从属于
	 */
	private String belong;
	/**
	 *
	 */
	private String cwhich;//
	/**
	 * 引用次数
	 */
	private Integer quoteNum;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 排列序号
	 */
	private Integer orderNo;//排序号
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getLayerNum() {
		return layerNum;
	}
	public void setLayerNum(Integer layerNum) {
		this.layerNum = layerNum;
	}
	public Integer getIsLeaf() {
		return isLeaf;
	}
	public void setIsLeaf(Integer isLeaf) {
		this.isLeaf = isLeaf;
	}
	public String getIco() {
		return ico;
	}
	public void setIco(String ico) {
		this.ico = ico;
	}
	public String getCpermission() {
		return cpermission;
	}
	public void setCpermission(String cpermission) {
		this.cpermission = cpermission;
	}
	public String getCurl() {
		return curl;
	}
	public void setCurl(String curl) {
		this.curl = curl;
	}
	public Integer getCtype() {
		return ctype;
	}
	public void setCtype(Integer ctype) {
		this.ctype = ctype;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getBelong() {
		return belong;
	}
	public void setBelong(String belong) {
		this.belong = belong;
	}
	public String getCwhich() {
		return cwhich;
	}
	public void setCwhich(String cwhich) {
		this.cwhich = cwhich;
	}
	public Integer getQuoteNum() {
		return quoteNum;
	}
	public void setQuoteNum(Integer quoteNum) {
		this.quoteNum = quoteNum;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
}
