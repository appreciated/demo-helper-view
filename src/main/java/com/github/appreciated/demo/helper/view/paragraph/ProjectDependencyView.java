package com.github.appreciated.demo.helper.view.paragraph;

import com.github.appreciated.css.grid.sizes.Flex;
import com.github.appreciated.css.grid.sizes.Length;
import com.github.appreciated.css.grid.sizes.MinMax;
import com.github.appreciated.css.grid.sizes.Repeat;
import com.github.appreciated.demo.helper.component.RoundImageElement;
import com.github.appreciated.demo.helper.view.entity.Project;
import com.github.appreciated.layout.FlexibleGridLayout;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.Arrays;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class ProjectDependencyView extends VerticalLayout {
    private final H1 header;
    private final FlexibleGridLayout flexLayout;

    public ProjectDependencyView(Project... project) {
        header = new H1("This Project relies on");
        flexLayout = new FlexibleGridLayout();
        flexLayout.withColumns(Repeat.RepeatMode.AUTO_FIT, new MinMax(new Length("120px"), new Flex(1)));
        flexLayout.withAutoRows(new Length("120px"));
        flexLayout.setWidthFull();
        Arrays.stream(project).forEach(this::addProject);
        setAlignItems(CENTER);
        add(header, flexLayout);
    }

    private void addProject(Project project) {
        flexLayout.add(new RoundImageElement(
                project.getImagePath(),
                "project",
                project.getName(),
                componentEvent -> UI.getCurrent().getPage().executeJavaScript("window.open(\"" + project.getUrl() + "\", \"_self\");"))
        );
    }
}
