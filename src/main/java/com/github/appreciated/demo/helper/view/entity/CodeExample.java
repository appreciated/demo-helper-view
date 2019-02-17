package com.github.appreciated.demo.helper.view.entity;

import com.github.appreciated.prism.element.Language;

public class CodeExample {
    private Language highlightingType;
    private String codeType;
    private String code;

    public CodeExample(String code, Language highlightingType, String codeType) {
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

    public Language getHighlightingType() {
        return highlightingType;
    }
}
