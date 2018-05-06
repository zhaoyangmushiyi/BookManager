package com.Monochrome.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.Monochrome.dao.BookDao;
import com.Monochrome.model.Book;
import com.Monochrome.util.DbUtil;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;

@SuppressWarnings("serial")
public class BookAddInterFrm extends JInternalFrame {
	
	private DbUtil dbUtil = new DbUtil();
	private BookDao bookDao = new BookDao();
	
	private JTextField textField_bookId;
	private JTextField textField_bookName;
	private JTextField textField_editor;
	private JTextField textField_author;
	private JTextField textField_press;
	private JTextField textField_bookTypeName;
	private JTextField textField_publishDate;
	private JTextField textField_price;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAddInterFrm frame = new BookAddInterFrm();
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
	public BookAddInterFrm() {
		getContentPane().setFont(new Font("Dialog", Font.PLAIN, 14));
		setIconifiable(true);
		setClosable(true);
		setTitle("图书添加");
		setBounds(100, 100, 435, 368);
		
		JLabel lblNewLabel = new JLabel("图书名字：");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(230, 14, 82, 16);
		
		textField_bookName = new JTextField();
		textField_bookName.setFont(new Font("宋体", Font.PLAIN, 14));
		textField_bookName.setBounds(321, 11, 91, 21);
		textField_bookName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("作者：");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(251, 78, 60, 18);
		
		textField_author = new JTextField();
		textField_author.setFont(new Font("宋体", Font.PLAIN, 14));
		textField_author.setBounds(321, 76, 91, 21);
		textField_author.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("主编：");
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 77, 53, 21);
		
		JLabel lblNewLabel_3 = new JLabel("图书价格：");
		lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(230, 208, 81, 16);
		
		textField_bookTypeName = new JTextField();
		textField_bookTypeName.setFont(new Font("宋体", Font.PLAIN, 14));
		textField_bookTypeName.setBounds(321, 142, 91, 22);
		textField_bookTypeName.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("图书号：");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(10, 13, 68, 18);
		
		JLabel lblNewLabel_5 = new JLabel("图书类别：");
		lblNewLabel_5.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(230, 144, 81, 18);
		
		JButton btnNewButton = new JButton("添加");
		btnNewButton.setBounds(88, 282, 91, 25);
		btnNewButton.setIcon(new ImageIcon(BookAddInterFrm.class.getResource("/images/add.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookAddActionPerformed(e);
			}
		});
		
		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.setBounds(234, 282, 91, 25);
		btnNewButton_1.setIcon(new ImageIcon(BookAddInterFrm.class.getResource("/images/add.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookValueActionPerformed(e);
			}
		});
		
		btnNewButton_1.setIcon(new ImageIcon(BookAddInterFrm.class.getResource("/images/reset.png")));
		
		textField_bookId = new JTextField();
		textField_bookId.setFont(new Font("宋体", Font.PLAIN, 14));
		textField_bookId.setBounds(88, 11, 91, 21);
		textField_bookId.setColumns(10);
		
		textField_editor = new JTextField();
		textField_editor.setFont(new Font("宋体", Font.PLAIN, 14));
		textField_editor.setBounds(88, 76, 91, 21);
		textField_editor.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("出版社：");
		lblNewLabel_6.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(10, 143, 68, 21);
		
		textField_press = new JTextField();
		textField_press.setFont(new Font("宋体", Font.PLAIN, 14));
		textField_press.setBounds(88, 142, 91, 21);
		textField_press.setColumns(10);
		getContentPane().setLayout(null);
		getContentPane().add(textField_editor);
		getContentPane().add(lblNewLabel_6);
		getContentPane().add(textField_press);
		getContentPane().add(lblNewLabel_2);
		getContentPane().add(lblNewLabel_4);
		getContentPane().add(textField_bookId);
		getContentPane().add(lblNewLabel_3);
		getContentPane().add(lblNewLabel_1);
		getContentPane().add(textField_author);
		getContentPane().add(textField_bookTypeName);
		getContentPane().add(lblNewLabel);
		getContentPane().add(textField_bookName);
		getContentPane().add(btnNewButton);
		getContentPane().add(btnNewButton_1);
		getContentPane().add(lblNewLabel_5);
		
		JLabel label = new JLabel("出版日期：");
		label.setFont(new Font("Dialog", Font.PLAIN, 14));
		label.setBounds(10, 207, 82, 18);
		getContentPane().add(label);
		
		textField_publishDate = new JTextField();
		textField_publishDate.setFont(new Font("宋体", Font.PLAIN, 14));
		textField_publishDate.setColumns(10);
		textField_publishDate.setBounds(88, 205, 91, 21);
		getContentPane().add(textField_publishDate);
		
		textField_price = new JTextField();
		textField_price.setFont(new Font("宋体", Font.PLAIN, 14));
		textField_price.setColumns(10);
		textField_price.setBounds(321, 206, 91, 21);
		getContentPane().add(textField_price);
				
	}
	/**
	 * 重置事件处理
	 * @param e
	 */
	private void bookValueActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.resetValue();
	}
	/**
	 * 添加事件处理
	 * @param evt
	 */
	private void bookAddActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		long bookId = Long.valueOf(this.textField_bookId.getText());
		String bookName = this.textField_bookName.getText();
		String bookState = "否";
		String editor = this.textField_editor.getText();
		String author = this.textField_author.getText();
		String press = this.textField_press.getText();
		String bookTypeName = this.textField_bookTypeName.getText();
		String publishDateStr = this.textField_publishDate.getText();
		@SuppressWarnings("deprecation")
		Date publishDate = new Date(
				Integer.valueOf(publishDateStr.substring(0, 4)) - 1900,
				Integer.valueOf(publishDateStr.substring(5, 7)) - 1,
				Integer.valueOf(publishDateStr.substring(8, 10)));
		System.out.println(publishDate);
		
		Double price = Double.valueOf(this.textField_price.getText());
		Date recordDate = new Date(System.currentTimeMillis());
		 Connection con = null;
	        try{
	        	con=dbUtil.getCon();
	        	Book book = new Book(bookId, bookName, bookState, editor, author, press, bookTypeName, publishDate, price, recordDate);
	        	if(bookDao.add(con, book)) {
		        	JOptionPane.showMessageDialog(null,"图书添加成功");
	        	}else {
		        	JOptionPane.showMessageDialog(null,"图书添加失败");
	        	}
	        }catch(Exception e){
	        	e.printStackTrace();  
	        	JOptionPane.showMessageDialog(null,"图书添加失败");
	        }finally{
	        	try{
	        	dbUtil.closeCon(con);
	        	}catch (Exception e) {
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
		this.textField_bookId.setText("");
		this.textField_bookName.setText("");
		this.textField_editor.setText("");
		this.textField_author.setText("");
		this.textField_press.setText("");
		this.textField_bookTypeName.setText("");
		this.textField_publishDate.setText("");
		this.textField_price.setText("");
	}
	
}

		
	