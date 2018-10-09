package com.inspection.entity.soldierstudent;
import com.inspection.entity.JunShiJiaFen;
import com.inspection.entity.soldierschool.SoldierSchoolEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "t_soldier_student", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
public class SoldierStudentMain implements Serializable {
    private String id;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private SoldierSchoolEntity schoolEntity;

    @Transient
    public SoldierSchoolEntity getSchoolEntity() {
        return schoolEntity;
    }

    public void setSchoolEntity(SoldierSchoolEntity schoolEntity) {
        this.schoolEntity = schoolEntity;
    }

    private SoldierStudentEntity entity;
    @Transient
    public SoldierStudentEntity getEntity() {
        return entity;
    }
    public void setEntity(SoldierStudentEntity entity) {
        this.entity = entity;
    }
    //任骨干情况
    private Date startTime;
    private Date endTime;
    private String zhiWu; //担任职务
    //立功受奖情况
    private List<String> shouJiangQingKuang;
    private String shouJiangString;

    public String getShouJiangString() {
        return shouJiangString;
    }

    public void setShouJiangString(String shouJiangString) {
        this.shouJiangString = shouJiangString;
    }

    //民主推荐
    private int yingDao; //应到人数
    private int shiDao; //实到人数
    private int youXiao; //有效人数
    private String chuQin; //出勤率
    private int zanCheng; //赞成票
    private String recommandRate; //得票率
    //总体情况
    private float junShiKeMu; //军事科目
    private float wenHuaKeMu; //文化科目
    private float mainShi; //面试成绩
    private float totalScore; //总成绩
    private int totalRank; //排名
    //体检情况
    private String tiJianJieGuo;
    private String  shuoMing;
    //军事考核成绩
    private float tiZhi; //停止间转法
    private float shiDan; //实弹射击
    private float qianJing; //前进
    private float yangWo; //仰卧起坐
    private float sheXing; //蛇形跑
    private float sanQian; //三千米
    private float junShiChengJi; //军事成绩
    private float junShiJiaFeng; //军事加分
    //军事加分细则
    private List<JunShiJiaFen> junShiJiaFen;
    private String jiaFenString;

    public String getJiaFenString() {
        return jiaFenString;
    }

    public void setJiaFenString(String jiaFenString) {
        this.jiaFenString = jiaFenString;
    }

    private List<Date> times;

    @Transient
    public List<Date> getTimes() {
        return times;
    }

    public void setTimes(List<Date> times) {
        this.times = times;
    }

    @Transient
    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }

    private List<String> details;

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getZhiWu() {
        return zhiWu;
    }

    public void setZhiWu(String zhiWu) {
        this.zhiWu = zhiWu;
    }

    @Transient
    public List<String> getShouJiangQingKuang() {
        return shouJiangQingKuang;
    }

    public void setShouJiangQingKuang(List<String> shouJiangQingKuang) {
        this.shouJiangQingKuang = shouJiangQingKuang;
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

    public float getJunShiKeMu() {
        return junShiKeMu;
    }

    public void setJunShiKeMu(float junShiKeMu) {
        this.junShiKeMu = junShiKeMu;
    }

    public float getWenHuaKeMu() {
        return wenHuaKeMu;
    }

    public void setWenHuaKeMu(float wenHuaKeMu) {
        this.wenHuaKeMu = wenHuaKeMu;
    }

    public float getMainShi() {
        return mainShi;
    }

    public void setMainShi(float mainShi) {
        this.mainShi = mainShi;
    }

    public float getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(float totalScore) {
        this.totalScore = totalScore;
    }

    public int getTotalRank() {
        return totalRank;
    }

    public void setTotalRank(int totalRank) {
        this.totalRank = totalRank;
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

    public float getShiDan() {
        return shiDan;
    }

    public void setShiDan(float shiDan) {
        this.shiDan = shiDan;
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

    public float getJunShiChengJi() {
        return junShiChengJi;
    }

    public void setJunShiChengJi(float junShiChengJi) {
        this.junShiChengJi = junShiChengJi;
    }

    public float getJunShiJiaFeng() {
        return junShiJiaFeng;
    }

    public void setJunShiJiaFeng(float junShiJiaFeng) {
        this.junShiJiaFeng = junShiJiaFeng;
    }

    @Transient
    public List<JunShiJiaFen> getJunShiJiaFen() {
        return junShiJiaFen;
    }

    public void setJunShiJiaFen(List<JunShiJiaFen> junShiJiaFen) {
        this.junShiJiaFen = junShiJiaFen;
    }
    //组织审批
    private Date zhiBuTime;
    private String zhiBuJueDing;
    private Date yingDangWeiTime;
    private String yingDangWeiJueDing;
    private Date lvDangWeiTime;
    private String lvDangWeiJueDing;

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