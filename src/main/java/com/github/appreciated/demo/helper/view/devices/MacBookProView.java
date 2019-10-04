package com.github.appreciated.demo.helper.view.devices;

import com.vaadin.flow.component.Component;

public class MacBookProView extends Device<MacBookProView> {
    public MacBookProView(Component component) {
        super(component);
        addClassNames("marvel-device", "macbook");
        add(
                new FluentDiv().withClassNames("top-bar"),
                new FluentDiv().withClassNames("camera"),
                new FluentDiv().withClassNames("screen")
                        .with(getContent()),
                new FluentDiv().withClassNames("bottom-bar"));
    }

    @Override
    String[] getColors() {
        return new String[0];
    }

    @Override
    protected int getMaxDeviceWidth() {
        return 1188;
    }

    @Override
    protected double getMaxScale() {
        return 1.0;
    }

    @Override
    public Orientation[] getOrientations() {
        return new Orientation[]{Orientation.LANDSCAPE};
    }
}
