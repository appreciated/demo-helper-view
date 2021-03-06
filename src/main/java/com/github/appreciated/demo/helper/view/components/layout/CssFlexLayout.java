package com.github.appreciated.demo.helper.view.components.layout;

import com.vaadin.flow.component.Component;

import java.util.Arrays;

public class CssFlexLayout extends com.vaadin.flow.component.orderedlayout.FlexLayout {

    private boolean hasPadding;
    private boolean hasMargin;
    private boolean hasSpacing;
    private FlexDirection direction;
    private FlexWrap flexWrap;
    private BoxSizing boxSizing;

    public CssFlexLayout() {
    }

    public CssFlexLayout(Component... children) {
        super(children);
        getStyle().set("--flex-layout-space", "var(--lumo-space-m)");
    }

    @Override
    public void add(Component... components) {
        super.add(components);
        if (hasSpacing) {
            hasSpacing = false;
            setSpacing(true);
        }
    }

    public void setMargin(boolean hasMargin) {
        if (this.hasMargin != hasMargin) {
            this.hasMargin = hasMargin;
            if (hasMargin) {
                getStyle().set("margin", "var(--flex-layout-space)");
            } else {
                getStyle().remove("margin");
            }
        }
    }

    private String getSpacingString() {
        if (direction == FlexDirection.ROW || direction == FlexDirection.ROW_REVERSE) {
            return "0 " + getSpacingValue() + " 0 " + getSpacingValue();
        } else {
            return getSpacingValue() + " 0 " + getSpacingValue() + " 0";
        }
    }

    private String getSpacingValue() {
        return hasPadding ? "calc(var(--flex-layout-space) / 2)" : "var(--flex-layout-space)";
    }

    public void setPadding(boolean hasPadding) {
        this.hasPadding = hasPadding;
        if (this.hasPadding != hasPadding) {
            if (hasPadding) {
                if (hasSpacing) {
                    getStyle().set("padding", "calc(var(--flex-layout-space) / 2)");
                } else {
                    getStyle().set("padding", "var(--flex-layout-space)");
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
            String value = getSpacingString();
            getChildren().forEach(component -> component.getElement().getStyle().set("margin", value));
            setPadding(hasPadding);
        }
    }

    public void setFlexDirection(FlexDirection direction) {
        this.direction = direction;
        getStyle().set(FlexDirection.styleName, direction.getFlexValue());
        setSpacing(this.hasSpacing);
    }


    public BoxSizing getBoxSizing() {
        return boxSizing;
    }

    public void setBoxSizing(BoxSizing boxSizing) {
        this.boxSizing = boxSizing;
        getStyle().set("box-sizing", boxSizing.getBoxSizingValue());
    }


    public static enum FlexDirection {

        ROW("row"),
        ROW_REVERSE("row-reverse"),
        COLUMN("column"),
        COLUMN_REVERSE("column-reverse");

        public static final String styleName = "flex-direction";
        private final String flexValue;

        FlexDirection(String flexValue) {
            this.flexValue = flexValue;
        }

        static FlexDirection toFlexDirection(String flexValue) {
            return toFlexDirection(flexValue, ROW);
        }

        static FlexDirection toFlexDirection(String flexValue, FlexDirection defaultValue) {
            return Arrays.stream(values()).filter((alignment) -> alignment.getFlexValue().equals(flexValue)).findFirst().orElse(defaultValue);
        }

        String getFlexValue() {
            return this.flexValue;
        }
    }

    public static enum BoxSizing {
        UNDEFINED("unset"),
        CONTENT_BOX("content-box"),
        BORDER_BOX("border-box");

        public static final String styleName = "box-sizing";
        private final String boxSizingValue;

        private BoxSizing(String boxSizingValue) {
            this.boxSizingValue = boxSizingValue;
        }

        static BoxSizing toFlexDirection(String boxSizingValue) {
            return toFlexDirection(boxSizingValue, UNDEFINED);
        }

        static BoxSizing toFlexDirection(String boxSizingValue, BoxSizing defaultValue) {
            return Arrays.stream(values()).filter((alignment) -> alignment.getBoxSizingValue().equals(boxSizingValue)).findFirst().orElse(defaultValue);
        }

        String getBoxSizingValue() {
            return this.boxSizingValue;
        }

    }

}
