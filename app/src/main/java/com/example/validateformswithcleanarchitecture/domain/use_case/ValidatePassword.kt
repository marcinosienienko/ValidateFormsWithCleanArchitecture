package com.example.validateformswithcleanarchitecture.domain.use_case

class ValidatePassword {
    fun execute(password: String): ValidationResult{
        if (password.length in 9..31)
            return ValidationResult(
                successful = false,
                errorMessage = "The password should be between 8 and 32 characters"
            )
        val containsLettersAndDigit = password.any { it.isLetter() } && password.any{ it.isDigit()}

        if (!containsLettersAndDigit) {
            return ValidationResult(
                successful = false,
                errorMessage = "The password needs to contain at least one letter and digit"
            )
        }
        return ValidationResult(
            successful = true
        )
    }

}