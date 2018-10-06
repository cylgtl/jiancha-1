package com.inspection.pojo;
import com.inspection.entity.soldierstudent.SoldierStudentEntity;
import java.util.Date;
import java.util.List;
public class SoldierStudentMain {
    private SoldierStudentEntity entity;
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
    //民主推荐
    private int yingDao; //应到人数
    private int shiDao; //实到人数
    private int youXiao; //有效人数
    private float chuQin; //出勤率
    private int zanCheng; //赞成票
    private float recommandRate; //得票率
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
    //组织审批
    private ZuZhiShenPi zhiBu; //支部研究
    private ZuZhiShenPi yingDangWei; //营党委
    private ZuZhiShenPi lvDangWei; //旅党委
}
class JunShiJiaFen{
    private Date time;
    private String detail;
    public JunShiJiaFen(Date time, String detail) {
        this.time = time;
        this.detail = detail;
    }
    public Date getTime() {
        return time;
    }
    public void setTime(Date time) {
        this.time = time;
    }
    public String getDetail() {
        return detail;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }
}