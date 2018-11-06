package com.lanou3g.filter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.*;

public class HttpCacheResponse extends HttpServletResponseWrapper {

    // 字节数组输出流  可以缓存数据的流
    private ByteArrayOutputStream out;

    public HttpCacheResponse(HttpServletResponse response) {
        super(response);
        out = new ByteArrayOutputStream();
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return new PrintWriter(new OutputStreamWriter(out,getCharacterEncoding()));
    }

    public String getResponseBody() throws UnsupportedEncodingException {
        //从字节数组输出流中获取保存的字节数组
        //把字节数组转成字符串
        byte[] bytes = out.toByteArray();
        return new String(bytes,getCharacterEncoding());

    }
}
