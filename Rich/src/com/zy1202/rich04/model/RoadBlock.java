package com.zy1202.rich04.model;

import com.zy1202.rich04.manager.GameManager;

public class RoadBlock extends Prop{

	public RoadBlock() {
		super();
		this.setName("路障");
		this.setIntroduce("可在前后10格设置路障，经过的玩家被迫停止在该格");
		this.setPoint(500);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void useProp(int location) {
		// TODO Auto-generated method stub
		GameManager.getMap().get(location).getCell().addRoadBlock();
	}

}
