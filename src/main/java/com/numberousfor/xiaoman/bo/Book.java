package com.numberousfor.xiaoman.bo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author cuddly
 * @data 2020/5/5 下午12:57
 */
public class Book implements Serializable {

    private Long id;

    private String description;

    private String image;

    private String category;

    private String author;

    private String bookName;

    private String readUrl;

    private String status;

    private Date updateTime;

    private Date createTime;

    private String latestChapterName;

    private String latestChapterUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getReadUrl() {
        return readUrl;
    }

    public void setReadUrl(String readUrl) {
        this.readUrl = readUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLatestChapterName() {
        return latestChapterName;
    }

    public void setLatestChapterName(String latestChapterName) {
        this.latestChapterName = latestChapterName;
    }

    public String getLatestChapterUrl() {
        return latestChapterUrl;
    }

    public void setLatestChapterUrl(String latestChapterUrl) {
        this.latestChapterUrl = latestChapterUrl;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", category='" + category + '\'' +
                ", author='" + author + '\'' +
                ", bookName='" + bookName + '\'' +
                ", readUrl='" + readUrl + '\'' +
                ", status='" + status + '\'' +
                ", updateTime=" + updateTime +
                ", createTime=" + createTime +
                ", latestChapterName='" + latestChapterName + '\'' +
                ", latestChapterUrl='" + latestChapterUrl + '\'' +
                '}';
    }
}
