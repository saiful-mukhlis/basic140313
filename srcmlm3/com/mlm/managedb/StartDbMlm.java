package com.mlm.managedb;

import com.basic.db.Agama;
import com.basic.db.Bos;
import com.basic.db.Grp;
import com.basic.db.JenisPekerjaan;
import com.basic.db.LogdbGrp;
import com.basic.db.LogdbUsr;
import com.basic.db.NumberId;
import com.basic.db.Usr;
import com.global.App;
import com.mlm.db.Paket;
import com.mlm.db.Pelanggan;
import com.mlm.db.Pp;
import com.mlm.db.StatusPelanggan;
import com.orientechnologies.orient.core.db.ODatabaseRecordThreadLocal;
import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.metadata.schema.OClass;
import com.orientechnologies.orient.core.metadata.schema.OType;
import com.orientechnologies.orient.object.db.OObjectDatabaseTx;

public class StartDbMlm {

	/**
	 * membuat schema,index dan relasi pada database di jalankan setelah
	 * database di buat, jadi hanya sekali saja
	 */
	public void createSchemaDb() {
		OObjectDatabaseTx db = App.getDb();

		OClass agama = db.getMetadata().getSchema().getClass(Agama.TABLE);
		OClass bos = db.getMetadata().getSchema().getClass(Bos.TABLE);
		OClass jenisPekerjaan = db.getMetadata().getSchema()
				.getClass(JenisPekerjaan.TABLE);
		OClass numberId = db.getMetadata().getSchema().getClass(NumberId.TABLE);

		OClass grp = db.getMetadata().getSchema().getClass(Grp.TABLE);
		OClass logdbUsr = db.getMetadata().getSchema().getClass(LogdbUsr.TABLE);
		OClass logdbGrp = db.getMetadata().getSchema().getClass(LogdbGrp.TABLE);
		OClass usr = db.getMetadata().getSchema().getClass(Usr.TABLE);
		OClass paket = db.getMetadata().getSchema().getClass(Paket.TABLE);
		OClass pelanggan = db.getMetadata().getSchema()
				.getClass(Pelanggan.TABLE);
		OClass pp = db.getMetadata().getSchema()
				.getClass(Pp.TABLE);
		OClass statusPelanggan = db.getMetadata().getSchema()
				.getClass(StatusPelanggan.TABLE);

		// tabel Agama
		agama.createProperty(Agama.CODE, OType.STRING).createIndex(
				OClass.INDEX_TYPE.UNIQUE);
		agama.createProperty(Agama.NAMA, OType.STRING).createIndex(
				OClass.INDEX_TYPE.UNIQUE);

		// table Jenis Pekerjaan
		jenisPekerjaan.createProperty(JenisPekerjaan.CODE, OType.STRING)
				.createIndex(OClass.INDEX_TYPE.UNIQUE);
		jenisPekerjaan.createProperty(JenisPekerjaan.NAMA, OType.STRING)
				.createIndex(OClass.INDEX_TYPE.UNIQUE);
		// tabel NumberId
		numberId.createProperty(NumberId.NAMA_TABLE, OType.STRING).createIndex(
				OClass.INDEX_TYPE.UNIQUE);

		// table Grp
		grp.createProperty(Grp.CODE, OType.STRING).createIndex(
				OClass.INDEX_TYPE.UNIQUE);
		grp.createProperty(Grp.NAME, OType.STRING).createIndex(
				OClass.INDEX_TYPE.UNIQUE);
		grp.createProperty(Grp.USRS, OType.LINKLIST);
		grp.createProperty(Grp.CREATE_BY, OType.LINK, usr);
		grp.createProperty(Grp.UPDATE_BY, OType.LINK, usr);

		logdbUsr.createProperty(LogdbUsr.USR, OType.LINK, usr);

		logdbGrp.createProperty(LogdbGrp.USR, OType.LINK, usr);

		// tabel Usr
		usr.createProperty(Usr.USERNAME, OType.STRING).createIndex(
				OClass.INDEX_TYPE.UNIQUE);
		usr.createProperty(Usr.CODE, OType.STRING).createIndex(
				OClass.INDEX_TYPE.UNIQUE);
		usr.createProperty(Usr.GRP, OType.LINK, grp);
		usr.createProperty(Usr.CREATE_BY, OType.LINK, usr);
		usr.createProperty(Usr.UPDATE_BY, OType.LINK, usr);

		// tabel Paket
		paket.createProperty(Paket.CODE, OType.STRING).createIndex(
				OClass.INDEX_TYPE.UNIQUE);
		paket.createProperty(Paket.NAMA, OType.STRING).createIndex(
				OClass.INDEX_TYPE.UNIQUE);
		paket.createProperty(Paket.DOWNLINES, OType.LINKLIST, pelanggan);

		// tabel Pelanggan
		pelanggan.createProperty(Pelanggan.CODE, OType.STRING).createIndex(
				OClass.INDEX_TYPE.UNIQUE);
		pelanggan.createProperty(Pelanggan.NAMA_TOKO, OType.STRING)
				.createIndex(OClass.INDEX_TYPE.UNIQUE);
		pelanggan.createProperty(Pelanggan.STATUS, OType.LINK, statusPelanggan);
		pelanggan.createProperty(Pelanggan.PAKETS, OType.LINKLIST, pp);
		
		// tabel Pp
				pp.createProperty(Pp.CODE, OType.STRING).createIndex(
						OClass.INDEX_TYPE.UNIQUE);
				pp.createProperty(Pp.PELANGGAN, OType.LINK, pelanggan);
				pp.createProperty(Pp.UP_LINE, OType.LINK, pp);
				pp.createProperty(Pp.PAKET, OType.LINK, paket);
				pp.createProperty(Pp.DOWNLINES, OType.LINKLIST, pp);

		// tabel Status Pelanggan
		statusPelanggan.createProperty(StatusPelanggan.CODE, OType.STRING)
				.createIndex(OClass.INDEX_TYPE.UNIQUE);
		statusPelanggan.createProperty(StatusPelanggan.NAMA, OType.STRING)
				.createIndex(OClass.INDEX_TYPE.UNIQUE);

		db.getMetadata().getSchema().save();

		db.close();

		ODatabaseDocumentTx dbd = App.getDbd();
		ODatabaseRecordThreadLocal.INSTANCE.set(dbd);
		App.getUsrDao().factoryModelFirst(dbd);
		App.getGrpDao().factoryModelFirst(dbd);
		App.getJenisPekerjaanDao().createFirst(dbd);
		dbd.close();

	}

}
