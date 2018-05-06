package com.Monochrome.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.Monochrome.dao.ReaderDao;
import com.Monochrome.model.Reader;
import com.Monochrome.util.DbUtil;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;

@SuppressWarnings("serial")
public class ReaderAddInterFrm extends JInternalFrame {
	
	private DbUtil dbUtil = new DbUtil();
	
	private ReaderDao readerDao = new ReaderDao();
	
	private JTextField textField_readerId;
	private JTextField textField_readerName;
	private JTextField textField_sex;
	private JTextField textField_college;
	private JTextField textField_enrollmentDate;
	private JTextField textField_phoneNumber;
	private JTextField textField_balance;
	
	
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
	public ReaderAddInterFrm() {
		getContentPane().setFont(new Font("Dialog", Font.PLAIN, 14));
		setIconifiable(true);
		setClosable(true);
		setTitle("读者添加");
		setBounds(100, 100, 435, 368);
		
		JLabel lblNewLabel = new JLabel("读者名字：");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(230, 14, 82, 16);
		
		textField_readerName = new JTextField();
		textField_readerName.setFont(new Font("宋体", Font.PLAIN, 14));
		textField_readerName.setBounds(321, 11, 91, 21);
		textField_readerName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("学院：");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(251, 78, 60, 18);
		
		textField_college = new JTextField();
		textField_college.setFont(new Font("宋体", Font.PLAIN, 14));
		textField_college.setBounds(321, 76, 91, 21);
		textField_college.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("性别：");
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 77, 53, 21);
		
		textField_phoneNumber = new JTextField();
		textField_phoneNumber.setFont(new Font("宋体", Font.PLAIN, 14));
		textField_phoneNumber.setBounds(321, 142, 91, 22);
		textField_phoneNumber.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("读者证号：");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(10, 13, 84, 21);
		
		JLabel lblNewLabel_5 = new JLabel("电话号码：");
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
		
		textField_readerId = new JTextField();
		textField_readerId.setFont(new Font("宋体", Font.PLAIN, 14));
		textField_readerId.setBounds(104, 11, 91, 21);
		textField_readerId.setColumns(10);
		
		textField_sex = new JTextField();
		textField_sex.setFont(new Font("宋体", Font.PLAIN, 14));
		textField_sex.setBounds(104, 76, 91, 21);
		textField_sex.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("入学日期：");
		lblNewLabel_6.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(10, 143, 84, 21);
		
		textField_enrollmentDate = new JTextField();
		textField_enrollmentDate.setFont(new Font("宋体", Font.PLAIN, 14));
		textField_enrollmentDate.setBounds(104, 142, 91, 21);
		textField_enrollmentDate.setColumns(10);
		getContentPane().setLayout(null);
		getContentPane().add(textField_sex);
		getContentPane().add(lblNewLabel_6);
		getContentPane().add(textField_enrollmentDate);
		getContentPane().add(lblNewLabel_2);
		getContentPane().add(lblNewLabel_4);
		getContentPane().add(textField_readerId);
		getContentPane().add(lblNewLabel_1);
		getContentPane().add(textField_college);
		getContentPane().add(textField_phoneNumber);
		getContentPane().add(lblNewLabel);
		getContentPane().add(textField_readerName);
		getContentPane().add(btnNewButton);
		getContentPane().add(btnNewButton_1);
		getContentPane().add(lblNewLabel_5);
		
		JLabel label = new JLabel("充值金额：");
		label.setFont(new Font("Dialog", Font.PLAIN, 14));
		label.setBounds(104, 202, 82, 18);
		getContentPane().add(label);
		
		textField_balance = new JTextField();
		textField_balance.setFont(new Font("宋体", Font.PLAIN, 14));
		textField_balance.setColumns(10);
		textField_balance.setBounds(198, 200, 91, 21);
		getContentPane().add(textField_balance);
				
	}
	/**
	 * 重置事件处理
	 * @param e
	 */
	private void bookValueActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.resetValue();
	}

	private void bookAddActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		long readerId = Long.valueOf(this.textField_readerId.getText());
		String readerName = this.textField_readerName.getText();
		String sex = this.textField_sex.getText();
		String college = this.textField_college.getText();
		String enrollmentDateStr = this.textField_enrollmentDate.getText();
		@SuppressWarnings("deprecation")
		Date enrollmentDate = new Date(
				Integer.valueOf(enrollmentDateStr.substring(0, 4)) - 1900,
				Integer.valueOf(enrollmentDateStr.substring(5, 7)) - 1,
				Integer.valueOf(enrollmentDateStr.substring(8, 10)));
		
		String phoneNumber = this.textField_phoneNumber.getText();
		double balance = Double.valueOf(this.textField_balance.getText());
		Date recordDate = new Date(System.currentTimeMillis());
		 Connection con = null;
	        try{
	        	con=dbUtil.getCon();
	        	Reader reader = new Reader(readerId, readerName, sex, college, enrollmentDate, phoneNumber, balance, recordDate);
	        	if(readerDao.add(con, reader)) {
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
		this.textField_readerId.setText("");
		this.textField_readerName.setText("");
		this.textField_sex.setText("");
		this.textField_college.setText("");
		this.textField_enrollmentDate.setText("");
		this.textField_phoneNumber.setText("");
		this.textField_balance.setText("");
	}
	
}

		
	