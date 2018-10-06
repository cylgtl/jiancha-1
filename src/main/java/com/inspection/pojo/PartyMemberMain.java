package com.inspection.pojo;

import com.inspection.entity.partyMember.PartyMemberEntity;

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
    private String ruDangShenQing;

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
    private ZuZhiShenPi ruDangJiJi; //确认入党积极分子研究决定
    private ZuZhiShenPi dangYuanFaZhan; //确认党员发展
    private ZuZhiShenPi yuBeiDangYuan; //接受预备党员研究决定
    private ZuZhiShenPi dangWei; //党委研究决定
    private ZuZhiShenPi yuBeiZhuanZheng; //预备党员转正

    //军事训练成绩
    private List<JunShiXunLian> junShiXunLian;

    //表彰和获奖情况
    private List<String> biaoZhang;

    public void setRuDangShenQing(String ruDangShenQing) {
        this.ruDangShenQing = ruDangShenQing;
    }

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

    public void setRuDangJiJi(ZuZhiShenPi ruDangJiJi) {
        this.ruDangJiJi = ruDangJiJi;
    }

    public void setDangYuanFaZhan(ZuZhiShenPi dangYuanFaZhan) {
        this.dangYuanFaZhan = dangYuanFaZhan;
    }

    public void setYuBeiDangYuan(ZuZhiShenPi yuBeiDangYuan) {
        this.yuBeiDangYuan = yuBeiDangYuan;
    }

    public void setDangWei(ZuZhiShenPi dangWei) {
        this.dangWei = dangWei;
    }

    public void setYuBeiZhuanZheng(ZuZhiShenPi yuBeiZhuanZheng) {
        this.yuBeiZhuanZheng = yuBeiZhuanZheng;
    }

    public void setJunShiXunLian(List<JunShiXunLian> junShiXunLian) {
        this.junShiXunLian = junShiXunLian;
    }

    public void setBiaoZhang(List<String> biaoZhang) {
        this.biaoZhang = biaoZhang;
    }
}

class JunShiXunLian {
    private String name;
    private String score;

    public JunShiXunLian(String name, String score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
