package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class SuccessKilledDaoTest {
    @Resource
    private SuccessKilledDao successKilledDao;

    @Test
    public void insertSuccessKilled() {
//      第一次执行：insertCount = 1
//      第二次执行：insertCount = 0   因为sql中定义它id 和phone 为联合主键，所以不允许重复插入，也就是不能重复秒杀,
//                  然后在seckillDao.xml中加了ignore，所以不会有主键异常报错
        long id = 1000;
        long phone = 13502181181L;
        int insertCount = successKilledDao.insertSuccessKilled(id, phone);
        System.out.println("insertCount = "+ insertCount );
    }

//    SuccessKilled{seckillId=1000, userPhone=13502181181, state=-1, createTime=Fri Nov 19 13:29:40 CST 2021}
//seckill{seckillid=1000, name='1000元秒杀iphone14', number=0, startTime=Thu May 21 00:00:00 CST 2020, endTime=Sat May 21 00:00:00 CST 2022, createTime=Sun Nov 13 12:54:27 CST 2022}
    @Test
    public void queryByIdWithSeckill() {
        long id = 1000;
        long phone = 13502181181L;
        SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(id, phone);
        System.out.println(successKilled);
        System.out.println(successKilled.getSeckill());
    }
}