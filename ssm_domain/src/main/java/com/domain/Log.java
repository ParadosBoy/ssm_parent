package com.domain;

public class Log {
    private Integer id;
    private String  visitTime;
    private String  username;
    private String  ip;
    private String  method;

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", visitTime='" + visitTime + '\'' +
                ", username='" + username + '\'' +
                ", ip='" + ip + '\'' +
                ", method='" + method + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}