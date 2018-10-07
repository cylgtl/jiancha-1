package com.inspection.pojo;

import com.inspection.entity.leave.SoldierLeaveEntity;
import com.inspection.entity.officerleave.OfficerLeaveEntity;

import java.util.Date;

public class OfficerLeaveMain {
    private OfficerLeaveEntity entity;

    public OfficerLeaveEntity getEntity() {
        return entity;
    }

    public void setEntity(OfficerLeaveEntity entity) {
        this.entity = entity;
    }

    private SoldierLeaveEntity soldierEntity;

    public SoldierLeaveEntity getSoldierEntity() {
        return soldierEntity;
    }

    public void setSoldierEntity(SoldierLeaveEntity soldierEntity) {
        this.soldierEntity = soldierEntity;
    }

    //个人休假计划
    public int ciShi1 = 1;
    public int ciShi2 = 2;
    private int jiHuaXiuJia1;
    private int jiHuaXiuJia2;

    //休假情况
    private int zongTianShu;
    private int yiXiuTianShu;
    private int weiXiuTianShu;
    private String xiuJiaLeiXing;
    private int benCiXiuJia;
    private int shengYuTianShu;
    private Date startTime;
    private Date endTime;
    private Date liDuiShiJian;
    private Date xiaoJiaShiJian;
    private String zaiWeiLv;

    public int getCiShi1() {
        return ciShi1;
    }

    public void setCiShi1(int ciShi1) {
        this.ciShi1 = ciShi1;
    }

    public int getCiShi2() {
        return ciShi2;
    }

    public void setCiShi2(int ciShi2) {
        this.ciShi2 = ciShi2;
    }

    public int getJiHuaXiuJia1() {
        return jiHuaXiuJia1;
    }

    public void setJiHuaXiuJia1(int jiHuaXiuJia1) {
        this.jiHuaXiuJia1 = jiHuaXiuJia1;
    }

    public int getJiHuaXiuJia2() {
        return jiHuaXiuJia2;
    }

    public void setJiHuaXiuJia2(int jiHuaXiuJia2) {
        this.jiHuaXiuJia2 = jiHuaXiuJia2;
    }

    public int getZongTianShu() {
        return zongTianShu;
    }

    public void setZongTianShu(int zongTianShu) {
        this.zongTianShu = zongTianShu;
    }

    public int getYiXiuTianShu() {
        return yiXiuTianShu;
    }

    public void setYiXiuTianShu(int yiXiuTianShu) {
        this.yiXiuTianShu = yiXiuTianShu;
    }

    public int getWeiXiuTianShu() {
        return weiXiuTianShu;
    }

    public void setWeiXiuTianShu(int weiXiuTianShu) {
        this.weiXiuTianShu = weiXiuTianShu;
    }

    public String getXiuJiaLeiXing() {
        return xiuJiaLeiXing;
    }

    public void setXiuJiaLeiXing(String xiuJiaLeiXing) {
        this.xiuJiaLeiXing = xiuJiaLeiXing;
    }

    public int getBenCiXiuJia() {
        return benCiXiuJia;
    }

    public void setBenCiXiuJia(int benCiXiuJia) {
        this.benCiXiuJia = benCiXiuJia;
    }

    public int getShengYuTianShu() {
        return shengYuTianShu;
    }

    public void setShengYuTianShu(int shengYuTianShu) {
        this.shengYuTianShu = shengYuTianShu;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getLiDuiShiJian() {
        return liDuiShiJian;
    }

    public void setLiDuiShiJian(Date liDuiShiJian) {
        this.liDuiShiJian = liDuiShiJian;
    }

    public Date getXiaoJiaShiJian() {
        return xiaoJiaShiJian;
    }

    public void setXiaoJiaShiJian(Date xiaoJiaShiJian) {
        this.xiaoJiaShiJian = xiaoJiaShiJian;
    }

    public String getZaiWeiLv() {
        return zaiWeiLv;
    }

    public void setZaiWeiLv(String zaiWeiLv) {
        this.zaiWeiLv = zaiWeiLv;
    }
}
