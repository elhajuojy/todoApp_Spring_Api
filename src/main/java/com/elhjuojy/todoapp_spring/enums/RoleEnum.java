package com.elhjuojy.todoapp_spring.enums;

public enum RoleEnum {
    ADMIN("admin") ,
    USER("user"),
    MANAGER("manager"),
    PRODUCT_MANAGER("product_manager"),
    CUSTOMER_MANAGER("customer_manager");

    public final String label;

    private RoleEnum(String label) {
        this.label = label;
    }

}
