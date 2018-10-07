package com.inspection.pojo;

import com.inspection.entity.backbone.BackboneEntity;

import java.util.Date;
import java.util.List;

public class BackboneMain {
    private BackboneEntity entity;

    public BackboneEntity getEntity() {
        return entity;
    }

    public void setEntity(BackboneEntity entity) {
        this.entity = entity;
    }

    //班排推荐
    private String banPaiTuiJian;

    //民主推荐
    private int yingDao; //应到人数
    private int shiDao; //实到人数
    private int youXiao; //有效人数
    private String chuQin; //出勤率
    private int zanCheng; //赞成票
    private String testRate; //得票率

    //组织审批
    private Date zhiBuTime;
    private String zhiBuJueDing;
    private Date yingDangWeiTime;
    private String yingDangWeiJueDing;

    //军事训练成绩
    private List<JunShiXunLian> junShiXunLian;

    //表彰与获奖情况
    private List<String> biaoZhang;

    public String getBanPaiTuiJian() {
        return banPaiTuiJian;
    }

    public void setBanPaiTuiJian(String banPaiTuiJian) {
        this.banPaiTuiJian = banPaiTuiJian;
    }

    public int getYingDao() {
        return yingDao;
    }

    public void setYingDao(int yingDao) {
        this.yingDao = yingDao;
    }

    public int getShiDao() {
        return shiDao;
    }

    public void setShiDao(int shiDao) {
        this.shiDao = shiDao;
    }

    public int getYouXiao() {
        return youXiao;
    }

    public void setYouXiao(int youXiao) {
        this.youXiao = youXiao;
    }

    public String getChuQin() {
        return chuQin;
    }

    public void setChuQin(String chuQin) {
        this.chuQin = chuQin;
    }

    public int getZanCheng() {
        return zanCheng;
    }

    public void setZanCheng(int zanCheng) {
        this.zanCheng = zanCheng;
    }

    public String getTestRate() {
        return testRate;
    }

    public void setTestRate(String testRate) {
        this.testRate = testRate;
    }

    public Date getZhiBuTime() {
        return zhiBuTime;
    }

    public void setZhiBuTime(Date zhiBuTime) {
        this.zhiBuTime = zhiBuTime;
    }

    public String getZhiBuJueDing() {
        return zhiBuJueDing;
    }

    public void setZhiBuJueDing(String zhiBuJueDing) {
        this.zhiBuJueDing = zhiBuJueDing;
    }

    public Date getYingDangWeiTime() {
        return yingDangWeiTime;
    }

    public void setYingDangWeiTime(Date yingDangWeiTime) {
        this.yingDangWeiTime = yingDangWeiTime;
    }

    public String getYingDangWeiJueDing() {
        return yingDangWeiJueDing;
    }

    public void setYingDangWeiJueDing(String yingDangWeiJueDing) {
        this.yingDangWeiJueDing = yingDangWeiJueDing;
    }

    public List<JunShiXunLian> getJunShiXunLian() {
        return junShiXunLian;
    }

    public void setJunShiXunLian(List<JunShiXunLian> junShiXunLian) {
        this.junShiXunLian = junShiXunLian;
    }

    public List<String> getBiaoZhang() {
        return biaoZhang;
    }

    public void setBiaoZhang(List<String> biaoZhang) {
        this.biaoZhang = biaoZhang;
    }
}
