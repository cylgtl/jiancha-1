package com.inspection.entity.delivery;

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
 * @Description: 被装发放信息
 * @author zhangdaihao
 * @date 2018-07-04 11:25:48
 * @version V1.0   
 *
 */
@Entity
@Table(name = "jc_delivery", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class DeliveryEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**标题*/
	private java.lang.String title;
	/**开始时间*/
	private java.util.Date startDate;
	/**结束时间*/
	private java.util.Date endDate;
	/**发放人*/
	private java.lang.String givePerson;
	/**联系方式*/
	private java.lang.String contactWay;
	/**附件地址*/
	private java.lang.String fileId;
	/**创建人*/
	private java.lang.String createBy;
	/**创建时间*/
	private java.util.Date cerateDate;
	/**修改人*/
	private java.lang.String updateBy;
	/**修改时间*/
	private java.util.Date updateDate;
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
	 *@return: java.lang.String  标题
	 */
	@Column(name ="TITLE",nullable=true,length=256)
	public java.lang.String getTitle(){
		return this.title;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  标题
	 */
	public void setTitle(java.lang.String title){
		this.title = title;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  开始时间
	 */
	@Column(name ="START_DATE",nullable=true)
	public java.util.Date getStartDate(){
		return this.startDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  开始时间
	 */
	public void setStartDate(java.util.Date startDate){
		this.startDate = startDate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  结束时间
	 */
	@Column(name ="END_DATE",nullable=true)
	public java.util.Date getEndDate(){
		return this.endDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  结束时间
	 */
	public void setEndDate(java.util.Date endDate){
		this.endDate = endDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  发放人
	 */
	@Column(name ="GIVE_PERSON",nullable=true,length=256)
	public java.lang.String getGivePerson(){
		return this.givePerson;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发放人
	 */
	public void setGivePerson(java.lang.String givePerson){
		this.givePerson = givePerson;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系方式
	 */
	@Column(name ="CONTACT_WAY",nullable=true,length=256)
	public java.lang.String getContactWay(){
		return this.contactWay;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系方式
	 */
	public void setContactWay(java.lang.String contactWay){
		this.contactWay = contactWay;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  附件地址
	 */
	@Column(name ="FILE_ID",nullable=true,length=512)
	public java.lang.String getFileId(){
		return this.fileId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  附件地址
	 */
	public void setFileId(java.lang.String fileId){
		this.fileId = fileId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人
	 */
	@Column(name ="CREATE_BY",nullable=true,length=256)
	public java.lang.String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人
	 */
	public void setCreateBy(java.lang.String createBy){
		this.createBy = createBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建时间
	 */
	@Column(name ="CERATE_DATE",nullable=true)
	public java.util.Date getCerateDate(){
		return this.cerateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建时间
	 */
	public void setCerateDate(java.util.Date cerateDate){
		this.cerateDate = cerateDate;
	}
	/**
	 *方法: 取得java.util.String
	 *@return: java.util.String  修改人
	 */
	@Column(name ="UPDATE_BY",nullable=true)
	public java.lang.String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  修改人
	 */
	public void setUpdateBy(java.lang.String updateBy){
		this.updateBy = updateBy;
	}
	
	/**
	 *方法: 取得java.util.String
	 *@return: java.util.String  部门id
	 */
	@Column(name ="DEPART_ID",nullable=true)
	public java.lang.String getDepartId(){
		return this.departId;
	}

	/**
	 *方法: 设置java.util.String
	 *@param: java.util.String  部门id
	 */
	public void setDepartId(java.lang.String departId){
		this.departId = departId;
	}
	
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  修改时间
	 */
	@Column(name ="UPDATE_DATE",nullable=true)
	public java.util.Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  修改时间
	 */
	public void setUpdateDate(java.util.Date updateDate){
		this.updateDate = updateDate;
	}
}
