package com.coppco.domain;

import java.util.Date;

public class Product {
	/*
	`pid` varchar (96),
	`pname` varchar (150),
	`market_price` double ,
	`shop_price` double ,
	`pimage` varchar (600),
	`pdate` date ,
	`pdesc` varchar (765)
	*/
	
	private String pid;
	private String pname;
	private double market_price;
	private double shop_price;
	private Date pdate;
	private String pimage;
	public String getPimage() {
		return pimage;
	}
	public void setPimage(String pimage) {
		this.pimage = pimage;
	}
	private String pdesc;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getMarket_price() {
		return market_price;
	}
	public void setMarket_price(double market_price) {
		this.market_price = market_price;
	}
	public double getShop_price() {
		return shop_price;
	}
	public void setShop_price(double shop_price) {
		this.shop_price = shop_price;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", market_price=" + market_price + ", shop_price="
				+ shop_price + ", pdate=" + pdate + ", pimage=" + pimage + ", pdesc=" + pdesc + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(market_price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((pdate == null) ? 0 : pdate.hashCode());
		result = prime * result + ((pdesc == null) ? 0 : pdesc.hashCode());
		result = prime * result + ((pid == null) ? 0 : pid.hashCode());
		result = prime * result + ((pimage == null) ? 0 : pimage.hashCode());
		result = prime * result + ((pname == null) ? 0 : pname.hashCode());
		temp = Double.doubleToLongBits(shop_price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (Double.doubleToLongBits(market_price) != Double.doubleToLongBits(other.market_price))
			return false;
		if (pdate == null) {
			if (other.pdate != null)
				return false;
		} else if (!pdate.equals(other.pdate))
			return false;
		if (pdesc == null) {
			if (other.pdesc != null)
				return false;
		} else if (!pdesc.equals(other.pdesc))
			return false;
		if (pid == null) {
			if (other.pid != null)
				return false;
		} else if (!pid.equals(other.pid))
			return false;
		if (pimage == null) {
			if (other.pimage != null)
				return false;
		} else if (!pimage.equals(other.pimage))
			return false;
		if (pname == null) {
			if (other.pname != null)
				return false;
		} else if (!pname.equals(other.pname))
			return false;
		if (Double.doubleToLongBits(shop_price) != Double.doubleToLongBits(other.shop_price))
			return false;
		return true;
	}
	
	
}
