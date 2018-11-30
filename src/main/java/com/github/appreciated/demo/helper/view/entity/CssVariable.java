package com.github.appreciated.demo.helper.view.entity;


public class CssVariable {
    private String variable;
    private String value;

    public CssVariable(String variable) {
        this(variable, null);
    }

    public CssVariable(String variable, String value) {
        this.variable = variable;
        this.value = value;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
