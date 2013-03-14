package com.basic.table.model;

import java.util.List;

import com.global.App;
import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.record.impl.ODocument;

public class UsrTMforGrp extends UsrTM {

	public UsrTMforGrp(ODatabaseDocumentTx db) {
		super(db);
	}

	
	

	@Override
	public void initDao() {
		dao = App.getUsrDao();
	}





	@Override
	public void setModels(List model) {
		this.model=model;
		fireTableDataChanged();
	}



	@Override
	public void loadJumlahData(ODatabaseDocumentTx db) {
		if (paging != null) {
			paging.getPanelPaging().setVisible(false);
		}
		
	}



	

}
