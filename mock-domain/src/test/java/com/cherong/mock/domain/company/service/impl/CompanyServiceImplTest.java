package com.cherong.mock.domain.company.service.impl;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;

import com.cherong.mock.domain.base.BaseBankTestService;
import com.cherong.mock.domain.company.model.Company;
import com.cherong.mock.domain.company.service.CompanyService;

/**
 * Description:
 * Auth:Paris
 * Date:Apr 19, 2016
**/
public class CompanyServiceImplTest extends BaseBankTestService{

	@Resource
	private CompanyService companyService;
	@Test
	public void testFindOne() {
		Company company = this.companyService.findOne(1l);
		assertNotNull(company);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>:" +company);
	}

}
