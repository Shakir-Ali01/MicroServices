package com.ms.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name = "Customer",
        description = "Schema to hold Customer and Account information"
)
public class CustomerDetailsDto {

    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 5, max = 30, message = "The length of the customer name should be between 5 and 30")
    @Schema(
            description = "Name of the customer", example = "Ms Boss"
    )
    private String name;


    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Email address should be a valid value")
    @Schema(
            description = "Email address of the customer", example = "tutor@msboss.com"
    )
    private String email;
    @NotEmpty(message = "Mobile number cannot be empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    @Schema(
            description = "Mobile Number of the customer", example = "9345432123"
    )
    private String mobileNumber;

    @Schema(
            description = "Account details of the Customer"
    )
    private AccountDto accountDto;

    @Schema(
            description = "Cards details of the Customer"
    )
    private CardsDto cardsDto;

    @Schema(
            description = "Loans details of the Customer"
    )
    private LoansDto loansDto;

}
