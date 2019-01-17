package com.github.appreciated.demo.helper.view.devices;

public enum DeviceType {
    PHONE("phone"),
    PHONE_LANDSCAPE("phone", "landscape"),
    TABLET("tablet"),
    TABLET_LANDSCAPE("tablet", "landscape"),
    LAPTOP("laptop");

    private String[] classNames;

    DeviceType(String... classNames) {
        this.classNames = classNames;
    }

    public String[] getClassNames() {
        return classNames;
    }
}
