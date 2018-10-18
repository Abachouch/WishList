package io.github.abachouch.wishlist.data;

import java.util.Date;

public class Wish {
    private String title ;
    private String info ;
    private int order ;
    private float cost ;
    private Date date ;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getCost() {
        return cost;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }


    public Wish(String title , Date date , float cost , int order , String info ){
        this.title = title.trim() ;
        this.info = info.trim();
        this.date = date ;
        this.cost = cost ;
        this.order = order ;
    }

    public Wish(String title ,String info , float cost , int order   ){
        this.title = title ;
        this.date = new Date();
        this.cost = cost ;
        this.order = order ;
        this.info = info ;
    }

    public Wish(String title){
        this.title = title ;
    }

    public Wish(){}


}
