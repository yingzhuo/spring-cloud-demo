package com.github.yingzhuo.scd.provider1.service;

import java.math.BigDecimal;

public interface AccountService {

    public void addBalance(Long accountId, BigDecimal balance);

}
