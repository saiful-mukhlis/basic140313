package org.basic.comp.abst;

import javax.swing.JPanel;

import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;

public class DetailAbs implements Detail {
	protected JPanel panel;

	@Override
	public void init() {

	}

	@Override
	public void build(ODatabaseDocumentTx db) {

	}
	
	@Override
	public void actionReset() {
		
	}

	@Override
	public JPanel getPanel() {
		return panel;
	}

	@Override
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

}
