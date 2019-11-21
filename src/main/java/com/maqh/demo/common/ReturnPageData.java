package com.maqh.demo.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 分页返回数据公共类
 *
 * @author maqh
 * @date 2019/10/22 11:00
 */
public class ReturnPageData {

    public static Map<String, Object> fillingData(long count, Object list) {
        Map<String, Object> map = new HashMap<>();
        map.put("count", count);
        map.put("data", list);
        return map;
    }
}
