package com.jiaolin.sell.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Joinlin
 * @Descriptional:
 * @Date: Create in 8:22 2018/5/18
 * @Modify By:
 */
public class CookUtils {

	/**
	 * 设置cookie
	 *
	 * @param response
	 * @param name
	 * @param value
	 * @param maxAge   设置有效时间
	 */
	public static void set(HttpServletResponse response,
						   String name,
						   String value,
						   int maxAge) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(maxAge);
		cookie.setPath("/");
		response.addCookie(cookie);
	}


	/**
	 * 获取cookie
	 *
	 * @param request
	 * @param name    名字
	 * @return
	 */
	public static Cookie get(HttpServletRequest request,
							 String name) {
		Map<String, Cookie> cookieMap = readCookieMap(request);
		if (cookieMap.containsKey(name)) {
			return cookieMap.get(name);
		} else {
			return null;
		}

	}


	/**
	 * 把cookie封装成一个map
	 * @param request
	 * @return
	 */
	private static Map<String, Cookie> readCookieMap(HttpServletRequest request) {
		Map<String, Cookie> cookieMap = new HashMap<>();
		//获取cookie数组
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				cookieMap.put(cookie.getName(), cookie);
			}
		}
		return cookieMap;
	}
}
