package com.lanou3g.controller;

import com.lanou3g.common.ResultWrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestGameController implements GameController {
    @Override
    public ResultWrapper findGame(int page, int count) {

        List<Map<String,Object>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Map<String,Object> map = new HashMap<>();
            map.put("gameId",i+1);
            map.put("gameName","超级玛丽"+i);
            list.add(map);
        }
        //总共有78条数据  查出list条数据
        return  ResultWrapper.success(78,list);
    }
}
