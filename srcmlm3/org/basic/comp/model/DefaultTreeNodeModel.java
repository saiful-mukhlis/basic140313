package org.basic.comp.model;

import org.basic.comp.listener.ODocumentToStringNodeInterface;
import org.jdesktop.swingx.treetable.DefaultMutableTreeTableNode;
import org.jdesktop.swingx.treetable.TreeTableNode;
import com.basic.db.Grp;
import com.global.App;
import com.orientechnologies.orient.core.db.ODatabaseRecordThreadLocal;
import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.record.impl.ODocument;

public class DefaultTreeNodeModel extends DefaultMutableTreeTableNode {

	protected ODocumentToStringNodeInterface documentToString;
	protected int columnCount = 1;

	public DefaultTreeNodeModel(ODocument userObject) {
		super(userObject);
	}

	@Override
	public int getColumnCount() {
		return columnCount;
	}


	public ODocumentToStringNodeInterface getDocumentToString() {
		return documentToString;
	}

	public void setDocumentToString(ODocumentToStringNodeInterface documentToString) {
		this.documentToString = documentToString;
	}
	
	public boolean isEditable(int column) {
		return false;
	}

}
