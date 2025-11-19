package utils;

import jakarta.servlet.jsp.JspWriter;

// 메시지 알림창을 띄우고 페이지 이동
public class JSFunction {
	
	public static void alertLocation(String msg, String url, JspWriter out) {
		try {
			String script = "<script>"
							+ "	alert('" + msg + "');"
							+ " location.href='" + url +"';"
							+ "</script>";
			out.println(script);
		} catch(Exception e) {}
	}
	
	public static void alertBack(String msg, JspWriter out) {
		try {
			String script = "<script>"
							+ "	alert('" + msg + "');"
							+ " history.back();"
							+ "</script>";
			out.println(script);
		} catch(Exception e) {}
	}
}
