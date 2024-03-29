package com.basic.view.detail;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.basic.comp.impl.master.GrpM;
import com.basic.icon.IconBase;
import com.basic.view.def.GrpC;
import com.global.App;
import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.record.impl.ODocument;

public class GrpV extends GrpC {
	
	public void init(ODatabaseDocumentTx db) {
		super.init(db);
		title = GrpM.TITLE_VIEW;
		icon = IconBase.VIEW;
		initComponent(db);
		setColorView();
		setEditable(false);
		buildLabel(db);
		buildForm(db);
		buildPanel();
	}

//	public void load(ODocument model) {
//		if (model==null) {
//			resetContentComponent();
//		}else if (modelIsTrue(model)) {
//			setContentComponent(model);
//		}
//		
//	}
	
	
	public void buildPanel(){
		panel=new JPanel(new BorderLayout());
		panelForm = builder.getPanel();
		
		panelForm.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					if (master!=null) {
						if (master.isPerspectiveDefault()) {
							if (typeEfectWidget==WIDGET_1) {
								master.perspective1();
							}else if(typeEfectWidget==WIDGET_2){
								master.perspective2();
							}else if (typeEfectWidget==WIDGET_3) {
								master.perspective3();
							}else if (typeEfectWidget==WIDGET_4) {
								master.perspective4();
							}
						}else{
							master.perspectiveDefault();
						}
					}else{
						App.showErrSementara("Master null");
					}
				}
			}
			public void mouseReleased(MouseEvent e) {}
		});
		
		pane=new JScrollPane(panelForm);
//		pane.setBackground(Color.WHITE);
//		panel.setBackground(Color.WHITE);
//		panelForm.setBackground(Color.WHITE);
		
		
		pane.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		panel.add(pane, BorderLayout.CENTER);
		panel.add(label, BorderLayout.NORTH);
	}
	
	
}
