package com.numberousfor.xiaoman.bo;

import java.io.Serializable;

/**
 * @author cuddly
 * @data 2020/5/5 下午1:01
 */
public class BookList implements Serializable {

    private Long id;

    private Long bookId;

    private String readUrl;

    private String name;

    private Integer sort;

    private String content;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReadUrl() {
        return readUrl;
    }

    public void setReadUrl(String readUrl) {
        this.readUrl = readUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "BookList{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", readUrl='" + readUrl + '\'' +
                ", name='" + name + '\'' +
                ", sort=" + sort +
                ", content='" + content + '\'' +
                '}';
    }
}
