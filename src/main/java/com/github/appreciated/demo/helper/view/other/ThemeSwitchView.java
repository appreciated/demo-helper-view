package com.github.appreciated.demo.helper.view.other;

import com.github.appreciated.demo.helper.view.animation.RippleAnimation;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.vaadin.addons.papertogglebutton.PaperToggleButton;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode.CENTER;

public class ThemeSwitchView extends HorizontalLayout {
    private final PaperToggleButton toggle;
    private final Div wrapper;
    private Component animation;

    public ThemeSwitchView(Component component) {
        toggle = new PaperToggleButton("Lumo.DARK");
        toggle.getStyle()
                .set("--primary-color", "var(--lumo-primary-color)")
                .set("--primary-text-color", "var(--lumo-body-text-color)")
                .set("position", "absolute")
                .set("top", "10px").set("right", "10px");
        getStyle()
                .set("position", "relative")
                .set("overflow", "hidden")
                .set("transition", "all 1s");
        toggle.addValueChangeListener(event -> {
            if (event.getValue()) {
                getElement().setAttribute("theme", "dark");
                addAnimation(new RippleAnimation());
            } else {
                getElement().removeAttribute("theme");
                addAnimation(new RippleAnimation());
            }
        });
        wrapper = new Div(component, toggle);
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(CENTER);
        wrapper.getStyle().set("margin", "32px").set("position", "relative");
        add(wrapper);
        setWidth("100%");
    }

    private void addAnimation(Component animation) {
        if (this.animation != null) {
            remove(this.animation);
        }
        this.animation = animation;
        addComponentAsFirst(animation);
    }

}
