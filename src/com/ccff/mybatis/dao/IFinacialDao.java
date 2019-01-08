package com.ccff.mybatis.dao;

import com.ccff.mybatis.model.Batch;
import com.ccff.mybatis.model.Customer;
import com.ccff.mybatis.model.FinacialProduct;

import java.util.List;

public interface IFinacialDao {
    //一对多查询：根据用户id查询该用户信息及用户所购买的理财产品批次信息。
    Customer selectCustomerByIdUnion(int cus_id);
    Customer selectCustomerByIdAlone(int cus_id);

    //多对一查询：查询batch批次表，并在查询时通过外键cus_id查询中customer用户表的数据
    List<Batch> selectAllBatchUnion();
    List<Batch> selectAllBatchAlone();

    //多对多查询：查询finacial_products表，及每个理财产品所被包含的批次信息
    List<FinacialProduct> selectAllFinacialProduct();

}
