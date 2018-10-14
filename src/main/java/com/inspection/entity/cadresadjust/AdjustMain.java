package com.inspection.entity.cadresadjust;

import com.google.gson.annotations.SerializedName;
import com.inspection.entity.cadresadjust.AdjustEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "t_adjust", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
public class AdjustMain implements Serializable {
    @Transient
    public AdjustEntity getAdjust() {
        return adjust;
    }

    public void setAdjust(AdjustEntity adjust) {
        this.adjust = adjust;
    }

    private AdjustEntity adjust;

    private String id;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //三评三考总体成绩
    private float sanPingScore; //三评总成绩
    private float sanKaoScore; //三考总成绩
    private int totalRank; //排名

    //民主测评优秀率
    private int yingDao; //应到人数
    private int shiDao; //实到人数
    private int youXiao; //有效人数
    private String chuQin; //出勤率
    private int zanCheng; //赞成票
    private String testRate; //得票率

    //民主推荐情况
    private int totalTicket; //总票数
    private int recommandTicket; //推荐票数
    private String ticketRate; //得票率

    //评岗位历练
    private List<String> jiaJianXiang; //加减分项

    public String getJiaJianString() {
        return jiaJianString;
    }

    public void setJiaJianString(String jiaJianString) {
        this.jiaJianString = jiaJianString;
    }

    private String jiaJianString;

    //评工作实绩
    private String pingShen; //评审结果
    private float pingShenScore; //得分

    //军事科目考试
    private float sanQian; //三千米
    private float yingTi; //引体向上
    private float tiNeng; //体能总评
    private float junShi; //军事理论
    private float tuShang; //图上作业
    private float junShiChengJi; //军事成绩评定
    private float zhiHuiXinXi; //指挥信息系统使用
    private float zuoZhanBiaoTu; //作战标图
    private float zuoZhanJiSuan; //作战计算
    private float sheJi; //射击
    private float junSHiKeMu; //军事科目得分

    //综合理论考试
    private float yingZhiYingHui; //应知应会
    private float zhuanYeLiLun; //专业理论

    //面试考察
    private String gongZuoSiLu; //工作思路方法

    @Column(name ="sanpingscore",nullable=true,columnDefinition="float(10,2) default '0.00'")
    public float getSanPingScore() {
        return sanPingScore;
    }

    public void setSanPingScore(float sanPingScore) {
        this.sanPingScore = sanPingScore;
    }

    //@Column(name ="sankaoscore",nullable=true,columnDefinition="float(10,2) default '0.00'")
    @Column(name ="sankaoscore",nullable=true,precision=10,scale=0)
    public float getSanKaoScore() {
        return sanKaoScore;
    }

    public void setSanKaoScore(float sanKaoScore) {
        this.sanKaoScore = sanKaoScore;
    }

    @Column(name ="totalrank",nullable=true,precision=10,scale=0)
    public int getTotalRank() {
        return totalRank;
    }

    public void setTotalRank(int totalRank) {
        this.totalRank = totalRank;
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

    public void setTestRate(String testRate) { this.testRate = testRate; }

    public int getTotalTicket() {
        return totalTicket;
    }

    public void setTotalTicket(int totalTicket) {
        this.totalTicket = totalTicket;
    }

    public int getRecommandTicket() {
        return recommandTicket;
    }

    public void setRecommandTicket(int recommandTicket) {
        this.recommandTicket = recommandTicket;
    }

    public String getTicketRate() {
        return ticketRate;
    }

    public void setTicketRate(String ticketRate) {
        this.ticketRate = ticketRate;
    }

    @Transient
    public List<String> getJiaJianXiang() {
        return jiaJianXiang;
    }

    public void setJiaJianXiang(List<String> jiaJianXiang) {
        this.jiaJianXiang = jiaJianXiang;
    }

    public String getPingShen() {
        return pingShen;
    }

    public void setPingShen(String pingShen) {
        this.pingShen = pingShen;
    }

    public float getPingShenScore() {
        return pingShenScore;
    }

    public void setPingShenScore(float pingShenScore) {
        this.pingShenScore = pingShenScore;
    }

    public float getSanQian() {
        return sanQian;
    }

    public void setSanQian(float sanQian) {
        this.sanQian = sanQian;
    }

    public float getYingTi() {
        return yingTi;
    }

    public void setYingTi(float yingTi) {
        this.yingTi = yingTi;
    }

    public float getTiNeng() {
        return tiNeng;
    }

    public void setTiNeng(float tiNeng) {
        this.tiNeng = tiNeng;
    }

    public float getJunShi() {
        return junShi;
    }

    public void setJunShi(float junShi) {
        this.junShi = junShi;
    }

    public float getTuShang() {
        return tuShang;
    }

    public void setTuShang(float tuShang) {
        this.tuShang = tuShang;
    }

    public float getJunShiChengJi() {
        return junShiChengJi;
    }

    public void setJunShiChengJi(float junShiChengJi) {
        this.junShiChengJi = junShiChengJi;
    }

    public float getZhiHuiXinXi() {
        return zhiHuiXinXi;
    }

    public void setZhiHuiXinXi(float zhiHuiXinXi) {
        this.zhiHuiXinXi = zhiHuiXinXi;
    }

    public float getZuoZhanBiaoTu() {
        return zuoZhanBiaoTu;
    }

    public void setZuoZhanBiaoTu(float zuoZhanBiaoTu) {
        this.zuoZhanBiaoTu = zuoZhanBiaoTu;
    }

    public float getZuoZhanJiSuan() {
        return zuoZhanJiSuan;
    }

    public void setZuoZhanJiSuan(float zuoZhanJiSuan) {
        this.zuoZhanJiSuan = zuoZhanJiSuan;
    }

    public float getSheJi() {
        return sheJi;
    }

    public void setSheJi(float sheJi) {
        this.sheJi = sheJi;
    }

    public float getJunSHiKeMu() {
        return junSHiKeMu;
    }

    public void setJunSHiKeMu(float junSHiKeMu) {
        this.junSHiKeMu = junSHiKeMu;
    }

    public float getYingZhiYingHui() {
        return yingZhiYingHui;
    }

    public void setYingZhiYingHui(float yingZhiYingHui) {
        this.yingZhiYingHui = yingZhiYingHui;
    }

    public float getZhuanYeLiLun() {
        return zhuanYeLiLun;
    }

    public void setZhuanYeLiLun(float zhuanYeLiLun) {
        this.zhuanYeLiLun = zhuanYeLiLun;
    }

    public String getGongZuoSiLu() {
        return gongZuoSiLu;
    }

    public void setGongZuoSiLu(String gongZuoSiLu) {
        this.gongZuoSiLu = gongZuoSiLu;
    }
}
