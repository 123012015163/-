package gui;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

import javax.swing.*;
import javax.swing.border.*;

public class MyClient extends JFrame { // 创建类继承JFrame类
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PrintWriter writer; // 声明PrintWriter类对象
	Socket socket; // 声明Socket对象
	private BufferedReader reader;
	private JTextArea ta = new JTextArea(); // 创建JtextArea对象，TextArea 是一个显示纯文本的多行区域。
	private JTextField tf = new JTextField(); // 创建JtextField对象，允许编辑单行文本
	Container cc; // 声明Container对象，要想new个窗口界面…就必须用到container这个容器
	
	public MyClient(String title) { // 构造方法
		super(title); // 调用父类的构造方法
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cc = this.getContentPane(); // 实例化对象

		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new BevelBorder(BevelBorder.RAISED));
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportView(ta);
		cc.add(tf, "South"); // 将文本框放在窗体的下部
		tf.addActionListener(new ActionListener() {
			// 绑定事件
			public void actionPerformed(ActionEvent e) {
				// 将文本框中信息写入流
				writer.println(tf.getText());
				// 将文本框中信息显示在文本域中
				ta.append(tf.getText() + '\n');
				ta.setSelectionEnd(ta.getText().length());
				tf.setText(""); // 将文本框清空
			}
		});
	}
	
	private void connect() { // 连接套接字方法
		ta.append("尝试连接\n"); // 文本域中提示信息
		try { // 捕捉异常
			socket = new Socket("127.0.0.1", 8998); // 实例化Socket对象
			ta.append("完成连接\n"); // 文本域中提示信息
			while(true){	
				writer = new PrintWriter(socket.getOutputStream(), true);
				reader =new BufferedReader(new InputStreamReader(socket.getInputStream()));
				getClientMessage();
			}
		} catch (Exception e) {
			e.printStackTrace(); // 输出异常信息
		}
	}
	
	private void getClientMessage() {
		try{
			while(true){
				ta.append("服务器："+reader.readLine()+"\n");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			if(reader!=null){
				reader.close();
			}
			if(socket!=null){
				socket.close();
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) { // 主方法
		MyClient client = new MyClient("向服务器送数据"); // 创建本例对象
		client.setSize(500, 500); // 设置窗体大小
		client.setVisible(true); // 将窗体显示
		client.connect(); // 调用连接方法
	}
}

