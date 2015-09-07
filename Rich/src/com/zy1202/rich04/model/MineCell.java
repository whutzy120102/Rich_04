package com.zy1202.rich04.model;

import com.zy1202.rich04.bo.IMineCellBO;

public class MineCell extends Cell implements IMineCellBO{
	private int point;
	public MineCell(String type,int point) {
		super(type);
		this.point=point;
		this.setName("矿地");
		// TODO Auto-generated constructor stub
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

}
