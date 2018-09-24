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
 * @Description: 技术学兵选调  民主评议/推荐
 * @author zhangdaihao
 * @date 2018-07-09 15:10:23
 * @version V1.0   
 *
 */
@Entity
@Table(name = "jc_technical_personnel_selection_recommend", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class PersonnelSelectionRecommendEntity implements java.io.Serializable {
	/**推荐id*/
	private java.lang.String id;
	/**表彰奖励表关联ID*/
	private java.lang.String officerId;
	/**评议方/推荐方*/
	private java.lang.String recommendPerson;
	/**开始时间*/
	private java.util.Date beginTime;
	/**结束时间*/
	private java.util.Date endTime;
	/**意见*/
	private java.lang.String suggestion;
	/**应到人数*/
	private java.lang.Integer shouldNumber;
	/**赞成票*/
	private java.lang.Integer favour;
	/**有效票*/
	private java.lang.Integer effective;
	/**实到人数*/
	private java.lang.Integer hierarchyNumber;
	/**得票率*/
	private java.lang.String vote;
	/**出勤率*/
	private java.lang.String attendance;
	/**结论*/
	private java.lang.String conclusion;
	/**创建人ID*/
	private java.lang.String createId;
	/**创建时间*/
	private java.util.Date createTime;
	/**修改人ID*/
	private java.lang.String updateId;
	/**修改时间*/
	private java.util.Date updateTime;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  推荐id
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
	 *@param: java.lang.String  推荐id
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  表彰奖励表关联ID
	 */
	@Column(name ="OFFICER_ID",nullable=true,length=64)
	public java.lang.String getOfficerId(){
		return this.officerId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  表彰奖励表关联ID
	 */
	public void setOfficerId(java.lang.String officerId){
		this.officerId = officerId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  评议方/推荐方
	 */
	@Column(name ="RECOMMEND_PERSON",nullable=true,length=256)
	public java.lang.String getRecommendPerson(){
		return this.recommendPerson;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  评议方/推荐方
	 */
	public void setRecommendPerson(java.lang.String recommendPerson){
		this.recommendPerson = recommendPerson;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  开始时间
	 */
	@Column(name ="BEGIN_TIME",nullable=true)
	public java.util.Date getBeginTime(){
		return this.beginTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  开始时间
	 */
	public void setBeginTime(java.util.Date beginTime){
		this.beginTime = beginTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  结束时间
	 */
	@Column(name ="END_TIME",nullable=true)
	public java.util.Date getEndTime(){
		return this.endTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  结束时间
	 */
	public void setEndTime(java.util.Date endTime){
		this.endTime = endTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  意见
	 */
	@Column(name ="SUGGESTION",nullable=true,length=1024)
	public java.lang.String getSuggestion(){
		return this.suggestion;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  意见
	 */
	public void setSuggestion(java.lang.String suggestion){
		this.suggestion = suggestion;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  应到人数
	 */
	@Column(name ="SHOULD_NUMBER",nullable=true,precision=10,scale=0)
	public java.lang.Integer getShouldNumber(){
		return this.shouldNumber;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  应到人数
	 */
	public void setShouldNumber(java.lang.Integer shouldNumber){
		this.shouldNumber = shouldNumber;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  赞成票
	 */
	@Column(name ="FAVOUR",nullable=true,precision=10,scale=0)
	public java.lang.Integer getFavour(){
		return this.favour;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  赞成票
	 */
	public void setFavour(java.lang.Integer favour){
		this.favour = favour;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  有效票
	 */
	@Column(name ="EFFECTIVE",nullable=true,precision=10,scale=0)
	public java.lang.Integer getEffective(){
		return this.effective;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  有效票
	 */
	public void setEffective(java.lang.Integer effective){
		this.effective = effective;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  实到人数
	 */
	@Column(name ="HIERARCHY_NUMBER",nullable=true,precision=10,scale=0)
	public java.lang.Integer getHierarchyNumber(){
		return this.hierarchyNumber;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  实到人数
	 */
	public void setHierarchyNumber(java.lang.Integer hierarchyNumber){
		this.hierarchyNumber = hierarchyNumber;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  得票率
	 */
	@Column(name ="VOTE",nullable=true,length=512)
	public java.lang.String getVote(){
		return this.vote;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  得票率
	 */
	public void setVote(java.lang.String vote){
		this.vote = vote;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  出勤率
	 */
	@Column(name ="ATTENDANCE",nullable=true,length=512)
	public java.lang.String getAttendance(){
		return this.attendance;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  出勤率
	 */
	public void setAttendance(java.lang.String attendance){
		this.attendance = attendance;
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
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  修改时间
	 */
	@Column(name ="UPDATE_TIME",nullable=true)
	public java.util.Date getUpdateTime(){
		return this.updateTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  修改时间
	 */
	public void setUpdateTime(java.util.Date updateTime){
		this.updateTime = updateTime;
	}

	public java.lang.String getConclusion() {
		return conclusion;
	}

	public void setConclusion(java.lang.String conclusion) {
		this.conclusion = conclusion;
	}
}
