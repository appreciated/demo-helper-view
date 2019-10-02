package com.github.appreciated.demo.helper.view.other;


import com.github.appreciated.demo.helper.entity.CodeExample;
import com.vaadin.flow.component.ClickNotifier;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;


public class CodeExampleView extends CodeExampleViewContent implements HasSize, ClickNotifier<CodeExampleView> {

    public CodeExampleView(CodeExample example) {
        super(example);
        setWidth("100%");
        setClipboard(example.getCode());
        addClickListener(clickEvent -> {
            HorizontalLayout hl = new HorizontalLayout(VaadinIcon.INFO.create(), new Label("Code has been copied to clipboard"));
            Notification notification = new Notification(hl);
            notification.setDuration(3000);
            notification.setPosition(Notification.Position.BOTTOM_END);
            notification.getElement().getStyle().set("background", "red");
            notification.setOpened(true);
        });
    }
}
