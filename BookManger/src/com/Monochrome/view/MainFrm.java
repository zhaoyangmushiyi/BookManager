package com.Monochrome.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Font;

@SuppressWarnings("serial")
public class MainFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
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
	public MainFrm() {
		setTitle("图书管理主界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 800);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("菜单");
		menu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/base.png")));
		menuBar.add(menu);
		
		JMenu mnNewMenu_1 = new JMenu("图书");
		mnNewMenu_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookManager.png")));
		menu.add(mnNewMenu_1);
		
		JMenuItem menuItem_1 = new JMenuItem("图书添加");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookAddInterFrm bookAddInterFrm = new BookAddInterFrm();
				bookAddInterFrm.setVisible(true);
			    table.add(bookAddInterFrm);
			    bookAddInterFrm.toFront();
			}
		});
		menuItem_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/books_16px.png")));
		mnNewMenu_1.add(menuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("图书管理");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookManageInterFrm bookManagerInterFrm = new BookManageInterFrm();
				bookManagerInterFrm.setVisible(true);
			    table.add(bookManagerInterFrm);
			    bookManagerInterFrm.toFront();
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/booksM_16px.png")));
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenuItem menuItem_3 = new JMenuItem("安全退出");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    int result = JOptionPane.showConfirmDialog(null,"是否退出系统");
			    if (result == 0) {
					System.exit(0);
				}
			}
		});
		
		JMenu mnNewMenu = new JMenu("读者");
		mnNewMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add_user.png")));
		menu.add(mnNewMenu);
		
		JMenuItem menuItem = new JMenuItem("读者添加");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReaderAddInterFrm readerAddInterFrm = new ReaderAddInterFrm();
				readerAddInterFrm.setVisible(true);
			    table.add(readerAddInterFrm);
			    readerAddInterFrm.toFront();
			}
		});
		menuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/users_add_16px.png")));
		mnNewMenu.add(menuItem);
		
		JMenuItem menuItem_2 = new JMenuItem("读者管理");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReaderManageInterFrm readerManageInterFrm = new ReaderManageInterFrm();
				readerManageInterFrm.setVisible(true);
			    table.add(readerManageInterFrm);
				readerManageInterFrm.toFront();
			}
		});
		menuItem_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/user_Options_16px.png")));
		mnNewMenu.add(menuItem_2);
		
		JMenuItem menuItem_4 = new JMenuItem("借阅信息");
		menuItem_4.setIcon(new ImageIcon(MainFrm.class.getResource("/images/txt_text_16px.png")));
		menu.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("罚单信息");
		menuItem_5.setIcon(new ImageIcon(MainFrm.class.getResource("/images/Warning_16px.png")));
		menu.add(menuItem_5);
		menuItem_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/close_16px.png")));
		menu.add(menuItem_3);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
        table = new JDesktopPane();		
		table.setBackground(Color.WHITE);
		contentPane.add(table);
		
		JButton btnNewButton = new JButton("添加图书");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookAddInterFrm bookAddInterFrm = new BookAddInterFrm();
				bookAddInterFrm.setVisible(true);
			    table.add(bookAddInterFrm);
			    bookAddInterFrm.toFront();
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setIcon(new ImageIcon(MainFrm.class.getResource("/images/books_128px.png")));
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 28));
		btnNewButton.setBounds(36, 29, 291, 131);
		table.add(btnNewButton);
		
		JButton button = new JButton("图书管理");
		button.setIcon(new ImageIcon(MainFrm.class.getResource("/images/booksM_128px.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookManageInterFrm bookManagerInterFrm = new BookManageInterFrm();
				bookManagerInterFrm.setVisible(true);
			    table.add(bookManagerInterFrm);
			    bookManagerInterFrm.toFront();
			}
		});
		button.setForeground(Color.BLACK);
		button.setFont(new Font("宋体", Font.PLAIN, 28));
		button.setBounds(377, 29, 291, 131);
		table.add(button);
		
		JButton button_1 = new JButton("添加读者");
		button_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/users_add_128px.png")));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReaderAddInterFrm readerAddInterFrm = new ReaderAddInterFrm();
				readerAddInterFrm.setVisible(true);
			    table.add(readerAddInterFrm);
			    readerAddInterFrm.toFront();
			}
		});
		button_1.setForeground(Color.BLACK);
		button_1.setFont(new Font("宋体", Font.PLAIN, 28));
		button_1.setBounds(36, 186, 291, 131);
		table.add(button_1);
		
		JButton button_2 = new JButton("读者管理");
		button_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/user_Options_128px.png")));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReaderManageInterFrm readerManageInterFrm = new ReaderManageInterFrm();
				readerManageInterFrm.setVisible(true);
				table.add(readerManageInterFrm);
				readerManageInterFrm.toFront();
			}
		});
		button_2.setForeground(Color.BLACK);
		button_2.setFont(new Font("宋体", Font.PLAIN, 28));
		button_2.setBounds(377, 186, 291, 131);
		table.add(button_2);
		
		JButton button_3 = new JButton("借阅信息");
		button_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/lend.png")));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LendInfoManageInterFrm lendInfoInterFrm = new LendInfoManageInterFrm();
				lendInfoInterFrm.setVisible(true);
				table.add(lendInfoInterFrm);
				lendInfoInterFrm.toFront();
			}
		});
		button_3.setForeground(Color.BLACK);
		button_3.setFont(new Font("宋体", Font.PLAIN, 28));
		button_3.setBounds(377, 347, 291, 131);
		table.add(button_3);
		
		JButton button_4 = new JButton("罚单信息");
		button_4.setIcon(new ImageIcon(MainFrm.class.getResource("/images/Warning_128px.png")));
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		button_4.setForeground(Color.BLACK);
		button_4.setFont(new Font("宋体", Font.PLAIN, 28));
		button_4.setBounds(712, 29, 291, 131);
		table.add(button_4);
		
		JButton button_5 = new JButton("退出系统");
		button_5.setIcon(new ImageIcon(MainFrm.class.getResource("/images/close_128px.png")));
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null,"是否退出系统");
				System.out.println(result);
				if (result == 0) {
					System.exit(0);
				}
			}
		});
		button_5.setForeground(Color.BLACK);
		button_5.setFont(new Font("宋体", Font.PLAIN, 28));
		button_5.setBounds(712, 347, 291, 130);
		table.add(button_5);
		
		JButton button_6 = new JButton("订阅图书");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LendInfoAddInterFrm lendInfoAddInterFrm = new LendInfoAddInterFrm();
				lendInfoAddInterFrm.setVisible(true);
				table.add(lendInfoAddInterFrm);
				lendInfoAddInterFrm.toFront();
			}
		});
		button_6.setIcon(new ImageIcon(MainFrm.class.getResource("/images/txt_text_72px.png")));
		button_6.setForeground(Color.BLACK);
		button_6.setFont(new Font("宋体", Font.PLAIN, 28));
		button_6.setBounds(36, 347, 291, 131);
		table.add(button_6);
	}
}
