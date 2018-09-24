package com.inspection.entity.soldierstudent;

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
 * @Description: 立功情况
 * @author zhangdaihao
 * @date 2018-07-10 15:40:42
 * @version V1.0   
 *
 */
@Entity
@Table(name = "jc_soldier_student_merit", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class SoldierStudentMeritEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**主表ID*/
	private java.lang.String studentId;
	/**立功类型*/
	private java.lang.String meritType;
	/**立功时间*/
	private java.util.Date meritTime;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
	 */
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=true,length=64)
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
	 *@return: java.lang.String  主表ID
	 */
	@Column(name ="STUDENT_ID",nullable=true,length=64)
	public java.lang.String getStudentId(){
		return this.studentId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主表ID
	 */
	public void setStudentId(java.lang.String studentId){
		this.studentId = studentId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  立功类型
	 */
	@Column(name ="MERIT_TYPE",nullable=true,length=255)
	public java.lang.String getMeritType(){
		return this.meritType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  立功类型
	 */
	public void setMeritType(java.lang.String meritType){
		this.meritType = meritType;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  立功时间
	 */
	@Column(name ="MERIT_TIME",nullable=true)
	public java.util.Date getMeritTime(){
		return this.meritTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  立功时间
	 */
	public void setMeritTime(java.util.Date meritTime){
		this.meritTime = meritTime;
	}
}
