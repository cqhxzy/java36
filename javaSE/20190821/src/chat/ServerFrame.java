package chat;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 服务端窗口
 * @author Administrator
 *
 */
public class ServerFrame extends JFrame {

	private JPanel contentPane; //显示面板

	private TCPServer server;
	private JButton btnStart; //启动监听按钮
	private JButton btnStop;  //停止监听按钮
	private JTextArea textArea; //显示交互信息的文本域

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerFrame frame = new ServerFrame(); //打开窗口
					frame.setVisible(true); //设置窗口可见
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ServerFrame() {
		setTitle("服务器端");
		// 实例化TCPServer对象
		server = new TCPServer(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 10, 424, 276);
		contentPane.add(scrollPane);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		btnStart = new JButton("启动监听");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 启动监听的单机事件
				server.startListener();// 启动监听
				if (server.isStart()) {
					btnStart.setEnabled(false);// 让启动监听按钮禁用
					btnStop.setEnabled(true);// 让停止监听按钮启用
					LogUtils.showLog("启动监听成功", textArea);
				} else {
					LogUtils.showLog("停止监听失败", textArea);
				}

			}
		});
		btnStart.setBounds(10, 306, 93, 23); //设置button的位置，宽高
		contentPane.add(btnStart);

		btnStop = new JButton("停止监听");
		btnStop.setEnabled(false);  //禁用停止监听按钮
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 停止监听
				// 启动监听的单机事件
				server.stopListener();// 启动监听
				if (!server.isStart()) {
					btnStart.setEnabled(true);// 让启动监听按钮启用
					btnStop.setEnabled(false);// 让停止监听按钮禁用
					LogUtils.showLog("停止监听成功", textArea);

				} else {
					LogUtils.showLog("停止监听失败", textArea);
				}
			}
		});
		btnStop.setBounds(128, 306, 93, 23);
		contentPane.add(btnStop);

		JButton btnExit = new JButton("退出");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 退出
				System.exit(0);
			}
		});
		btnExit.setBounds(331, 306, 93, 23);
		contentPane.add(btnExit);
	}

	/************* getter and setter ************************************/
	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

}