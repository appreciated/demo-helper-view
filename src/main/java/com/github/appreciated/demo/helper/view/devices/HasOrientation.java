package com.github.appreciated.demo.helper.view.devices;

import com.vaadin.flow.component.HasStyle;

import static com.github.appreciated.demo.helper.view.devices.Orientation.LANDSCAPE;
import static com.github.appreciated.demo.helper.view.devices.Orientation.PORTRAIT;

public interface HasOrientation extends HasStyle {
    default Orientation getOrientation() {
        return getClassNames().contains(Orientation.LANDSCAPE.getCssClassName()) ? LANDSCAPE : PORTRAIT;
    }

    default void setOrientation(Orientation orientation) {
        if (orientation == Orientation.LANDSCAPE) {
            getClassNames().add(LANDSCAPE.getCssClassName());
        } else {
            getClassNames().remove(LANDSCAPE.getCssClassName());
        }
    }

    default void toggleOrientation() {
        setOrientation(getOrientation() == Orientation.LANDSCAPE ? PORTRAIT : LANDSCAPE);
    }
}
