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

}
