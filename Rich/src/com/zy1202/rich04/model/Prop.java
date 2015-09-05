package com.zy1202.rich04.model;

import com.zy1202.rich04.bo.IPropBo;

public abstract class Prop implements IPropBo{
	private String name;
	private String introduce;
	private int point;
	
	
	public Prop() {
		super();
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
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name=name;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void setIntroduce(String Introduce) {
		// TODO Auto-generated method stub
		this.introduce=introduce;
	}

	@Override
	public String getIntroduce() {
		// TODO Auto-generated method stub
		return introduce;
	}

	

	public abstract void useProp(int location);
}
