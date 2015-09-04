package com.zy1202.rich04.model;

import com.zy1202.rich04.biz.IHouseCellBiz;
import com.zy1202.rich04.bo.IHouseCellBO;

public class HouseCell extends Cell implements IHouseCellBO,IHouseCellBiz{
	private Player owner;
	private House house;
	public HouseCell(String type,House house) {
		super(type);
		this.house=house;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean hasOwner() {
		// TODO Auto-generated method stub
		if(owner==null){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public void setOwner(Player player) {
		// TODO Auto-generated method stub
		this.owner=player;
	}

	@Override
	public Player getOwner() {
		// TODO Auto-generated method stub
		return owner;
	}

	@Override
	public void setHouse(House house) {
		// TODO Auto-generated method stub
		this.house=house;
	}

	@Override
	public House getHouse() {
		// TODO Auto-generated method stub
		return house;
	}

}
