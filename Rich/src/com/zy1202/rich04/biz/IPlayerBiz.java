package com.zy1202.rich04.biz;

public interface IPlayerBiz {
	boolean isFree();
	int addFree(int day);
	int reduceFree(int day);
	boolean isStop();
	int addStopDay(int day);
	int reduceStopDay(int day);
	int throwDice();
	void leaveGame();
}
