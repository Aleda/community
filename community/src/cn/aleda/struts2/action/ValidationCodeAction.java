package cn.aleda.struts2.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.net.HttpCookie;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

public class ValidationCodeAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware {
	private HttpServletRequest request;
	private HttpServletResponse response;
	private final String codeChars = "1234567890qwertyuiopasdfghjklzxcvbnm";
	private String code;
	
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public Color getColor(int minColor, int maxColor) {
		Random random = new Random();
		int red = minColor + random.nextInt(maxColor - minColor);
		int green = minColor + random.nextInt(maxColor - minColor);
		int blue = minColor + random.nextInt(maxColor - minColor);
		return new Color(red, green, blue);
	}
	
	public String execute() throws Exception {
		//下面3条记录是关闭客户端浏览器的缓冲区
		response.setHeader("ragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		
		int width = 90;
		int height = 33; //设置图像的大小；
		
		//
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		Graphics g = img.getGraphics();
		
		Random random = new Random();
		
		g.fillRect(0, 0, width, height);
		g.setFont(new Font("Times New Roman", Font.ITALIC, height));
		g.setColor(getColor(160, 180));
		
		StringBuilder validatorCode = new StringBuilder();
		
		//设置随机字体
		String[] fontNames = {"Times New Roman", "Consolas", "Arial"};
		
		for (int i = 0; i < 4; i++) {
			//获取随机的字体
			g.setFont(new Font(fontNames[random.nextInt(3)], Font.ITALIC, height));
			//获取随机的字符
			char codeChar = codeChars.charAt(random.nextInt(codeChars.length()));
			//将字符存起来
			validatorCode.append(codeChar);
			//绘制字符
			g.setColor(getColor(0, 255));
			g.drawString(String.valueOf(codeChar), 16 * i + random.nextInt(7),
					height - random.nextInt(5));
		}
		HttpSession session = request.getSession();
		Cookie cookie = new Cookie("validationcode", validatorCode.toString());
		response.addCookie(cookie);
		setCode(validatorCode.toString());
		System.out.println("code = " + getCode());
		session.setAttribute("validatorCode", validatorCode.toString());
		session.setMaxInactiveInterval(5 * 60); //设置session对象五分钟失效
		g.dispose();//关闭Graphics对象
		
		OutputStream output = response.getOutputStream();
		ImageIO.write(img, "JPEG", output);
		
		return null;
	}
}
