package com.github.appreciated.demo.helper.view.devices;

import com.vaadin.flow.component.Component;

public class GalaxyNote8View extends Device<IPhoneXView> {
    public GalaxyNote8View(Component component) {
        super(component);
        addClassNames("marvel-device", "note8");
        add(new FluentDiv().withClassNames("inner"),
                new FluentDiv().withClassNames("overflow")
                        .with(new FluentDiv()
                                .withClassNames("shadow")
                        ),
                new FluentDiv().withClassNames("speaker"),
                new FluentDiv().withClassNames("sensors"),
                new FluentDiv().withClassNames("more-sensors"),
                new FluentDiv().withClassNames("sleep"),
                new FluentDiv().withClassNames("volume"),
                new FluentDiv().withClassNames("camera"),
                new FluentDiv().withClassNames("screen")
                        .with(getContent())
        );
    }

    @Override
    String[] getColors() {
        return new String[0];
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
