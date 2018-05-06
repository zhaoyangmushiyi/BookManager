package com.Monochrome.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.Monochrome.dao.ReaderDao;
import com.Monochrome.model.Reader;
import com.Monochrome.util.DbUtil;
import com.Monochrome.util.StringUtil;

@SuppressWarnings("serial")
public class ReaderManageInterFrm extends JInternalFrame {
	private JTable readerTable;
	private JTextField s_readerIdTxt;
	private JTextField s_readerNameTxt;
	
	private DbUtil dbUtil=new DbUtil();
	private ReaderDao readerDao = new ReaderDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReaderManageInterFrm frame = new ReaderManageInterFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ReaderManageInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("读者管理");
		setBounds(100, 100, 776, 679);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton button_1 = new JButton("\u4FEE\u6539");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				readerUpdateActionPerformed(evt);
			}
		});
		button_1.setIcon(new ImageIcon(ReaderManageInterFrm.class.getResource("/images/modify.png")));
		
		JButton button_2 = new JButton("\u5220\u9664");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				readerDeleteActionPerformed(evt);
			}
		});
		button_2.setIcon(new ImageIcon(ReaderManageInterFrm.class.getResource("/images/delete.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(288, Short.MAX_VALUE)
					.addComponent(button_1)
					.addGap(89)
					.addComponent(button_2)
					.addGap(229))
				.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 484, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_2)
						.addComponent(button_1))
					.addGap(96))
		);
		
		JLabel label = new JLabel("读者证号：");
		
		s_readerIdTxt = new JTextField();
		s_readerIdTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("读者姓名：");
		
		s_readerNameTxt = new JTextField();
		s_readerNameTxt.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				readerSearchActionPerformed(e);
			}
		});
		button.setIcon(new ImageIcon(ReaderManageInterFrm.class.getResource("/images/search.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(19)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_readerIdTxt, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
					.addComponent(label_1)
					.addGap(28)
					.addComponent(s_readerNameTxt, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(96)
					.addComponent(button)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(s_readerIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button)
						.addComponent(s_readerNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGap(16))
		);
		panel.setLayout(gl_panel);
		
		readerTable = new JTable();
		readerTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent met) {
				//bookTableMousePressed(met);
			}
		});
		scrollPane.setViewportView(readerTable);
		readerTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8BFB\u8005\u8BC1\u53F7", "\u8BFB\u8005\u59D3\u540D", "\u6027\u522B", "\u5B66\u9662", "\u5165\u5B66\u65E5\u671F", "\u7535\u8BDD\u53F7", "\u4F59\u989D", "\u767B\u8BB0\u65E5\u671F"
			}
		));
		getContentPane().setLayout(groupLayout);

		fillTable();
	}
	
	/**
	 * 读者删除事件处理
	 * @param evt
	 */
	private void readerDeleteActionPerformed(ActionEvent evt) {
		long id = Long.valueOf(readerTable.getValueAt(readerTable.getSelectedRow(), 0).toString()); //获取所选中的行的第一个位置的内容
		if(StringUtil.isEmpty(id + "")){
			JOptionPane.showMessageDialog(null, "请选择要删除的记录");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "确定要删除这条记录么");
		if(n==0){
			Connection con=null;
			try{
				con=dbUtil.getCon();
				if(readerDao.delete(con, id)){
					JOptionPane.showMessageDialog(null, "删除成功");
					this.fillTable();
				}else{
					JOptionPane.showMessageDialog(null, "当前读者可能还有借阅信息，删除失败");
				}
			}catch(Exception e){
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "删除失败");
			}finally{
				try {
					dbUtil.closeCon(con);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	
	/**
	 * 读者修改事件处理
	 * @param evt
	 */	
	private void readerUpdateActionPerformed(ActionEvent evt) {
		long readerId = Long.valueOf(readerTable.getValueAt(readerTable.getSelectedRow(), 0).toString()); //获取所选中的行的第一个位置的内容
		if(StringUtil.isEmpty(readerId + "")){
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "确定要修改这条记录么");
		if(n==0){
			Connection con=null;
			try{
				con=dbUtil.getCon();
				String readerName = readerTable.getValueAt(readerTable.getSelectedRow(), 1).toString();
				String sex = readerTable.getValueAt(readerTable.getSelectedRow(), 2).toString();
				String college = readerTable.getValueAt(readerTable.getSelectedRow(), 3).toString();
				String enrollmentDateStr = readerTable.getValueAt(readerTable.getSelectedRow(), 4).toString();
				
				@SuppressWarnings("deprecation")
				Date enrollmentDate = new Date(
						Integer.valueOf(enrollmentDateStr.substring(0, 4)) - 1900,
						Integer.valueOf(enrollmentDateStr.substring(5, 7)) - 1,
						Integer.valueOf(enrollmentDateStr.substring(8, 10)));
				String phoneNumber = readerTable.getValueAt(readerTable.getSelectedRow(), 5).toString();
				Double balance = Double.valueOf(readerTable.getValueAt(readerTable.getSelectedRow(), 6).toString());
				String recordDateStr = readerTable.getValueAt(readerTable.getSelectedRow(), 7).toString();
				
				@SuppressWarnings("deprecation")
				Date recordDate = new Date(
						Integer.valueOf(recordDateStr.substring(0, 4)) - 1900,
						Integer.valueOf(recordDateStr.substring(5, 7)) - 1,
						Integer.valueOf(recordDateStr.substring(8, 10)));
				
				Reader reader = new Reader(readerId, readerName, sex, college, enrollmentDate, phoneNumber, balance, recordDate);
				if(readerDao.update(con, readerId, reader)){
					JOptionPane.showMessageDialog(null, "修改成功");
					this.fillTable();
				}else{
					JOptionPane.showMessageDialog(null, "修改失败");
				}
			}catch(Exception e){
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "修改失败");
			}finally{
				try {
					dbUtil.closeCon(con);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	

	/**
	 * 读者查询事件处理
	 * @param e
	 */
	private void readerSearchActionPerformed(ActionEvent evt) {
		List<Reader> readers = null;
		long readerId = Long.valueOf(this.s_readerIdTxt.getText());
		String readerName = this.s_readerNameTxt.getText();
		
		Connection con = dbUtil.getCon();
		
		if (readerId == 0) {
			if (StringUtil.isNotEmpty(readerName)) {
				readers = readerDao.searchByName(con, readerName);
			}else {
				readers = readerDao.list(con);
			}
		}else {
			if (StringUtil.isNotEmpty(readerName)) {
				Reader reader = readerDao.searchByIdAndName(con, readerId, readerName);
				readers = new LinkedList<>();
				readers.add(reader);
			}
			else {
				Reader reader = readerDao.searchById(con, readerId);
				readers = new LinkedList<>();
				readers.add(reader);
			}
		}
		this.fillTable(readers);
	}
	
	
	
	/**
	 * 初始化表格
	 * @param book
	 */
	private void fillTable(){
		DefaultTableModel dtm = (DefaultTableModel) readerTable.getModel();
		dtm.setRowCount(0); // 设置成0行
		Connection con=null;
		List<Reader> readers = null;
		try{
			con = dbUtil.getCon();
			readers = readerDao.list(con);
			for (Reader reader : readers) {
				Vector<Object> v = new Vector<>();
				v.add(reader.getReaderId());
				v.add(reader.getReaderName());
				v.add(reader.getSex());
				v.add(reader.getCollege());
				v.add(reader.getEnrollmentDate());
				v.add(reader.getPhoneNumber());
				v.add(reader.getBalance());
				v.add(reader.getRecordDate());
				dtm.addRow(v);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private void fillTable(List<Reader> readers) {
		DefaultTableModel dtm = (DefaultTableModel) readerTable.getModel();
		dtm.setRowCount(0); // 设置成0行
		for (Reader reader : readers) {
			Vector<Object> v = new Vector<>();
			v.add(reader.getReaderId());
			v.add(reader.getReaderName());
			v.add(reader.getSex());
			v.add(reader.getCollege());
			v.add(reader.getEnrollmentDate());
			v.add(reader.getPhoneNumber());
			v.add(reader.getBalance());
			v.add(reader.getRecordDate());
			dtm.addRow(v);
		}
	}
}
