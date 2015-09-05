package com.zy1202.rich04.view;

public class CellView {
	public CellView(){
	}
	public CellView(int id,int x,int y){
		this.x=x;
		this.id=id;
		this.y=y;
	}
	private int id;
	private int x;
	private int y;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
}
