package com.github.appreciated.demo.helper.view.design;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.ui.declarative.Design;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

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
public class StepDesign extends HorizontalLayout {
    private Label stepNumber;
    private Label stepHeader;
    private Label stepDescription;
    private VerticalLayout codeExampleHolder;

    public StepDesign() {
        Design.read(this);
    }

    public Label getStepNumber() {
        return stepNumber;
    }

    public Label getStepHeader() {
        return stepHeader;
    }

    public Label getStepDescription() {
        return stepDescription;
    }

    public VerticalLayout getCodeExampleHolder() {
        return codeExampleHolder;
    }

}
