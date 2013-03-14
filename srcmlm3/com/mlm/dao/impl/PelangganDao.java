package com.mlm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.basic.comp.base.TextArea;
import org.basic.comp.base.TextField;
import org.basic.comp.model.ODocumentToString;
import org.basic.dao.abst.DaoAbstract;

import com.basic.dao.impl.GrpDao;
import com.basic.db.Grp;
import com.basic.db.Usr;
import com.basic.lang.LPelanggan;
import com.global.App;
import com.mlm.db.Paket;
import com.mlm.db.Pelanggan;
import com.mlm.db.Pp;
import com.mlm.db.StatusPelanggan;
import com.orientechnologies.orient.core.db.ODatabaseRecordThreadLocal;
import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.id.ORecordId;
import com.orientechnologies.orient.core.metadata.schema.OType;
import com.orientechnologies.orient.core.record.impl.ODocument;

public class PelangganDao extends DaoAbstract {

	public PelangganDao() {
		super(Pelanggan.TABLE);
	}

	public PelangganDao setCode(ODocument o, String code) {
		o.field(Pelanggan.CODE, code);
		return this;
	}

	public PelangganDao setCode(ODocument o, TextField code) {
		setCode(o, code.getText());
		return this;
	}

	public String getCode(ODocument o) {
		String tmp = o.field(Pelanggan.CODE);
		if (tmp == null) {
			tmp = "";
		}
		return tmp;
	}

	public boolean vCode(ODatabaseDocumentTx db, TextField code) {
		if (!(code.getText().trim().equals("") || code.getText().trim()
				.equalsIgnoreCase("Auto"))) {
			long tmp = getCountByColumn(db, Pelanggan.CODE, code.getText());
			if (tmp > 0) {
				App.showErrorDataSudahAda(db, LPelanggan.CODE);
				return false;
			}
		}
		return true;
	}

	public boolean vCode(ODatabaseDocumentTx db, TextField code, ODocument model) {
		if (!code.getText().equalsIgnoreCase(
				(String) model.field(Pelanggan.CODE))) {
			long tmp = getCountByColumn(db, Pelanggan.CODE, code.getText());
			if (tmp > 0) {
				App.showErrorDataSudahAda(db, LPelanggan.CODE);
				return false;
			}
			if (code.getText().trim().equals("")) {
				App.showErrorFieldEmpty(db, LPelanggan.CODE);
				return false;
			}
		}
		return true;
	}

	public PelangganDao setNamaToko(ODocument o, String namaToko) {
		o.field(Pelanggan.NAMA_TOKO, namaToko);
		return this;
	}

	public PelangganDao setNamaToko(ODocument o, TextField namaToko) {
		setNamaToko(o, namaToko.getText());
		return this;
	}

	public String getNamaToko(ODocument o) {
		String tmp = o.field(Pelanggan.NAMA_TOKO);
		if (tmp == null) {
			tmp = "";
		}
		return tmp;
	}

	public boolean vNamaToko(ODatabaseDocumentTx db, TextField namaToko) {
		if (!validate(db, namaToko, LPelanggan.NAMA_TOKO)) {
			return false;
		}
		return true;
	}

	public boolean vNamaToko(ODatabaseDocumentTx db, TextField namaToko,
			ODocument model) {
		if (!validate(db, namaToko, LPelanggan.NAMA_TOKO)) {
			return false;
		}
		return true;
	}

	public PelangganDao setNamaPemilik(ODocument o, String namaPemilik) {
		o.field(Pelanggan.NAMA_PEMILIK, namaPemilik);
		return this;
	}

	public PelangganDao setNamaPemilik(ODocument o, TextField namaPemilik) {
		setNamaPemilik(o, namaPemilik.getText());
		return this;
	}

	public String getNamaPemilik(ODocument o) {
		String tmp = o.field(Pelanggan.NAMA_PEMILIK);
		if (tmp == null) {
			tmp = "";
		}
		return tmp;
	}

	public boolean vNamaPemilik(ODatabaseDocumentTx db, TextField namaPemilik) {
		if (!validate(db, namaPemilik, LPelanggan.NAMA_PEMILIK)) {
			return false;
		}
		return true;
	}
	
	

	public boolean vNamaPemilik(ODatabaseDocumentTx db, TextField namaPemilik,
			ODocument model) {
		if (!validate(db, namaPemilik, LPelanggan.NAMA_PEMILIK)) {
			return false;
		}
		return true;
	}

	
	public PelangganDao setJenisIdentitas(ODocument o, String jenisIdentitas) {
		o.field(Pelanggan.JENIS_IDENTITAS, jenisIdentitas);
		return this;
	}

	public PelangganDao setJenisIdentitas(ODocument o, TextField jenisIdentitas) {
		setJenisIdentitas(o, jenisIdentitas.getText());
		return this;
	}

	public String getJenisIdentitas(ODocument o) {
		String tmp = o.field(Pelanggan.JENIS_IDENTITAS);
		if (tmp == null) {
			tmp = "";
		}
		return tmp;
	}

	public boolean vJenisIdentitas(ODatabaseDocumentTx db, TextField jenisIdentitas) {
		if (!validate(db, jenisIdentitas, LPelanggan.JENIS_IDENTITAS)) {
			return false;
		}
		return true;
	}

	public boolean vJenisIdentitas(ODatabaseDocumentTx db, TextField jenisIdentitas,
			ODocument model) {
		if (!validate(db, jenisIdentitas, LPelanggan.JENIS_IDENTITAS)) {
			return false;
		}
		return true;
	}
	public PelangganDao setNoIdentitas(ODocument o, String noIdentitas) {
		o.field(Pelanggan.NO_IDENTITAS, noIdentitas);
		return this;
	}

	public PelangganDao setNoIdentitas(ODocument o, TextField noIdentitas) {
		setNoIdentitas(o, noIdentitas.getText());
		return this;
	}

	public String getNoIdentitas(ODocument o) {
		String tmp = o.field(Pelanggan.NO_IDENTITAS);
		if (tmp == null) {
			tmp = "";
		}
		return tmp;
	}

	public boolean vNoIdentitas(ODatabaseDocumentTx db, TextField noIdentitas) {
		if (!validate(db, noIdentitas, LPelanggan.NO_IDENTITAS)) {
			return false;
		}
		return true;
	}

	public boolean vNoIdentitas(ODatabaseDocumentTx db, TextField noIdentitas,
			ODocument model) {
		if (!validate(db, noIdentitas, LPelanggan.NO_IDENTITAS)) {
			return false;
		}
		return true;
	}
	public PelangganDao setAlamat(ODocument o, String alamat) {
		o.field(Pelanggan.ALAMAT, alamat);
		return this;
	}

	public PelangganDao setAlamat(ODocument o, TextArea alamat) {
		setAlamat(o, alamat.getText());
		return this;
	}

	public String getAlamat(ODocument o) {
		String tmp = o.field(Pelanggan.ALAMAT);
		if (tmp == null) {
			tmp = "";
		}
		return tmp;
	}

	public boolean vAlamat(ODatabaseDocumentTx db, TextField alamat) {
		if (!validate(db, alamat, LPelanggan.ALAMAT)) {
			return false;
		}
		return true;
	}

	public boolean vAlamat(ODatabaseDocumentTx db, TextField alamat,
			ODocument model) {
		if (!validate(db, alamat, LPelanggan.ALAMAT)) {
			return false;
		}
		return true;
	}

	public PelangganDao setKota(ODocument o, String kota) {
		o.field(Pelanggan.KOTA, kota);
		return this;
	}

	public PelangganDao setKota(ODocument o, TextField kota) {
		setKota(o, kota.getText());
		return this;
	}

	public String getKota(ODocument o) {
		String tmp = o.field(Pelanggan.KOTA);
		if (tmp == null) {
			tmp = "";
		}
		return tmp;
	}

	public boolean vKota(ODatabaseDocumentTx db, TextField kota) {
		if (!validate(db, kota, LPelanggan.KOTA)) {
			return false;
		}
		return true;
	}

	public boolean vKota(ODatabaseDocumentTx db, TextField kota, ODocument model) {
		if (!validate(db, kota, LPelanggan.KOTA)) {
			return false;
		}
		return true;
	}

	public PelangganDao setNoTelp(ODocument o, String noTelp) {
		o.field(Pelanggan.NO_TELP, noTelp);
		return this;
	}

	public PelangganDao setNoTelp(ODocument o, TextField noTelp) {
		setNoTelp(o, noTelp.getText());
		return this;
	}

	public String getNoTelp(ODocument o) {
		String tmp = o.field(Pelanggan.NO_TELP);
		if (tmp == null) {
			tmp = "";
		}
		return tmp;
	}

	public boolean vNoTelp(ODatabaseDocumentTx db, TextField noTelp) {
		if (!validate(db, noTelp, LPelanggan.NO_TELP)) {
			return false;
		}
		return true;
	}

	public boolean vNoTelp(ODatabaseDocumentTx db, TextField noTelp,
			ODocument model) {
		if (!validate(db, noTelp, LPelanggan.NO_TELP)) {
			return false;
		}
		return true;
	}

	public PelangganDao setNoFax(ODocument o, String noFax) {
		o.field(Pelanggan.NO_FAX, noFax);
		return this;
	}

	public PelangganDao setNoFax(ODocument o, TextField noFax) {
		setNoFax(o, noFax.getText());
		return this;
	}

	public String getNoFax(ODocument o) {
		String tmp = o.field(Pelanggan.NO_FAX);
		if (tmp == null) {
			tmp = "";
		}
		return tmp;
	}

	public boolean vNoFax(ODatabaseDocumentTx db, TextField noFax) {
		if (!validate(db, noFax, LPelanggan.NO_FAX)) {
			return false;
		}
		return true;
	}

	public boolean vNoFax(ODatabaseDocumentTx db, TextField noFax,
			ODocument model) {
		if (!validate(db, noFax, LPelanggan.NO_FAX)) {
			return false;
		}
		return true;
	}

	public PelangganDao setNoHp1(ODocument o, String noHp1) {
		o.field(Pelanggan.NO_HP1, noHp1);
		return this;
	}

	public PelangganDao setNoHp1(ODocument o, TextField noHp1) {
		setNoHp1(o, noHp1.getText());
		return this;
	}

	public String getNoHp1(ODocument o) {
		String tmp = o.field(Pelanggan.NO_HP1);
		if (tmp == null) {
			tmp = "";
		}
		return tmp;
	}

	public boolean vNoHp1(ODatabaseDocumentTx db, TextField noHp1) {
		if (!validate(db, noHp1, LPelanggan.NO_HP1)) {
			return false;
		}
		return true;
	}

	public boolean vNoHp1(ODatabaseDocumentTx db, TextField noHp1,
			ODocument model) {
		if (!validate(db, noHp1, LPelanggan.NO_HP1)) {
			return false;
		}
		return true;
	}

	public PelangganDao setNoHp2(ODocument o, String noHp2) {
		o.field(Pelanggan.NO_HP2, noHp2);
		return this;
	}

	public PelangganDao setNoHp2(ODocument o, TextField noHp2) {
		setNoHp2(o, noHp2.getText());
		return this;
	}

	public String getNoHp2(ODocument o) {
		String tmp = o.field(Pelanggan.NO_HP2);
		if (tmp == null) {
			tmp = "";
		}
		return tmp;
	}

	public boolean vNoHp2(ODatabaseDocumentTx db, TextField noHp2) {
		if (!validate(db, noHp2, LPelanggan.NO_HP2)) {
			return false;
		}
		return true;
	}

	public boolean vNoHp2(ODatabaseDocumentTx db, TextField noHp2,
			ODocument model) {
		if (!validate(db, noHp2, LPelanggan.NO_HP2)) {
			return false;
		}
		return true;
	}

	public PelangganDao setPinBb1(ODocument o, String pinBb1) {
		o.field(Pelanggan.PIN_BB1, pinBb1);
		return this;
	}

	public PelangganDao setPinBb1(ODocument o, TextField pinBb1) {
		setPinBb1(o, pinBb1.getText());
		return this;
	}

	public String getPinBb1(ODocument o) {
		String tmp = o.field(Pelanggan.PIN_BB1);
		if (tmp == null) {
			tmp = "";
		}
		return tmp;
	}

	public boolean vPinBb1(ODatabaseDocumentTx db, TextField pinBb1) {
		if (!validate(db, pinBb1, LPelanggan.PIN_BB1)) {
			return false;
		}
		return true;
	}

	public boolean vPinBb1(ODatabaseDocumentTx db, TextField pinBb1,
			ODocument model) {
		if (!validate(db, pinBb1, LPelanggan.PIN_BB1)) {
			return false;
		}
		return true;
	}

	public PelangganDao setPinBb2(ODocument o, String pinBb2) {
		o.field(Pelanggan.PIN_BB2, pinBb2);
		return this;
	}

	public PelangganDao setPinBb2(ODocument o, TextField pinBb2) {
		setPinBb2(o, pinBb2.getText());
		return this;
	}

	public String getPinBb2(ODocument o) {
		String tmp = o.field(Pelanggan.PIN_BB2);
		if (tmp == null) {
			tmp = "";
		}
		return tmp;
	}

	public boolean vPinBb2(ODatabaseDocumentTx db, TextField pinBb2) {
		if (!validate(db, pinBb2, LPelanggan.PIN_BB2)) {
			return false;
		}
		return true;
	}

	public boolean vPinBb2(ODatabaseDocumentTx db, TextField pinBb2,
			ODocument model) {
		if (!validate(db, pinBb2, LPelanggan.PIN_BB2)) {
			return false;
		}
		return true;
	}

	public PelangganDao setStatus(ODocument o, ODocument status) {
		o.field(Pelanggan.STATUS, status, OType.LINK);
		return this;
	}

	public String statusToString(ODatabaseDocumentTx db,ODocument model) {
		return App.getStatusPelangganDao().getNama(getStatus(db, model));
	}

	
	public ODocument getStatus(ODatabaseDocumentTx db,ODocument o) {
		if (o.isLazyLoad()) {
			return o.field(Pelanggan.STATUS);
		}else{
			ORecordId id=o.field(Pelanggan.STATUS);
			if (id!=null) {
				if (db==null) {
					db = App.getDbd();
					ODatabaseRecordThreadLocal.INSTANCE.set(db);
					ODocument tmp= getOneByRid(db, id.toString());
					db.close();
					return tmp;
				}
				ODocument tmp= getOneByRid(db, id.toString());
				return tmp;
			}
			return null;
		}
	}
	
	public List<ODocument> getPakets(ODatabaseDocumentTx db,ODocument o){
		List<ODocument> tmp=o.field(Pelanggan.PAKETS);
		if (tmp==null) {
			tmp=new ArrayList<>();
		}
		return tmp;
	}

	public PelangganDao setPakets(ODocument o, List<ODocument> pakets){
		o.field(Pelanggan.PAKETS, pakets, OType.LINKLIST);
		return this;
	}


	public PelangganDao setLogdb(ODocument o, int status) {
		o.field(Pelanggan.STATUS, status, OType.INTEGER);
		return this;
	}

	@Override
	public void afterDelete(ODatabaseDocumentTx db, ODocument o) {
		// App.getPiutangDao().delNull(db);
		super.afterDelete(db, o);
	}

	@Override
	public boolean beforeDelete(ODatabaseDocumentTx db, ODocument o) {
		List<ODocument> pps=getPakets(db, o);
		for (ODocument opp : pps) {
			App.getPpDao().beforeDelete(db, opp);
			opp.delete();
		}
		
		// bila menghapus pelanggan maka harus menghapus downlines,
		// di sini downines tidak banyak(tidak semua)
		// yang banyak adalah mengurangi jumlah downline
		
		//ternyata aq salah , downline adalah jumlah max
		
//		List<ODocument> paket=getPakets(db, o);
//		for (ODocument p : paket) {
//			int tmp=App.getPaketDao().getDownline(p);
//			if (tmp>0) {
//				tmp--;
//				App.getPaketDao().setDownline(p, tmp);
//				App.getPaketDao().update(db, p);
//			}
//			
//		}
		// ternyata ini punyaknya ppdao
		//command(db, "update "+Paket.TABLE+" remove "+Paket.DOWNLINES+" = "+o.getIdentity());
		// piutang & penjualan
		// piutang harus nol
		// boolean boleh=true;
		// List<ODocument> piutangs = App.getPiutangDao().getAllByColumn(db,
		// PiutangDao.pelanggan, o.getIdentity());
		// for (ODocument oDocument : piutangs) {
		// double sisa=oDocument.field(PiutangDao.total);
		// if (sisa>0) {
		// boleh=false;
		// App.showPelangganTidakDapatDiHapus();
		// }
		//
		// }
		// if(boleh){
		// for (ODocument oDocument : piutangs) {
		// App.getPiutangDao().setNull(db, oDocument);
		// }
		// List<ODocument> penjualans = App.getPenjualanDao().getAllByColumn(db,
		// PenjualanDao.pelanggan, o.getIdentity());
		// for (ODocument oDocument : penjualans) {
		// App.getPenjualanDao().setNull(db, oDocument);
		// }
		// return super.beforeDelete(db, o);
		// }else{
		// return false;
		// }

		return true;

	}

	
	public ODocumentToString[] getStatusData(ODatabaseDocumentTx db) {
		StatusPelangganDao statusPelangganDao = App.getStatusPelangganDao();
		List<ODocument> grps = statusPelangganDao.getAllAsc(db, StatusPelanggan.NAMA);
		ODocumentToString[] modelStatuss = new ODocumentToString[grps.size() + 1];
		modelStatuss[0] = new ODocumentToString(statusPelangganDao,
				App.getT("Pilih Status"));
		int i = 1;
		for (ODocument oDocument : grps) {
			modelStatuss[i] = new ODocumentToString(statusPelangganDao, oDocument);
			i++;
		}
		return modelStatuss;
	}

	@Override
	public String getNameFielsToString() {
		return Pelanggan.NAMA_TOKO;
	}


	
	
}
