package com.github.appreciated.demo.helper.view;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.Element;

public class RevealableContent extends Div {

    private final Element element;
    private Component component;

    public RevealableContent(Component component, Component revealingContent) {
        this.component = component;
        this.element = component.getElement();
        component.getChildren().forEach(child -> child.getElement().getStyle().set("pointer-events", "none"));
        add(component);
        component.getElement().addEventListener("click", e -> {
            System.out.println("Clicked!");
            Dialog dl = new Dialog();
            dl.setSizeFull();
            Button b = new Button("Close", buttonClickEvent -> dl.close());
            VerticalLayout hl = new VerticalLayout(revealingContent, b);
            dl.add(hl);
            dl.open();
            dl.getParent().ifPresent(component1 -> {
                component.getElement().getStyle().set("top", "0px").set("left", "0px").set("right", "0px").set("bottom", "0px");
            });
            dl.addDialogCloseActionListener(dialogCloseActionEvent -> {
                dl.close();
                //toggleOverlay(false);
            });
            //toggleOverlay(true);
        });
        element.getStyle().set("transition", "box-shadow ease 1s").set("box-shadow", "var(--lumo-box-shadow-s)");
        element.addEventListener("mouseout", domEvent -> element.getStyle().set("box-shadow", "var(--lumo-box-shadow-s)"));
        element.addEventListener("mouseover", domEvent -> element.getStyle().set("box-shadow", "var(--lumo-box-shadow-xl)"));
        element.getStyle().set("cursor", "pointer");//.set("pointer-events", "none")
    }

    private void toggleOverlay(boolean open) {
        if (open) {
            component.getElement().getStyle().set("position", "fixed")
                    .set("z-index", "1000")
                    .set("top", "50%")
                    .set("left", "50%")
                    .set("transform", "translate(-50%,-50%)");
        } else {
            component.getElement().getStyle().remove("position")
                    .remove("z-index")
                    .remove("top")
                    .remove("left")
                    .remove("transform");
        }
    }
}
