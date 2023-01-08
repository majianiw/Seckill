package org.seckill.service;

//import ch.qos.logback.classic.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.SeckillException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"" +
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class SeckillServiceTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillId() {

        List<Seckill> list = seckillService.getSeckillList();
        logger.info("list = {}",list);
        for(Seckill seckill : list){
            System.out.println(seckill);
        }
    }

    @Test
    public void getById() {
        long id = 1000;
        Seckill seckill = seckillService.getById(id);
        logger.info("seckillid = {}",seckill);
    }

    @Test
    public void exportSeckillUrl() {
        long id = 1000;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        logger.info("export = {}",exposer);
//      Exposer{exposed=true,
//      md5='0baf5476f31a88a70cdbb56d8a9155f4',
//      seckillId=1000,
//      now=0, start=0, end=0}
    }

    @Test
    public void executeSeckill() {
        long id = 1000;
        long phone = 13891977541L;
        String md5 = "0baf5476f31a88a70cdbb56d8a9155f4";
        SeckillExecution execution = seckillService.executeSeckill(id,phone,md5);
        logger.info("result={}",execution);

//        result=SeckillExecution{seckillId=1000, state=1, stateInfo='秒杀成功',
//                  successKilled=SuccessKilled{
//                  seckillId=1000, userPhone=13891977541,
//                  state=0, createTime=Mon Nov 21 12:53:20 CST 2022}}
    }
    @Test
    public void executeSeckillProcedure() {
        long seckillId = 1001;
        long phone = 1368011101;
        Exposer exposer = seckillService.exportSeckillUrl(seckillId);
        if (exposer.isExposed()) {
            String md5 = exposer.getMd5();
            SeckillExecution execution = seckillService.executeSeckillProcedure(seckillId, phone, md5);
            logger.info(execution.getStateInfo());
        }
    }
}