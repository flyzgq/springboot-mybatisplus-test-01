package com.fly.springboot.handler;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author fly
 * @date 2018/7/8 18:20
 * @description: 自定义公共字段填充处理器
 **/
public class MyMetaObjectHandler extends MetaObjectHandler {

    public static final Logger LOGGER = LoggerFactory.getLogger(MyMetaObjectHandler.class);
    /**
     * <p>
     * 插入元对象字段填充
     * </p>
     *
     * @param metaObject 元对象
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        /*获取需要被填充测字段的值*/
        Object fieldValByName = this.getFieldValByName("name", metaObject);
        if(fieldValByName == null){
            LOGGER.debug("*******************插入操作, 满足填充条件***********************");
            this.setFieldValByName("name", "flyzgq", metaObject);
        }
    }

    /**
     * 更新元对象字段填充（用于更新时对公共字段的填充）
     * Created with IntelliJ IDEA.
     * Author:  Wu Yujie
     * Email:  coffee377@dingtalk.com
     * Time:  2017/04/16 15:03
     *
     * @param metaObject 元对象
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        /*获取需要被填充测字段的值*/
        Object fieldValByName = this.getFieldValByName("name", metaObject);
        if(fieldValByName == null){
            LOGGER.debug("*******************更新操作, 满足填充条件***********************");
            this.setFieldValByName("name", "zgq", metaObject);
        }
    }
}
