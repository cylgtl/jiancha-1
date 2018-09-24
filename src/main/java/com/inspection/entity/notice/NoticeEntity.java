package com.inspection.entity.notice;

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
 * @Description: 各种类型通知
 * @author zhangdaihao
 * @date 2018-07-01 15:09:10
 * @version V1.0   
 *
 */
@Entity
@Table(name = "jc_notice", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class NoticeEntity implements java.io.Serializable {
	/**主键ID*/
	private java.lang.String id;
	/**类型ID,关联数据字典*/
	private java.lang.String type;
	/**标题*/
	private java.lang.String title;
	/**发布人*/
	private java.lang.String release;
	/**内容*/
	private java.lang.String content;
	/**发布日期*/
	private java.lang.String releaseTime;
	/**截止*/
	private java.lang.String end;
	/**创建时间*/
	private java.util.Date createTime;
	/**更新时间*/
	private java.util.Date updateTime;
	/**创建人*/
	private java.lang.String createId;
	/**部门ID*/
	private java.lang.String departId;
	
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
	 *@return: java.lang.String  类型ID,关联数据字典
	 */
	@Column(name ="TYPE",nullable=true,length=40)
	public java.lang.String getType(){
		return this.type;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  类型ID,关联数据字典
	 */
	public void setType(java.lang.String type){
		this.type = type;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  标题
	 */
	@Column(name ="TITLE",nullable=true,length=500)
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  发布人
	 */
	@Column(name ="RELEASE",nullable=true,length=100)
	public java.lang.String getRelease(){
		return this.release;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发布人
	 */
	public void setRelease(java.lang.String release){
		this.release = release;
	}
	/**
	 *方法: 取得java.lang.Object
	 *@return: java.lang.Object  内容
	 */
	@Column(name ="CONTENT",nullable=true,length=65535)
	public java.lang.String getContent(){
		return this.content;
	}

	/**
	 *方法: 设置java.lang.Object
	 *@param: java.lang.Object  内容
	 */
	public void setContent(java.lang.String content){
		this.content = content;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  发布日期
	 */
	@Column(name ="RELEASE_TIME",nullable=true,length=30)
	public java.lang.String getReleaseTime(){
		return this.releaseTime;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发布日期
	 */
	public void setReleaseTime(java.lang.String releaseTime){
		this.releaseTime = releaseTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  截止
	 */
	@Column(name ="END",nullable=true,length=30)
	public java.lang.String getEnd(){
		return this.end;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  截止
	 */
	public void setEnd(java.lang.String end){
		this.end = end;
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
	 *@return: java.lang.String  创建人
	 */
	@Column(name ="CREATE_ID",nullable=true,length=40)
	public java.lang.String getCreateId(){
		return this.createId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人
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
}
