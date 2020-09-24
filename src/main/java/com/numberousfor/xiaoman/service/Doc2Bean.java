package com.numberousfor.xiaoman.service;

import com.numberousfor.xiaoman.bo.*;
import com.numberousfor.xiaoman.utils.HttpUtils;
import com.numberousfor.xiaoman.utils.UrlUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.*;

/**
 * @author cuddly
 * @data 2020/5/5 下午1:06
 */
public class Doc2Bean {

    private static final String pattern = "yyyy-MM-dd HH:mm:ss";
    private static final String property = "property";
    private static final String content = "content";

    /**
     * 获取图书信息
     *
     * @param document
     * @param book
     */
    public static void doc2BeanBook(Document document, Book book) {
        String author = document.getElementsByAttributeValue(property, DocumentBook.AUTHOR).get(0).attr(content);
        String bookName = document.getElementsByAttributeValue(property, DocumentBook.BOOK_NAME).get(0).attr(content);
        String category = document.getElementsByAttributeValue(property, DocumentBook.CATEGORY).
                get(0).attr(content);
        String description = document.getElementsByAttributeValue(property, DocumentBook.DESCRIPTION).
                get(0).attr(content);
        String image = document.getElementsByAttributeValue(property, DocumentBook.IMAGE).
                get(0).attr(content);
        String latestChapterName = document.getElementsByAttributeValue(property, DocumentBook.LATEST_CHAPTER_NAME).
                get(0).attr(content);
        String latestChapterUrl = document.getElementsByAttributeValue(property, DocumentBook.LATEST_CHAPTER_URL).
                get(0).attr(content);
        String readUrl = document.getElementsByAttributeValue(property, DocumentBook.READ_URL).
                get(0).attr(content);
        String status = document.getElementsByAttributeValue(property, DocumentBook.STATUS).
                get(0).attr(content);
        String updateTime = document.getElementsByAttributeValue(property, DocumentBook.UPDATE_TIME).
                get(0).attr(content);

        book.setAuthor(author);
        book.setBookName(bookName);
        book.setCategory(category);
        book.setDescription(description);
        book.setImage(image);
        book.setLatestChapterName(latestChapterName);
        book.setLatestChapterUrl(latestChapterUrl);
        book.setReadUrl(readUrl);
        book.setStatus(status);
        book.setCreateTime(new Date());
        try {
            book.setUpdateTime(DateUtils.parseDate(updateTime, pattern));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取小说章节
     *
     * @param document
     * @param bookId
     */
    public static List<BookList> doc2BeanBookList(Document document, Long bookId) {
        List<BookList> bookLists = new ArrayList<>();
        Element list = document.getElementById("list");
        Elements dds = list.select("dd").select("a");
        Set<Map<String, String>> objects = new HashSet<>();
        for (Element e : dds) {
            Map<String, String> urlMap = new HashMap<>();
            String href = e.attr("href");
            String sort = UrlUtils.getSort(href);
            urlMap.put("sort", sort);
            urlMap.put("href", href);
            urlMap.put("text", e.text());
            objects.add(urlMap);
        }
        Iterator<Map<String, String>> iterator = objects.iterator();
        while (iterator.hasNext()) {
            Map<String, String> map = iterator.next();
            BookList bookList = new BookList();
            bookList.setBookId(bookId);
            bookList.setName(map.get("text"));
            String href = map.get("href");
            bookList.setReadUrl(href);
            bookList.setSort(Integer.parseInt(String.valueOf(map.get("sort"))));
            bookLists.add(bookList);
        }
        return bookLists;
    }

    /**
     * 获取小说内容
     *
     * @param document
     */
    public static BookInfo doc2BeanBookInfo(Document document) {
        BookInfo bookInfo = new BookInfo();
        String preHref = document.getElementsByAttributeValue("class", "pre").get(0).attr("href");
        String nextHref = document.getElementsByAttributeValue("class", "next").get(0).attr("href");
        String content = document.getElementById("content").toString();
        bookInfo.setPre(UrlUtils.getSort(preHref));
        bookInfo.setNext(UrlUtils.getSort(nextHref));
        bookInfo.setContent(content);
        return bookInfo;
    }

    /**
     * 获取搜索到所有图书信息
     */
    public static List<Books> doc2BookList(Document document) {
        List<Books> books = new ArrayList<>();
        Element main = document.getElementById("main");
        Elements item = main.getElementsByClass("item");

        Set<Map<String, String>> objects = new HashSet<>();
        for (Element e : item) {
            Map<String, String> map = new HashMap<>();
            Elements img = e.select("img");
            // 获取图书封面
            String src = img.attr("src");
            src = "https://www.biqudu.net/" + src;
            Elements span = e.select("span");
            // 获取图书作者
            String author = span.text();
            Elements a = e.select("a");
            String href = a.attr("href");
            String sort = UrlUtils.getSort(href);
            Elements dd = e.select("dd");
            // 获取图书描述
            String description = dd.text();
            map.put("src", src);
            map.put("author", author);
            map.put("href", href);
            map.put("sort", sort);
            map.put("description", description);
            objects.add(map);
        }

        for (Map<String, String> object : objects) {
            Books book = new Books();
            book.setSrc(object.get("src"));
            book.setAuthor(object.get("author"));
            book.setDescription(object.get("description"));
            book.setHref(object.get("href"));
            book.setSort(object.get("sort"));
            books.add(book);
        }
        return books;
    }

    public static void main(String[] args) throws Exception {
//         String base = "https://www.biqudu.net/searchbook.php?keyword=终极斗罗";
//        String  base = "https://www.ximalaya.com/youshengshu/23034547/324723271";
//        String base = "https://www.ximalaya.com/search/十宗罪";
//        String base = "https://www.ximalaya.com/youshengshu/24495649/297822813";
//        String base = "https://m.ximalaya.com/youshengshu/24495649/297822813";
        String base = "https://www.biqudu.net";
        String path = "/130_130297/";
        Document document = HttpUtils.doGetReptile(base, path);
        System.out.println(document.toString());
//        List<Books> books = new ArrayList<>();
//        Doc2Bean.doc2BookList(document, books);
//        for (Books book : books) {
//            System.out.println(book.toString());
//        }
        Book book = new Book();
        // 这里是提取小说名称等
        Doc2Bean.doc2BeanBook(document, book);
        // 这里是提取章节等
        List<BookList> bookLists = Doc2Bean.doc2BeanBookList(document, book.getId());
        for (BookList bookList : bookLists) {
            System.out.println("章节------------------------:" + bookList.toString());
        }
        // 这里是提取小说正文
        for (BookList bl : bookLists) {
            Document doc = HttpUtils.doGetReptile(base, bl.getReadUrl());
            BookInfo bookInfo = Doc2Bean.doc2BeanBookInfo(doc);
            System.out.println(bookInfo.toString());
            break;
        }
    }

    /**
     * 缓存小说
     */
    public static void download() {

    }


}
