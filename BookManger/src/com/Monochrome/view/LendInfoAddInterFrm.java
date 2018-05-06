package com.Monochrome.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.Monochrome.dao.BookDao;
import com.Monochrome.dao.LendInfoDao;
import com.Monochrome.dao.ReaderDao;
import com.Monochrome.model.Book;
import com.Monochrome.model.LendInfo;
import com.Monochrome.util.DbUtil;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;

@SuppressWarnings("serial")
public class LendInfoAddInterFrm extends JInternalFrame {

	private DbUtil dbUtil = new DbUtil();
	private LendInfoDao lendInfoDao = new LendInfoDao();

	private JTextField textField_lendInfoId;
	private JTextField textField_readerId;
	private JTextField textField_bookId;
	private JTextField textField_returnDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LendInfoAddInterFrm frame = new LendInfoAddInterFrm();
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
	public LendInfoAddInterFrm() {
		getContentPane().setFont(new Font("Dialog", Font.PLAIN, 14));
		setIconifiable(true);
		setClosable(true);
		setTitle("订阅图书");
		setBounds(100, 100, 435, 368);

		JLabel lblNewLabel = new JLabel("读者证号：");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(111, 81, 82, 16);

		textField_readerId = new JTextField();
		textField_readerId.setFont(new Font("宋体", Font.PLAIN, 14));
		textField_readerId.setBounds(202, 78, 91, 21);
		textField_readerId.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("归还日期：");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(111, 188, 81, 18);

		textField_returnDate = new JTextField();
		textField_returnDate.setFont(new Font("宋体", Font.PLAIN, 14));
		textField_returnDate.setBounds(202, 186, 91, 21);
		textField_returnDate.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("图书号：");
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(111, 129, 81, 21);

		JLabel lblNewLabel_4 = new JLabel("订单号：");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(111, 29, 81, 18);

		JButton btnNewButton = new JButton("添加");
		btnNewButton.setBounds(101, 254, 91, 25);
		btnNewButton.setIcon(new ImageIcon(LendInfoAddInterFrm.class.getResource("/images/add.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookAddActionPerformed(e);
			}
		});

		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.setBounds(202, 254, 91, 25);
		btnNewButton_1.setIcon(new ImageIcon(LendInfoAddInterFrm.class.getResource("/images/add.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookValueActionPerformed(e);
			}
		});

		btnNewButton_1.setIcon(new ImageIcon(LendInfoAddInterFrm.class.getResource("/images/reset.png")));

		textField_lendInfoId = new JTextField();
		textField_lendInfoId.setFont(new Font("宋体", Font.PLAIN, 14));
		textField_lendInfoId.setBounds(202, 27, 91, 21);
		textField_lendInfoId.setColumns(10);

		textField_bookId = new JTextField();
		textField_bookId.setFont(new Font("宋体", Font.PLAIN, 14));
		textField_bookId.setBounds(202, 128, 91, 21);
		textField_bookId.setColumns(10);
		getContentPane().setLayout(null);
		getContentPane().add(textField_bookId);
		getContentPane().add(lblNewLabel_2);
		getContentPane().add(lblNewLabel_4);
		getContentPane().add(textField_lendInfoId);
		getContentPane().add(lblNewLabel_1);
		getContentPane().add(textField_returnDate);
		getContentPane().add(lblNewLabel);
		getContentPane().add(textField_readerId);
		getContentPane().add(btnNewButton);
		getContentPane().add(btnNewButton_1);

	}

	/**
	 * 重置事件处理
	 * 
	 * @param e
	 */
	private void bookValueActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.resetValue();
	}

	/**
	 * 添加事件处理
	 * 
	 * @param evt
	 */
	private void bookAddActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		long lendId = Long.valueOf(this.textField_lendInfoId.getText());
		long readerId = Long.valueOf(this.textField_readerId.getText());
		long bookId = Long.valueOf(this.textField_bookId.getText());
		String returnDateStr = this.textField_returnDate.getText();

		@SuppressWarnings("deprecation")
		Date returnDate = new Date(Integer.valueOf(returnDateStr.substring(0, 4)) - 1900,
				Integer.valueOf(returnDateStr.substring(5, 7)) - 1, Integer.valueOf(returnDateStr.substring(8, 10)));
		Date borrowDate = new Date(System.currentTimeMillis());
		Connection con = null;
		try {
			con = dbUtil.getCon();
			LendInfo lendInfo = new LendInfo();
			lendInfo.setLendId(lendId);
			lendInfo.setReaderId(readerId);
			lendInfo.setReaderName(new ReaderDao().get(con, readerId).getReaderName());
			lendInfo.setBookId(bookId);
			Book book = new BookDao().get(con, bookId);
			if (book.getBookState().equals("是")) {
				JOptionPane.showMessageDialog(null, "该图书已被借阅");
				return;
			}
			lendInfo.setBookName(book.getBookName());
			lendInfo.setBorrowDate(borrowDate);
			lendInfo.setReturnDate(returnDate);
			lendInfo.setLendState("否");
			if (lendInfoDao.add(con, lendInfo)) {
				JOptionPane.showMessageDialog(null, "借阅信息添加成功");
			} else {
				JOptionPane.showMessageDialog(null, "借阅信息添加失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "借阅信息添加失败");
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}
	}

	/**
	 * 重置表单
	 */
	private void resetValue() {
		// TODO Auto-generated method stub
		this.textField_lendInfoId.setText("");
		this.textField_readerId.setText("");
		this.textField_bookId.setText("");
		this.textField_returnDate.setText("");
	}

}
