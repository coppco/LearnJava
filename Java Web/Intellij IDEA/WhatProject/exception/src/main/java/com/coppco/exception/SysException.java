package com.coppco.exception;

/**
 * 异常信息类
 */
public class SysException extends Exception {
    /**
     * 异常信息
     */
    private String message;

    public SysException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
