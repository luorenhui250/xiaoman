package com.numberousfor.xiaoman.web;

import com.numberousfor.xiaoman.bo.BookInfo;
import com.numberousfor.xiaoman.bo.BookList;
import com.numberousfor.xiaoman.bo.Books;
import com.numberousfor.xiaoman.config.enums.ErrorEnum;
import com.numberousfor.xiaoman.config.exception.PendingException;
import com.numberousfor.xiaoman.service.BookService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author cuddly
 * @data 2020/5/5 下午4:05
 */
@Controller
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * 根据小说名称搜索小说
     * @return
     */
    @GetMapping(value = "/search.do")
    @ResponseBody
    public List<Books> getBooks(@RequestParam(value = "bookName") String bookName) throws PendingException {
        if (StringUtils.isBlank(bookName)) {
            throw new PendingException(ErrorEnum.SEARCH_BOOK_NAME_IS_BLANK);
        }
        return bookService.search(bookName);
    }

    /**
     * 获取小说章节
     * @param href 小说超链接
     * @return
     */
    @GetMapping(value = "/get_chapter.do")
    @ResponseBody
    public List<BookList> getBooksChapter(String href) {
        return bookService.getChapter(href);
    }

    /**
     * 获取小说内容
     * @param readUrl
     * @return
     */
    @GetMapping(value = "/get_content.do")
    @ResponseBody
    public BookInfo getBookContent(String readUrl) {
        return bookService.getContent(readUrl);
    }

}
