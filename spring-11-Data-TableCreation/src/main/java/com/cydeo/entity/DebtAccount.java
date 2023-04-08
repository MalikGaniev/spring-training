package com.cydeo.entity;

import javax.persistence.Entity;
import java.math.BigDecimal;
@Entity
public class DebtAccount extends Account{
    private BigDecimal overDraftFee;
}
