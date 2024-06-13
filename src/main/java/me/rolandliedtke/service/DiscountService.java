package me.rolandliedtke.service;

import me.rolandliedtke.exception.InvalidDiscountCodeException;
import me.rolandliedtke.interfaces.discount.DiscountInterface;
import me.rolandliedtke.model.DiscountCode;

public class DiscountService implements DiscountInterface {

    @Override
    public Double getDiscount(String discountCode) {
        return switch (discountCode) {
            case "DISCOUNT_10" -> DiscountCode.DISCOUNT_10.value;
            case "DISCOUNT_20" -> DiscountCode.DISCOUNT_20.value;
            case "DISCOUNT_30" -> DiscountCode.DISCOUNT_30.value;
            default -> throw new InvalidDiscountCodeException("Niepoprawny kod: " + discountCode);
        };
    }
}
