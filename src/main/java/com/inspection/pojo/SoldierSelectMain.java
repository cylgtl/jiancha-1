package com.inspection.pojo;

import com.inspection.entity.soldierselect.SoldierSelectEntity;

import java.util.Date;

public class SoldierSelectMain {
    private SoldierSelectEntity entity;

    public SoldierSelectEntity getEntity() {
        return entity;
    }

    public void setEntity(SoldierSelectEntity entity) {
        this.entity = entity;
    }

    private String selectType; //选取类型
    private String selectMajor; //选取专业

    //民主推荐
    private int yingDao; //应到人数
    private int shiDao; //实到人数
    private int youXiao; //有效人数
    private String chuQin; //出勤率
    private int zanCheng; //赞成票
    private String recommandRate; //得票率

    //总体成绩
    private float shenTi; //身体和心理素质
    private float jiBenLiLun; //基本理论
    private float junShiJiNeng; //军事技能
    private float zongChengJi; //总成绩
    private int totalRank; // 排名

    //军事技能考核
    private float sanQian; //三千米
    private float fuWoCheng; //俯卧撑
    private float yangWoQiZuo; //仰卧起坐
    private float zhuanYeJiNeng; //专业技能

    //基本理论考核
    private String zhengZhiLiLun; //政治理论
    private String faLingTiaoGui; //法令条规
    private String junShiLilun; //军事理论基础
    private String zhuanYeLiLun; //专业理论

    //身体和心理素质考核
    private String tiJian; //体检
    private String xinLiSuZhi; //心理素质

    //组织审批
    private Date zhiBuTime;
    private String zhiBuJueDing;
    private Date yingDangWeiTime;
    private String yingDangWeiJueDing;
    private Date lvDangWeiTime;
    private String lvDangWeiJueDing;

    public String getSelectType() {
        return selectType;
    }

    public void setSelectType(String selectType) {
        this.selectType = selectType;
    }

    public String getSelectMajor() {
        return selectMajor;
    }

    public void setSelectMajor(String selectMajor) {
        this.selectMajor = selectMajor;
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

    public float getShenTi() {
        return shenTi;
    }

    public void setShenTi(float shenTi) {
        this.shenTi = shenTi;
    }

    public float getJiBenLiLun() {
        return jiBenLiLun;
    }

    public void setJiBenLiLun(float jiBenLiLun) {
        this.jiBenLiLun = jiBenLiLun;
    }

    public float getJunShiJiNeng() {
        return junShiJiNeng;
    }

    public void setJunShiJiNeng(float junShiJiNeng) {
        this.junShiJiNeng = junShiJiNeng;
    }

    public float getZongChengJi() {
        return zongChengJi;
    }

    public void setZongChengJi(float zongChengJi) {
        this.zongChengJi = zongChengJi;
    }

    public int getTotalRank() {
        return totalRank;
    }

    public void setTotalRank(int totalRank) {
        this.totalRank = totalRank;
    }

    public float getSanQian() {
        return sanQian;
    }

    public void setSanQian(float sanQian) {
        this.sanQian = sanQian;
    }

    public float getFuWoCheng() {
        return fuWoCheng;
    }

    public void setFuWoCheng(float fuWoCheng) {
        this.fuWoCheng = fuWoCheng;
    }

    public float getYangWoQiZuo() {
        return yangWoQiZuo;
    }

    public void setYangWoQiZuo(float yangWoQiZuo) {
        this.yangWoQiZuo = yangWoQiZuo;
    }

    public float getZhuanYeJiNeng() {
        return zhuanYeJiNeng;
    }

    public void setZhuanYeJiNeng(float zhuanYeJiNeng) {
        this.zhuanYeJiNeng = zhuanYeJiNeng;
    }

    public String getZhengZhiLiLun() {
        return zhengZhiLiLun;
    }

    public void setZhengZhiLiLun(String zhengZhiLiLun) {
        this.zhengZhiLiLun = zhengZhiLiLun;
    }

    public String getFaLingTiaoGui() {
        return faLingTiaoGui;
    }

    public void setFaLingTiaoGui(String faLingTiaoGui) {
        this.faLingTiaoGui = faLingTiaoGui;
    }

    public String getJunShiLilun() {
        return junShiLilun;
    }

    public void setJunShiLilun(String junShiLilun) {
        this.junShiLilun = junShiLilun;
    }

    public String getZhuanYeLiLun() {
        return zhuanYeLiLun;
    }

    public void setZhuanYeLiLun(String zhuanYeLiLun) {
        this.zhuanYeLiLun = zhuanYeLiLun;
    }

    public String getTiJian() {
        return tiJian;
    }

    public void setTiJian(String tiJian) {
        this.tiJian = tiJian;
    }

    public String getXinLiSuZhi() {
        return xinLiSuZhi;
    }

    public void setXinLiSuZhi(String xinLiSuZhi) {
        this.xinLiSuZhi = xinLiSuZhi;
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

