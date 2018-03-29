package com.github.appreciated.demo;

import com.github.appreciated.demo.helper.DemoHelperView;
import com.github.appreciated.demo.helper.view.entity.CodeExample;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

import javax.servlet.annotation.WebServlet;

@Theme("demo")
@Title("MyComponent Add-on Demo")
@SuppressWarnings("serial")
public class DemoUI extends UI {

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = DemoUI.class)
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {

        // Initialize our new UI component
        DemoHelperView demoView = new DemoHelperView()
                .withHeaderView("I am a HeaderView", "I display a header and an optional subtitle for the demo")
                .withTabletAndPhoneView(
                        getLabel("< I belong to a TabletAndPhoneView an display content inside a css rendered tablet >"),
                        getLabel("< I also belong to a TabletAndPhoneView an display content inside a css rendered phone >")
                )
                .withParagraphView("I am a ParagraphView", "I can display a header and a description")
                .withPhoneView(
                        getLabel("< I belong to a PhoneView I display content inside a css rendered phone >"),
                        "Also I can show a optional message beside the PhoneView"
                )
                .withImageParagraphView("I am a ImageParagraphView", "I can display a header, a description and an image", new ThemeResource("images/phone.png"))
                .withTabletView(getLabel("< I belong to a TabletView I display content inside a css rendered tablet >"))
                .withParagraphView("I am a ParagraphView", "I display a header and a description")
                .withLaptopView(getLabel("< I belong to a LaptopView I display content inside a css rendered laptop >"))
                .withStepView("I am a StepView",
                        "I display a header step number (1,2,3,4,5) which is automatically generated, also a description and one or multiple code examples",
                        new CodeExample("<dependency>\n" +
                                "\t<groupId>com.github.appreciated</groupId>\n" +
                                "\t<artifactId>demo-helper</artifactId>\n" +
                                "\t<version>0.7.2</version>\n" +
                                "</dependency>", "Maven")
                )
                .withStepView("I am also a StepView",
                        "And I contain a single code example",
                        new CodeExample("clean install", "Maven")
                )
                .withStepView("I am also a StepView", "And I contain multiple code examples",
                        new CodeExample("// Initialize our new UI component\n" +
                                "DemoView demoView = new DemoView(\"DemoView Demo\", \n" +
                                "        \"https://github.com/appreciated/vaadin-app-layout\", \n" +
                                "        new VerticalLayout(new Button(\"Tablet\")), \n" +
                                "        new VerticalLayout(new Button(\"Handheld\"))\n" +
                                ");", "JAVA"),
                        new CodeExample("DemoView demoView = new DemoView(\"DemoView Demo\", \n" +
                                "        \"https://github.com/appreciated/vaadin-app-layout\", \n" +
                                "        new VerticalLayout(new Button(\"Tablet\")), \n" +
                                "        new VerticalLayout(new Button(\"Handheld\"))\n" +
                                ");", "JAVA"),
                        new CodeExample("DemoView demoView = new DemoView(\"DemoView Demo\", \n" +
                                "        \"https://github.com/appreciated/vaadin-app-layout\", \n" +
                                "        new VerticalLayout(new Button(\"Tablet\")), \n" +
                                "        new VerticalLayout(new Button(\"Handheld\"))\n" +
                                ");", "JAVA")
                );

        demoView.setSizeFull();
        setContent(demoView);
    }

    VerticalLayout getLabel(String text) {
        Label label = new Label("< I belong to a TabletAndPhoneView an display content inside a css rendered tablet >");
        label.setSizeFull();
        return new VerticalLayout(label);
    }

}
