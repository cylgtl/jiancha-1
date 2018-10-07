package com.inspection.pojo;

import com.inspection.entity.soldiersApply.SoldiersApplyEntity;

import java.util.List;

public class SoldiersApplyMain {
    private SoldiersApplyEntity entity;

    public SoldiersApplyEntity getEntity() {
        return entity;
    }

    public void setEntity(SoldiersApplyEntity entity) {
        this.entity = entity;
    }

    //总体成绩
    private float yuXuanKaoHe;
    private float zhiQianKaoHe;
    private float jiaFen; //加分
    private float zongChengJi;
    private int rank;

    //民主推荐
    private int yingDao; //应到人数
    private int shiDao; //实到人数
    private int youXiao; //有效人数
    private String chuQin; //出勤率
    private int zanCheng; //赞成票
    private String recommandRate; //得票率

    //文化考核
    private float yuWen;
    private float shuXue;
    private float yingYu;
    private float zongHe; //综合

    //体检情况
    private String tiJianJieGuo;
    private String  shuoMing;

    //军事考核成绩
    private float tiZhi; //停止间转法
    private float qianJing; //前进
    private float yangWo; //仰卧起坐
    private float shiDan; //实弹射击
    private float sheXing; //蛇形跑
    private float sanQian; //三千米

    //军事加分细则
    private List<JunShiJiaFen> junShiJiaFen;

    //组织审批
    private ZuZhiShenPi zhiBu; //支部研究
    private ZuZhiShenPi yingDangWei; //营党委
    private ZuZhiShenPi lvDangWei; //旅党委

    public float getYuXuanKaoHe() {
        return yuXuanKaoHe;
    }

    public void setYuXuanKaoHe(float yuXuanKaoHe) {
        this.yuXuanKaoHe = yuXuanKaoHe;
    }

    public float getZhiQianKaoHe() {
        return zhiQianKaoHe;
    }

    public void setZhiQianKaoHe(float zhiQianKaoHe) {
        this.zhiQianKaoHe = zhiQianKaoHe;
    }

    public float getJiaFen() {
        return jiaFen;
    }

    public void setJiaFen(float jiaFen) {
        this.jiaFen = jiaFen;
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

    public String getTiJianJieGuo() {
        return tiJianJieGuo;
    }

    public void setTiJianJieGuo(String tiJianJieGuo) {
        this.tiJianJieGuo = tiJianJieGuo;
    }

    public String getShuoMing() {
        return shuoMing;
    }

    public void setShuoMing(String shuoMing) {
        this.shuoMing = shuoMing;
    }

    public float getTiZhi() {
        return tiZhi;
    }

    public void setTiZhi(float tiZhi) {
        this.tiZhi = tiZhi;
    }

    public float getQianJing() {
        return qianJing;
    }

    public void setQianJing(float qianJing) {
        this.qianJing = qianJing;
    }

    public float getYangWo() {
        return yangWo;
    }

    public void setYangWo(float yangWo) {
        this.yangWo = yangWo;
    }

    public float getShiDan() {
        return shiDan;
    }

    public void setShiDan(float shiDan) {
        this.shiDan = shiDan;
    }

    public float getSheXing() {
        return sheXing;
    }

    public void setSheXing(float sheXing) {
        this.sheXing = sheXing;
    }

    public float getSanQian() {
        return sanQian;
    }

    public void setSanQian(float sanQian) {
        this.sanQian = sanQian;
    }

    public List<JunShiJiaFen> getJunShiJiaFen() {
        return junShiJiaFen;
    }

    public void setJunShiJiaFen(List<JunShiJiaFen> junShiJiaFen) {
        this.junShiJiaFen = junShiJiaFen;
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
