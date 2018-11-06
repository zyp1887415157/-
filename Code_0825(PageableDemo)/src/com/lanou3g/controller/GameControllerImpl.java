package com.lanou3g.controller;

import com.lanou3g.Service.GameService;
import com.lanou3g.Service.IGameService;
import com.lanou3g.common.ResultWrapper;

//controller 层,一般用来处理前端传递过来的数据
public class GameControllerImpl implements GameController {

    private IGameService gameService = new GameService();

    @Override
    public ResultWrapper findGame(int page, int count) {
        //由于前端传来的参数已经在Servlet处理完了
        //所以该层没有什么逻辑了
        //直接把数据传递给Service层进行处理
        return gameService.games(page, count);
    }
}
