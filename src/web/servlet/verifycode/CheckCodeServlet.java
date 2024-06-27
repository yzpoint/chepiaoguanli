package web.servlet.verifycode;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 验证码
 */
@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		//服务器通知浏览器不要缓存
		response.setHeader("pragma","no-cache");
		response.setHeader("cache-control","no-cache");
		response.setHeader("expires","0");

		//在内存中创建一个长80，宽30的图片，默认黑色背景
		//参数一：长
		//参数二：宽
		//参数三：颜色
		int width = 136;
		int height = 38;
		BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

		//获取画笔
		Graphics g = image.getGraphics();
		//设置画笔颜色为灰色
		g.setColor(Color.GRAY);
		//填充图片
		g.fillRect(0,0, width,height);

		//产生4个随机验证码，12Ey
		String checkCode = getCheckCode();
		//将验证码放入HttpSession中
		request.getSession().setAttribute("CHECKCODE_SERVER",checkCode);

		//设置画笔颜色为黄色
		g.setColor(Color.YELLOW);
		//设置字体的小大
		g.setFont(new Font("黑体",Font.BOLD,30));
		//向图片上写入验证码
		g.drawString(checkCode,36,28);

		//将内存中的图片输出到浏览器
		//参数一：图片对象
		//参数二：图片的格式，如PNG,JPG,GIF
		//参数三：图片输出到哪里去
		ImageIO.write(image,"PNG",response.getOutputStream());
	}
	/**
	 * 产生4位随机字符串 
	 */
	private String getCheckCode() {
		String base = "23456789ABCDEFGHJKMNPQRSTUVWXYZabcdefghjkmnpqrstuvwxyz";
		int size = base.length();
		Random r = new Random();
		StringBuffer sb = new StringBuffer();
		for(int i=1;i<=4;i++){
			//产生0到size-1的随机值
			int index = r.nextInt(size);
			//在base字符串中获取下标为index的字符
			char c = base.charAt(index);
			//将c放入到StringBuffer中去
			sb.append(c);
		}
		return sb.toString();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request,response);
	}
}
//doGet 方法处理GET请求。首先设置响应头部，告诉浏览器不要缓存该验证码图片。
//创建一个宽度为136，高度为38的 BufferedImage 对象作为验证码图片。
//获取 Graphics 对象用于绘制图形，并设置背景色为灰色，填充整个图片。
//调用 getCheckCode() 方法生成一个4位的随机验证码 (checkCode)。
//将生成的验证码存入Session中，键名为 CHECKCODE_SERVER，以便后续的验证码验证。
//设置画笔颜色为黄色，设置字体为黑体粗体，绘制验证码文字到图片上。
//最后使用 ImageIO.write() 将生成的验证码图片以PNG格式写入到响应的输出流中，返回给浏览器显示。
//getCheckCode 方法生成一个由大小写字母和数字组成的随机4位验证码。
//doPost 方法直接调用了 doGet 方法，确保无论是GET还是POST请求，最终都会执行生成验证码的逻辑。

