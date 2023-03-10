package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface SeckillDao {

    //减库存
    int reduceNumber(@Param("seckillId")long seckillId, @Param("killTime")Date killTime);

    //根据id查询秒杀对象
    Seckill queryById(long seckilled);

    //根据偏移量查询秒杀商品列表
    List<Seckill> queryAll(@Param("offset") int offset,@Param("limit") int limit);

    /**
    * @Param:
    * @Author: maojh
    * @Description:使用存储过程执行秒杀
    * @Date: 2023/1/6 9:16
    */
    void killByProcedure(Map<String,Object> paramMap);
}
