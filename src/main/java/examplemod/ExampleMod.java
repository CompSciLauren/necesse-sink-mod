package examplemod;

import examplemod.examples.*;
import necesse.engine.commands.CommandsManager;
import necesse.engine.modLoader.annotations.ModEntry;
import necesse.engine.registries.*;
import necesse.inventory.recipe.Ingredient;
import necesse.inventory.recipe.Recipe;
import necesse.inventory.recipe.Recipes;

@ModEntry
public class ExampleMod {

    public void init() {
        System.out.println("Hello world from my example mod!");

        // Register out objects
        ObjectRegistry.registerObject("exampleobject", new ExampleObject(), 2, true);

        // Register our items
        ItemRegistry.registerItem("exampleitem", new ExampleMaterialItem(), 10, true);
    }

    public void postInit() {
        // Add recipes
        // Example item recipe, crafted in inventory for 2 iron bars
        Recipes.registerModRecipe(new Recipe(
                "exampleitem",
                1,
                RecipeTechRegistry.NONE,
                new Ingredient[]{
                        new Ingredient("ironbar", 2)
                }
        ).showAfter("woodboat")); // Show recipe after wood boat recipe

        // Register our server chat command
        CommandsManager.registerServerCommand(new ExampleChatCommand());
    }

}
