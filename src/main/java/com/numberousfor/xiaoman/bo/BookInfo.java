package com.numberousfor.xiaoman.bo;

import java.io.Serializable;

/**
 * @author cuddly
 * @data 2020/5/5 下午1:02
 */
public class BookInfo implements Serializable {

    private Long id;

    private String readUrl;

    private String pre;

    private String next;

    private String content;


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

    public String getPre() {
        return pre;
    }

    public void setPre(String pre) {
        this.pre = pre;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "BookInfo{" +
                "id='" + id + '\'' +
                ", readUrl='" + readUrl + '\'' +
                ", pre='" + pre + '\'' +
                ", next='" + next + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
