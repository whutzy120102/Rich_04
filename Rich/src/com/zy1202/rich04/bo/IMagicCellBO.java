package com.zy1202.rich04.bo;

import java.util.List;

import com.zy1202.rich04.model.Magic;

public interface IMagicCellBO {
	void setMagics(List<Magic> magics);
	List<Magic> getMagics();
}
