package com.cherong.mock.domain.company.service.impl;

import org.springframework.stereotype.Service;

import com.cherong.mock.common.base.jpa.service.BaseServiceImpl;
import com.cherong.mock.domain.api.company.model.Company;
import com.cherong.mock.domain.api.company.service.CompanyService;

/**
 * Description:
 * Auth:Paris
 * Date:Apr 19, 2016
**/
@Service("companyService")
public class CompanyServiceImpl extends BaseServiceImpl<Company, Long> implements CompanyService{

}
