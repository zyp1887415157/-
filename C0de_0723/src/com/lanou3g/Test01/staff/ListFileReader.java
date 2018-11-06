package com.lanou3g.Test01.staff;

import com.lanou3g.Test01.entity.GoodsList;
import com.lanou3g.Test01.equipment.GoodsShelf;

/**
 * 解析器
 *
 * @author 铭
 */
public interface ListFileReader {

    boolean loadListToShelf(GoodsList list, GoodsShelf shelf) throws Exception;

    boolean store(GoodsList list2, GoodsShelf shelf2);
}
