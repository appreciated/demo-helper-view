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
        this.getStepNumber().setValue(String.valueOf(stepNumber));
        this.getStepHeader().setValue(title);
        this.getStepDescription().setValue(description);
        Arrays.stream(codeExamples).forEach(codeExample -> {
            CodeDesign codeDesign = new CodeDesign();
            codeDesign.getStepCode().setValue(codeExample.getCode());
            codeDesign.getStepCode().setRows(countLines(codeExample.getCode()));
            if (codeExample.getCodeType() == null) {
                codeDesign.getCodeTypeLabel().setVisible(false);
            } else {
                codeDesign.getCodeTypeLabel().setValue(codeExample.getCodeType());
            }
            getCodeExampleHolder().addComponent(codeDesign);
        });
    }

    private int countLines(String str) {
        return str.split("\r\n|\r|\n").length;
    }

}
