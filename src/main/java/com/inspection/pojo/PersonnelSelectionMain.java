package com.inspection.pojo;

import com.inspection.entity.personnelSelection.PersonnelSelectionEntity;

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
    private float yingYu;
    private float zongHe; //综合
    private float zhuanYeMoDi; //专业摸底
    private String tiJian; //体检
    private float zongChengJi; //总成绩
    private int rank; //同专业排名

    //组织审批
    private ZuZhiShenPi zhiBu; //支部研究
    private ZuZhiShenPi yingDangWei; //营党委
    private ZuZhiShenPi lvDangWei; //旅党委

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

    public float getYingYu() {
        return yingYu;
    }

    public void setYingYu(float yingYu) {
        this.yingYu = yingYu;
    }

    public float getZongHe() {
        return zongHe;
    }

    public void setZongHe(float zongHe) {
        this.zongHe = zongHe;
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

    public ZuZhiShenPi getZhiBu() {
        return zhiBu;
    }

    public void setZhiBu(ZuZhiShenPi zhiBu) {
        this.zhiBu = zhiBu;
    }

    public ZuZhiShenPi getYingDangWei() {
        return yingDangWei;
    }

    public void setYingDangWei(ZuZhiShenPi yingDangWei) {
        this.yingDangWei = yingDangWei;
    }

    public ZuZhiShenPi getLvDangWei() {
        return lvDangWei;
    }

    public void setLvDangWei(ZuZhiShenPi lvDangWei) {
        this.lvDangWei = lvDangWei;
    }
}
