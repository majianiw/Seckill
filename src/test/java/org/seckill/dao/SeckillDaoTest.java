package org.seckill.dao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 首先需要配置spring 和 junit 整合，为了junit启动时加载springIOC容器
 * spring-test,junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring 配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {
    //注入Dao依赖
    @Resource
    private  SeckillDao seckillDao;

//    updateCount=0
    @Test
    public void reduceNumber() {
        Date killTime =new Date();
        int updateCount = seckillDao.reduceNumber(1000L,killTime);
        System.out.println("updateCount=" + updateCount);

    }
//1000元秒杀iphone14
//seckill{seckillid=1000, name='1000元秒杀iphone14', number=100, startTime=Thu May 21 00:00:00 CST 2020, endTime=Sat May 21 00:00:00 CST 2022, createTime=Sun Nov 13 12:54:27 CST 2022}
    @Test
    public void queryById() {
        long id = 1000;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);
    }
//seckill{seckillid=1000, name='1000元秒杀iphone14', number=100, startTime=Thu May 21 00:00:00 CST 2020, endTime=Sat May 21 00:00:00 CST 2022, createTime=Sun Nov 13 12:54:27 CST 2022}
//seckill{seckillid=1001, name='500元秒杀ipad2', number=200, startTime=Thu May 21 00:00:00 CST 2020, endTime=Sat May 21 00:00:00 CST 2022, createTime=Sun Nov 13 12:54:27 CST 2022}
//seckill{seckillid=1002, name='300元秒杀小米4', number=300, startTime=Thu May 21 00:00:00 CST 2020, endTime=Sat May 21 00:00:00 CST 2022, createTime=Sun Nov 13 12:54:27 CST 2022}
//seckill{seckillid=1003, name='200元秒杀红米note', number=400, startTime=Thu May 21 00:00:00 CST 2020, endTime=Sat May 21 00:00:00 CST 2022, createTime=Sun Nov 13 12:54:27 CST 2022}
    @Test
    public void queryAll() {
        List<Seckill> seckills = seckillDao.queryAll(0,100);
        for (Seckill seckill:seckills) {
            System.out.println(seckill);
        }
    }
}