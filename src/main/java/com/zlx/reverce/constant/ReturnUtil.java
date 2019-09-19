package com.zlx.reverce.constant;

import java.util.HashMap;
import java.util.Map;

public class ReturnUtil {

    public ReturnUtil() {
    }

    public static <T> Map<String, Object> returnSuccess(ResponseCode responseCode, T data) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", responseCode.getCode());
        map.put("message", responseCode.getMessage());
        map.put("data", data);
        return map;
    }

    public static <T> Map<String, Object> returnFail(T data) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", ResponseCode.failed.getCode());
        map.put("message", ResponseCode.failed.getMessage());
        map.put("data", data);
        return map;
    }

    public static <T> Map<String, Object> returnSuccess(T data) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", ResponseCode.success.getCode());
        map.put("message", ResponseCode.success.getMessage());
        map.put("data", data);
        return map;
    }

    public static Map<String, Object> returnSuccess(ResponseCode responseCode) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", responseCode.getCode());
        map.put("message", responseCode.getMessage());
        map.put("data", null);
        return map;
    }


    public static <T> Map<String, Object> returnMap(boolean success) {
        if (success) {
            return returnSuccess(ResponseCode.success);
        } else {
            return returnSuccess(ResponseCode.failed);
        }
    }
}
