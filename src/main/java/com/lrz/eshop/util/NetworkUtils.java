package com.lrz.eshop.util;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 网络相关工具类
 * @author 天天
 * @create 2023/1/21 11:26
 * @description
 */
public class NetworkUtils {

    /**
     * 根据http请求获取客户端IP地址
     *
     * @param request http请求
     * @return IP地址
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ipAddress = null;
        try {
            ipAddress = request.getHeader("x-forwarded-for");
            if (ipAddress == null || ipAddress.length() == 0 || Constant.UNKNOWN.equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || Constant.UNKNOWN.equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || Constant.UNKNOWN.equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getRemoteAddr();
            }
            String comma = ",";
            String localhost = "127.0.0.1";
            String localNetwork = "0:0:0:0:0:0:0:1";
            if (ipAddress.contains(comma)) {
                ipAddress = ipAddress.split(",")[0];
            }
            if (localhost.equals(ipAddress) || localNetwork.equals(ipAddress)) {
                // 获取本机真正的ip地址
                try {
                    ipAddress = InetAddress.getLocalHost().getHostAddress();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
            }
            // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
            if (ipAddress != null && ipAddress.length() > Constant.IP_MAX_LENGTH) {
                if (ipAddress.indexOf(comma) > 0) {
                    ipAddress = ipAddress.substring(0, ipAddress.indexOf(comma));
                }
            }
        } catch (Exception e){
            ipAddress = "";
            e.printStackTrace();
        }
        return ipAddress;
    }
}

