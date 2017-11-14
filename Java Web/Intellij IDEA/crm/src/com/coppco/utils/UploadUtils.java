package com.coppco.utils;

import java.util.UUID;

public class UploadUtils {
    /**
     * 获取UUID名称
     * @param fileName
     * @return
     */
    public static String getUUIDName(String fileName) {
        int index = fileName.lastIndexOf(".");
        fileName = fileName.substring(index, fileName.length());
        return UUID.randomUUID().toString().replace("-", "") + fileName;
    }
}
