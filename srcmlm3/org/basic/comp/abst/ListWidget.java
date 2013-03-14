package org.basic.comp.abst;

import javax.swing.JPanel;

public interface ListWidget {

	public abstract JPanel getPanel();

	public abstract void setPanel(JPanel panel);

}