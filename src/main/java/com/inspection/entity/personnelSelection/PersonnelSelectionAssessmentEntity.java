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
 * @Description: 技术学兵选调  考核结果
 * @author zhangdaihao
 * @date 2018-07-09 16:12:56
 * @version V1.0   
 *
 */
@Entity
@Table(name = "jc_technical_personnel_selection_assessment", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class PersonnelSelectionAssessmentEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**officerId*/
	private java.lang.String officerId;
	/**fileId*/
	private java.lang.String fileId;
	/**结论*/
	private java.lang.Integer conclusion;
	/**createId*/
	private java.lang.String createId;
	/**createTime*/
	private java.util.Date createTime;
	/**updateId*/
	private java.lang.String updateId;
	/**updateTime*/
	private java.util.Date updateTime;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
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
	 *@param: java.lang.String  id
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  officerId
	 */
	@Column(name ="OFFICER_ID",nullable=true,length=64)
	public java.lang.String getOfficerId(){
		return this.officerId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  officerId
	 */
	public void setOfficerId(java.lang.String officerId){
		this.officerId = officerId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fileId
	 */
	@Column(name ="FILE_ID",nullable=true,length=512)
	public java.lang.String getFileId(){
		return this.fileId;
	}

	/**
	 *方法: 设置java.lang.Object
	 *@param: java.lang.Object  fileId
	 */
	public void setFileId(java.lang.String fileId){
		this.fileId = fileId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  结论
	 */
	@Column(name ="CONCLUSION",nullable=true,precision=3,scale=0)
	public java.lang.Integer getConclusion(){
		return this.conclusion;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  结论
	 */
	public void setConclusion(java.lang.Integer conclusion){
		this.conclusion = conclusion;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  createId
	 */
	@Column(name ="CREATE_ID",nullable=true,length=40)
	public java.lang.String getCreateId(){
		return this.createId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  createId
	 */
	public void setCreateId(java.lang.String createId){
		this.createId = createId;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  createTime
	 */
	@Column(name ="CREATE_TIME",nullable=true)
	public java.util.Date getCreateTime(){
		return this.createTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  createTime
	 */
	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  updateId
	 */
	@Column(name ="UPDATE_ID",nullable=true,length=40)
	public java.lang.String getUpdateId(){
		return this.updateId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  updateId
	 */
	public void setUpdateId(java.lang.String updateId){
		this.updateId = updateId;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  updateTime
	 */
	@Column(name ="UPDATE_TIME",nullable=true)
	public java.util.Date getUpdateTime(){
		return this.updateTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  updateTime
	 */
	public void setUpdateTime(java.util.Date updateTime){
		this.updateTime = updateTime;
	}
}
