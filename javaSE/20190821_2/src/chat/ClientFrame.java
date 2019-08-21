package chat;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;  //姓名文本框
	private JTextField txtMessage;//发送信息文本框
	private JTextArea textArea; //显示历史消息的文本域
	private TCPClient client;
	private 	JButton btnLink;//连接服务器按钮
	private JButton btnDisLink ;//断开连接按钮

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientFrame frame = new ClientFrame();
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
	public ClientFrame() {
		setTitle("我的客户端");
		// 实例化client对象
		client = new TCPClient(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 414, 255);
		contentPane.add(scrollPane);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		btnLink = new JButton("\u8FDE\u63A5\u670D\u52A1\u5668");
		btnLink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = ClientFrame.this.txtName.getText().trim();
				// 连接服务器
				client.connect();
				if (client.isConnect()) {
					// 连接服务器成功
					btnLink.setEnabled(false);//让连接服务器按钮禁用
					btnDisLink.setEnabled(true);//让断开服务器按钮启用
					System.out.println();
					LogUtils.showLog(name + ":连接服务器成功！", textArea);
				} else {
					LogUtils.showLog(name + ":连接服务器失败！", textArea);
				}
			}
		});
		btnLink.setBounds(10, 290, 105, 23);
		contentPane.add(btnLink);
		btnDisLink = new JButton("\u65AD\u5F00\u670D\u52A1\u5668");
		btnDisLink.setEnabled(false);
		btnDisLink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = ClientFrame.this.txtName.getText().trim();
				// 断开服务器
				client.disConnect();
				if (client.isConnect() == false) {
					btnLink.setEnabled(true);//让连接服务器按钮启用
					btnDisLink.setEnabled(false);//让断开服务器按钮禁用
					// 断开服务器成功
					LogUtils.showLog(name + ":断开服务器成功！", textArea);
				} else {
					LogUtils.showLog(name + ":断开服务器失败！", textArea);
				}
			}
		});
		btnDisLink.setBounds(125, 290, 107, 23);
		contentPane.add(btnDisLink);

		JLabel label = new JLabel("\u59D3\u540D\uFF1A");
		// label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(242, 290, 54, 23);
		contentPane.add(label);

		txtName = new JTextField();
		txtName.setText("\u6843\u592A\u90CE");
		txtName.setBounds(286, 291, 138, 21);
		contentPane.add(txtName);
		txtName.setColumns(10);

		txtMessage = new JTextField();
		txtMessage.setBounds(10, 323, 286, 36);
		contentPane.add(txtMessage);
		txtMessage.setColumns(10);

		JButton btnSend = new JButton("\u53D1\u9001");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 发送按钮
				client.send(txtName.getText().trim()+"  说："+txtMessage.getText().trim());
			}
		});
		btnSend.setBounds(296, 322, 128, 37);
		contentPane.add(btnSend);
	}
	/***********************getter    and     setter*************************************/
	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}




}