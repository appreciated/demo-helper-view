package com.github.appreciated.demo;

import com.github.appreciated.demo.helper.DemoHelperView;
import com.github.appreciated.demo.helper.view.entity.CodeExample;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

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
                .withHeaderView("I am a HeaderView I display a header for the demo")
                .withTabletAndPhoneView(
                        new CssLayout(new Label("< I belong to a TabletAndPhoneView an display content inside a css rendered tablet >")),
                        new CssLayout(new Label("< I also belong to a TabletAndPhoneView an display content inside a css rendered phone >"))
                )
                .withTextContentView("I am a TextContentView", "I can display a header and a description")
                .withPhoneView(
                        new CssLayout(new Label("< I belong to a PhoneView I display content inside a css rendered phone >")),
                        "Also I can show an optional message beside the css rendered phone"
                )
                .withImageContentView("I am a ImageContentView", "I can display a header, a description and an image", new ThemeResource("images/phone.png"))
                .withTabletView(new CssLayout(new Label("< I belong to a TabletView I display content inside a css rendered tablet >")))
                .withTextContentView("I am a TextContentView", "I display a header and a description")
                .withLaptopView(new CssLayout(new Label("< I belong to a LaptopView I display content inside a css rendered laptop >")))
                .withStepView("I am a StepView",
                        "I display a header step number (1,2,3,4,5) which is automatically generated, also a description and one or multiple code examples",
                        new CodeExample("<dependency>\n" +
                                "\t<groupId>com.github.appreciated</groupId>\n" +
                                "\t<artifactId>demo-helper</artifactId>\n" +
                                "\t<version>0.7</version>\n" +
                                "</dependency>", "Maven")
                )
                .withStepView("I am also a StepView",
                        "And I contain a single code examples",
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
}
