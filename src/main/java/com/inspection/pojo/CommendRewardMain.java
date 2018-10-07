package com.inspection.pojo;

import com.inspection.entity.commendreward.CommendRewardEntity;

import java.util.Date;
import java.util.List;

public class CommendRewardMain {
    private CommendRewardEntity entity;

    public CommendRewardEntity getEntity() {
        return entity;
    }

    public void setEntity(CommendRewardEntity entity) {
        this.entity = entity;
    }

    private String jiangLiLeiXing;
    private String tiMingLeiXing;

    //事迹材料
    private byte[] shiJiCaiLiao;

    //群众评议
    private int yingDao; //应到人数
    private int shiDao; //实到人数
    private int youXiao; //有效人数
    private String chuQin; //出勤率
    private int zanCheng; //赞成票
    private String testRate; //得票率

    //组织审批
    private Date zhiBuTime;
    private String zhiBuJueDing;
    private Date dangWeiTime;
    private String dangWeiJueDing;

    //军事训练成绩
    private List<JunShiXunLian> junShiXunLian;

    //今年取得成绩
    private List<String> biaoZhang;

    public String getJiangLiLeiXing() {
        return jiangLiLeiXing;
    }

    public void setJiangLiLeiXing(String jiangLiLeiXing) {
        this.jiangLiLeiXing = jiangLiLeiXing;
    }

    public String getTiMingLeiXing() {
        return tiMingLeiXing;
    }

    public void setTiMingLeiXing(String tiMingLeiXing) {
        this.tiMingLeiXing = tiMingLeiXing;
    }

    public byte[] getShiJiCaiLiao() {
        return shiJiCaiLiao;
    }

    public void setShiJiCaiLiao(byte[] shiJiCaiLiao) {
        this.shiJiCaiLiao = shiJiCaiLiao;
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

    public Date getDangWeiTime() {
        return dangWeiTime;
    }

    public void setDangWeiTime(Date dangWeiTime) {
        this.dangWeiTime = dangWeiTime;
    }

    public String getDangWeiJueDing() {
        return dangWeiJueDing;
    }

    public void setDangWeiJueDing(String dangWeiJueDing) {
        this.dangWeiJueDing = dangWeiJueDing;
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
