package com.github.appreciated.demo.helper.view.devices;

import com.vaadin.flow.component.Component;

public class IPhone8View extends Device<IPhone8View> {
    public IPhone8View(Component component) {
        super(component);
        addClassNames("marvel-device", "iphone8", "black", "landscape");
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
    String[] getColors() {
        return new String[]{"black", "silver", "gold"};
    }

    @Override
    protected int getMaxDeviceWidth() {
        return 364;
    }

    @Override
    protected double getMaxScale() {
        return 0.8;
    }

    @Override
    public Orientation[] getOrientations() {
        return new Orientation[]{Orientation.PORTRAIT, Orientation.LANDSCAPE};
    }
}
