package com.numberousfor.xiaoman.service;

import com.numberousfor.xiaoman.bo.BookInfo;
import com.numberousfor.xiaoman.bo.BookList;
import com.numberousfor.xiaoman.bo.Books;
import com.numberousfor.xiaoman.utils.HttpUtils;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cuddly
 * @data 2020/5/5 下午5:24
 */
@Service
public class BookService {

    @Value("${search_url}")
    private String SEARCH_URL;

    @Value("${url}")
    private String URL;

    /**
     * 根据小说名称搜索小说
     * @param bookName 小说名称
     * @return
     */
    public List<Books> search(String bookName) {
        List<Books> books = new ArrayList<>();
        try {
            String path = SEARCH_URL + bookName;
            System.out.println("请求路径" + path);
            Document document = HttpUtils.doGetReptile(null, path);
            books = Doc2Bean.doc2BookList(document);
            return books;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }

    public static void main(String[] args) throws Exception {
        String path = "https://www.biqudu.net/";
        Document document = HttpUtils.doGetReptile(null, path);
        System.out.println(document.toString());
    }

    /**
     * 获取小说章节
     * @param href 小说超链接
     * @return
     */
    public List<BookList> getChapter(String href) {
        String path = URL + href;
        List<BookList> list = new ArrayList<>();
        try {
            System.out.println("获取小说章节path:" + path);
            Document document = HttpUtils.doGetReptile(null, path);
            System.out.println(document.toString());
            list = Doc2Bean.doc2BeanBookList(document, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 获取小说内容
     * @param readUrl 阅读url
     * @return
     */
    public BookInfo getContent(String readUrl) {
        BookInfo bookInfo = new BookInfo();
        try {
            String path = URL + readUrl;
            Document document = HttpUtils.doGetReptile(null, path);
            bookInfo = Doc2Bean.doc2BeanBookInfo(document);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookInfo;
    }
}
