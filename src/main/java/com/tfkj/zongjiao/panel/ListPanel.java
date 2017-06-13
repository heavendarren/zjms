package com.tfkj.zongjiao.panel;

import com.tfkj.zongjiao.entity.Item;
import com.tfkj.zongjiao.entity.RelgPer;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

@SuppressWarnings("serial")                                                                                                    
public class ListPanel extends JPanel {                                                                                  
    JTable table = null;  
    JButton viewButton2 = new JButton("查看");  
    JButton editButton2 = new JButton("修改");
    JButton deleteButton2 = new JButton("删除");  
    public Dialog dialog;
    protected String id;
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
    protected String btn;


	public String getBtn() {
		return btn;
	}

	public void setBtn(String btn) {
		this.btn = btn;
	}

	public ListPanel(List<RelgPer> list,JDialog dialog,int cnt, int pageNo,List<Item> regionList, List<Item> nationList) {                                                                                                 
        super(new BorderLayout());                                                                                             
        this.dialog=dialog;                                                                                                                      
        //创建表头                                                                                                             
        String[] columnNames = { "id", "姓名", "性别", "民族", "身份", "出生年月日", "宗教信仰", "工作单位及职务", "社会职务", "填报单位", "操作"};                                                                                  
        Object[][] data = new Object[list.size()][11];
        for (int i=0;i<list.size();i++) {
        	RelgPer rp = list.get(i);
        	data[i][0] = rp.getId();
        	data[i][1] = rp.getName();
        	String sexLabel = "";
        	if ("1".equals(rp.getSex())) {
        		sexLabel = "男";
        	} else if ("2".equals(rp.getSex())) {
          		sexLabel = "女";
        	} else {
        		sexLabel = rp.getSex();
        	}
        	data[i][2] = sexLabel;
        	
        	String nation = rp.getNation();
        	for (Item item:nationList) {
        		if (item.getKey().equals(rp.getNation())) {
        			nation = item.getValue();
        			break;
        		}
        	}
        	data[i][3] = nation;
        	
        	String identityCodeLabel = "";
        	if ("1".equals(rp.getIdentityCode())) {
        		identityCodeLabel = "少数民族代表人士";
        	} else if ("2".equals(rp.getIdentityCode())) {
        		identityCodeLabel = "宗教界代表人士";
        	} else if ("3".equals(rp.getIdentityCode())) {
        		identityCodeLabel = "宗教教职人员";
        	} else if ("4".equals(rp.getIdentityCode())) {
        		identityCodeLabel = "民族宗教干部";
        	} else if ("5".equals(rp.getIdentityCode())) {
        		identityCodeLabel = "民族宗教信息员";
        	} else {
        		identityCodeLabel = rp.getIdentityCode();
        	}
        	data[i][4] = identityCodeLabel;
        	data[i][5] = rp.getBirth();
        	
        	String religion = "";
        	if ("01".equals(rp.getReligion())) {
        		religion = "基督教";
        	} else if ("02".equals(rp.getReligion())) {
        		religion = "伊斯兰教";
        	} else if ("03".equals(rp.getReligion())) {
        		religion = "佛教";
        	} else if ("04".equals(rp.getReligion())) {
        		religion = "道教";
        	} else if ("05".equals(rp.getReligion())) {
        		religion = "天主教";
        	} else {
        		religion = rp.getReligion();
        	}
        	data[i][6] = religion;
        	
        	data[i][7] = rp.getWorkUnitPosition();
        	data[i][8] = rp.getSocialPosition();
        	String region = rp.getRegion();
        	for (Item item:regionList) {
        		if (item.getKey().equals(rp.getRegion())) {
        			region = item.getValue();
        			break;
        		}
        	}
        	data[i][9] = region;
        	data[i][10] = null;

        }                                         
                                                                                                                               
        /*                                                                                                                     
         * JTable还提供了一个重载的构造方法,传入两个Vector                                                                     
         * JTable(Vector rowData, Vector columnNames)                                                                          
         *                                                                                                                     
         */                                                                                                                    
                                                                                                                               
        table = new JTable(data, columnNames);
        table.setRowHeight(25);
        hideTableColumn(table, 0);
        table.getColumnModel().getColumn(1).setPreferredWidth(15);
        table.getColumnModel().getColumn(2).setPreferredWidth(45);
        table.getColumnModel().getColumn(3).setPreferredWidth(80);
        table.getColumnModel().getColumn(4).setPreferredWidth(50);
        table.getColumnModel().getColumn(5).setPreferredWidth(40);
        ActionPanelEditorRenderer er = new ActionPanelEditorRenderer();
        table.getColumnModel().getColumn(9).setMaxWidth(200);
        table.getColumnModel().getColumn(9).setMinWidth(200);
        TableColumn column = table.getColumnModel().getColumn(9);
        column.setCellRenderer(er);  
        column.setCellEditor(er); 
        //这也是官方建议使用的方式，否则表头不会显示，需要单独获取到TableHeader自己手动地添加显示                              
        JScrollPane scrollPane = new JScrollPane(table);                                                                       
                                                                                                                               
        add(scrollPane);
        
        JPanel panel2 = new JPanel();                                   
        this.add(panel2,BorderLayout.SOUTH);                            
        JButton btn1 = new JButton("前一页");
        JLabel lable1 = new JLabel(String.valueOf(pageNo)+ "/" + getMyInt(cnt,30) + "页");
        JButton btn2 = new JButton("后一页"); 
        JLabel lable2 = new JLabel("共"+ cnt +"条数据");
        
        if (pageNo<=1) {
        	btn1.setEnabled(false);
        }
        
        if (pageNo >= getMyInt(cnt,30)) {
        	btn2.setEnabled(false);
        }

        panel2.add(btn1); 
        panel2.add(lable1);  
        panel2.add(btn2);                                               
        panel2.add(lable2);                                               
                                                               
        btn1.addActionListener(new ActionListener() {                   
            @Override                                                   
            public void actionPerformed(ActionEvent e) {
                btn = "4";
                dialog.dispose();
            }                                                           
        });                                                             
                                                                        
        btn2.addActionListener(new ActionListener() {                   
            @Override                                                   
            public void actionPerformed(ActionEvent e) {
                btn = "5";
                dialog.dispose();

            }                                                           
        });                                                                                                                                                                     
                                                                                                                               
    }                                                                                                                               
 
    private void hideTableColumn(JTable table, int column){  
        TableColumnModel tcm = table.getColumnModel();  
        //其实没有移除，仅仅隐藏而已  
        TableColumn tc = tcm.getColumn(column);
        tcm.removeColumn(tc);         
    } 
    
    private int getMyInt(int a,int b) {  
		return(((double)a/(double)b)>(a/b)?a/b+1:a/b);  
        }                                                                                                                         
    
    class ActionPanelEditorRenderer extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {  
        JPanel panel2 = new JPanel();  
  
        public ActionPanelEditorRenderer() {
        	Dimension preferredSize = new Dimension(60,15);//设置尺寸
        	viewButton2.setPreferredSize(preferredSize);
        	editButton2.setPreferredSize(preferredSize);
        	deleteButton2.setPreferredSize(preferredSize);

            panel2.add(viewButton2);  
            panel2.add(editButton2);
            panel2.add(deleteButton2); 
            javax.swing.table.TableModel model = table.getModel();  
            viewButton2.addActionListener(new ActionListener() {  
                
                @Override  
                public void actionPerformed(ActionEvent arg0) {  
                      
                    int i = table.getSelectedRow();
                    btn = "1";
                    id = (String)model.getValueAt(i, 0); 
                    dialog.dispose();
                }  
            });
            
            editButton2.addActionListener(new ActionListener() {  
                
                @Override  
                public void actionPerformed(ActionEvent arg0) {            
                    int i = table.getSelectedRow();  
                    btn = "2";
                    id = (String)model.getValueAt(i, 0);  
                    dialog.dispose();
                      
                }  
            });
            
            deleteButton2.addActionListener(new ActionListener() {  
                
                @Override  
                public void actionPerformed(ActionEvent arg0) {            
                    int i = table.getSelectedRow();  
                    btn = "3";
                    id = (String)model.getValueAt(i, 0); 
                    dialog.dispose();
                      

                }  
            });
        }  
  
        @Override  
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,  
                int row, int column) {  
            panel2.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());  
            return panel2;  
        }  
  
        @Override  
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {  
            panel2.setBackground(table.getSelectionBackground());  
            return panel2;  
        }  
  
        @Override  
        public Object getCellEditorValue() {  
            return null;  
        }  
    }  
    
}                                                                                                                              
