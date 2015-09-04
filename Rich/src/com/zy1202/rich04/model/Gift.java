package com.zy1202.rich04.model;

import com.zy1202.rich04.bo.IGiftBO;

public abstract class Gift implements IGiftBO{
	
	public final static int CASH=1;
	public final static int POINT=2;
	public final static int FREE=3;
	
	private int id;
	private String name;
	private String introduce;
		

	public Gift(String name, String introduce) {
		super();
		this.name = name;
		this.introduce = introduce;
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
	public void setIntroduce(String introduce) {
		// TODO Auto-generated method stub
		this.introduce=introduce;
	}

	@Override
	public String getIntroduce() {
		// TODO Auto-generated method stub
		return introduce;
	}

}
