package com.cherong.mock.domain.bank.service.impl;

import org.springframework.stereotype.Service;

import com.cherong.mock.common.base.jpa.service.BaseServiceImpl;
import com.cherong.mock.domain.api.bank.model.Bank;
import com.cherong.mock.domain.api.bank.service.BankService;

/**
 * Description:
 * Auth:Paris
 * Date:Apr 19, 2016
**/
@Service
public class BankServiceImpl extends BaseServiceImpl<Bank, Long> implements BankService{

	@Override
	public Bank createBank(Bank bank) {
		return this.save(bank);
	}

}
