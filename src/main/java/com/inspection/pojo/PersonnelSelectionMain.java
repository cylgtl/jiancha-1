package com.inspection.pojo;

import com.inspection.entity.personnelSelection.PersonnelSelectionEntity;

import java.util.Date;

public class PersonnelSelectionMain {
    private PersonnelSelectionEntity entity;

    public PersonnelSelectionEntity getEntity() {
        return entity;
    }

    public void setEntity(PersonnelSelectionEntity entity) {
        this.entity = entity;
    }

    private String peiXunLeiXing;
    private String peiXunZhuanYe;

    //民主推荐
    private int yingDao; //应到人数
    private int shiDao; //实到人数
    private int youXiao; //有效人数
    private String chuQin; //出勤率
    private int zanCheng; //赞成票
    private String recommandRate; //得票率

    //考核成绩
    private float junShiKaoHe;
    private float yuWen;
    private float shuXue;
    private float zhengZhi;
    private float wuLi; //综合
    private float zhuanYeMoDi; //专业摸底
    private String tiJian; //体检
    private float zongChengJi; //总成绩
    private int rank; //同专业排名

    //组织审批
    private Date zhiBuTime;
    private String zhiBuJueDing;
    private Date yingDangWeiTime;
    private String yingDangWeiJueDing;
    private Date lvDangWeiTime;
    private String lvDangWeiJueDing;

    public String getPeiXunLeiXing() {
        return peiXunLeiXing;
    }

    public void setPeiXunLeiXing(String peiXunLeiXing) {
        this.peiXunLeiXing = peiXunLeiXing;
    }

    public String getPeiXunZhuanYe() {
        return peiXunZhuanYe;
    }

    public void setPeiXunZhuanYe(String peiXunZhuanYe) {
        this.peiXunZhuanYe = peiXunZhuanYe;
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

    public String getRecommandRate() {
        return recommandRate;
    }

    public void setRecommandRate(String recommandRate) {
        this.recommandRate = recommandRate;
    }

    public float getJunShiKaoHe() {
        return junShiKaoHe;
    }

    public void setJunShiKaoHe(float junShiKaoHe) {
        this.junShiKaoHe = junShiKaoHe;
    }

    public float getYuWen() {
        return yuWen;
    }

    public void setYuWen(float yuWen) {
        this.yuWen = yuWen;
    }

    public float getShuXue() {
        return shuXue;
    }

    public void setShuXue(float shuXue) {
        this.shuXue = shuXue;
    }

    public float getZhengZhi() {
        return zhengZhi;
    }

    public void setZhengZhi(float zhengZhi) {
        this.zhengZhi = zhengZhi;
    }

    public float getWuLi() {
        return wuLi;
    }

    public void setWuLi(float wuLi) {
        this.wuLi = wuLi;
    }

    public float getZhuanYeMoDi() {
        return zhuanYeMoDi;
    }

    public void setZhuanYeMoDi(float zhuanYeMoDi) {
        this.zhuanYeMoDi = zhuanYeMoDi;
    }

    public String getTiJian() {
        return tiJian;
    }

    public void setTiJian(String tiJian) {
        this.tiJian = tiJian;
    }

    public float getZongChengJi() {
        return zongChengJi;
    }

    public void setZongChengJi(float zongChengJi) {
        this.zongChengJi = zongChengJi;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
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

    public Date getLvDangWeiTime() {
        return lvDangWeiTime;
    }

    public void setLvDangWeiTime(Date lvDangWeiTime) {
        this.lvDangWeiTime = lvDangWeiTime;
    }

    public String getLvDangWeiJueDing() {
        return lvDangWeiJueDing;
    }

    public void setLvDangWeiJueDing(String lvDangWeiJueDing) {
        this.lvDangWeiJueDing = lvDangWeiJueDing;
    }
}
