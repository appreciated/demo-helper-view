package com.github.appreciated.demo.helper.view.devices;

import com.vaadin.flow.component.HasStyle;

import static com.github.appreciated.demo.helper.view.devices.Orientation.LANDSCAPE;
import static com.github.appreciated.demo.helper.view.devices.Orientation.PORTRAIT;

public interface HasOrientation<T> extends HasStyle {
    default void toggleOrientation() {
        setOrientation(getOrientation() == Orientation.LANDSCAPE ? PORTRAIT : LANDSCAPE);
    }

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

    default T withOrientation(Orientation orientation) {
        setOrientation(orientation);
        return (T) this;
    }
}
