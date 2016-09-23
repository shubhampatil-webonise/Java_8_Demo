package org.webonise.lambdafundamentals;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Application {
    private final List<Apple> apples;
    private static final Logger logger = Logger.getLogger(Application.class.getName());
    private static final int CATEGORY_WEIGHT_LIMIT = 150;
    private static final String RED = "red";
    private static final String GREEN = "green";

    public Application() {
        this.apples = new ArrayList<>();
    }

    public void start() {
        populateAppleList();

        prettyPrintApple(apples, apple -> logger.log(Level.INFO, "Weight of apple :" + apple.getWeight()));
        prettyPrintApple(apples, apple -> logger.log(Level.INFO, "Color of apple :" + apple.getColor()));
        prettyPrintApple(apples, apple -> {
            String category = apple.getWeight() > CATEGORY_WEIGHT_LIMIT ? "Heavy" : "Light";
            logger.log(Level.INFO, "Category of apple : " + category);
        });
    }

    private void prettyPrintApple(List<Apple> apples, ApplePrinter applePrinter) {
        apples.stream().forEachOrdered(apple -> applePrinter.printApple(apple));
    }

    private void populateAppleList() {
        apples.add(new Apple(150, GREEN));
        apples.add(new Apple(200, RED));
        apples.add(new Apple(120, RED));
        apples.add(new Apple(170, GREEN));
        apples.add(new Apple(100, GREEN));
    }
}
