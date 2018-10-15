package com.inspection.entity.commendreward;

import com.inspection.entity.JunShiXunLian;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "t_commend_reward", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
public class CommendRewardMain {
    private String shiJiFilename;

    public String getShiJiFilename() {
        return shiJiFilename;
    }

    public void setShiJiFilename(String shiJiFilename) {
        this.shiJiFilename = shiJiFilename;
    }

    private String id;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private CommendRewardEntity entity;

    @Transient
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
    private String xunLianString;

    public String getXunLianString() {
        return xunLianString;
    }

    public void setXunLianString(String xunLianString) {
        this.xunLianString = xunLianString;
    }

    private List<String> names;
    private List<String> scores;

    @Transient
    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    @Transient
    public List<String> getScores() {
        return scores;
    }

    public void setScores(List<String> scores) {
        this.scores = scores;
    }

    //今年取得成绩
    private List<String> biaoZhang;
    private String biaoZhangString;

    public String getBiaoZhangString() {
        return biaoZhangString;
    }

    public void setBiaoZhangString(String biaoZhangString) {
        this.biaoZhangString = biaoZhangString;
    }

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

    @Lob
    @Basic(fetch = FetchType.LAZY)
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

    @Transient
    public List<JunShiXunLian> getJunShiXunLian() {
        return junShiXunLian;
    }

    public void setJunShiXunLian(List<JunShiXunLian> junShiXunLian) {
        this.junShiXunLian = junShiXunLian;
    }

    @Transient
    public List<String> getBiaoZhang() {
        return biaoZhang;
    }

    public void setBiaoZhang(List<String> biaoZhang) {
        this.biaoZhang = biaoZhang;
    }
}
