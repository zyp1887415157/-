package com.lanou3g.dao;

import com.lanou3g.bean.GameBean;

import java.util.List;

public interface GameDao {

    //总数
    int queryTotalCount() throws Exception;

    //查询内容
    List<GameBean> queryLimit(int offset, int count) throws Exception;

}
