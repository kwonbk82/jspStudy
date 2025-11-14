package utils;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

public class CookieManager {
// 쿠키생성
	public static void makeCookie(HttpServletRequest response, String cName, String cValue, int cTime) {
		Cookie cookie = new Cookie(cName,cValue);
		cookie.setPath("/");
		cookie.setMaxAge(cTime);
		response.addCookie(cookie);
	}
	
//	읽어오기
	public static String readCookie(HttpServletRequest request, String cName) {
		String cookieValue = "";
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie c :cookies) {
				String cookieName = c.getName();
				if(cookieName.equals(cName)) {
					cookieValue = c.getValue();
				}
			}
		}
	}
	public static void deleteCookie(HttpServletRequest response, String cName) {
		makeCookie(response,cName,"",0);
	}
}
