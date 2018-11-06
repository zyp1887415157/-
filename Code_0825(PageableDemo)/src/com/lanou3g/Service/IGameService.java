package com.lanou3g.Service;

import com.lanou3g.common.ResultWrapper;

//声明接口的另一种方式 I开头
//Service 层, 一般用来做业务逻辑的处理
public interface IGameService {
    ResultWrapper games(int page,int count);
}
