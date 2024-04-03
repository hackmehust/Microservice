package com.thangnh28.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
//    @Query("select ce from CurrencyExchange ce where ce.from = :from and ce.to = :to")
    CurrencyExchange findByFromAndTo(String from, String to);
}
