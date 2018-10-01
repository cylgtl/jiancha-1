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
 * @Description: 各级研究意见和结果
 * @author zhangdaihao
 * @date 2018-07-05 22:26:34
 * @version V1.0   
 *
 */
@Entity
@Table(name = "jc_soldier_auditing", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class SoldierAuditingEntity implements java.io.Serializable {
	/**主键ID*/
	private java.lang.String id;
	/**开始时间*/
	private java.lang.String beginTime;
	/**结束时间*/
	private java.lang.String endTime;
	/**单位*/
	private java.lang.String unit;
	/**意见*/
	private java.lang.String option;
	/**文件路径*/
	private java.lang.String file;
	/**创建时间*/
	private java.util.Date createTime;
	/**更新时间*/
	private java.util.Date updateTime;
	/**创建人ID*/
	private java.lang.String createId;
	
	private java.lang.String leaveId;
	
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
	 *@return: java.lang.String  开始时间
	 */
	@Column(name ="BEGIN_TIME",nullable=true,length=40)
	public java.lang.String getBeginTime(){
		return this.beginTime;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  开始时间
	 */
	public void setBeginTime(java.lang.String beginTime){
		this.beginTime = beginTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  结束时间
	 */
	@Column(name ="END_TIME",nullable=true,length=40)
	public java.lang.String getEndTime(){
		return this.endTime;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  结束时间
	 */
	public void setEndTime(java.lang.String endTime){
		this.endTime = endTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  单位
	 */
	@Column(name ="UNIT",nullable=true,length=300)
	public java.lang.String getUnit(){
		return this.unit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单位
	 */
	public void setUnit(java.lang.String unit){
		this.unit = unit;
	}
	/**
	 *方法: 取得java.lang.Object
	 *@return: java.lang.Object  意见
	 */
	@Column(name ="OPTION",nullable=true,length=65535)
	public java.lang.String getOption(){
		return this.option;
	}

	/**
	 *方法: 设置java.lang.Object
	 *@param: java.lang.Object  意见
	 */
	public void setOption(java.lang.String option){
		this.option = option;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  文件路径
	 */
	@Column(name ="FILE",nullable=true,length=500)
	public java.lang.String getFile(){
		return this.file;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  文件路径
	 */
	public void setFile(java.lang.String file){
		this.file = file;
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
	 * @return the leaveId
	 */
	@Column(name ="LEAVE_ID",nullable=true,length=40)
	public java.lang.String getLeaveId() {
		return leaveId;
	}

	/**
	 * @param leaveId the leaveId to set
	 */
	public void setLeaveId(java.lang.String leaveId) {
		this.leaveId = leaveId;
	}
}
