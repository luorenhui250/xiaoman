package com.numberousfor.xiaoman.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @author cuddly
 * @data 2020/5/5 下午1:17
 */
public class UrlUtils {

    /**
     * 给Url拼接
     * @param url
     * @return
     */
    public static String urlAdd(String url) {
        StringBuffer sb = new StringBuffer("/");
        sb.append(url);
        sb.append("/");
        return sb.toString();
    }

    /**
     * 去掉连接头尾/ . 取中间的数值
     * @param url
     * @return
     */
    public static String getSort(String url) {
        if (null == url) {
            return null;
        }
        if (!StringUtils.contains(url, ".")) {
            return getTrimId(url);
        }
        return url.substring(url.lastIndexOf("/") + 1, url.lastIndexOf("."));
    }

    /**
     * 去掉id的下划线
     * @param id
     * @return
     */
    public static String getTrimId(String id) {
        String replaceAll = id.replaceAll("/", "");
        return replaceAll.trim();
    }

    /**
     * 给url拼接连接
     * @param bookId
     * @param sort
     * @return
     */
    public static String urlAdd(String bookId, Integer sort) {
        StringBuffer sb = new StringBuffer("/");
        sb.append(bookId);
        sb.append("/");
        sb.append(sort);
        sb.append(".html");
        return sb.toString();
    }

    public static String urlAddNotHtml(String bookId, String readUrl) {
        StringBuffer sb = new StringBuffer("/");
        sb.append(bookId);
        sb.append("/");
        sb.append(readUrl);
        return sb.toString();
    }

}
