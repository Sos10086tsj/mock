package com.cherong.mock.domain.base;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * Description:
 * Auth:Paris
 * Date:Apr 7, 2016
**/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
@TransactionConfiguration(transactionManager = "bankTransactionManager", defaultRollback = true)
public class BaseBankTestService extends AbstractTransactionalJUnit4SpringContextTests{

}
