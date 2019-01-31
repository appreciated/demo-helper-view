package com.github.appreciated.demo.helper.view.other;

import com.github.appreciated.IronCollapse;
import com.vaadin.flow.component.ClickNotifier;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class AccordionView extends Composite<VerticalLayout> {

    String[] shadows = new String[]{"var(--lumo-box-shadow-s)", "var(--lumo-box-shadow-m)", "var(--lumo-box-shadow-l)", "var(--lumo-box-shadow-xl)"};

    public AccordionView() {
        getContent().setPadding(false);
        getContent().setWidth("unset");
        getContent().getStyle()
                .set("overflow", "hidden")
                .set("border-radius", "20px")
                .set("position", "relative")
                .set("box-shadow", shadows[1]);
    }

    public void add(Component component, String collapsibleString) {
        getContent().add((Component) getComponentWrapper(component, new Button(collapsibleString)));
        updateZIndex();
    }

    public void add(Component component, ClickNotifier customButton) {
        getContent().add((Component) getComponentWrapper(component, customButton));
        updateZIndex();
    }

    public void add(Component component) {
        getContent().add((Component) getComponentWrapper(component, null));
        updateZIndex();
    }

    private HasComponents getComponentWrapper(Component component, ClickNotifier collapseTrigger) {
        VerticalLayout wrapper = new VerticalLayout();
        wrapper.setMargin(false);
        wrapper.getStyle()
                .set("box-shadow", shadows[getContent().getComponentCount()])
                .set("border-bottom-right-radius", "20px")
                .set("border-bottom-left-radius", "20px");
        if (getContent().getComponentCount() > 0) {
            wrapper.getStyle()
                    .set("margin-top", "-20px")
                    .set("padding-top", "40px")
                    .set("border-radius", "10px");
        }

        if (collapseTrigger != null) {
            IronCollapse collapse = new IronCollapse(component);
            wrapper.add(collapse, (Component) collapseTrigger);
            collapseTrigger.addClickListener(clickEvent -> collapse.toggle());
        } else {
            wrapper.add(component);
        }
        return wrapper;
    }

    private void updateZIndex() {
        final int[] i = {getContent().getComponentCount() + 1};
        getContent().getChildren().forEach(component -> component.getElement().getStyle().set("z-index", String.valueOf(i[0]--)));
    }
}
