package com.inspection.entity.partyMember;

import com.inspection.entity.JunShiXunLian;

import java.util.Date;
import java.util.List;
public class PartyMemberMain {
    private PartyMemberEntity entity;
    public PartyMemberEntity getEntity() {
        return entity;
    }
    public void setEntity(PartyMemberEntity entity) {
        this.entity = entity;
    }
    //入党申请书
    private byte[] ruDangShenQing;
    //培养联系人
    private String lianXiRen1;
    private String lianXiRen2;
    //考核成绩
    private String score;
    private String level;
    //民主评议
    private int yingDao; //应到人数
    private int shiDao; //实到人数
    private int youXiao; //有效人数
    private String chuQin; //出勤率
    private int zanCheng; //赞成票
    private String testRate; //得票率
    //组织审批
    private Date ruDangJiJiTime; //确认入党积极分子研究决定时间
    private String ruDangJiJi; //确认入党积极分子研究决定
    private Date dangYuanFaZhanTime; //确认党员发展时间
    private String dangYuanFaZhan; //确认党员发展
    private Date yuBeiDangYuanTime; //接受预备党员研究决定时间
    private String yuBeiDangYuan; //接受预备党员研究决定
    private Date dangWeiTime; //党委研究决定时间
    private String dangWei; //党委研究决定
    private Date yuBeiZhuanZhengTime; //预备党员转正时间
    private String yuBeiZhuanZheng; //预备党员转正
    //军事训练成绩
    private List<JunShiXunLian> junShiXunLian;
    private List<String> names;
    private List<String> scores;

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public List<String> getScores() {
        return scores;
    }

    public void setScores(List<String> scores) {
        this.scores = scores;
    }

    //表彰和获奖情况
    private List<String> biaoZhang;
    public void setLianXiRen1(String lianXiRen1) {
        this.lianXiRen1 = lianXiRen1;
    }
    public void setLianXiRen2(String lianXiRen2) {
        this.lianXiRen2 = lianXiRen2;
    }
    public void setScore(String score) {
        this.score = score;
    }
    public void setLevel(String level) {
        this.level = level;
    }
    public void setYingDao(int yingDao) {
        this.yingDao = yingDao;
    }
    public void setShiDao(int shiDao) {
        this.shiDao = shiDao;
    }
    public void setYouXiao(int youXiao) {
        this.youXiao = youXiao;
    }
    public void setChuQin(String chuQin) {
        this.chuQin = chuQin;
    }
    public void setZanCheng(int zanCheng) {
        this.zanCheng = zanCheng;
    }
    public void setTestRate(String testRate) {
        this.testRate = testRate;
    }

    public void setJunShiXunLian(List<JunShiXunLian> junShiXunLian) {
        this.junShiXunLian = junShiXunLian;
    }
    public void setBiaoZhang(List<String> biaoZhang) {
        this.biaoZhang = biaoZhang;
    }

    public String getLianXiRen1() {
        return lianXiRen1;
    }

    public String getLianXiRen2() {
        return lianXiRen2;
    }

    public String getScore() {
        return score;
    }

    public String getLevel() {
        return level;
    }

    public int getYingDao() {
        return yingDao;
    }

    public int getShiDao() {
        return shiDao;
    }

    public int getYouXiao() {
        return youXiao;
    }

    public String getChuQin() {
        return chuQin;
    }

    public int getZanCheng() {
        return zanCheng;
    }

    public String getTestRate() {
        return testRate;
    }

    public Date getRuDangJiJiTime() {
        return ruDangJiJiTime;
    }

    public void setRuDangJiJiTime(Date ruDangJiJiTime) {
        this.ruDangJiJiTime = ruDangJiJiTime;
    }

    public String getRuDangJiJi() {
        return ruDangJiJi;
    }

    public void setRuDangJiJi(String ruDangJiJi) {
        this.ruDangJiJi = ruDangJiJi;
    }

    public Date getDangYuanFaZhanTime() {
        return dangYuanFaZhanTime;
    }

    public void setDangYuanFaZhanTime(Date dangYuanFaZhanTime) {
        this.dangYuanFaZhanTime = dangYuanFaZhanTime;
    }

    public String getDangYuanFaZhan() {
        return dangYuanFaZhan;
    }

    public void setDangYuanFaZhan(String dangYuanFaZhan) {
        this.dangYuanFaZhan = dangYuanFaZhan;
    }

    public Date getYuBeiDangYuanTime() {
        return yuBeiDangYuanTime;
    }

    public void setYuBeiDangYuanTime(Date yuBeiDangYuanTime) {
        this.yuBeiDangYuanTime = yuBeiDangYuanTime;
    }

    public String getYuBeiDangYuan() {
        return yuBeiDangYuan;
    }

    public void setYuBeiDangYuan(String yuBeiDangYuan) {
        this.yuBeiDangYuan = yuBeiDangYuan;
    }

    public Date getDangWeiTime() {
        return dangWeiTime;
    }

    public void setDangWeiTime(Date dangWeiTime) {
        this.dangWeiTime = dangWeiTime;
    }

    public String getDangWei() {
        return dangWei;
    }

    public void setDangWei(String dangWei) {
        this.dangWei = dangWei;
    }

    public Date getYuBeiZhuanZhengTime() {
        return yuBeiZhuanZhengTime;
    }

    public void setYuBeiZhuanZhengTime(Date yuBeiZhuanZhengTime) {
        this.yuBeiZhuanZhengTime = yuBeiZhuanZhengTime;
    }

    public String getYuBeiZhuanZheng() {
        return yuBeiZhuanZheng;
    }

    public void setYuBeiZhuanZheng(String yuBeiZhuanZheng) {
        this.yuBeiZhuanZheng = yuBeiZhuanZheng;
    }

    public List<JunShiXunLian> getJunShiXunLian() {
        return junShiXunLian;
    }

    public List<String> getBiaoZhang() {
        return biaoZhang;
    }

    public byte[] getRuDangShenQing() {
        return ruDangShenQing;
    }

    public void setRuDangShenQing(byte[] ruDangShenQing) {
        this.ruDangShenQing = ruDangShenQing;
    }
}