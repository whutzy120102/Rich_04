package com.zy1202.rich04.view;

import com.zy1202.rich04.model.Cell;

public class CellView {
	
	private int id;
	private int x;
	private int y;
	private Cell cell=null;
	
	public CellView(){
	}
	public CellView(int id,int x,int y,Cell cell){
		this.x=x;
		this.id=id;
		this.y=y;
		this.cell=cell;
	}

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
	
	public Cell getCell(){
		return this.cell;
	}
	
}
