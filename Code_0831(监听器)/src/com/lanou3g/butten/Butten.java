package com.lanou3g.butten;
//主题
public class Butten {

    // 就相当于 List<Observer>
    private OnClickListener onClickListener;

    public void performClick(){
        if (onClickListener!=null){
            onClickListener.onClick(this);
        }
    }

    //就相当于  addObserver 的方法
    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    //观察者  Observer
    public interface OnClickListener{
        void onClick(Butten btn);
    }

}
