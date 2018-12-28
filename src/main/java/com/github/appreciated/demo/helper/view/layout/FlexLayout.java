package com.github.appreciated.demo.helper.view.layout;

import com.vaadin.flow.component.Component;

import java.util.Arrays;

public class FlexLayout extends com.vaadin.flow.component.orderedlayout.FlexLayout {

    private boolean hasPadding;
    private boolean hasMargin;
    private boolean hasSpacing;

    public FlexLayout() {
    }

    public FlexLayout(Component... children) {
        super(children);
    }


    @Override
    public void add(Component... components) {
        super.add(components);
        if (hasSpacing) {
            Arrays.stream(components).forEach(component -> getStyle().set("margin", "calc(var(--lumo-space-m) / 2)"));
        }
    }

    public void setMargin(boolean hasMargin) {
        if (this.hasMargin != hasMargin) {
            this.hasMargin = hasMargin;
            if (hasMargin) {
                getStyle().set("margin", "var(--lumo-space-m)");
            } else {
                getStyle().remove("margin");
            }
        }
    }

    public void setPadding(boolean hasPadding) {
        this.hasPadding = hasPadding;
        if (this.hasPadding != hasPadding) {
            if (hasPadding) {
                if (hasSpacing) {
                    getStyle().set("padding", "calc(var(--lumo-space-m) / 2)");
                } else {
                    getStyle().set("padding", "var(--lumo-space-m)");
                }
                setPadding(hasPadding);
            } else {
                getStyle().remove("padding");
            }

        }
    }

    public void setSpacing(boolean hasSpacing) {
        if (this.hasSpacing != hasSpacing) {
            this.hasSpacing = hasSpacing;
            getChildren().forEach(component -> {
                if (hasPadding) {
                    getStyle().set("margin", "calc(var(--lumo-space-m) / 2)");
                } else {
                    getStyle().remove("margin");
                }
            });
            setPadding(hasPadding);
        }
    }

    public void setFlexDirection(FlexDirection direction) {
        getStyle().set(FlexDirection.styleName, direction.flexValue);
    }

    public static enum FlexDirection {

        ROW("row"),
        ROW_REVERSE("row-reverse"),
        COLUMN("column"),
        COLUMN_REVERSE("column-reverse");

        public static final String styleName = "flex-direction";
        private final String flexValue;

        private FlexDirection(String flexValue) {
            this.flexValue = flexValue;
        }

        static FlexDirection toFlexDirection(String flexValue, FlexDirection defaultValue) {
            return Arrays.stream(values()).filter((alignment) -> alignment.getFlexValue().equals(flexValue)).findFirst().orElse(defaultValue);
        }

        String getFlexValue() {
            return this.flexValue;
        }
    }

}
