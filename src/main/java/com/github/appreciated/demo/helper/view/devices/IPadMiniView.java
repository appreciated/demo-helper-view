package com.github.appreciated.demo.helper.view.devices;

import com.vaadin.flow.component.Component;

public class IPadMiniView extends Device<IPadMiniView> {
    public IPadMiniView(Component component) {
        super(component);
        addClassNames("marvel-device", "ipad", "silver");
        add(
                new FluentDiv().withClassNames("camera"),
                new FluentDiv().withClassNames("screen").with(getContent()),
                new FluentDiv().withClassNames("home")
        );
    }

    @Override
    protected int getMaxDeviceWidth() {
        return 948;
    }

    @Override
    String[] getColors() {
        return new String[]{"black", "silver"};
    }

    @Override
    protected double getMaxScale() {
        return 1.0;
    }

    @Override
    public Orientation[] hasOrientation() {
        return new Orientation[]{Orientation.PORTRAIT, Orientation.LANDSCAPE};
    }
}
