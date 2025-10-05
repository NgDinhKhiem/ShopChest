package de.epiceric.shopchest.shop;

import de.epiceric.shopchest.ShopChest;
import dev.lone.itemsadder.api.CustomStack;
import dev.lone.itemsadder.api.ItemsAdder;
import net.kyori.adventure.text.Component;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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

        return ShopChest.getInstance().getLanguageManager().getItemNameManager().getItemName(getItemStack());
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