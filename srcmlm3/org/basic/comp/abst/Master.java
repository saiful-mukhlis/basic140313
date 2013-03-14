package org.basic.comp.abst;

import javax.swing.JPanel;

import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;

public interface Master {

	void init();

	void build(ODatabaseDocumentTx db);

	JPanel getPanel();

	void setPanel(JPanel panel);

	AddDialog getAddDialog();

	void setAddDialog(AddDialog addDialog);

	ListWidget getListWidget();

	void setListWidget(ListWidget listWidget);

	EditDialog getEditDialog();

	void setEditDialog(EditDialog editDialog);

	Detail getDetail();

	void setDetail(Detail detail);

	ToolbarSmall getToolbarSmall();

	void setToolbarSmall(ToolbarSmall toolbarSmall);

	int getDevide();

	void setDevide(int devide);

	double getLebar();

	void setLebar(double lebar);

	Window getWindow();

	void setWindow(Window window);

	void requestDefaultSelected();

}