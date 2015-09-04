package com.zy1202.rich04.biz;

import java.util.List;

import com.zy1202.rich04.model.House;

public interface IMoneyBiz {
	int addCash(int cash);
	int reduceCash(int cash);
	int queryCash();
	int addPoint(int point);
	int reducePoint(int point);
	int queryPoint();
	List<House> addHouse(House house);
	List<House> reduceHouse(House house);
	List<House> queryHouse();
}
