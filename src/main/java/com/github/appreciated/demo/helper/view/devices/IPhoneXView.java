package com.github.appreciated.demo.helper.view.devices;

import com.vaadin.flow.component.Component;

public class IPhoneXView extends Device<IPhoneXView> {
    public IPhoneXView(Component component) {
        super(component);
        withClassNames("marvel-device", "iphone-x");
        add(new FluentDiv().withClassNames("notch")
                        .with(new FluentDiv().withClassNames("camera"),
                                new FluentDiv().withClassNames("speaker")
                        ),
                new FluentDiv().withClassNames("top-bar"),
                new FluentDiv().withClassNames("sleep"),
                new FluentDiv().withClassNames("bottom-bar"),
                new FluentDiv().withClassNames("volume"),
                new FluentDiv().withClassNames("overflow")
                        .with(new FluentDiv().withClassNames("shadow", "shadow--tr"),
                                new FluentDiv().withClassNames("shadow", "shadow--tl"),
                                new FluentDiv().withClassNames("shadow", "shadow--br"),
                                new FluentDiv().withClassNames("shadow", "shadow--bl")
                        ),
                new FluentDiv().withClassNames("inner-shadow"));
        FluentDiv screen = new FluentDiv().withClassNames("screen").with(getContent());
        add(screen);
        screen.getStyle()
                .set("padding-top", "30px")
                .set("box-sizing", "border-box");
    }

    @Override
    String[] getColors() {
        return new String[0];
    }

    @Override
    protected int getMaxDeviceWidth() {
        return 427;
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
