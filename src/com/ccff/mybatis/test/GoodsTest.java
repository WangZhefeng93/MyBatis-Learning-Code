package com.ccff.mybatis.test;

import com.ccff.mybatis.dao.GoodsMapper;
import com.ccff.mybatis.datasource.DataConnection;
import com.ccff.mybatis.model.Goods;
import com.ccff.mybatis.model.GoodsExample;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class GoodsTest {
    private SqlSession sqlSession;
    private GoodsMapper goodsMapper;
    private DataConnection dataConnection = new DataConnection();

    @Before
    public void init() {
        try {
            sqlSession = dataConnection.getSqlSession();
            goodsMapper = sqlSession.getMapper(GoodsMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestInsert(){
        Goods goods = new Goods();
        goods.setName("三只松鼠坚果");
        goods.setNo("SP498713");
        goods.setPrice(28.8);
        goods.setNumber(100);
        goods.setType("食品");
        goodsMapper.insert(goods);
        sqlSession.commit();
        System.out.println("插入了名为："+goods.getName()+"的商品信息");
    }

    @Test
    public void TestSelectByExample(){
        GoodsExample goodsExample = new GoodsExample();
        //通过Criteria构造查询条件
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        //查询条件1：name like 'II'
        criteria.andNameLike("%II%");
        //查询条件2：price > 1000
        criteria.andPriceGreaterThan(1000.00);
        //查询条件3：type is not null
        criteria.andTypeIsNotNull();
        //可能返回多条记录
        List<Goods> list = goodsMapper.selectByExample(goodsExample);
        for (Goods goods : list){
            System.out.println(goods.getId()+"："+goods.getName());
        }
    }

    @Test
    public void TestUpdate(){
        Goods goods = null;
        //对所有字段进行更新，需要先查询出来再更新
        goods = goodsMapper.selectByPrimaryKey(5);
        goods.setName("三只松鼠夏威夷果");
        goodsMapper.updateByPrimaryKey(goods);
        sqlSession.commit();
        System.out.println("更新id为："+goods.getId()+"的商品的所有信息");

        //对个别字段进行更新：只有传入字段不空才更新，在批量更新中使用此方法，不需要先查询再更新
        goods = new Goods();
        goods.setId(3);
        goods.setName("NIKE Kobe 15");
        goodsMapper.updateByPrimaryKeySelective(goods);
        sqlSession.commit();
        System.out.println("更新id为："+goods.getId()+"的用户商品名为："+goods.getName());
    }

    @Test
    public void TestDeleteByPrimaryKey(){
        int deleteId = 4;
        goodsMapper.deleteByPrimaryKey(deleteId);
        Goods goods = goodsMapper.selectByPrimaryKey(deleteId);
        sqlSession.commit();
        if (goods == null){
            System.out.println("删除id为："+deleteId+"的商品成功，删除成功");
        }
    }

    @After
    public void tearDown(){
        if (sqlSession != null)
            sqlSession.close();
    }
}
