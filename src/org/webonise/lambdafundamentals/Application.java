package org.webonise.lambdafundamentals;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Application {
    private final List<Apple> apples;
    private static final Logger logger = Logger.getLogger(Application.class.getName());

    public Application() {
        this.apples = new ArrayList<>();
    }

    public void start() {
        populateAppleList();

        prettyPrintApple(apples, apple -> logger.log(Level.INFO, "Weight of apple :" + apple.getWeight()));
        prettyPrintApple(apples, apple -> logger.log(Level.INFO, "Weight of apple :" + apple.getWeight()));
        prettyPrintApple(apples, apple -> {
            String category = apple.getWeight() > 150 ? "Heavy" : "Light";
            logger.log(Level.INFO, "Category of apple : " + category);
        });
    }

    private void prettyPrintApple(List<Apple> apples, ApplePrinter applePrinter) {
        apples.stream().forEachOrdered(apple -> applePrinter.toCustomizedString(apple));
    }

    private void populateAppleList() {
        apples.add(new Apple(150, "green"));
        apples.add(new Apple(200, "red"));
        apples.add(new Apple(120, "red"));
        apples.add(new Apple(170, "green"));
        apples.add(new Apple(100, "green"));
    }
}
