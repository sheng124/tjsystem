package com.tjsystem.interceptor;

import com.tjsystem.utils.JwtAndLoginUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginCheckInterceptor implements HandlerInterceptor{
    @Override//方法1：Controller运行前执行，true放行，false拦截
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle...");

        //1.判断请求是否是登录请求，如果是，直接放行
        String url= request.getRequestURI();
        System.out.println("url："+url);
        if(url.contains("/login")){
            return true;
        }
        //2.如果不是登录请求，获取令牌，判断令牌是否存在，如果不存在则不放行
        String token=request.getHeader("token");
        if(!StringUtils.hasLength(token)){
            JwtAndLoginUtils.writeResponse(response);
            return false;
        }
        //3.如果存在，对令牌进行解析，如果解析正确（不报错），则放行，否则不放行
        try{
            JwtAndLoginUtils.parseJWT(token);
            return true;
        }catch (Exception e){
            JwtAndLoginUtils.writeResponse(response);
            return false;
        }
    }

    @Override//方法2：Controller运行后执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle...");
    }

    @Override//方法3：视图渲染完成后运行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion...");
    }
}
