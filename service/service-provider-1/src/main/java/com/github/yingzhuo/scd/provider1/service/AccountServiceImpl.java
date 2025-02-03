package com.github.yingzhuo.scd.provider1.service;

import com.github.yingzhuo.scd.provider1.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.math.BigDecimal;

@Slf4j
@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountMapper accountMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addBalance(Long accountId, BigDecimal balance) {
        Assert.notNull(accountId, "accountId is required");
        Assert.notNull(balance, "balance is required");

        if (balance.compareTo(BigDecimal.ZERO) != 0) {
            accountMapper.addBalance(accountId, balance);
        }
    }

}
