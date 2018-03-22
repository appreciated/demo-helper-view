package com.github.appreciated.demo;

import com.github.appreciated.view.DemoView;
import com.github.appreciated.view.PresentationView;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
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
        DemoView demoView = new DemoView("DemoView Demo",
                "https://github.com/appreciated/vaadin-app-layout",
                new VerticalLayout(new Button("Tablet")),
                new VerticalLayout(new Button("Handheld"))
        );

        demoView.addStep("Add the Maven dependencies",
                "Copy the code and paste it to your pom.xml beside the other dependencies",
                "Maven",
                new String[]{"<dependency>\n" +
                        "\t<groupId>com.github.appreciated</groupId>\n" +
                        "\t<artifactId>demo-helper</artifactId>\n" +
                        "\t<version>0.5</version>\n" +
                        "</dependency>"}
        );

        demoView.addStep("Install the Maven dependencies",
                "Run a Maven with the following goals to install the dependencies",
                "Maven",
                new String[]{"clean install"}
        );


        demoView.addStep("Example Code", "Copy the code into your UI class",
                "Java",
                new String[]{"// Initialize our new UI component\n" +
                        "DemoView demoView = new DemoView(\"DemoView Demo\", \n" +
                        "        \"https://github.com/appreciated/vaadin-app-layout\", \n" +
                        "        new VerticalLayout(new Button(\"Tablet\")), \n" +
                        "        new VerticalLayout(new Button(\"Handheld\"))\n" +
                        ");",
                        "DemoView demoView = new DemoView(\"DemoView Demo\", \n" +
                                "        \"https://github.com/appreciated/vaadin-app-layout\", \n" +
                                "        new VerticalLayout(new Button(\"Tablet\")), \n" +
                                "        new VerticalLayout(new Button(\"Handheld\"))\n" +
                                ");",
                        "DemoView demoView = new DemoView(\"DemoView Demo\", \n" +
                        "        \"https://github.com/appreciated/vaadin-app-layout\", \n" +
                        "        new VerticalLayout(new Button(\"Tablet\")), \n" +
                        "        new VerticalLayout(new Button(\"Handheld\"))\n" +
                        ");"}
        );

        demoView.setSizeFull();
        setContent(demoView);
    }
}
