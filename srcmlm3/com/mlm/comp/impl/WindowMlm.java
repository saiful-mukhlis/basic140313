package com.mlm.comp.impl;

import org.basic.comp.abst.WindowAbs;

public class WindowMlm extends WindowAbs{

	@Override
	public void init() {
		super.init();
		
		toolbar=new ToolbarMlm();
		menu=new MenuMlm();
	}

}
