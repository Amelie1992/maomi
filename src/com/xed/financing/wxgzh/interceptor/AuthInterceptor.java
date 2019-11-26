package com.xed.financing.wxgzh.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;

/**
 * 
 * @className:com.xed.financing.wxgzh.interceptor.AuthInterceptor
 * @description:
 * @version:v1.0.0
 * @date:2017年5月3日 上午11:22:34
 * @author:WangJun
 */
@Component("SpringMVCInterceptor")
public class AuthInterceptor extends HandlerInterceptorAdapter
{

	private static final String[] IGNORE_URI = {"crowdfund/buycrowfund","/subject/checkMoney","/s/","/ios/","/images/","/js/","/css/","/toPayExport","/toPayNetExport","/paymentSuccess","/paymentError","/audio/"};
	
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag = false;
        String url = request.getRequestURL().toString() +  "?" + request.getQueryString();
        //System.out.println(">>>: " + url);
        for (String s : IGNORE_URI) {
            if (url.contains(s)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
        	AccountInfo accountInfo = (AccountInfo) request.getSession().getAttribute("account");
            if (accountInfo != null) flag = true;
        }
        
        if(flag){
        	return flag;
        }
        String toUrl = url.substring(0,url.lastIndexOf("xed_financing_wxgzh"))+"xed_financing_wxgzh/loginregister/s/toLogin";
        //System.out.println(toUrl);
        //System.out.println("url:" + url);
        request.getSession().setAttribute("lastPath", url);
        response.sendRedirect(toUrl);
        return flag;
    }
	
	@Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }
	
	
	/*private HashMap<String, String> urlMap = new HashMap<String, String>()
	{

		*//**
		 * sss
		 *//*
		private static final long serialVersionUID = 1L;

		{
			put("/loginregister/login", "1");
			put("/", "1");
		}
	};

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse rsp, Object handler) throws Exception
	{
		String requestUri = req.getRequestURI().replace("/xed_financing_wxgzh", "");

		if (StringTools.isNullOrEmpty(urlMap.get(requestUri)))
		{
			AccountInfo bean = (AccountInfo) req.getSession().getAttribute("account");
			if (StringTools.isNullOrEmpty(bean))
			{

				// return new ModelAndView("redirect:" +
				// UserConstants.LOGIN_URL);
				if (isAjax(req))
				{
					rsp.setHeader("sessionstatus", "timeout");// 在响应头设置session状态
					return false;
				}
				else
				{
					req.getSession().setAttribute("pre", requestUri + "?" + req.getQueryString());
					rsp.sendRedirect("../loginregister/login");
					return false;
				}
			}
		}
		return true;
	}

	public boolean isAjax(HttpServletRequest request)
	{
		return (request.getHeader("X-Requested-With") != null && "XMLHttpRequest".equals(request.getHeader(
				"X-Requested-With").toString()));
	}*/
}
