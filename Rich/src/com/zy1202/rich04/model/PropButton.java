package com.zy1202.rich04.model;

import javax.swing.JButton;

public class PropButton extends JButton{
	private Prop prop;

	public PropButton(Prop prop) {
		super();
		this.prop = prop;
	}

	public Prop getProp() {
		return prop;
	}

	public void setProp(Prop prop) {
		this.prop = prop;
	}
	
	
}
