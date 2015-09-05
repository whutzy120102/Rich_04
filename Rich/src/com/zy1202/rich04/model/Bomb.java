package com.zy1202.rich04.model;

import com.zy1202.rich04.manager.GameManager;

public class Bomb extends Prop{

	public Bomb() {
		super();
		this.setName("炸弹");
		this.setIntroduce("可放置在前后10格，走到格子上时被扎伤送医院休息三个回合");
		this.setPoint(50);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void useProp(int location) {
		// TODO Auto-generated method stub
		GameManager.getMap().get(location).getCell().addBomb();
	}

}
