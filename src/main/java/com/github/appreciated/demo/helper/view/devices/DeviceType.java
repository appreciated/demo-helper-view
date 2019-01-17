package com.github.appreciated.demo.helper.view.devices;

public enum DeviceType {
    PHONE("phone"),
    PHONE_LANDSCAPE("phone", "ladscape"),
    TABLET("tablet"),
    TABLET_LANDSCAPE("tablet"),
    LAPTOP("laptop");

    private String[] classNames;

    DeviceType(String... classNames) {
        this.classNames = classNames;
    }

    public String[] getClassNames() {
        return classNames;
    }
}
