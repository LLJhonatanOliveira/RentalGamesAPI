package com.rentalgames.api.services;

import org.springframework.stereotype.Service;

import com.rentalgames.api.dtos.CustomerDTO;
import com.rentalgames.api.exceptions.ConflictCustomerCpfException;
import com.rentalgames.api.exceptions.CustomerNotFoundException;
import com.rentalgames.api.models.CustomerModel;
import com.rentalgames.api.repositories.CustomerRepository;

import jakarta.validation.Valid;
import lombok.NonNull;
@Service
public class CustomerService {

  private final CustomerRepository customerRepository;

  public CustomerService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public CustomerModel findById(@NonNull Long id) {
    return customerRepository.findById(id).orElseThrow(() -> {
      throw new CustomerNotFoundException();
    });
  }

  public CustomerModel create(CustomerDTO dto) {
    if (customerRepository.existsByCpf(dto.getCpf())) {
      throw new ConflictCustomerCpfException();
    }
    return customerRepository.save(new CustomerModel(dto));
  }

  public CustomerModel update(@NonNull Long id, @Valid CustomerDTO dto) {
    CustomerModel customer = customerRepository.findById(id).orElseThrow(() -> {
      throw new CustomerNotFoundException();
    });
    if (customer.getCpf() != dto.getCpf() && customerRepository.existsByCpf(dto.getCpf())) {
      throw new ConflictCustomerCpfException();
    }
    CustomerModel newCustomer = new CustomerModel(dto);

    newCustomer.setId(id);
    return customerRepository.save(newCustomer);
  }

}