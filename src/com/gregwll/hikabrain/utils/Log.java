package com.gregwll.hikabrain.utils;

public class Log {

    String prefix;

    public Log(String prefix) {
        this.prefix = prefix;
    }

    public void sendInfo(String content) {
        System.out.println(prefix + " " + content);
    }

    public void sendError(String content) {
        System.err.println(prefix + " " + content);
    }
}
