package com.github.appreciated.demo.helper.view.devices;

import com.vaadin.flow.component.Component;

public class IPhone5C extends Device<IPhone5C> {
    public IPhone5C(Component component) {
        super(component);
        addClassNames("marvel-device", "iphone5c", "green");
        add(new FluentDiv().withClassNames("top-bar"),
                new FluentDiv().withClassNames("sleep"),
                new FluentDiv().withClassNames("volume"),
                new FluentDiv().withClassNames("camera"),
                new FluentDiv().withClassNames("sensor"),
                new FluentDiv().withClassNames("speaker"),
                new FluentDiv().withClassNames("screen").with(getContent()),
                new FluentDiv().withClassNames("home"),
                new FluentDiv().withClassNames("bottom-bar"));
    }

    @Override
    protected int getMaxDeviceWidth() {
        return 364;
    }

    @Override
    String[] getColors() {
        return new String[]{"white", "red", "yellow", "green", "blue"};
    }

    @Override
    protected double getMaxScale() {
        return 0.8;
    }

    @Override
    public Orientation[] hasOrientation() {
        return new Orientation[]{Orientation.PORTRAIT, Orientation.LANDSCAPE};
    }
}
