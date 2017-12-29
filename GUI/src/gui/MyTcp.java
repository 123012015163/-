package gui;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

import javax.swing.*;
import javax.swing.border.*;

public class MyTcp extends JFrame{
	private PrintWriter writer; // 声明PrintWriter类对象
	private BufferedReader reader;
	private ServerSocket server;
	private Socket socket;
	private JTextArea ta = new JTextArea(); // 创建JtextArea对象
	private JTextField tf = new JTextField(); // 创建JtextField对象
	Container cc; // 声明Container对象
	
	public MyTcp(String title){
		super(title);
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
	
	void getserver(){
		try{
			server = new ServerSocket(8998);
			ta.append("服务器套接字已经创建成功\n");
			
			while(true){
				ta.append("等待客户机的连接\n");
				socket=server.accept();
				writer = new PrintWriter(socket.getOutputStream(), true);
				reader =new BufferedReader(new InputStreamReader(socket.getInputStream()));
				getClientMessage();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	private void getClientMessage() {
		try{
			while(true){
				ta.append("客户机："+reader.readLine()+"\n");
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
	
	public static void main(String[]args){
		MyTcp tcp = new MyTcp("向客户端发送消息");
		tcp.setSize(400, 400);//设置窗口大小
		tcp.setVisible(true);//将窗体显示
		tcp.getserver();
	}
}
