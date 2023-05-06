package com.tjsystem.utils;

import com.alibaba.fastjson.JSONObject;
import com.tjsystem.pojo.Result;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

public class JwtAndLoginUtils {

    private static final String signKey = "TJSystem";
    private static final int expire = 3600000;

    /**
     * 生成JWT令牌
     * @param claims 需要存储的内容
     * @return JWT令牌
     */
    public static String generateJwt(Map<String, Object> claims){
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, signKey)
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + expire))
                .compact();
        return jwt;
    }

    /**
     * 解析JWT令牌
     * @param jwt JWT令牌
     * @return JWT有效负载 payload 中存储的内容
     */
    public static Claims parseJWT(String jwt){
        Claims claims = Jwts.parser()
                .setSigningKey(signKey)
                .parseClaimsJws(jwt)
                .getBody();
        return claims;
    }

    /**
     * 返回未登录信息
     * @param response HttpServletResponse对象
     * @throws IOException write可能报错
     */
    public static void writeResponse(HttpServletResponse response) throws IOException {
        //创建返回未登录信息的Result
        Result responseResult = Result.error("NOT_LOGIN");
        //把Result对象转换为JSON格式字符串
        String responseJSON = JSONObject.toJSONString(responseResult);
        //响应请求（告知浏览器：响应的数据类型为json、响应的数据编码表为utf-8）
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(responseJSON);
    }
}
