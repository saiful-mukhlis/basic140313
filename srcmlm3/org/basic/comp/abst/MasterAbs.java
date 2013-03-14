package org.basic.comp.abst;

import javax.swing.JPanel;

import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;

public class MasterAbs implements Master {
	protected JPanel panel;
	protected AddDialog addDialog;
	protected ListWidget listWidget;
	protected EditDialog editDialog;
	protected Detail detail;
	protected ToolbarSmall toolbarSmall;
	protected int devide;
	protected double lebar;
	protected Window window;
	

	public Window getWindow() {
		return window;
	}

	public void setWindow(Window window) {
		this.window = window;
	}

	@Override
	public void init() {

	}

	@Override
	public void build(ODatabaseDocumentTx db) {

	}

	@Override
	public JPanel getPanel() {
		return panel;
	}

	@Override
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	@Override
	public AddDialog getAddDialog() {
		return addDialog;
	}

	@Override
	public void setAddDialog(AddDialog addDialog) {
		this.addDialog = addDialog;
	}

	@Override
	public ListWidget getListWidget() {
		return listWidget;
	}

	@Override
	public void setListWidget(ListWidget listWidget) {
		this.listWidget = listWidget;
	}

	@Override
	public EditDialog getEditDialog() {
		return editDialog;
	}

	@Override
	public void setEditDialog(EditDialog editDialog) {
		this.editDialog = editDialog;
	}

	@Override
	public Detail getDetail() {
		return detail;
	}

	@Override
	public void setDetail(Detail detail) {
		this.detail = detail;
	}

	@Override
	public ToolbarSmall getToolbarSmall() {
		return toolbarSmall;
	}

	@Override
	public void setToolbarSmall(ToolbarSmall toolbarSmall) {
		this.toolbarSmall = toolbarSmall;
	}

	@Override
	public int getDevide() {
		return devide;
	}

	@Override
	public void setDevide(int devide) {
		this.devide = devide;
	}

	@Override
	public double getLebar() {
		return lebar;
	}

	@Override
	public void setLebar(double lebar) {
		this.lebar = lebar;
	}
	
	

}
