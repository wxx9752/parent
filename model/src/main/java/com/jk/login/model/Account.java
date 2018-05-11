package com.jk.login.model;
import javax.persistence.*;
@Entity
@Table(name = "account")
public class Account {

    @Id
    @Column(name = "cwid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer cwid;

    @Column(name = "jinprice")
    private double jinprice;

    @Column(name = "goodsprice")
    private double goodsprice;

    @Column(name = "goodsname")
    private String goodsname;

    @Column(name = "profit")
    private String profit;

    @Column(name = "cwdate")
    private String cwdate;

    @Column(name = "membernum")
    private String membernum;

    public Integer getCwid() {
        return cwid;
    }

    public void setCwid(Integer cwid) {
        this.cwid = cwid;
    }

    public double getJinprice() {
        return jinprice;
    }

    public void setJinprice(double jinprice) {
        this.jinprice = jinprice;
    }

    public double getGoodsprice() {
        return goodsprice;
    }

    public void setGoodsprice(double goodsprice) {
        this.goodsprice = goodsprice;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public String getProfit() {
        return profit;
    }

    public void setProfit(String profit) {
        this.profit = profit;
    }

    public String getCwdate() {
        return cwdate;
    }

    public void setCwdate(String cwdate) {
        this.cwdate = cwdate;
    }

    public String getMembernum() {
        return membernum;
    }

    public void setMembernum(String membernum) {
        this.membernum = membernum;
    }
}
