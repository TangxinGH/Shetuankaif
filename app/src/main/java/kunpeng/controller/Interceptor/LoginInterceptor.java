package kunpeng.controller.Interceptor;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


import org.springframework.web.servlet.ModelAndView;

/**
 * 登录拦截器
 * @author Administrator
 *
 */
@Component
public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
//        System.out.println("执行了TestInterceptor的preHandle方法");
		try {
			//统一拦截（查询当前session是否存在user）(这里user会在每次登陆成功后，写入session)
			User user=(User)request.getSession().getAttribute("USER");
			if(user!=null){
				return true;
			}
			response.sendRedirect(request.getContextPath()+"/api/login");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;//如果设置为false时，被请求时，拦截器执行到此处将不会继续操作
		//如果设置为true时，请求将会继续执行后面的操作
	}

	/**
	 * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
//         System.out.println("执行了TestInterceptor的postHandle方法");
	}

	/**
	 * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
//        System.out.println("执行了TestInterceptor的afterCompletion方法");
	}
}
