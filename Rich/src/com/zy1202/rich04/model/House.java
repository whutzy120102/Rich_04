package com.zy1202.rich04.model;

import com.zy1202.rich04.biz.IHouseBiz;
import com.zy1202.rich04.bo.IHouseBO;

public class House implements IHouseBO,IHouseBiz{

	private int id;
	private int rank;
	private int price;
	
		
	public House(int id, int price) {
		super();
		this.id = id;
		this.rank = 0;
		this.price = price;
	}

	@Override
	public int upRank() {
		// TODO Auto-generated method stub
		rank++;
		return rank;
	}

	@Override
	public void setId(int id) {
		// TODO Auto-generated method stub
		this.id=id;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public void setRank(int rank) {
		// TODO Auto-generated method stub
		this.rank=rank;
	}

	@Override
	public int getRank() {
		// TODO Auto-generated method stub
		return rank;
	}

	@Override
	public void setPrice(int price) {
		// TODO Auto-generated method stub
		this.price=price;
	}

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

}
