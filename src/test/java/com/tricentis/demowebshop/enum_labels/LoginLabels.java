package com.tricentis.demowebshop.enum_labels;

public enum LoginLabels {
    UNSUCCESSFUL_LOGIN_ERROR_LABEL("Login was unsuccessful. Please correct the errors and try again."),
    NO_ACCOUNT_FOUND_ERROR_LABEL("No customer account found"),
    INVALID_EMAIL_ERROR_LABEL("Please enter a valid email address."),
    INVALID_PASSWORD_ERROR_LABEL("The credentials provided are incorrect");

    private final String name;

    LoginLabels(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
