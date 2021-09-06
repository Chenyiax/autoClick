package com.a.main;

import java.io.Serializable;

/**
 * student
 * @author 
 */
public class Student implements Serializable {
    private String xh;
    private String url;

    public Student(String xh, String url) {
        this.xh = xh;
        this.url = url;
    }

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}