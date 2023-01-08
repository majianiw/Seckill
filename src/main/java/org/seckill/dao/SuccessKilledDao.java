package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SuccessKilled;

/**
 * @InterfaceName:SuccessKilledDao
 * @Author: maojh
 * @Description:
 * @Data: create in 17:142022/11/13
 * @Modified By:
 */
public interface SuccessKilledDao {
    /**
    * @Param: * @param null
    * @Author: maojh
    * @Description:插入购买明细，可过滤重复(之前设置主键用的是两种联合主键)。返回值大于1，就说明对返回值数行进行了操作
    * @Date: 2022/11/13 17:28
    */
    int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone")long userPhone);

    /**
    * @Param:
    * @Author: maojh
    * @Description:根据id查询SuccessKilled并携带秒杀产品对象实体
    * @Date: 2022/11/13 17:28
    */
    SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId, @Param("userPhone")long userPhone);
}
