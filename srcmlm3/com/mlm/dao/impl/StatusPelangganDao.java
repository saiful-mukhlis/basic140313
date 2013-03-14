package com.mlm.dao.impl;

import org.basic.comp.base.TextField;
import org.basic.dao.abst.DaoAbstract;

import com.global.App;
import com.mlm.db.StatusPelanggan;
import com.mlm.lang.LStatusPelanggan;
import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.record.impl.ODocument;



public class StatusPelangganDao extends DaoAbstract {

	public StatusPelangganDao() {
		super(StatusPelanggan.TABLE);
	}

	public String getCode(ODocument o){
		String tmp=o.field(StatusPelanggan.CODE);
		if (tmp==null) {
			tmp="";
		}
		return tmp;
	}
	
	public String getNama(ODocument o){
		if (o==null) {
			return "";
		}
		String tmp=o.field(StatusPelanggan.NAMA);
		if (tmp==null) {
			tmp="";
		}
		return tmp;
	}
	
	public boolean vCode(ODatabaseDocumentTx db, TextField code){
		if (!(code.getText().trim().equals("") || code.getText().trim().equalsIgnoreCase("Auto"))) {
			long tmp=getCountByColumn(db, StatusPelanggan.CODE, code.getText());
			if (tmp>0) {
				App.showErrorDataSudahAda(db, LStatusPelanggan.CODE);
				return false;
			}
		}
		return true;
	}
	
	public boolean vCode(ODatabaseDocumentTx db, TextField code, ODocument model){
		if (!code.getText().equalsIgnoreCase((String) model.field(StatusPelanggan.CODE))) {
			long tmp=getCountByColumn(db, StatusPelanggan.CODE, code.getText());
			if (tmp>0) {
				App.showErrorDataSudahAda(db, LStatusPelanggan.CODE);
				return false;
			}
			if (code.getText().trim().equals("")) {
				App.showErrorFieldEmpty(db, LStatusPelanggan.CODE);
				return false;
			}
		}
		return true;
	}
	
	public boolean vNama(ODatabaseDocumentTx db, TextField nama){
		if (!validate(db, nama, LStatusPelanggan.NAMA)) {
			return false;
		}
		return true;
	}
	
	public boolean vNama(ODatabaseDocumentTx db, TextField nama, ODocument model){
		if (!validate(db, nama, LStatusPelanggan.NAMA)) {
			return false;
		}
		return true;
	}

	public StatusPelangganDao setCode(ODocument o, String code){
		o.field(StatusPelanggan.CODE, code);
		return this;
	}
	
	public StatusPelangganDao setCode(ODocument o, TextField code){
		setCode(o, code.getText());
		return this;
	}
	
	public StatusPelangganDao setNama(ODocument o, String nama){
		o.field(StatusPelanggan.NAMA, nama);
		return this;
	}
	
	public StatusPelangganDao setNama(ODocument o, TextField nama){
		setNama(o, nama.getText());
		return this;
	}
	
//	public StatusPelangganDao setCode(ODocument o, String code){
//		o.field(StatusPelanggan.CODE, code);
//		return this;
//	}
//	
//	public StatusPelangganDao setNama(ODocument o, String nama){
//		o.field(StatusPelanggan.NAMA, nama);
//		return this;
//	}
	
	public void createFirst(ODatabaseDocumentTx db){
		ODocument o=new ODocument(getClassName());
		setNama(o, "Aktiv");
		save(db, o);
		
		o=new ODocument(getClassName());
		setNama(o, "Aktiv Hot");
		save(db, o);
		
		o=new ODocument(getClassName());
		setNama(o, "Active Cool");
		save(db, o);
		
		o=new ODocument(getClassName());
		setNama(o, "Active Warm");
		save(db, o);
		
		o=new ODocument(getClassName());
		setNama(o, "New");
		save(db, o);
		
		o=new ODocument(getClassName());
		setNama(o, "Old");
		save(db, o);
		
	}
	
	
	@Override
	public String getNameFielsToString() {
		return StatusPelanggan.NAMA;
	}
	
}

