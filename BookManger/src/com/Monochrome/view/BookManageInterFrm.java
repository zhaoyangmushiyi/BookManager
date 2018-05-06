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

import com.Monochrome.dao.BookDao;
import com.Monochrome.model.Book;
import com.Monochrome.util.DbUtil;
import com.Monochrome.util.StringUtil;

@SuppressWarnings("serial")
public class BookManageInterFrm extends JInternalFrame {
	private JTable bookTable;
	private JTextField s_bookNameTxt;
	private JTextField s_authorTxt;
	
	private DbUtil dbUtil=new DbUtil();
	private BookDao bookDao=new BookDao();

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookManageInterFrm frame = new BookManageInterFrm();
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
	public BookManageInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u56FE\u4E66\u7BA1\u7406");
		setBounds(100, 100, 776, 679);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton button_1 = new JButton("\u4FEE\u6539");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bookUpdateActionPerformed(evt);
			}
		});
		button_1.setIcon(new ImageIcon(BookManageInterFrm.class.getResource("/images/modify.png")));
		
		JButton button_2 = new JButton("\u5220\u9664");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bookDeleteActionPerformed(evt);
			}
		});
		button_2.setIcon(new ImageIcon(BookManageInterFrm.class.getResource("/images/delete.png")));
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
		
		JLabel label = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		
		s_bookNameTxt = new JTextField();
		s_bookNameTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
		
		s_authorTxt = new JTextField();
		s_authorTxt.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookSearchActionPerformed(e);
			}
		});
		button.setIcon(new ImageIcon(BookManageInterFrm.class.getResource("/images/search.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(19)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_bookNameTxt, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
					.addComponent(label_1)
					.addGap(28)
					.addComponent(s_authorTxt, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addGap(122)
					.addComponent(button)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(s_bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button)
						.addComponent(s_authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGap(16))
		);
		panel.setLayout(gl_panel);
		
		bookTable = new JTable();
		bookTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent met) {
				//bookTableMousePressed(met);
			}
		});
		scrollPane.setViewportView(bookTable);
		bookTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u56FE\u4E66\u53F7", "\u56FE\u4E66\u540D", "\u501F\u9605\u72B6\u6001", "\u4E3B\u7F16", "\u4F5C\u8005", "\u51FA\u7248\u793E", "\u56FE\u4E66\u79CD\u7C7B", "\u51FA\u7248\u65E5\u671F", "\u4EF7\u683C", "\u767B\u8BB0\u65E5\u671F"
			}
		));
		getContentPane().setLayout(groupLayout);

		fillTable();
	}
	
	/**
	 * 图书删除事件处理
	 * @param evt
	 */
	private void bookDeleteActionPerformed(ActionEvent evt) {
		long id = Long.valueOf(bookTable.getValueAt(bookTable.getSelectedRow(), 0).toString()); //获取所选中的行的第一个位置的内容
		if(StringUtil.isEmpty(id + "")){
			JOptionPane.showMessageDialog(null, "请选择要删除的记录");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "确定要删除这条记录么");
		if(n==0){
			Connection con=null;
			try{
				con=dbUtil.getCon();
				if(bookDao.delete(con, id)){
					JOptionPane.showMessageDialog(null, "删除成功");
					this.fillTable();
				}else{
					JOptionPane.showMessageDialog(null, "删除失败");
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
	 * 图书修改事件处理
	 * @param evt
	 */	
	private void bookUpdateActionPerformed(ActionEvent evt) {
		long bookId = Long.valueOf(bookTable.getValueAt(bookTable.getSelectedRow(), 0).toString()); //获取所选中的行的第一个位置的内容
		if(StringUtil.isEmpty(bookId + "")){
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "确定要修改这条记录么");
		if(n==0){
			Connection con=null;
			try{
				con=dbUtil.getCon();
				String bookName = bookTable.getValueAt(bookTable.getSelectedRow(), 1).toString();
				String bookState = bookTable.getValueAt(bookTable.getSelectedRow(), 2).toString();
				String editor = bookTable.getValueAt(bookTable.getSelectedRow(), 3).toString();
				String author = bookTable.getValueAt(bookTable.getSelectedRow(), 4).toString();
				String press = bookTable.getValueAt(bookTable.getSelectedRow(), 5).toString();
				String bookTypeName = bookTable.getValueAt(bookTable.getSelectedRow(), 6).toString();
				String publishDateStr = bookTable.getValueAt(bookTable.getSelectedRow(), 7).toString();
				
				@SuppressWarnings("deprecation")
				Date publishDate = new Date(
						Integer.valueOf(publishDateStr.substring(0, 4)) - 1900,
						Integer.valueOf(publishDateStr.substring(5, 7)) - 1,
						Integer.valueOf(publishDateStr.substring(8, 10)));
				
				Double price = Double.valueOf(bookTable.getValueAt(bookTable.getSelectedRow(), 8).toString());
				String recordDateStr = bookTable.getValueAt(bookTable.getSelectedRow(), 9).toString();
				
				@SuppressWarnings("deprecation")
				Date recordDate = new Date(
						Integer.valueOf(recordDateStr.substring(0, 4)) - 1900,
						Integer.valueOf(recordDateStr.substring(5, 7)) - 1,
						Integer.valueOf(recordDateStr.substring(8, 10)));
				
				Book book = new Book(bookId, bookName, bookState, editor, author, press, bookTypeName, publishDate, price, recordDate);
				if(bookDao.update(con, bookId, book)){
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
	 * 图书查询事件处理
	 * @param e
	 */
	private void bookSearchActionPerformed(ActionEvent evt) {
		List<Book> books = null;
		String bookName = this.s_bookNameTxt.getText();
		String author = this.s_authorTxt.getText();
		
		Connection con = dbUtil.getCon();
		
		if (StringUtil.isEmpty(bookName)) {
			if (StringUtil.isNotEmpty(author)) {
				books = bookDao.searchByAuthor(con, author);
			}else {
				books = bookDao.list(con);
			}
		}else {
			if (StringUtil.isNotEmpty(author)) {
				Book book = bookDao.searchByNameAndAuthor(con, bookName, author);
				books = new LinkedList<>();
				books.add(book);
			}
			else {
				books = bookDao.searchByName(con, bookName);
			}
		}
		this.fillTable(books);
	}
	
	
	
	/**
	 * 初始化表格
	 * @param book
	 */
	private void fillTable(){
		DefaultTableModel dtm = (DefaultTableModel) bookTable.getModel();
		dtm.setRowCount(0); // 设置成0行
		Connection con=null;
		List<Book> books = null;
		try{
			con = dbUtil.getCon();
			books = bookDao.list(con);
			for (Book book : books) {
				Vector<Object> v = new Vector<>();
				v.add(book.getBookId());
				v.add(book.getBookName());
				v.add(book.getBookState());
				v.add(book.getEditor());
				v.add(book.getAuthor());
				v.add(book.getPress());
				v.add(book.getBookTypeName());
				v.add(book.getPublishDate());
				v.add(book.getPrice());
				v.add(book.getRecordDate());
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
	private void fillTable(List<Book> books) {
		DefaultTableModel dtm = (DefaultTableModel) bookTable.getModel();
		dtm.setRowCount(0); // 设置成0行
		for (Book book : books) {
			Vector<Object> v = new Vector<>();
			v.add(book.getBookId());
			v.add(book.getBookName());
			v.add(book.getBookState());
			v.add(book.getEditor());
			v.add(book.getAuthor());
			v.add(book.getPress());
			v.add(book.getBookTypeName());
			v.add(book.getPublishDate());
			v.add(book.getPrice());
			v.add(book.getRecordDate());
			dtm.addRow(v);
		}
	}
}
