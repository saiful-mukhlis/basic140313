package com.basic.print.adapter;

import java.awt.Window;
import java.util.Collection;

import javax.swing.JFrame;

import ar.com.fdvs.dj.domain.Style;
import ar.com.fdvs.dj.domain.entities.columns.AbstractColumn;

import com.basic.print.interfaces.PrintInterface;
import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;


public class PrintAdapter implements PrintInterface{

	@Override
	public void buildColSpan() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buildColumn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AbstractColumn buildColumn(String property, String title, int width) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractColumn buildColumn(String property, String title, int width,
			Style style, Style styleHeader, Collection styleCond) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ODatabaseDocumentTx db) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buildReport(ODatabaseDocumentTx db) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run(ODatabaseDocumentTx db) {}



	@Override
	public void initReportChild() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initStyles() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Window getWindow(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JFrame getFrame(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void runPrint(ODatabaseDocumentTx db) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void runPdf(ODatabaseDocumentTx db) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void runWord(ODatabaseDocumentTx db) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void runExcel(ODatabaseDocumentTx db) {
		// TODO Auto-generated method stub
		
	}}
