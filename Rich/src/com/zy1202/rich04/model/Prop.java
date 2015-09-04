package com.zy1202.rich04.model;

import com.zy1202.rich04.bo.IPropBo;

public abstract class Prop implements IPropBo{
	private String name;
	private String introduce;
	
	
	public Prop(String name, String introduce) {
		super();
		this.name = name;
		this.introduce = introduce;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setIntroduce(String Introduce) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getIntroduce() {
		// TODO Auto-generated method stub
		return null;
	}

	

	public abstract void useProp(int location);
}
