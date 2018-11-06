  package com.lanou3g.filter;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@WebFilter(filterName = "JsonCacheFilter", urlPatterns = "*.json")
/*
urlPatterns规则:
      /*  表示所有网址
      /abc/def/*  可以匹配/abc/def/xxx   /abc/def/ooo
      *.jsp  可以匹配: a.jsp  b.jsp ...
      * 要么就写一个具体的地址,只匹配一个
 */
// 遍历map  map的entrySet().for方法
public class JsonCacheFilter extends HttpFilter {

    private Map<String,String> cache = new HashMap<>();//new  HashTable  线程安全

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //转为线程安全的map
        cache = Collections.synchronizedMap(cache);
    }

    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain Chain) throws IOException, ServletException {
        /*
        要做的功能
        查询数据的时候,只有第一次请求  才会去数据库中做查询
        以后如果想请求同样的数据,从缓存中取
        根据请求的地址 和请求的参数就可以区分不同的数据,所以我们创建一个map用来
        缓存数据 ,key:网址和请求参数  value:对应的json数据
         */
        //问题:
        //1.如何生成这个key
        //key的规则:请求方法:url?请求参数
        //GET:sdf?key=value&key=value...
        resp.setContentType("application/json;charset=utf-8");
        String method = req.getMethod();
        if ("get".equalsIgnoreCase(method)){
            //如果是get请求才过滤
            String key = paresRequestToKey(req);
            String json = cache.get(key);
            if (json == null) {
                // 代表这个地址没有缓存
                // 放行
                HttpCacheResponse response = new HttpCacheResponse(resp);
                //把增强功能的response对象放行
                Chain.doFilter(req,response);//相当于执行doGat
                // 2.如何从响应中拿到数据
                String jsonData = response.getResponseBody();

                //拿到数据之后,存到cache中
                cache.put(key,jsonData);
                //把数据返回给前端
                //把数据写入到原始的输出流中
                PrintWriter writer = resp.getWriter();
                writer.println(jsonData);
            }else {
                //拿到缓存
                resp.getWriter().println(json);
            }
            return;
        }else {
            Chain.doFilter(req,resp);
        }

    }

    private String paresRequestToKey(HttpServletRequest req) {
        String method = req.getMethod();
        String uri = req.getRequestURI();
        Map<String, String[]> parameterMap = req.getParameterMap();

        StringBuilder builder = new StringBuilder();
        builder.append(method)
                .append(":")
                .append(uri)
                .append("?");
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            String key = entry.getKey();
            String[] values = entry.getValue();
            for (String value : values) {
                builder.append(key)
                        .append("=")
                        .append(value)
                        .append("&");
            }
        }
        //删除最后一个& 符号
        builder.deleteCharAt(builder.length()-1);
        return builder.toString();

    }
}
