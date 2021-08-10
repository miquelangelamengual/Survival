package es.hulk.survival.managers.recipe;

import es.hulk.survival.Survival;
import es.hulk.survival.managers.recipe.recipes.CustomExperienceBottle;
import es.hulk.survival.managers.recipe.recipes.EnchantedPickaxe;

public class RecipeManager {

    private Survival plugin;

    public void loadRecipes() {
        EnchantedPickaxe.enchantedPickaxe();
        CustomExperienceBottle.customExperienceBottle();
    }

}