package org.basic.comp.abst;

import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;

public interface Menu {

	/* (non-Javadoc)
	 * @see org.basic.comp.abst.Menu#init()
	 */
	public abstract void init();

	/* (non-Javadoc)
	 * @see org.basic.comp.abst.Menu#build(com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx)
	 */
	public abstract void build(ODatabaseDocumentTx db);

	public abstract Window getWindow();

	public abstract void setWindow(Window window);

}