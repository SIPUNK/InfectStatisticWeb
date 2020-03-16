package com.example.demo;

import java.io.Serializable;

/**
 * Created by yjl on 2019/5/30.
 */
public class HttpPojo implements Serializable{
    private static final long serialVersionUID = -2019661705306735496L;

    private String httpIp;
    private String httpHost;
    private String httpAccept;
    private String httpConnection;
    private String httpUserAgent;
    private String httpReferer;
    private String httpOrigin;
    private String httpCookie;
    private String httpContentType;

    public String getHttpCookie() {
        return httpCookie;
    }

    public void setHttpCookie(String httpCookie) {
        this.httpCookie = httpCookie;
    }

    public String getHttpIp() {
        return httpIp;
    }

    public void setHttpIp(String httpIp) {
        this.httpIp = httpIp;
    }

    public String getHttpHost() {
        return httpHost;
    }

    public void setHttpHost(String httpHost) {
        this.httpHost = httpHost;
    }

    public String getHttpAccept() {
        return httpAccept;
    }

    public void setHttpAccept(String httpAccept) {
        this.httpAccept = httpAccept;
    }

    public String getHttpConnection() {
        return httpConnection;
    }

    public void setHttpConnection(String httpConnection) {
        this.httpConnection = httpConnection;
    }

    public String getHttpUserAgent() {
        return httpUserAgent;
    }

    public void setHttpUserAgent(String httpUserAgent) {
        this.httpUserAgent = httpUserAgent;
    }

    public String getHttpReferer() {
        return httpReferer;
    }

    public void setHttpReferer(String httpReferer) {
        this.httpReferer = httpReferer;
    }

    public String getHttpOrigin() {
        return httpOrigin;
    }

    public void setHttpOrigin(String httpOrigin) {
        this.httpOrigin = httpOrigin;
    }

    public String getHttpContentType() {
        return httpContentType;
    }

    public void setHttpContentType(String httpContentType) {
        this.httpContentType = httpContentType;
    }
}