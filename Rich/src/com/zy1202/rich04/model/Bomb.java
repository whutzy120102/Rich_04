package com.zy1202.rich04.model;

import com.zy1202.rich04.manager.GameManager;

public class Bomb extends Prop{

	public Bomb(String name, String introduce) {
		super(name, introduce);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void useProp(int location) {
		// TODO Auto-generated method stub
		GameManager.getMap().get(location).addBomb();
	}

}
