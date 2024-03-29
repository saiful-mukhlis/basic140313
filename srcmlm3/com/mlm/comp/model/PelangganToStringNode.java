package com.mlm.comp.model;

import org.basic.comp.listener.ODocumentToStringNodeInterface;
import org.jdesktop.swingx.treetable.MutableTreeTableNode;
import org.jdesktop.swingx.treetable.TreeTableNode;

import com.global.App;
import com.mlm.db.Pelanggan;
import com.mlm.db.Pp;
import com.orientechnologies.orient.core.record.impl.ODocument;

public class PelangganToStringNode implements ODocumentToStringNodeInterface {

	private ODocument o;
	private MutableTreeTableNode node;
	private boolean isPaket=false;

	public PelangganToStringNode(ODocument o, MutableTreeTableNode node) {
		super();
		this.o = o;
		this.node=node;
	}
	
	public PelangganToStringNode(ODocument o, MutableTreeTableNode node, boolean paket) {
		super();
		this.o = o;
		this.node=node;
		isPaket=paket;
	}

	@Override
	public ODocument getO() {
		return o;
	}

	public void setO(ODocument o) {
		this.o = o;
	}

	@Override
	public String toString() {
		if (o.field("@class").equals(Pelanggan.TABLE)) {
			return App.getPelangganDao().getNamaToko(o)+" ("+node.getChildCount()+")";
		}else if (o.field("@class").equals(Pp.TABLE)) {
			if (isPaket) {
				return App.getPpDao().paketToString(null, o)+" ("+node.getChildCount()+")";
			}else{
				return App.getPpDao().pelangganToString(null, o)+" ("+node.getChildCount()+")";
			}
		}
		return "";
	}

	public MutableTreeTableNode getNode() {
		return node;
	}

	public void setNode(MutableTreeTableNode node) {
		this.node = node;
	}
	
	
	

}
