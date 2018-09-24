package com.inspection.entity.officerleave;

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
 * @Description: 军官请假信息
 * @author zhangdaihao
 * @date 2018-07-17 11:36:52
 * @version V1.0   
 *
 */
@Entity
@Table(name = "jc_officer_leave", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class OfficerLeaveEntity implements java.io.Serializable {
	/**主键ID*/
	private java.lang.String id;
	/**流程类型*/
	private java.lang.String type;
	/**标题*/
	private java.lang.String title;
	/**现军衔*/
	private java.lang.String nowRank;
	/**姓名*/
	private java.lang.String name;
	/**军衔时间*/
	private java.util.Date rankTime;
	/**出生日期*/
	private java.util.Date birthday;
	/**入伍时间*/
	private java.util.Date militaryTime;
	/**部职别*/
	private java.lang.String jobTitle;
	/**休假开始时间*/
	private java.util.Date beginTime;
	/**休假结束时间*/
	private java.util.Date endTime;
	/**创建时间*/
	private java.util.Date createTime;
	/**更新时间*/
	private java.util.Date updateTime;
	/**修改人ID*/
	private java.lang.String updateId;
	/**创建人ID*/
	private java.lang.String createId;
	/**请假天数*/
	private java.lang.String days;
	/**籍贯*/
	private java.lang.String nativePlace;
	/**民族*/
	private java.lang.String national;
	/**政治面貌*/
	private java.lang.String political;
	/**学历*/
	private java.lang.String educational;
	/**性别*/
	private java.lang.String sex;
	/**部门*/
	private java.lang.String departId;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键ID
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
	 *@param: java.lang.String  主键ID
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  流程类型
	 */
	@Column(name ="TYPE",nullable=true,length=40)
	public java.lang.String getType(){
		return this.type;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  流程类型
	 */
	public void setType(java.lang.String type){
		this.type = type;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  标题
	 */
	@Column(name ="TITLE",nullable=true,length=150)
	public java.lang.String getTitle(){
		return this.title;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  标题
	 */
	public void setTitle(java.lang.String title){
		this.title = title;
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  姓名
	 */
	@Column(name ="NAME",nullable=true,length=250)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  姓名
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  军衔时间
	 */
	@Column(name ="RANK_TIME",nullable=true,length=40)
	public java.util.Date getRankTime(){
		return this.rankTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date 军衔时间
	 */
	public void setRankTime(java.util.Date rankTime){
		this.rankTime = rankTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  出生日期
	 */
	@Column(name ="BIRTHDAY",nullable=true)
	public java.util.Date getBirthday(){
		return this.birthday;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  出生日期
	 */
	public void setBirthday(java.util.Date birthday){
		this.birthday = birthday;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  入伍时间
	 */
	@Column(name ="MILITARY_TIME",nullable=true)
	public java.util.Date getMilitaryTime(){
		return this.militaryTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  入伍时间
	 */
	public void setMilitaryTime(java.util.Date militaryTime){
		this.militaryTime = militaryTime;
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
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  休假开始时间
	 */
	@Column(name ="BEGIN_TIME",nullable=true)
	public java.util.Date getBeginTime(){
		return this.beginTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  休假开始时间
	 */
	public void setBeginTime(java.util.Date beginTime){
		this.beginTime = beginTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  休假结束时间
	 */
	@Column(name ="END_TIME",nullable=true)
	public java.util.Date getEndTime(){
		return this.endTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  休假结束时间
	 */
	public void setEndTime(java.util.Date endTime){
		this.endTime = endTime;
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
	 *@return: java.lang.String  请假天数
	 */
	@Column(name ="DAYS",nullable=true,length=5)
	public java.lang.String getDays(){
		return this.days;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  请假天数
	 */
	public void setDays(java.lang.String days){
		this.days = days;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  籍贯
	 */
	@Column(name ="NATIVE_PLACE",nullable=true,length=200)
	public java.lang.String getNativePlace(){
		return this.nativePlace;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  籍贯
	 */
	public void setNativePlace(java.lang.String nativePlace){
		this.nativePlace = nativePlace;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  民族
	 */
	@Column(name ="NATIONAL",nullable=true,length=50)
	public java.lang.String getNational(){
		return this.national;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  民族
	 */
	public void setNational(java.lang.String national){
		this.national = national;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  政治面貌
	 */
	@Column(name ="POLITICAL",nullable=true,length=100)
	public java.lang.String getPolitical(){
		return this.political;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  政治面貌
	 */
	public void setPolitical(java.lang.String political){
		this.political = political;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学历
	 */
	@Column(name ="EDUCATIONAL",nullable=true,length=50)
	public java.lang.String getEducational(){
		return this.educational;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学历
	 */
	public void setEducational(java.lang.String educational){
		this.educational = educational;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  性别
	 */
	@Column(name ="SEX",nullable=true,length=32)
	public java.lang.String getSex(){
		return this.sex;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  性别
	 */
	public void setSex(java.lang.String sex){
		this.sex = sex;
	}
	@Column(name ="depart_id",nullable=true,length=64)
	public java.lang.String getDepartId() {
		return departId;
	}

	public void setDepartId(java.lang.String departId) {
		this.departId = departId;
	}
	
	
}
