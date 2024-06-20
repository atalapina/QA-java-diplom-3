package org.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TransitionsTest extends BaseTest {
    private final IngredientTabType ingredientTab;

    public TransitionsTest(IngredientTabType ingredientTab) {
        this.ingredientTab = ingredientTab;
    }

    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][]{
                {IngredientTabType.BUN},
                {IngredientTabType.SAUCE},
                {IngredientTabType.FILLING},
        };
    }

    private IngredientTabType getAnotherTab(IngredientTabType ingredientTab) {
        IngredientTabType result = null;
        if (ingredientTab == IngredientTabType.BUN) {
            result = IngredientTabType.SAUCE;
        } else if (ingredientTab == IngredientTabType.SAUCE) {
            result = IngredientTabType.FILLING;
        } else if (ingredientTab == IngredientTabType.FILLING) {
            result = IngredientTabType.SAUCE;
        }
        return result;
    }

    @Test
    public void clickLocatorSuccess() {

        HeadPage headPage = new HeadPage(driver);

        var ingredientTabCurrent = headPage
                .clickIngredientTab(getAnotherTab(ingredientTab))
                .clickIngredientTab(ingredientTab)
                .getIngredientTab(ingredientTab);

        assert headPage.getIngredientTabCurrent().equals(ingredientTabCurrent);
    }
}