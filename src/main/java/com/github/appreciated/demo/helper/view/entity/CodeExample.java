package com.github.appreciated.demo.helper.view.entity;

public class CodeExample {
    private String highlightingType;
    private String codeType;
    private String code;

    public CodeExample(String code, String highlightingType, String codeType) {
        this.highlightingType = highlightingType;
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

    public String getHighlightingType() {
        return highlightingType;
    }
}
