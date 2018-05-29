package com.github.appreciated.demo.helper.view.design;


import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;

public class CodeDesign extends VerticalLayout {
    private TextArea stepCode;
    private Label codeTypeLabel;

    public TextArea getStepCode() {
        return stepCode;
    }

    public Label getCodeTypeLabel() {
        return codeTypeLabel;
    }

}
