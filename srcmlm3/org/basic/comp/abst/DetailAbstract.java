package org.basic.comp.abst;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import org.basic.comp.adapter.DetailAdapter;
import org.basic.comp.adapter.DetailWidgetInterface;
import org.basic.comp.adapter.EfectWidget;
import org.basic.comp.listener.WidgetInterface;
import org.basic.comp.model.ODocumentToString;
import org.basic.dao.adapter.DaoInterface;

import com.basic.lang.LApp;
import com.global.App;
import com.jgoodies.forms.layout.FormLayout;
import com.orientechnologies.orient.core.db.ODatabaseRecordThreadLocal;
import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.record.impl.ODocument;

public abstract class DetailAbstract extends DetailAdapter{
	
	public final static int WIDGET_1=0;
	public final static int WIDGET_2=1;
	public final static int WIDGET_3=2;
	public final static int WIDGET_4=3;
	
	protected int typeEfectWidget=WIDGET_2;
	
	protected double lebar;
	protected Icon icon;
	protected String title;
	protected JLabel label;
	protected JPanel panel;
	protected JPanel panelForm;
	
	protected EfectWidget master;
	
	protected JScrollPane pane;
	protected FormBuilder builder;
	protected FormLayout layout;
	
	protected List<WidgetInterface> widgets=new ArrayList<WidgetInterface>();
	protected DaoInterface dao;

	
	/**
	 * untuk menjalankan ini harus sudah build label dan build form 
	 */
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
		
		pane.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		panel.add(pane, BorderLayout.CENTER);
		panel.add(label, BorderLayout.NORTH);
	}
	/**
	 *  untuk menjalankan ini icon dan title tidak boleh kosong
	 * @param db
	 */
	public void buildLabel(ODatabaseDocumentTx db){
		label=new JLabel(icon);
		label.setText(title);
		label.setBorder(App.borderBlackBottom5555);
		label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
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
				}
			}
			public void mouseReleased(MouseEvent e) {}
		});
	}
	public void setFocusEnter(JTextComponent sebelum, final JTextComponent sesudah) {
		sebelum.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (KeyEvent.VK_ENTER==e.getKeyCode()) {
					sesudah.requestFocus();
					sesudah.selectAll();
				}
			}
		});
	}
	
	public void setFocusEnter(JTextComponent sebelum, final JComponent sesudah) {
		sebelum.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (KeyEvent.VK_ENTER==e.getKeyCode()) {
					sesudah.requestFocus();
				}
			}
		});
	}
	public void setFocusEnter(JComponent sebelum, final JComponent sesudah) {
		sebelum.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (KeyEvent.VK_ENTER==e.getKeyCode()) {
					sesudah.requestFocus();
				}
			}
		});
	}
	
	
	public void addWidget(WidgetInterface e){
		widgets.add(e);
	}
	
	public JFrame getFrame(Object o){
		if (o instanceof JFrame) {
			return ((JFrame) o);
		} else {
			if (o instanceof Component) {
				return  getFrame(((Component) o).getParent());
			}else{
				return null;
			}
		}
	}
	public void clearText(JTextComponent field) {
		field.setText("");
	}
	public boolean modelIsTrue(ODocument model){
		return model.field("@class").equals(dao.getClassName());
	}
	public void setBackground(JComponent field){
		field.setBackground(App.whiteSmoke);
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// default
	public double getLebar() {
		return lebar;
	}
	public void setLebar(double lebar) {
		this.lebar = lebar;
	}
	public Icon getIcon() {
		return icon;
	}
	public void setIcon(Icon icon) {
		this.icon = icon;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public JLabel getLabel() {
		return label;
	}
	public Component getLabelTitle() {
		return label;
	}
	public void setLabel(JLabel label) {
		this.label = label;
	}
	public JPanel getPanel() {
		return panel;
	}
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	public JScrollPane getPane() {
		return pane;
	}
	public void setPane(JScrollPane pane) {
		this.pane = pane;
	}
	public FormBuilder getBuilder() {
		return builder;
	}
	public void setBuilder(FormBuilder builder) {
		this.builder = builder;
	}
	public FormLayout getLayout() {
		return layout;
	}
	public void setLayout(FormLayout layout) {
		this.layout = layout;
	}
	public DaoInterface getDao() {
		return dao;
	}
	public void setDao(DaoInterface dao) {
		this.dao = dao;
	}
	
	public void modelWidgetChange(ODocument model) {
		load(model);
	}

	public Component getPanelForm() {
		return panelForm;
	}

	public void setPanelForm(JPanel panelForm) {
		this.panelForm = panelForm;
	}

	public EfectWidget getMaster() {
		return master;
	}

	public void setMasterEfectWidget(EfectWidget master) {
		this.master = master;
	}
	
	
	
	@Override
	public void build(ODatabaseDocumentTx db) {
		// TODO Auto-generated method stub
		init(db);
	}

	public void init(ODatabaseDocumentTx db) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void load(ODocument model) {
		// TODO Auto-generated method stub
		
	}

	
	public int getTypeEfectWidget() {
		return typeEfectWidget;
	}

	public void setTypeEfectWidget(int typeEfectWidget) {
		this.typeEfectWidget = typeEfectWidget;
	}
	public void requestDefaultFocus(){};
}
