package com.wywnb.schoolrun.component;

import org.bson.types.ObjectId;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256Coding {
    public static String coding(@NonNull String username, @NonNull ObjectId id) {
        String temp = username + id.toHexString();
        // SHA 加密开始
        // 创建加密对象 并傳入加密類型
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            // 传入要加密的字符串
            messageDigest.update(temp.getBytes());
            // 得到 byte 類型结果
            return byte2Hex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String byte2Hex(byte[] bytes){
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        for (byte aByte : bytes) {
            temp = Integer.toHexString(aByte & 0xFF);
            if (temp.length() == 1) {
                //1得到一位的进行补0操作
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }
}
