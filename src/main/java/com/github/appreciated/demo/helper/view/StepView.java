package com.github.appreciated.demo.helper.view;

import com.github.appreciated.demo.helper.view.design.CodeDesign;
import com.github.appreciated.demo.helper.view.design.StepDesign;
import com.github.appreciated.demo.helper.view.entity.CodeExample;

import java.util.Arrays;

public class StepView extends StepDesign {

    /**
     * @param stepNumber
     * @param title
     * @param description
     * @param codeExamples
     */
    public StepView(int stepNumber, String title, String description, CodeExample... codeExamples) {
        this.getStepNumber().setText(String.valueOf(stepNumber));
        this.getStepHeader().setText(title);
        this.getStepDescription().setText(description);
        Arrays.stream(codeExamples).forEach(codeExample -> {
            CodeDesign codeDesign = new CodeDesign(codeExample.getCode(), codeExample.getCodeType());
            if (codeExample.getCodeType() == null) {
                codeDesign.getCodeTypeLabel().setVisible(false);
            } else {
                codeDesign.getCodeTypeLabel().setText(codeExample.getCodeType());
            }
            getCodeExampleHolder().add(codeDesign);
        });
    }

    private int countLines(String str) {
        return str.split("\r\n|\r|\n").length;
    }

}
