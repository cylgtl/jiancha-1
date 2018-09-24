package com.inspection.entity.evaluation;

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
 * @Description: 官兵评残证明材料信息
 * @author zhangdaihao
 * @date 2018-07-07 15:24:04
 * @version V1.0   
 *
 */
@Entity
@Table(name = "jc_evaluation_residual_prove", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class EvaluationResidualProveEntity implements java.io.Serializable {
	/**证明人*/
	private java.lang.String id;
	/**主表*/
	private java.lang.String officerId;
	/**证明人*/
	private java.lang.String proveName;
	/**部职别*/
	private java.lang.String jobTitle;
	/**证明结果*/
	private java.lang.String result;
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
	 *@return: java.lang.String  证明人
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
	 *@param: java.lang.String  证明人
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主表
	 */
	@Column(name ="OFFICER_ID",nullable=true,length=40)
	public java.lang.String getOfficerId(){
		return this.officerId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主表
	 */
	public void setOfficerId(java.lang.String officerId){
		this.officerId = officerId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  证明人
	 */
	@Column(name ="PROVE_NAME",nullable=true,length=64)
	public java.lang.String getProveName(){
		return this.proveName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  证明人
	 */
	public void setProveName(java.lang.String proveName){
		this.proveName = proveName;
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
	 *@return: java.lang.String  证明结果
	 */
	@Column(name ="RESULT",nullable=true,length=64)
	public java.lang.String getResult(){
		return this.result;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  证明结果
	 */
	public void setResult(java.lang.String result){
		this.result = result;
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
