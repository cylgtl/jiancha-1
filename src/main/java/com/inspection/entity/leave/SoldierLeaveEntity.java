package com.inspection.entity.leave;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

/**   
 * @Title: Entity
 * @Description: 战士请假
 * @author zhangdaihao
 * @date 2018-07-10 23:26:12
 * @version V1.0   
 *
 */
@Entity
@Table(name = "jc_soldier_leave", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class SoldierLeaveEntity implements java.io.Serializable {
	/**主键ID*/
	private java.lang.String id;
	/**流程类型*/
	private java.lang.String type;
	/**姓名*/
	private java.lang.String name;
	/**部职别*/
	private java.lang.String jobTitle;
	/**休假类型*/
	private java.lang.String leaveType;
	/**出生日期*/
	private java.lang.String birthday;
	/**入伍时间*/
	private java.lang.String militaryTime;
	
	/**现军衔*/
	private java.lang.String rank;
	
	/**现军衔时间*/
	private java.lang.String rankTime;
	/**休假开始时间*/
	private java.lang.String beginTime;
	/**休假结束时间*/
	private java.lang.String endTime;
	/**创建时间*/
	private java.util.Date createTime;
	/**更新时间*/
	private java.util.Date updateTime;
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
	
	/**
	 * 部门信息
	 */
	private java.lang.String departId;

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键ID
	 */
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=40)
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  部职别
	 */
	@Column(name ="JOB_TITLE",nullable=true,length=150)
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
	 *@return: java.lang.String  休假类型
	 */
	@Column(name ="LEAVE_TYPE",nullable=true,length=40)
	public java.lang.String getLeaveType(){
		return this.leaveType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  休假类型
	 */
	public void setLeaveType(java.lang.String leaveType){
		this.leaveType = leaveType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  出生日期
	 */
	@Column(name ="BIRTHDAY",nullable=true,length=40)
	public java.lang.String getBirthday(){
		return this.birthday;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  出生日期
	 */
	public void setBirthday(java.lang.String birthday){
		this.birthday = birthday;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  入伍时间
	 */
	@Column(name ="MILITARY_TIME",nullable=true,length=40)
	public java.lang.String getMilitaryTime(){
		return this.militaryTime;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  入伍时间
	 */
	public void setMilitaryTime(java.lang.String militaryTime){
		this.militaryTime = militaryTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  现军衔时间
	 */
	@Column(name ="RANK_TIME",nullable=true,length=40)
	public java.lang.String getRankTime(){
		return this.rankTime;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  现军衔时间
	 */
	public void setRankTime(java.lang.String rankTime){
		this.rankTime = rankTime;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  现军衔
	 */
	@Column(name ="RANK",nullable=true,length=100)
	public java.lang.String getRank(){
		return this.rank;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  现军衔时间
	 */
	public void setRank(java.lang.String rank){
		this.rank = rank;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  休假开始时间
	 */
	@Column(name ="BEGIN_TIME",nullable=true,length=20)
	public java.lang.String getBeginTime(){
		return this.beginTime;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  休假开始时间
	 */
	public void setBeginTime(java.lang.String beginTime){
		this.beginTime = beginTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  休假结束时间
	 */
	@Column(name ="END_TIME",nullable=true,length=20)
	public java.lang.String getEndTime(){
		return this.endTime;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  休假结束时间
	 */
	public void setEndTime(java.lang.String endTime){
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
	@Column(name ="SEX",nullable=true,length=5)
	public java.lang.String getSex(){
		return this.sex;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学历
	 */
	public void setSex(java.lang.String sex){
		this.sex = sex;
	}

	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String   部门
	 */
	@Column(name ="depart_id",nullable=true,length=64)
	public java.lang.String getDepartId(){
		return this.departId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  部门
	 */
	public void setDepartId(java.lang.String departId){
		this.departId = departId;
	}

}
