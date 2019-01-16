package com.github.appreciated.demo.helper.view.devices;

public enum Orientation {
    LANDSCAPE("landscape"), PORTRAIT(null);

    private String cssClassName;

    Orientation(String cssClassName) {
        this.cssClassName = cssClassName;
    }

    public String getCssClassName() {
        return cssClassName;
    }
}
