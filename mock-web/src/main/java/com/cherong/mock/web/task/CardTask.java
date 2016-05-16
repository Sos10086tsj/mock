package com.cherong.mock.web.task;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.annotation.Resource;

import org.apache.commons.lang.math.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cherong.mock.domain.api.bank.constant.CardCurrencyType;
import com.cherong.mock.domain.api.bank.model.Card;
import com.cherong.mock.web.bank.logic.CardLogic;

/**
 * Description:
 * Auth:Paris
 * Date:May 16, 2016
**/
@Component
public class CardTask {
	private Logger logger = LoggerFactory.getLogger(CardTask.class);
	@Resource
	private CardLogic cardLogic;

	/**
	 * 每日定期开卡
	 */
	@Scheduled(cron = "0 0 6 * * ?")
	public void applyCard(){
		this.logger.info("Start daily card applying.");
		int random = RandomUtils.nextInt(20);
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		String yearStr = String.valueOf(year - 2000);
		String monthStr = month > 9 ? String.valueOf(month) : "0" + month;
		String dayStr = day > 9 ? String.valueOf(day) : "0" + day;
		BigDecimal zero = new BigDecimal(0);
		
		for (int i = 0; i < random; i++) {
			Card card = new Card();
			long time = System.currentTimeMillis();//1463387338869
			card.setAccno("390" + time + i);//39010000210044200
			card.setMdcardno("62223300" + yearStr + monthStr + dayStr + i + RandomUtils.nextInt(10));//6222330055127450
			card.setLstbal(zero);
			card.setDtopamt(zero);
			card.setAcpayamt(zero);
			card.setLstlfee(zero);
			card.setLstiint(zero);
			card.setLstoint(zero);
			card.setCurrtype(CardCurrencyType.RMB);
			card.setCino(year + monthStr + dayStr + i + RandomUtils.nextInt(100));//100100265945931
			card.setLetpaamt(zero);
			card.setLstpbal(zero);
			
			this.cardLogic.update(card);
		}
		this.logger.info("Daily card applying done.");
	}
	
	public static void main(String args[]) {
		System.out.println(System.currentTimeMillis());
	}
}
