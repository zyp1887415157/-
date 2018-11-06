package com.lanou3g.homeWork;

import java.util.ArrayList;
import java.util.List;

public abstract class GoodsContainer {


    public static class GoodsCell{
        private Goods goods;
        private int quantity;

        public GoodsCell(Goods goods, int quantity) {
            this.goods = goods;
            this.quantity = quantity;
        }

        public GoodsCell() {
        }

        public Goods getGoods() {
            return goods;
        }

        public GoodsCell setGoods(Goods goods) {
            this.goods = goods;
            return this;
        }

        public int getQuantity() {
            return quantity;
        }

        public GoodsCell setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }
    }


}
