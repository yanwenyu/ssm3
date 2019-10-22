package com.duyi.hrb.controller;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BaseCotroller {
    public void wirteResult(HttpServletResponse response, String status, String msg, Object data) throws IOException {
        JSONObject result = new JSONObject();

        result.put("status", status);
        result.put("msg", msg);
        result.put("data", data);

        response.getWriter().write(result.toJSONString());
    }
}
