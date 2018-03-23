package com.github.appreciated.demo.helper.view.entity;

public class CodeExample {
    private String codeType;
    private String code;

    public CodeExample(String code, String codeType) {
        this.codeType = codeType;
        this.code = code;
    }

    public CodeExample(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getCodeType() {
        return codeType;
    }
}
