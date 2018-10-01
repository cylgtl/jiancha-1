package com.inspection.entity.soldierschool;

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
 * @Description: 优秀士兵保送入学个人表现信息
 * @author zhangdaihao
 * @date 2018-07-07 15:21:20
 * @version V1.0   
 *
 */
@Entity
@Table(name = "jc_soldier_school_performance", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class SoldierSchoolPerformanceEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**主表ID*/
	private java.lang.String officerId;
	/**个人表现类型 表现类型 1-军事训练成绩 2-骨干配备 3-表彰奖励*/
	private java.lang.String bxType;
	/**fileId*/
	private java.lang.String fileId;
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
	 *@return: java.lang.String  个人表现类型 表现类型 1-军事训练成绩 2-骨干配备 3-表彰奖励
	 */
	@Column(name ="BX_TYPE",nullable=true,length=64)
	public java.lang.String getBxType(){
		return this.bxType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  个人表现类型 表现类型 1-军事训练成绩 2-骨干配备 3-表彰奖励
	 */
	public void setBxType(java.lang.String bxType){
		this.bxType = bxType;
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
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fileId
	 */
	public void setFileId(java.lang.String fileId){
		this.fileId = fileId;
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
