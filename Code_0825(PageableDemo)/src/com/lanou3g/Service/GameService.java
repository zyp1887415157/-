package com.lanou3g.Service;

import com.lanou3g.bean.GameBean;
import com.lanou3g.common.ResultWrapper;
import com.lanou3g.dao.GameDao;
import com.lanou3g.dao.GameDaoImpl;

import java.util.List;

public class GameService implements IGameService {

    private GameDao gameDao = new GameDaoImpl();
    @Override
    public ResultWrapper games(int page, int count) {

        try {
            //1.把page进行计算得到limit 参数
            int offset = (page - 1) * count;
            //2.查询数据总数
            int totalCount = gameDao.queryTotalCount();
            //3.查询需要的数据
            List<GameBean> items = gameDao.queryLimit(offset,count);
            //4.处理异常

            //5.数据整合为ResultWrapper
            return ResultWrapper.success(totalCount,items);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultWrapper.error(406,"查询数据不存在");
        }
    }
}
