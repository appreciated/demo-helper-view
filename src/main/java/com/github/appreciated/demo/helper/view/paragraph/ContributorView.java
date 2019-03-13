package com.github.appreciated.demo.helper.view.paragraph;

import com.github.appreciated.css.grid.sizes.Flex;
import com.github.appreciated.css.grid.sizes.Length;
import com.github.appreciated.css.grid.sizes.MinMax;
import com.github.appreciated.css.grid.sizes.Repeat;
import com.github.appreciated.demo.helper.component.RoundImageElement;
import com.github.appreciated.demo.helper.view.entity.Contributor;
import com.github.appreciated.layout.FlexibleGridLayout;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.Arrays;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class ContributorView extends VerticalLayout {

    private final H2 h2;
    private final FlexibleGridLayout flexLayout;

    public ContributorView(Contributor... contributors) {
        h2 = new H2("Created by the following contributors");
        flexLayout = new FlexibleGridLayout();
        flexLayout.withColumns(Repeat.RepeatMode.AUTO_FIT, new MinMax(new Length("120px"), new Flex(1)));
        flexLayout.withAutoRows(new Length("120px"));
        flexLayout.setWidthFull();
        Arrays.stream(contributors).forEach(this::addContributor);
        setAlignItems(CENTER);
        add(h2, flexLayout);
    }

    private void addContributor(Contributor contributor) {
        flexLayout.add(new RoundImageElement(
                contributor.getAvatarUrl(),
                "avatar",
                contributor.getName(),
                componentEvent -> UI.getCurrent().getPage().executeJavaScript("window.open(\"" + contributor.getUrl() + "\", \"_self\");")
        ));
    }
}
