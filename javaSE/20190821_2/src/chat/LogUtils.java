package chat;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogUtils {
	//用于将信息存入文本框
	public static void showLog(String str, JTextArea area) {
		// 获取系统当前时间
		Date now = new Date();
		//格式化时间格式
		String time = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(now);
		//获取文本框之前的内容
		String oldContent=area.getText();
		//需要新加入的内容
		String newContent=time+"---"+str;
		area.setText(oldContent+"\n"+newContent);
	}
}
