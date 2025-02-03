package com.github.yingzhuo.scd.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@TableName("t_account")
public class Account implements Serializable {

    @TableId("id")
    private Long id;

    @TableField("account")
    private String account;

    @TableField("balance")
    private BigDecimal balance;

}
