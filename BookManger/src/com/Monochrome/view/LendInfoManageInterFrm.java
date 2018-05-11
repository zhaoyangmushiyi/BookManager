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
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import com.Monochrome.dao.BookDao;
import com.Monochrome.dao.LendInfoDao;
import com.Monochrome.dao.ReaderDao;
import com.Monochrome.model.Book;
import com.Monochrome.model.LendInfo;
import com.Monochrome.model.Reader;
import com.Monochrome.util.DbUtil;
import com.Monochrome.util.StringUtil;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class LendInfoManageInterFrm extends JInternalFrame {
	private JTable lendInfoTable;

	private DbUtil dbUtil = new DbUtil();
	private LendInfoDao lendInfoDao = new LendInfoDao();
	private JTextField textField_reader;
	private JTextField textField_book;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LendInfoManageInterFrm frame = new LendInfoManageInterFrm();
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
	public LendInfoManageInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("订单信息");
		setBounds(100, 100, 605, 613);

		JScrollPane scrollPane = new JScrollPane();

		JButton button_1 = new JButton("\u4FEE\u6539");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				lendInfoUpdateActionPerformed(evt);
			}
		});
		button_1.setIcon(new ImageIcon(LendInfoManageInterFrm.class.getResource("/images/modify.png")));

		JButton button_2 = new JButton("\u5220\u9664");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				lendInfoDeleteActionPerformed(evt);
			}
		});
		button_2.setIcon(new ImageIcon(LendInfoManageInterFrm.class.getResource("/images/delete.png")));

		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JLabel label = new JLabel("读者姓名：");

		textField_reader = new JTextField();
		textField_reader.setColumns(10);

		JLabel label_1 = new JLabel("图书名字：");

		textField_book = new JTextField();
		textField_book.setColumns(10);

		JButton button_search = new JButton("查询");
		button_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lendInfoSearchActionPerformed();
			}
		});
		button_search.setIcon(new ImageIcon(LendInfoManageInterFrm.class.getResource("/images/search.png")));

		JButton button_list = new JButton("显示所有");
		button_list.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fillTable();
			}
		});
		button_list.setIcon(new ImageIcon(LendInfoManageInterFrm.class.getResource("/images/txt_text_16px.png")));

		JLabel lblOr = new JLabel("OR");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addGap(28).addComponent(lblOr))
								.addGroup(gl_panel.createSequentialGroup().addGap(63)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(label_1)
												.addComponent(label))))
						.addGap(28)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false).addComponent(textField_book)
								.addComponent(textField_reader, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
						.addGap(18).addComponent(button_search)
						.addPreferredGap(ComponentPlacement.RELATED, 71, Short.MAX_VALUE).addComponent(button_list)
						.addGap(62)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(label).addComponent(
								textField_reader, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_book, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1))
						.addGap(16))
				.addGroup(gl_panel.createSequentialGroup().addGap(36).addComponent(lblOr).addContainerGap(35,
						Short.MAX_VALUE))
				.addGroup(gl_panel
						.createSequentialGroup().addGap(23).addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(button_search).addComponent(button_list))
						.addContainerGap(38, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup().addGap(126).addComponent(button_1).addGap(74)
						.addComponent(button_2).addContainerGap(175, Short.MAX_VALUE))
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE).addContainerGap()));
		groupLayout
				.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addContainerGap()
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 392, GroupLayout.PREFERRED_SIZE)
								.addGap(18).addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(button_2).addComponent(button_1))
								.addContainerGap(12, Short.MAX_VALUE)));

		lendInfoTable = new JTable();
		lendInfoTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent met) {
				// LendInfoTableMousePressed(met);
			}
		});
		scrollPane.setViewportView(lendInfoTable);
		lendInfoTable.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "\u501F\u9605\u53F7", "\u8BFB\u8005\u8BC1\u53F7", "\u8BFB\u8005\u59D3\u540D",
						"\u56FE\u4E66\u53F7", "\u56FE\u4E66\u540D\u5B57", "\u501F\u4E66\u65E5\u671F",
						"\u5F52\u8FD8\u65E5\u671F", "\u662F\u5426\u5F52\u8FD8" }));
		getContentPane().setLayout(groupLayout);

	}

	/**
	 * 查询事件处理
	 */
	protected void lendInfoSearchActionPerformed() {
		// TODO Auto-generated method stub
		List<LendInfo> lendInfos = new LinkedList<>();
		String bookName = this.textField_book.getText();
		String readerName = this.textField_reader.getText();

		Connection con = dbUtil.getCon();

		if (StringUtil.isEmpty(bookName)) {
			if (StringUtil.isNotEmpty(readerName)) {
				lendInfos = lendInfoDao.searchByReaderName(con, readerName);
			} else {
				JOptionPane.showMessageDialog(null, "请输入查询条件");
			}
		} else {
			if (StringUtil.isNotEmpty(readerName)) {
				LendInfo lendInfo = new LendInfo();
				lendInfo = lendInfoDao.searchByReaderNameAndBookName(con, readerName, bookName);
				lendInfos.add(lendInfo);
			} else {
				lendInfos = lendInfoDao.searchByBookName(con, bookName);
			}
		}
		for (LendInfo lendInfo : lendInfos) {
			System.out.println(lendInfo);
		}
		this.fillTable(lendInfos);
	}

	private void fillTable(List<LendInfo> lendInfos) {
		// TODO Auto-generated method stub
		DefaultTableModel dtm = (DefaultTableModel) lendInfoTable.getModel();
		dtm.setRowCount(0); // 设置成0行
		Connection con = null;
		try {
			con = dbUtil.getCon();
			for (LendInfo lendinfo : lendInfos) {
				Vector<Object> v = new Vector<>();
				v.add(lendinfo.getLendId());
				v.add(lendinfo.getReaderId());
				v.add(lendinfo.getReaderName());
				v.add(lendinfo.getBookId());
				v.add(lendinfo.getBookName());
				v.add(lendinfo.getBorrowDate());
				v.add(lendinfo.getReturnDate());
				v.add(lendinfo.getLendState());
				dtm.addRow(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 删除事件处理
	 * 
	 * @param evt
	 */
	private void lendInfoDeleteActionPerformed(ActionEvent evt) {
		long id = Long.valueOf(lendInfoTable.getValueAt(lendInfoTable.getSelectedRow(), 0).toString()); // 获取所选中的行的第一个位置的内容
		if (StringUtil.isEmpty(id + "")) {
			JOptionPane.showMessageDialog(null, "请选择要删除的记录");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "确定要删除这条记录么");
		if (n == 0) {
			Connection con = null;
			try {				
				
				con = dbUtil.getCon();
				Book book = new BookDao().get(con, new LendInfoDao().get(con, id).getBookId());

				if (book.getBookState().equals("是")) {
					JOptionPane.showMessageDialog(null, "检查到图书未归还，借阅信息不能删除");
					return;
				}
				if (lendInfoDao.delete(con, id)) {
					JOptionPane.showMessageDialog(null, "删除成功");
					this.fillTable();
				} else {
					JOptionPane.showMessageDialog(null, "删除失败");
				}
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "删除失败");
			} finally {
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
	 * 修改事件处理
	 * 
	 * @param evt
	 */
	private void lendInfoUpdateActionPerformed(ActionEvent evt) {
		long lendId = Long.valueOf(lendInfoTable.getValueAt(lendInfoTable.getSelectedRow(), 0).toString()); // 获取所选中的行的第一个位置的内容
		if (StringUtil.isEmpty(lendId + "")) {
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "确定要修改这条记录么");
		if (n == 0) {
			Connection con = null;
			try {
				con = dbUtil.getCon();
				LendInfo lendInfo = new LendInfoDao().get(con, lendId);
				long readerId = Long.valueOf(lendInfoTable.getValueAt(lendInfoTable.getSelectedRow(), 1).toString());
				String readerName = lendInfoTable.getValueAt(lendInfoTable.getSelectedRow(), 2).toString();
				Reader reader = new ReaderDao().get(con, readerId);
				if (!reader.getReaderName().equals(readerName)) {
					readerName = reader.getReaderName();
					int t = JOptionPane.showConfirmDialog(null,
							"发现所修改订单信息的读者号改变，但当前信息的读者名字不是所对应读者号的读者名字，是否改变成读者号所对应的读者名字？");
					if (t != 0) {
						JOptionPane.showMessageDialog(null, "修改失败");
						return;
					}
				}

				long bookId = Long.valueOf(lendInfoTable.getValueAt(lendInfoTable.getSelectedRow(), 3).toString());
				Book book = new BookDao().get(con, bookId);
				String bookName = lendInfoTable.getValueAt(lendInfoTable.getSelectedRow(), 4).toString();
				long oldBookId = lendInfo.getBookId();
				if (!book.getBookName().equals(bookName)) {
					bookName = book.getBookName();
					int t = JOptionPane.showConfirmDialog(null,
							"发现所修改订单信息的图书号改变，但当前信息的图书名字不是所对应图书号的图书名字，是否改变成图书号所对应的图书名字？");
					if (t != 0) {
						JOptionPane.showMessageDialog(null, "修改失败");
						return;
					}
					Book oldBook = new BookDao().get(con, oldBookId);
					oldBook.setBookState("否");
					new BookDao().update(con, oldBookId, oldBook);
					JOptionPane.showMessageDialog(null, "检测到你修改了图书号，原来的图书借阅状态变为未借阅");
				}

				String borrowDateStr = lendInfoTable.getValueAt(lendInfoTable.getSelectedRow(), 5).toString();
				@SuppressWarnings("deprecation")
				Date borrowDate = new Date(Integer.valueOf(borrowDateStr.substring(0, 4)) - 1900,
						Integer.valueOf(borrowDateStr.substring(5, 7)) - 1,
						Integer.valueOf(borrowDateStr.substring(8, 10)));

				String returnDateStr = lendInfoTable.getValueAt(lendInfoTable.getSelectedRow(), 6).toString();
				@SuppressWarnings("deprecation")
				Date returnDate = new Date(Integer.valueOf(returnDateStr.substring(0, 4)) - 1900,
						Integer.valueOf(returnDateStr.substring(5, 7)) - 1,
						Integer.valueOf(returnDateStr.substring(8, 10)));

				String lendState = lendInfoTable.getValueAt(lendInfoTable.getSelectedRow(), 7).toString();


				lendInfo.setBorrowDate(borrowDate);
				lendInfo.setReturnDate(returnDate);
				lendInfo.setLendId(lendId);
				lendInfo.setReaderId(readerId);
				lendInfo.setReaderName(readerName);
				lendInfo.setBookId(bookId);
				lendInfo.setBookName(bookName);
				lendInfo.setLendState(lendState);
				
				if (lendState.equals("是")) {
					if (book.getBookState().equals("是")) {
						book.setBookState("否");
						new BookDao().update(con, bookId, book);
						JOptionPane.showMessageDialog(null, "检测到你归还了图书，所归还的图书借阅状态变为未借阅");
					}
				}
				
				if (lendState.equals("否")) {
					if (book.getBookState().equals("否")) {
						book.setBookState("是");
						new BookDao().update(con, bookId, book);
					}
				}
				
				System.out.println(lendInfo);
				if (lendInfoDao.update(con, lendId, lendInfo)) {
					JOptionPane.showMessageDialog(null, "修改成功");
					this.fillTable();
				} else {
					JOptionPane.showMessageDialog(null, "修改失败");
				}
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "修改失败");
			} finally {
				try {
					dbUtil.closeCon(con);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private void fillTable() {
		DefaultTableModel dtm = (DefaultTableModel) lendInfoTable.getModel();
		dtm.setRowCount(0); // 设置成0行
		Connection con = null;
		List<LendInfo> lendInfos = null;
		try {
			con = dbUtil.getCon();
			lendInfos = lendInfoDao.list(con);
			for (LendInfo lendinfo : lendInfos) {
				Vector<Object> v = new Vector<>();
				v.add(lendinfo.getLendId());
				v.add(lendinfo.getReaderId());
				v.add(lendinfo.getReaderName());
				v.add(lendinfo.getBookId());
				v.add(lendinfo.getBookName());
				v.add(lendinfo.getBorrowDate());
				v.add(lendinfo.getReturnDate());
				v.add(lendinfo.getLendState());
				dtm.addRow(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
