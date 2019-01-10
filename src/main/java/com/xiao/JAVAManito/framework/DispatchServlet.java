/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.xiao.JAVAManito.framework;

import com.alibaba.fastjson.JSON;
import com.xiao.JAVAManito.framework.helper.BeanHelper;
import com.xiao.JAVAManito.framework.helper.ControllerHelper;
import com.xiao.JAVAManito.framework.helper.LoaderHelper;
import com.xiao.JAVAManito.framework.util.ReflectionUtil;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * MVC 框架请求转发
 *
 * @author xiaomengning
 * @version $Id: DispatchServlet.java, v 0.1 2019年01月07日 21:29 xiaomengning Exp $
 */
@WebServlet(urlPatterns = "/*", loadOnStartup = 0)
public class DispatchServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        //初始化 所有helper类
        LoaderHelper.init();
        super.init(config);
    }

    /**
     * 框架请求转发 核心逻辑
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestMethod = req.getMethod().toLowerCase();
        String requestPath = req.getPathInfo();

        //Action 处理器

        Handler handler = ControllerHelper.getHandler(requestMethod, requestPath);

        if (handler != null) {
            Class<?> controllerClass = handler.getControllerClass();
            Object controllerBean = BeanHelper.getBeanInstance(controllerClass);
            Map<String, Object> paramMap = new HashMap<>();

            Enumeration<String> parameterNames = req.getParameterNames();
            while (parameterNames.hasMoreElements()) {
                String paramName = parameterNames.nextElement();
                String paramValue = req.getParameter(paramName);
                paramMap.put(paramName, paramValue);
            }

            //根据业务需要 是否需要解析 请求body
            Param param = new Param(paramMap);


            //调用action方法,得到请求的执行结果
            Method actionMethod = handler.getActionMethod();
            Object result = ReflectionUtil.invokeMethod(controllerBean, actionMethod, paramMap);


            //  处理 返回结果
            if(result instanceof Result){
                    //返回json
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                PrintWriter pw = resp.getWriter();
                String jsonData = JSON.toJSONString(result);
                pw.write(jsonData);
                pw.flush();
                pw.close();
            }
            
        }

    }
}