package com.example.ad8.util;

import java.util.Collection;
import java.util.List;

public class ListUtil {

    /***
     * 判断是否为空 为空返回真
     * @param list
     * @return
     */
    public static boolean isNull(List<?> list) {
        return null == list || list.size() <= 0;
    }
    /***
     * 判断集合是否为空 为空返回真
     * @param list
     * @return
     */
    public static boolean isNull(Collection<?> list) {
        return null == list || list.size() <= 0;
    }

    /***
     * 判断是否为空,不为空返回真
     * @param list
     * @return
     */
    public static boolean isNotNull(List<?> list) {
        return null != list && list.size() > 0;
    }
    /***
     * 判断是否为空,不为空返回真
     * @param list
     * @return
     */
    public static boolean isNotNull(Collection<?> list) {
        return null != list && list.size() > 0;
    }


}
