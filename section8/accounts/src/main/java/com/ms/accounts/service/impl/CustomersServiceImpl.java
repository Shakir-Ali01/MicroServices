package com.ms.accounts.service.impl;

import com.ms.accounts.dto.AccountDto;
import com.ms.accounts.dto.CardsDto;
import com.ms.accounts.dto.CustomerDetailsDto;
import com.ms.accounts.dto.LoansDto;
import com.ms.accounts.entitty.Accounts;
import com.ms.accounts.entitty.Customer;
import com.ms.accounts.exception.ResourceNotFoundException;
import com.ms.accounts.mapper.AccountMapper;
import com.ms.accounts.mapper.CustomerMapper;
import com.ms.accounts.repository.AccountsRepository;
import com.ms.accounts.repository.CustomerRepository;
import com.ms.accounts.service.ICustomersService;
import com.ms.accounts.service.client.CardsFeignClient;
import com.ms.accounts.service.client.LoansFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomersServiceImpl implements ICustomersService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;

    /**
     * @param mobileNumber - Input Mobile Number
     * @return Customer Details based on a given mobileNumber
     */
    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString())
        );

        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
        customerDetailsDto.setAccountDto(AccountMapper.mapToAccountsDto(accounts, new AccountDto()));
        System.out.println("Hello Testing");
        ResponseEntity<LoansDto> loansDtoResponseEntity = loansFeignClient.fetchLoanDetails(mobileNumber);
        customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());
        System.out.println(customerDetailsDto.getEmail());
        ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsFeignClient.fetchCardDetails(mobileNumber);
        customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());

        return customerDetailsDto;

    }
}