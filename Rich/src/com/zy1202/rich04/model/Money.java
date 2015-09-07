package com.zy1202.rich04.model;

import java.util.ArrayList;
import java.util.List;

import com.zy1202.rich04.biz.IMoneyBiz;
import com.zy1202.rich04.bo.IMoneyBO;

public class Money implements IMoneyBO,IMoneyBiz{
	private int cash;
	private int point;
	private List<House> houses; 
	
	
	public Money(int cash, int point) {
		super();
		this.cash = cash;
		this.point = point;
		this.houses = new ArrayList<House>();
	}

	@Override
	public int addCash(int cash) {
		// TODO Auto-generated method stub
		this.cash+=cash;
		return cash;
	}

	@Override
	public int reduceCash(int cash) {
		// TODO Auto-generated method stub
		this.cash-=cash;
		return cash;
	}

	@Override
	public int queryCash() {
		// TODO Auto-generated method stub
		return cash;
	}

	@Override
	public int addPoint(int point) {
		// TODO Auto-generated method stub
		this.point+=point;
		return point;
	}

	@Override
	public int reducePoint(int point) {
		// TODO Auto-generated method stub
		this.point-=point;
		return point;
	}

	@Override
	public int queryPoint() {
		// TODO Auto-generated method stub
		return point;
	}

	@Override
	public List<House> addHouse(House house) {
		// TODO Auto-generated method stub
		this.houses.add(house);
		return houses;
	}

	@Override
	public List<House> reduceHouse(House house) {
		// TODO Auto-generated method stub
		this.houses.remove(house);
		return houses;
	}

	@Override
	public List<House> queryHouse() {
		// TODO Auto-generated method stub
		return houses;
	}

	@Override
	public void setCash(int cash) {
		// TODO Auto-generated method stub
		this.cash=cash;
	}

	@Override
	public int getCash() {
		// TODO Auto-generated method stub
		return cash;
	}

	@Override
	public void setPoint(int point) {
		// TODO Auto-generated method stub
		this.point=point;
	}

	@Override
	public int getPoint() {
		// TODO Auto-generated method stub
		return point;
	}

	@Override
	public void setHouse(List<House> houses) {
		// TODO Auto-generated method stub
		this.houses=houses;
	}

	@Override
	public List<House> getHouse() {
		// TODO Auto-generated method stub
		return houses;
	}

	@Override
	public String toString() {
		return "Money [cash=" + cash + ", point=" + point + ", houses="
				+ houses + "]";
	}
	
	
}
