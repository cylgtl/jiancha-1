package com.inspection.entity.partyMember;

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
 * @Description: 党员发展  个人平时表现
 * @author zhangdaihao
 * @date 2018-07-12 16:13:20
 * @version V1.0   
 *
 */
@Entity
@Table(name = "jc_party_member_performance", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class PartyMemberPerformanceEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**主表ID*/
	private java.lang.String officerId;
	/**党小组意见*/
	private java.lang.String partySuggestion;
	/**联系人1*/
	private java.lang.String contact1;
	/**联系人意见1*/
	private java.lang.String contactSuggestion1;
	/**联系人2*/
	private java.lang.String contact2;
	/**联系人意见2*/
	private java.lang.String contactSuggestion2;
	/**录入时间*/
	private java.util.Date inputTime;
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
	 *@return: java.lang.String  主表ID
	 */
	@Column(name ="OFFICER_ID",nullable=true,length=40)
	public java.lang.String getOfficerId(){
		return this.officerId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主表ID
	 */
	public void setOfficerId(java.lang.String officerId){
		this.officerId = officerId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  党小组意见
	 */
	@Column(name ="PARTY_SUGGESTION",nullable=true,length=1024)
	public java.lang.String getPartySuggestion(){
		return this.partySuggestion;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  党小组意见
	 */
	public void setPartySuggestion(java.lang.String partySuggestion){
		this.partySuggestion = partySuggestion;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系人1
	 */
	@Column(name ="CONTACT1",nullable=true,length=64)
	public java.lang.String getContact1(){
		return this.contact1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系人1
	 */
	public void setContact1(java.lang.String contact1){
		this.contact1 = contact1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系人意见1
	 */
	@Column(name ="CONTACT_SUGGESTION1",nullable=true,length=1024)
	public java.lang.String getContactSuggestion1(){
		return this.contactSuggestion1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系人意见1
	 */
	public void setContactSuggestion1(java.lang.String contactSuggestion1){
		this.contactSuggestion1 = contactSuggestion1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系人2
	 */
	@Column(name ="CONTACT2",nullable=true,length=64)
	public java.lang.String getContact2(){
		return this.contact2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系人2
	 */
	public void setContact2(java.lang.String contact2){
		this.contact2 = contact2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系人意见2
	 */
	@Column(name ="CONTACT_SUGGESTION2",nullable=true,length=1024)
	public java.lang.String getContactSuggestion2(){
		return this.contactSuggestion2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系人意见2
	 */
	public void setContactSuggestion2(java.lang.String contactSuggestion2){
		this.contactSuggestion2 = contactSuggestion2;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  录入时间
	 */
	@Column(name ="INPUT_TIME",nullable=true)
	public java.util.Date getInputTime(){
		return this.inputTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  录入时间
	 */
	public void setInputTime(java.util.Date inputTime){
		this.inputTime = inputTime;
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
}
