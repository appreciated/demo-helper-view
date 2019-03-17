package com.github.appreciated.demo.helper.view.other;


import com.github.appreciated.demo.helper.entity.CodeExample;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.vaadin.olli.ClipboardHelper;

public class CodeExampleView extends ClipboardHelper implements HasSize {

    public CodeExampleView(CodeExample example) {
        super(example.getCode(), new CodeExampleViewContent(example));
        setWidth("100%");
    }

    public void onClick() {
        HorizontalLayout hl = new HorizontalLayout(VaadinIcon.INFO.create(), new Label("Code has been copied to clipboard"));
        Notification notification = new Notification(hl);
        notification.setDuration(3000);
        notification.setPosition(Notification.Position.BOTTOM_END);
        notification.getElement().getStyle().set("background", "red");
        notification.setOpened(true);
    }

}
