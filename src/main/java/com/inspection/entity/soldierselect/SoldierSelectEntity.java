package com.inspection.entity.soldierselect;

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
 * @Description: 士兵选取信息
 * @author zhangdaihao
 * @date 2018-07-09 15:56:05
 * @version V1.0   
 *
 */
@Entity
@Table(name = "jc_soldier_select", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class SoldierSelectEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**选取类型*/
	private java.lang.String selectType;
	/**姓名*/
	private java.lang.String name;
	/**身份证号*/
	private java.lang.String idCard;
	/**名额*/
	private java.lang.Integer places;
	/**部职别*/
	private java.lang.String jobTitle;
	/**籍贯*/
	private java.lang.String nativePlace;
	/**性别*/
	private java.lang.String sex;
	/**政治面貌*/
	private java.lang.String politicalLandscape;
	/**出生日期*/
	private java.util.Date birthDay;
	/**入伍时间*/
	private java.util.Date militaryTime;
	/**改后军衔*/
	private java.lang.String endRank;
	/**现军衔*/
	private java.lang.String nowRank;
	/**军衔时间*/
	private java.util.Date rankTime;
	/**学历*/
	private java.lang.String education;
	/**改后专业*/
	private java.lang.String endProfessional;
	/**专业技术等级*/
	private java.lang.String professionalLevel;
	/**现专业*/
	private java.lang.String nowProfessional;
	/**录入时间*/
	private java.util.Date entryTime;
	/**毕业时间*/
	private java.util.Date graduateTime;
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
	/**民族*/
	private java.lang.String nationalName;
	/**职务*/
	private java.lang.String position;
	/**班级*/
	private java.lang.String theClass;
	
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
	 *@return: java.lang.String  选取类型
	 */
	@Column(name ="SELECT_TYPE",nullable=true,length=32)
	public java.lang.String getSelectType(){
		return this.selectType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  选取类型
	 */
	public void setSelectType(java.lang.String selectType){
		this.selectType = selectType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  姓名
	 */
	@Column(name ="NAME",nullable=true,length=32)
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
	 *@return: java.lang.String  身份证号
	 */
	@Column(name ="ID_CARD",nullable=true,length=32)
	public java.lang.String getIdCard(){
		return this.idCard;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身份证号
	 */
	public void setIdCard(java.lang.String idCard){
		this.idCard = idCard;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  名额
	 */
	@Column(name ="PLACES",nullable=true,precision=10,scale=0)
	public java.lang.Integer getPlaces(){
		return this.places;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  名额
	 */
	public void setPlaces(java.lang.Integer places){
		this.places = places;
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
	 *@return: java.lang.String  籍贯
	 */
	@Column(name ="NATIVE_PLACE",nullable=true,length=256)
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
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  政治面貌
	 */
	@Column(name ="POLITICAL_LANDSCAPE",nullable=true,length=32)
	public java.lang.String getPoliticalLandscape(){
		return this.politicalLandscape;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  政治面貌
	 */
	public void setPoliticalLandscape(java.lang.String politicalLandscape){
		this.politicalLandscape = politicalLandscape;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  出生日期
	 */
	@Column(name ="BIRTH_DAY",nullable=true)
	public java.util.Date getBirthDay(){
		return this.birthDay;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  出生日期
	 */
	public void setBirthDay(java.util.Date birthDay){
		this.birthDay = birthDay;
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
	 *@return: java.lang.String  改后军衔
	 */
	@Column(name ="END_RANK",nullable=true,length=64)
	public java.lang.String getEndRank(){
		return this.endRank;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  改后军衔
	 */
	public void setEndRank(java.lang.String endRank){
		this.endRank = endRank;
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
	@Column(name ="RANK_TIME",nullable=true,length=32)
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
	 *@return: java.lang.String  学历
	 */
	@Column(name ="EDUCATION",nullable=true,length=16)
	public java.lang.String getEducation(){
		return this.education;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学历
	 */
	public void setEducation(java.lang.String education){
		this.education = education;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  改后专业
	 */
	@Column(name ="END_PROFESSIONAL",nullable=true,length=64)
	public java.lang.String getEndProfessional(){
		return this.endProfessional;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  改后专业
	 */
	public void setEndProfessional(java.lang.String endProfessional){
		this.endProfessional = endProfessional;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  专业技术等级
	 */
	@Column(name ="PROFESSIONAL_LEVEL",nullable=true,length=32)
	public java.lang.String getProfessionalLevel(){
		return this.professionalLevel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  专业技术等级
	 */
	public void setProfessionalLevel(java.lang.String professionalLevel){
		this.professionalLevel = professionalLevel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  现专业
	 */
	@Column(name ="NOW_PROFESSIONAL",nullable=true,length=64)
	public java.lang.String getNowProfessional(){
		return this.nowProfessional;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  现专业
	 */
	public void setNowProfessional(java.lang.String nowProfessional){
		this.nowProfessional = nowProfessional;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  录入时间
	 */
	@Column(name ="ENTRY_TIME",nullable=true)
	public java.util.Date getEntryTime(){
		return this.entryTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  录入时间
	 */
	public void setEntryTime(java.util.Date entryTime){
		this.entryTime = entryTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  毕业时间
	 */
	@Column(name ="GRADUATE_TIME",nullable=true)
	public java.util.Date getGraduateTime(){
		return this.graduateTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  毕业时间
	 */
	public void setGraduateTime(java.util.Date graduateTime){
		this.graduateTime = graduateTime;
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
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  民族
	 */
	@Column(name ="NATIONAL_NAME",nullable=true,length=32)
	public java.lang.String getNationalName(){
		return this.nationalName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  民族
	 */
	public void setNationalName(java.lang.String nationalName){
		this.nationalName = nationalName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职务
	 */
	@Column(name ="POSITION",nullable=true,length=64)
	public java.lang.String getPosition(){
		return this.position;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职务
	 */
	public void setPosition(java.lang.String position){
		this.position = position;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  班级
	 */
	@Column(name ="THE_CLASS",nullable=true,length=64)
	public java.lang.String getTheClass(){
		return this.theClass;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  班级
	 */
	public void setTheClass(java.lang.String theClass){
		this.theClass = theClass;
	}
}
