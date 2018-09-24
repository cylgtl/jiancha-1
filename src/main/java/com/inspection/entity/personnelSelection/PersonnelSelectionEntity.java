package com.inspection.entity.personnelSelection;

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
 * @Description: 技术学兵选调
 * @author zhangdaihao
 * @date 2018-07-08 22:57:43
 * @version V1.0   
 *
 */
@Entity
@Table(name = "jc_technical_personnel_selection", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class PersonnelSelectionEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**类型*/
	private java.lang.String type;
	/**姓名*/
	private java.lang.String name;
	/**部职别*/
	private java.lang.String jobTitle;
	/**性别*/
	private java.lang.String sex;
	/**民族*/
	private java.lang.String nation;
	/**籍贯*/
	private java.lang.String nativePlace;
	/**政治面貌*/
	private java.lang.String politicalStatus;
	/**出生时间*/
	private java.util.Date birthday;
	/**入伍时间*/
	private java.util.Date militaryTime;
	/**现军衔*/
	private java.lang.String nowRank;
	/**现军衔时间*/
	private java.util.Date rankTime;
	/**选调类型*/
	private java.lang.String selectionType;
	/**学历*/
	private java.lang.String educational;
	/**专业*/
	private java.lang.String specialty;
	/**从事本专业时间*/
	private java.util.Date specialtyTime;
	/**培训单位*/
	private java.lang.String trainingUnit;
	/**培训专业*/
	private java.lang.String trainingSpecialty;
	/**当前专业分配名额*/
	private java.lang.String places;
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
	 *@return: java.lang.String  类型
	 */
	@Column(name ="TYPE",nullable=true,length=32)
	public java.lang.String getType(){
		return this.type;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  类型
	 */
	public void setType(java.lang.String type){
		this.type = type;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  姓名
	 */
	@Column(name ="NAME",nullable=true,length=256)
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
	 *@return: java.lang.String  性别
	 */
	@Column(name ="SEX",nullable=true,precision=3,scale=0)
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
	 *@return: java.lang.String  民族
	 */
	@Column(name ="NATION",nullable=true,length=20)
	public java.lang.String getNation(){
		return this.nation;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  民族
	 */
	public void setNation(java.lang.String nation){
		this.nation = nation;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  籍贯
	 */
	@Column(name ="NATIVE_PLACE",nullable=true,length=100)
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
	 *@return: java.lang.String  政治面貌
	 */
	@Column(name ="POLITICAL_STATUS",nullable=true,length=20)
	public java.lang.String getPoliticalStatus(){
		return this.politicalStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  政治面貌
	 */
	public void setPoliticalStatus(java.lang.String politicalStatus){
		this.politicalStatus = politicalStatus;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  出生时间
	 */
	@Column(name ="BIRTHDAY",nullable=true)
	public java.util.Date getBirthday(){
		return this.birthday;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  出生时间
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
	 *@return: java.util.Date  现军衔时间
	 */
	@Column(name ="RANK_TIME",nullable=true,length=20)
	public java.util.Date getRankTime(){
		return this.rankTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  现军衔时间
	 */
	public void setRankTime(java.util.Date rankTime){
		this.rankTime = rankTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  选调类型
	 */
	@Column(name ="SELECTION_TYPE",nullable=true,length=50)
	public java.lang.String getSelectionType(){
		return this.selectionType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  选调类型
	 */
	public void setSelectionType(java.lang.String selectionType){
		this.selectionType = selectionType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  专业
	 */
	@Column(name ="SPECIALTY",nullable=true,length=100)
	public java.lang.String getSpecialty(){
		return this.specialty;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  专业
	 */
	public void setSpecialty(java.lang.String specialty){
		this.specialty = specialty;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  从事本专业时间
	 */
	@Column(name ="SPECIALTY_TIME",nullable=true)
	public java.util.Date getSpecialtyTime(){
		return this.specialtyTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  从事本专业时间
	 */
	public void setSpecialtyTime(java.util.Date specialtyTime){
		this.specialtyTime = specialtyTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  培训单位
	 */
	@Column(name ="TRAINING_UNIT",nullable=true,length=100)
	public java.lang.String getTrainingUnit(){
		return this.trainingUnit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  培训单位
	 */
	public void setTrainingUnit(java.lang.String trainingUnit){
		this.trainingUnit = trainingUnit;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  培训专业
	 */
	@Column(name ="TRAINING_SPECIALTY",nullable=true,length=100)
	public java.lang.String getTrainingSpecialty(){
		return this.trainingSpecialty;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  培训专业
	 */
	public void setTrainingSpecialty(java.lang.String trainingSpecialty){
		this.trainingSpecialty = trainingSpecialty;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  当前专业分配名额
	 */
	@Column(name ="PLACES",nullable=true,length=100)
	public java.lang.String getPlaces(){
		return this.places;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  当前专业分配名额
	 */
	public void setPlaces(java.lang.String places){
		this.places = places;
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

	public java.lang.String getEducational() {
		return educational;
	}

	public void setEducational(java.lang.String educational) {
		this.educational = educational;
	}
}
