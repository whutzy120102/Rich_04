package com.zy1202.rich04.model;

import com.zy1202.rich04.manager.GameManager;

public class RoadBlock extends Prop{

	public RoadBlock(String name, String introduce) {
		super(name, introduce);
		// TODO Auto-generated constructor stub
	}



	@Override
	public void useProp(int location) {
		// TODO Auto-generated method stub
		GameManager.getMap().get(location).addRoadBlock();
	}

}
