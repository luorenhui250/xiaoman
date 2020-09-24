package com.numberousfor.xiaoman.bo;

import java.io.Serializable;

/**
 * @author cuddly
 * @data 2020/5/5 下午4:46
 */
public class Books implements Serializable {

    private Long id;

    private String src;

    private String author;

    private String href;

    private String sort;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", src='" + src + '\'' +
                ", author='" + author + '\'' +
                ", href='" + href + '\'' +
                ", sort='" + sort + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
