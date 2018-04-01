package com.github.appreciated.demo.helper.view.devices.design;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.ui.*;
import com.vaadin.ui.declarative.Design;

/**
 * !! DO NOT EDIT THIS FILE !!
 * <p>
 * This class is generated by Vaadin Designer and will be overwritten.
 * <p>
 * Please make a subclass with logic and additional interfaces as needed,
 * e.g class LoginView extends LoginDesign implements View { }
 */
@DesignRoot
@AutoGenerated
@SuppressWarnings("serial")
public class PhoneDesign extends VerticalLayout {
    private CssLayout deviceWrapper;
    private Panel phoneContent;
    private HorizontalLayout labelHolder;
    private Label label;

    public PhoneDesign() {
        Design.read(this);
    }

    public CssLayout getDeviceWrapper() {
        return deviceWrapper;
    }

    public Panel getPhoneContent() {
        return phoneContent;
    }

    public HorizontalLayout getLabelHolder() {
        return labelHolder;
    }

    public Label getLabel() {
        return label;
    }

}
