package com.cherong.mock.domain.api.bank.service;

import com.cherong.mock.common.base.jpa.service.BaseService;
import com.cherong.mock.domain.api.bank.model.Bank;

/**
 * Description:
 * Auth:Paris
 * Date:Apr 19, 2016
**/
public interface BankService extends BaseService<Bank, Long>{
	/**
	 * 创建银行
	 * @param bank
	 * @return
	 */
	public Bank createBank(Bank bank);
}
