package com.inspection.entity.commendreward;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;

/**   
 * @Title: Entity
 * @Description: 表彰奖励详情信息
 * @author zhangdaihao
 * @date 2018-07-07 16:44:27
 * @version V1.0   
 *
 */
@Entity
@Table(name = "jc_commend_reward", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class CommendRewardEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**表彰类型*/
	private java.lang.String recognitType;
	/**姓名/单位*/
	private java.lang.String nameUnit;
	/**部职别*/
	private java.lang.String jobTitle;
	/**现军衔*/
	private java.lang.String nowRank;
	/**军衔时间*/
	private java.util.Date rankTime;
	/**提名类型 1-首长提名 2-群众提名*/
	private java.lang.String nominateType;
	/**提名奖励类型*/
	private java.lang.String nominateRewardType;
	/**名额*/
	private java.lang.String places;
	/**事迹材料*/
	private java.lang.String fileId;
	/**录用时间*/
	private java.util.Date employTime;
	/**创建时间*/
	private java.util.Date createTime;
	/**更新时间*/
	private java.util.Date updateTime;
	/**修改人ID*/
	private java.lang.String updateId;
	/**创建人ID*/
	private java.lang.String createId;
	/**部门ID*/
	private java.lang.String departId;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=64)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主键
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  表彰类型
	 */
	@Column(name ="RECOGNIT_TYPE",nullable=true,length=32)
	public java.lang.String getRecognitType(){
		return this.recognitType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  表彰类型
	 */
	public void setRecognitType(java.lang.String recognitType){
		this.recognitType = recognitType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  姓名/单位
	 */
	@Column(name ="NAME_UNIT",nullable=true,length=256)
	public java.lang.String getNameUnit(){
		return this.nameUnit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  姓名/单位
	 */
	public void setNameUnit(java.lang.String nameUnit){
		this.nameUnit = nameUnit;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  部职别
	 */
	@Column(name ="JOB_TITLE",nullable=true,length=256)
	public java.lang.String getJobTitle(){
		return this.jobTitle;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  部职别
	 */
	public void setJobTitle(java.lang.String jobTitle){
		this.jobTitle = jobTitle;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  现军衔
	 */
	@Column(name ="NOW_RANK",nullable=true,length=64)
	public java.lang.String getNowRank(){
		return this.nowRank;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  现军衔
	 */
	public void setNowRank(java.lang.String nowRank){
		this.nowRank = nowRank;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  军衔时间
	 */
	@Column(name ="RANK_TIME",nullable=true)
	public java.util.Date getRankTime(){
		return this.rankTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  军衔时间
	 */
	public void setRankTime(java.util.Date rankTime){
		this.rankTime = rankTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  提名类型 1-首长提名 2-群众提名
	 */
	@Column(name ="NOMINATE_TYPE",nullable=true,length=256)
	public java.lang.String getNominateType(){
		return this.nominateType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  提名类型 1-首长提名 2-群众提名
	 */
	public void setNominateType(java.lang.String nominateType){
		this.nominateType = nominateType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  提名奖励类型
	 */
	@Column(name ="NOMINATE_REWARD_TYPE",nullable=true,length=64)
	public java.lang.String getNominateRewardType(){
		return this.nominateRewardType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  提名奖励类型
	 */
	public void setNominateRewardType(java.lang.String nominateRewardType){
		this.nominateRewardType = nominateRewardType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  名额
	 */
	@Column(name ="PLACES",nullable=true,length=256)
	public java.lang.String getPlaces(){
		return this.places;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  名额
	 */
	public void setPlaces(java.lang.String places){
		this.places = places;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  事迹材料
	 */
	@Column(name ="FILE_ID",nullable=true,length=1024)
	public java.lang.String getFileId(){
		return this.fileId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  事迹材料
	 */
	public void setFileId(java.lang.String fileId){
		this.fileId = fileId;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  录用时间
	 */
	@Column(name ="EMPLOY_TIME",nullable=true)
	public java.util.Date getEmployTime(){
		return this.employTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  录用时间
	 */
	public void setEmployTime(java.util.Date employTime){
		this.employTime = employTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建时间
	 */
	@Column(name ="CREATE_TIME",nullable=true)
	public java.util.Date getCreateTime(){
		return this.createTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建时间
	 */
	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新时间
	 */
	@Column(name ="UPDATE_TIME",nullable=true)
	public java.util.Date getUpdateTime(){
		return this.updateTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新时间
	 */
	public void setUpdateTime(java.util.Date updateTime){
		this.updateTime = updateTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  修改人ID
	 */
	@Column(name ="UPDATE_ID",nullable=true,length=40)
	public java.lang.String getUpdateId(){
		return this.updateId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  修改人ID
	 */
	public void setUpdateId(java.lang.String updateId){
		this.updateId = updateId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人ID
	 */
	@Column(name ="CREATE_ID",nullable=true,length=40)
	public java.lang.String getCreateId(){
		return this.createId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人ID
	 */
	public void setCreateId(java.lang.String createId){
		this.createId = createId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  部门ID
	 */
	@Column(name ="DEPART_ID",nullable=true,length=40)
	public java.lang.String getDepartId(){
		return this.departId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  部门ID
	 */
	public void setDepartId(java.lang.String departId){
		this.departId = departId;
	}
}
