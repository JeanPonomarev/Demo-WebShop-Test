package com.tricentis.demowebshop.enum_labels;

public enum RegistrationLabels {
    REGISTRATION_COMPLETED_TEXT("Your registration completed"),
    FIRST_NAME_ERROR_LABEL("First name is required."),
    LAST_NAME_ERROR_LABEL("Last name is required."),
    EMAIL_REQUIRED_ERROR_LABEL("Email is required."),
    PASSWORD_ERROR_LABEL("Password is required."),
    PASSWORD_MISMATCH_ERROR_LABEL("The password and confirmation password do not match."),
    EMAIL_ALREADY_EXISTS_ERROR_LABEL("The specified email already exists"),
    WRONG_EMAIL_ERROR_LABEL("Wrong email"),
    SHORT_PASSWORD_ERROR_LABEL("The password should have at least 6 characters.");

    private final String name;

    RegistrationLabels(String labelText) {
        this.name = labelText;
    }

    @Override
    public String toString() {
        return name;
    }
}
