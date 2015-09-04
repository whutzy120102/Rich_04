package com.zy1202.rich04.model;

import com.zy1202.rich04.bo.IMagicBO;

public class Magic implements IMagicBO{
	
	public static final int TYPE_1=1;
	public static final int TYPE_2=2;
	
	private int id;
	private String name;
	private String introduce;
	
	
	public Magic(int id,String name, String introduce) {
		super();
		this.id=id;
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
