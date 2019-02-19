package com.github.appreciated.demo.helper.view.entity;

import com.github.appreciated.demo.helper.code.JavaCodeReader;
import com.github.appreciated.demo.helper.dependencies.MavenDependencyReader;
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

    public CodeExample(Class className) {
        this.highlightingType = Language.java;
        this.codeType = "Java";
        this.code = new JavaCodeReader(className).getCodeExample();
    }

    public CodeExample(MavenDependencyReader reader) {
        this.highlightingType = Language.markup;
        this.codeType = "Maven";
        this.code = reader.getDependencyString();
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
