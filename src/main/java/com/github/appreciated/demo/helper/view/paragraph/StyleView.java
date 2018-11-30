package com.github.appreciated.demo.helper.view.paragraph;

import com.github.appreciated.papermenubutton.HorizontalAlignment;
import com.github.appreciated.papermenubutton.PaperMenuButton;
import com.github.appreciated.papermenubutton.VerticalAlignment;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class StyleView extends HorizontalLayout {
    private final PaperMenuButton styleButton;
    private String verticalMargin = "0px";
    private String horizontalMargin = "0px";
    private com.github.appreciated.demo.helper.view.paragraph.Alignment alignment;

    public StyleView(Component component, CssVariableView view) {
        getStyle().set("position", "relative");
        add(component);
        Button button = new Button(VaadinIcon.PAINTBRUSH.create());
        button.getStyle()
                .set("background", "var(--lumo-primary-color)")
                .set("color", "var(--lumo-tint)")
                .set("border-radius", "100%")
                .set("width", "50px")
                .set("height", "50px");

        styleButton = new PaperMenuButton(button, view);
        styleButton.setHorizontalAlignment(HorizontalAlignment.LEFT);
        styleButton.setVerticalAlignment(VerticalAlignment.BOTTOM);
        styleButton.getStyle().set("position", "absolute").set("padding", "0");
        add(styleButton);
        setButtonAlignment(com.github.appreciated.demo.helper.view.paragraph.Alignment.BOTTOM_RIGHT);
        view.setValueChangeListener((variable, value) -> {
            component.getElement().getStyle().set(variable, value);
        });
    }

    public StyleView withButtonAlignment(com.github.appreciated.demo.helper.view.paragraph.Alignment alignment) {
        setButtonAlignment(alignment);
        return this;
    }

    /**
     * Align the Style Button anywhere you like.
     *
     * @param alignment
     */
    public void setButtonAlignment(com.github.appreciated.demo.helper.view.paragraph.Alignment alignment) {
        this.alignment = alignment;
        if (alignment.isLeft()) {
            styleButton.getStyle().set("left", horizontalMargin).remove("right");
        } else {
            styleButton.getStyle().set("right", horizontalMargin).remove("left");
        }
        if (alignment.isTop()) {
            styleButton.getStyle().set("top", verticalMargin).remove("bottom");
        } else {
            styleButton.getStyle().set("bottom", verticalMargin).remove("top");
        }
    }

    /**
     * Set the vertical margin
     *
     * @param margin
     */
    public void setVerticalMargin(String margin) {
        this.verticalMargin = margin;
        setButtonAlignment(alignment);
    }

    /**
     * Set the horizontal margin
     *
     * @param margin
     */
    public void setHorizontalMargin(String margin) {
        this.horizontalMargin = margin;
        setButtonAlignment(alignment);
    }

    public StyleView withVerticalMargin(String margin) {
        setVerticalMargin(margin);
        return this;
    }

    public StyleView withHorizontalMargin(String margin) {
        setHorizontalMargin(margin);
        return this;
    }

}

