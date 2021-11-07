package org.hegemol.taube.broker.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * ip工具类.
 *
 * @author KevinClair
 **/
public class IpUtils {

    /**
     * 获取ip地址
     *
     * @return ip地址
     * @throws UnknownHostException
     */
    public static String getIp() throws UnknownHostException {
        return InetAddress.getLocalHost().getHostAddress();
    }


}
