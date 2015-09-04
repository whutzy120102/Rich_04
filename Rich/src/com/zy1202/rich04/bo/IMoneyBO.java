package com.zy1202.rich04.bo;

import java.util.List;

import com.zy1202.rich04.model.House;



public interface IMoneyBO {
	void setCash(int cash);
	int getCash();
	void setPoint(int point);
	int getPoint();
	void setHouse(List<House> houses);
	List<House> getHouse();
}
