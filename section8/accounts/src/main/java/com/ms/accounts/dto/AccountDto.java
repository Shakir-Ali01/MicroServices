package com.ms.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Schema(
        name = "Accounts",
        description = "Schema to hold Account information"
)
public class AccountDto {
    @NotEmpty(message = "Account number cannot be empty")
    @Pattern(regexp = "[0-9]{10}", message = "Account number must be a number")
    @Schema(
            description = "Account Number of Ms Bank account", example = "3454433243"
    )
    private Long accountNumber;

    @NotEmpty(message = "Account type cannot be empty")
    @Schema(
            description = "Account type of Ms Bank account", example = "Savings"
    )
    private String accountType;

    @Schema(
            description = "Eazy Bank branch address", example = "123 NewYork"
    )
    @NotEmpty(message = "Branch address cannot be empty")
    private String branchAddress;
}
