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
                .withHeaderView("My demo!")
                .withTabletAndPhoneView(new CssLayout(new Button("Tablet")), new CssLayout(new Button("Phone")))
                .withTextContentView("My lovely header", "My lovely description ..........")
                .withPhoneView(new CssLayout(new Button("Phone")), "Some inspirational letters ...")
                .withImageContentView("My lovely header", "My lovely description ..........", new ThemeResource("images/phone.png"))
                .withTabletView(new CssLayout(new Button("Tablet")))
                .withTextContentView("My lovely header", "My lovely description ..........")
                .withLaptopView(new CssLayout(new Button("Laptop")))
                .withStepView("Add the Maven dependencies",
                        "Copy the code and paste it to your pom.xml beside the other dependencies",
                        new CodeExample("<dependency>\n" +
                                "\t<groupId>com.github.appreciated</groupId>\n" +
                                "\t<artifactId>demo-helper</artifactId>\n" +
                                "\t<version>0.7</version>\n" +
                                "</dependency>","Maven")
                )
                .withStepView("Install the Maven dependencies",
                        "Run a Maven with the following goals to install the dependencies",
                        new CodeExample("clean install","Maven")
                )
                .withStepView("Example CodeExample", "Copy the code into your UI class",
                        new CodeExample("// Initialize our new UI component\n" +
                                "DemoView demoView = new DemoView(\"DemoView Demo\", \n" +
                                "        \"https://github.com/appreciated/vaadin-app-layout\", \n" +
                                "        new VerticalLayout(new Button(\"Tablet\")), \n" +
                                "        new VerticalLayout(new Button(\"Handheld\"))\n" +
                                ");","JAVA"),
                        new CodeExample("DemoView demoView = new DemoView(\"DemoView Demo\", \n" +
                                "        \"https://github.com/appreciated/vaadin-app-layout\", \n" +
                                "        new VerticalLayout(new Button(\"Tablet\")), \n" +
                                "        new VerticalLayout(new Button(\"Handheld\"))\n" +
                                ");","JAVA"),
                        new CodeExample("DemoView demoView = new DemoView(\"DemoView Demo\", \n" +
                                "        \"https://github.com/appreciated/vaadin-app-layout\", \n" +
                                "        new VerticalLayout(new Button(\"Tablet\")), \n" +
                                "        new VerticalLayout(new Button(\"Handheld\"))\n" +
                                ");","JAVA")
                );

        demoView.setSizeFull();
        setContent(demoView);
    }
}
