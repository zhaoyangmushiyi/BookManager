package com.Monochrome.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.Monochrome.dao.ManagerDao;
import com.Monochrome.util.DbUtil;
import com.Monochrome.util.StringUtil;


@SuppressWarnings("serial")
public class LogOnFrm extends JFrame {

	private JPanel contentPane;
	private final JTextField textField = new JTextField();
	private JPasswordField passwordTxt;
	
	private DbUtil dbUtil = new DbUtil();
	private ManagerDao managerDao = new ManagerDao();
	private JTextField userNameTxt;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogOnFrm frame = new LogOnFrm();
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
	public LogOnFrm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
		setTitle("管理员登录");
		setBounds(100, 100, 443, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("图书管理系统");
		label.setFont(new Font("黑体", Font.BOLD, 25));
		label.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/book.png")));
		
		JLabel lblNewLabel = new JLabel("用户名：");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 13));
		lblNewLabel.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/user.png")));
		
		JLabel lblNewLabel_1 = new JLabel("密  码：");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 13));
		lblNewLabel_1.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/password.png")));
		textField.setColumns(10);
		
		passwordTxt = new JPasswordField();
		
		JButton btnNewButton = new JButton("登录");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    loginActionPerformed(e);	
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 13));
		
		btnNewButton.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/login.png")));
		
		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 13));
		btnNewButton_1.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/reset.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		
		userNameTxt = new JTextField();
		userNameTxt.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
								.addGap(223))
							.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
								.addContainerGap(79, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnNewButton))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(userNameTxt, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
											.addComponent(passwordTxt, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
										.addPreferredGap(ComponentPlacement.RELATED))
									.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
										.addComponent(btnNewButton_1)
										.addGap(30)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(52)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)))
					.addGap(82))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(label)
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordTxt))
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(76))
		);
		contentPane.setLayout(gl_contentPane);
		
		//设置居中显示
		this.setLocationRelativeTo(null);
	}
	
    /**
     * 登录事件处理
     * @param e
     */
	protected void loginActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String userName = this.userNameTxt.getText();
		String password = new String(this.passwordTxt.getPassword());
		if(StringUtil.isEmpty(userName)){
			JOptionPane.showMessageDialog(this,"用户名不能为空");
			return;
		}
		if(StringUtil.isEmpty(password)){
			JOptionPane.showMessageDialog(this,"密码不能为空");
			return;
		}
		Connection con = null;
		try{
			con = dbUtil.getCon();
			if(managerDao.isExit(con, userName, password)){
				//JOptionPane.showMessageDialog(null,"登录成功");	
			    dispose();
			    new MainFrm().setVisible(true);
			}else{
				JOptionPane.showMessageDialog(this,"用户名密码错误");
			}
			
		}catch(Exception e1){
			e1.printStackTrace();
			
		}
		
	}

	/**
     * 重置事件处理
     * @param evt
     */
    
	private void resetValueActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		this.userNameTxt.setText("");
		this.passwordTxt.setText("");
	}
}
