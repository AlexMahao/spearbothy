package com.spearbothy.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestWrapper;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncodeFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		chain.doFilter(new EncodeRequest((HttpServletRequest) request), response);
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
	}

}

class EncodeRequest extends HttpServletRequestWrapper {

	private ServletRequest request;

	public EncodeRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}

	@Override
	public String getParameter(String name) {
		return getParameterValues(name)[0];
	}

	@Override
	public String[] getParameterValues(String name) {
		return getParameterMap().get(name);
	}

	private boolean flag = true;

	@Override
	public Map<String, String[]> getParameterMap() {
		Map<String, String[]> map = this.request.getParameterMap();
		if (flag) {
			for (String key : map.keySet()) {
				String[] array = map.get(key);
				for (int i = 0; i < array.length; i++) {
					try {
						array[i] = new String(array[i].getBytes("iso-8859-1"), "utf-8");
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			flag = false;
		}

		return map;
	}
}
