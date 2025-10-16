package de.epiceric.shopchest.shop;

import de.epiceric.shopchest.ShopChest;
import dev.lone.itemsadder.api.CustomStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ShopProduct {

    private final ItemStack itemStack;
    private final int amount;

    public ShopProduct(ItemStack itemStack, int amount) {
        this.itemStack = new ItemStack(itemStack);
        this.itemStack.setAmount(1);
        this.amount = amount;
    }

    public ShopProduct(ItemStack itemStack) {
        this(itemStack, itemStack.getAmount());
    }

    /**
     * @return The localized name of the product's {@link ItemStack} in the selected language file.
     */
    public String getLocalizedName() {
        CustomStack customStack = CustomStack.byItemStack(getItemStack());
        if (customStack != null) {
            return customStack.getDisplayName();
        }

        String str = ShopChest.getInstance().getLanguageManager().getItemNameManager().getItemName(getItemStack());
        if(str.equalsIgnoreCase("ERROR")){
            Material material = getItemStack().getType();
            String[] parts = material.name().toLowerCase().split("_");
            StringBuilder name = new StringBuilder();
            for (String part : parts) {
                name.append(Character.toUpperCase(part.charAt(0)))
                        .append(part.substring(1))
                        .append(" ");
            }
            return name.toString().trim();
        }

        return str;
        //LanguageUtils.getItemName(getItemStack());
    }

    /**
     * @return The {@link ItemStack} with an amount of {@code 1}.
     */
    public ItemStack getItemStack() {
        return itemStack;
    }

    /**
     * @return The amount
     */
    public int getAmount() {
        return amount;
    }
    
}