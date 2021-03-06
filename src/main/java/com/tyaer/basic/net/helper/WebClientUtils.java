package com.tyaer.basic.net.helper;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.util.Cookie;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;

import java.util.Set;

/**
 * cookie获取根据
 * 
 * @author Twin
 *
 */
public class WebClientUtils {

	protected static Logger LOGGER = Logger.getLogger(WebClientUtils.class
			.getName());
	
	private WebClient _WebClient = null;
	
	public WebClientUtils() {
		_WebClient = new WebClient(BrowserVersion.FIREFOX_38);
		// htmlunit 对css和javascript的支持不好，所以请关闭之。url为JS请求则必须打开！
		_WebClient.getOptions().setJavaScriptEnabled(false);
		_WebClient.getOptions().setCssEnabled(false);
	}

	public String getCookie(String str_url) {
		Set<Cookie> set_cookies = null;
		String str_cookie = "";
		Page page =null;
		try {
			// 先得到page,才能拿到cookie
		    page = _WebClient.getPage(str_url);
//			URL url_urlReq = new URL(str_url);
//			set_cookies = _WebClient.getCookies(url_urlReq);
			set_cookies = _WebClient.getCookieManager().getCookies();
			if (set_cookies!=null) {
				str_cookie = getCookieHeader(set_cookies);
			}
		} catch (Exception e) {
			LOGGER.error("_getCookie请求错误：" + str_url);
			LOGGER.error(ExceptionUtils.getMessage(e));
		} finally {
			if (page != null) {
				page.cleanUp();
			}
		}
		return str_cookie;
	}
	
	/**
	 * 关闭WebClient
	 */
	@SuppressWarnings("deprecation")
//	public void colseWebClient() {
//		if(_WebClient!=null){
//			_WebClient.close();
//			_WebClient.closeAllWindows();
//		}
//	}

	/**
	 * 格式化cookie
	 */
	public static String getCookieHeader(Set<Cookie> cookies) {
		StringBuilder cookieBuilder = new StringBuilder();
		for (Cookie cookie : cookies) {
			cookieBuilder.append(cookie.getName() + "=" + cookie.getValue()
					+ ";");
		}
		String cookieStr = "";
		// 去除最后的;
		if (cookieBuilder.length() > 0) {
			cookieStr = cookieBuilder.substring(0, cookieBuilder.length() - 1);
		}
		return cookieStr;
	}

	/**
	 * 网站基本信息展示
	 * 
	 * @param str_url
	 */
	public static void showBaseInfo(String str_url) {
		WebClient _WebClient = new WebClient();
		// htmlunit 对css和javascript的支持不好，所以请关闭之。JS请求必须打开！
		_WebClient.getOptions().setJavaScriptEnabled(false);
		_WebClient.getOptions().setCssEnabled(false);
		// 获取页面
		HtmlPage page = null;
		try {
			page = _WebClient.getPage(str_url);
		} catch (Exception e) {
			LOGGER.error(ExceptionUtils.getMessage(e));
		} finally {
			if (_WebClient != null) {
				_WebClient.close();
			}
		}
		// 获取页面的TITLE
		String str_title = page.getTitleText();
		System.out.println("标题：" + str_title);
		// 获取页面的XML代码
		String str_html = page.asXml();
		System.out.println("XML:" + str_html);
		// 获取页面的文本
		String str_text = page.asText();
		System.out.println("html:" + str_text);

		String str_textContent = page.getTextContent();
		System.out.println("TextContent:" + str_textContent);
	}

	public String getHtml(String url){
		WebClient _WebClient = new WebClient();
		// htmlunit 对css和javascript的支持不好，所以请关闭之。JS请求必须打开！
		_WebClient.getOptions().setJavaScriptEnabled(false);
		_WebClient.getOptions().setCssEnabled(false);
		// 获取页面
		HtmlPage page = null;
		try {
			page = _WebClient.getPage(url);
		} catch (Exception e) {
			LOGGER.error(ExceptionUtils.getMessage(e));
		} finally {
			if (_WebClient != null) {
				_WebClient.close();
			}
		}
		String str_html = page.asXml();
		System.out.println("XML:" + str_html);
		return str_html;
	}

	public static void main(String[] args) {
		// String url="https://www.baidu.com/";
		WebClientUtils util = new WebClientUtils();
//		String str_url = "http://weixin.sogou.com/gzh?openid=oIWsFt4JERI6aVU7J1rs8Dt3KXGI&ext=_L45N5QlA_UKT-ub2PvBariKo4q1GneO27SYX3LrolBwYHVDZU1rm_CRFk9m4Hy8";
		String str_url = "https://itravel.hwht.com/hotel/detail/100001418?s=08dd2aaca1015a382a8f970a740e794a";

//		String str_cookie = util.getCookie(str_url);
//		System.out.println("Cookie:" + str_cookie);
		util.getCookie(str_url);
		util.getHtml(str_url);
	}
}
