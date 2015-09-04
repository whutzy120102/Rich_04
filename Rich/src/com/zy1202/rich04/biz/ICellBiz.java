package com.zy1202.rich04.biz;

public interface ICellBiz {
	boolean hasBomb();
	void addBomb();
	void reduceBomb();
	void moveAllBomb();
	boolean hasRoadBlock();
	void addRoadBlock();
	void moveAllRoadBlock();
	void reduceRoadBlock();
}
