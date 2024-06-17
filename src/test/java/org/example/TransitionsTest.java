package org.example;

import org.junit.Test;

import java.util.List;

public class TransitionsTest extends BaseTest{

    private final List<TransitionType> transitionList = List.of(TransitionType.SAUCE, TransitionType.FILLING, TransitionType.BUN);

    @Test
    public void clickBunLocatorSuccess() throws InterruptedException {

        HeadPage headPage = new HeadPage(driver);

        for (var transition: transitionList) {
            headPage = headPage.clickTransition(transition);
            assert headPage.getVisibleTransitionText(transition);
            Thread.sleep(1000);
        }

    }
}