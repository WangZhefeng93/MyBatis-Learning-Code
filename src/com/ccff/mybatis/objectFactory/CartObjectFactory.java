package com.ccff.mybatis.objectFactory;

import com.ccff.mybatis.model.ShoppingCart;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.util.List;
import java.util.Properties;

public class CartObjectFactory extends DefaultObjectFactory {
    //处理默认构造方法
    @Override
    public <T> T create(Class<T> type) {
        return super.create(type);
    }

    //处理有参构造方法
    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        //DefaultObjectFactory的create(Class<T> type)方法也会调用此方法
        //所以，只需要在此方法中添加逻辑即可
        T ret = super.create(type, constructorArgTypes, constructorArgs);
        //判断加载的类的类型，然后执行init方法
        if (ShoppingCart.class.isAssignableFrom(type)){
            ShoppingCart entity = (ShoppingCart) ret;
            entity.init();
        }
        return ret;
    }

    //处理参数
    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
    }

    //处理集合类型参数
    @Override
    protected Class<?> resolveInterface(Class<?> type) {
        return super.resolveInterface(type);
    }
}
