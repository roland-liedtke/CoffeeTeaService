package me.rolandliedtke.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The DiscountCode enum represents various discount codes that can be applied to a tea order.
 * <p>
 * Each discount code has a value that typically represents the percentage discount it provides.
 * </p>
 */
@AllArgsConstructor
@Getter
public enum DiscountCode {

    /**
     * Represents no discount.
     * This code has a value of 0.0.
     */
    EMPTY(0.0),

    /**
     * Represents a 10% discount.
     * This code has a value of 0.1.
     */
    DISCOUNT_10(0.1),

    /**
     * Represents a 20% discount.
     * This code has a value of 0.2.
     */
    DISCOUNT_20(0.2),

    /**
     * Represents a 30% discount.
     * This code has a value of 0.3.
     */
    DISCOUNT_30(0.3);

    public final double value;
}
