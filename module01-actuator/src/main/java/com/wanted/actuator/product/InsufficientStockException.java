package com.wanted.actuator.product;

public class InsufficientStockException extends RuntimeException {
    public InsufficientStockException() {
        super("상품 재고 부족!!");
    }
}
