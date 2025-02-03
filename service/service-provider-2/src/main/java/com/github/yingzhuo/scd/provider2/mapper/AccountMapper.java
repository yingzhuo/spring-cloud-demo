package com.github.yingzhuo.scd.provider2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.yingzhuo.scd.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

@Mapper
public interface AccountMapper extends BaseMapper<Account> {

    public void addBalance(@Param("accountId") Long accountId, @Param("balance") BigDecimal balance);

}
