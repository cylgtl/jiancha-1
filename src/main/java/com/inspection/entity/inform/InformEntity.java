package com.inspection.entity.inform;

import java.util.Date;

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
 * @Description: 通知
 * @author zhangdaihao
 * @date 2018-07-06 23:29:52
 * @version V1.0   
 *
 */
@Entity
@Table(name = "jc_inform", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class InformEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**序号*/
	private java.lang.Integer no;
	/**标题*/
	private java.lang.String title;
	/**内容*/
	private java.lang.String content;
	/**分类*/
	private java.lang.String type;
	/**发布时间*/
	private Date beginTime;
	/**截止时间*/
	private Date endTime;
	/**发布人*/
	private java.lang.String head;
	/**创建人*/
	private java.lang.String createUserId;
	/**更新人*/
	private java.lang.String updateUserId;
	/**创建时间*/
	private java.util.Date createTime;
	/**更新时间*/
	private java.util.Date updateTime;
	/**部分ID*/
	private java.lang.String departId;
	/**跳转地址*/
	private java.lang.String url;
	/**点击次数*/
	private java.lang.Integer clickCount;

	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
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
	 *@param: java.lang.String  主键
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  序号
	 */
	@Column(name ="NO",nullable=true,precision=10,scale=0)
	public java.lang.Integer getNo(){
		return this.no;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  序号
	 */
	public void setNo(java.lang.Integer no){
		this.no = no;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  标题
	 */
	@Column(name ="TITLE",nullable=true,length=300)
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
	 *@return: java.lang.String  内容
	 */
	@Column(name ="CONTENT",nullable=true,length=1000)
	public java.lang.String getContent(){
		return this.content;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  内容
	 */
	public void setContent(java.lang.String content){
		this.content = content;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  分类
	 */
	@Column(name ="TYPE",nullable=true,precision=10,scale=0)
	public java.lang.String getType(){
		return this.type;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  分类
	 */
	public void setType(java.lang.String type){
		this.type = type;
	}
	/**
	 *方法: 取得Date
	 *@return: Date  发布时间
	 */
	@Column(name ="BEGIN_TIME",nullable=true,length=15)
	public Date getBeginTime(){
		return this.beginTime;
	}

	/**
	 *方法: 设置Date
	 *@param: Date  发布时间
	 */
	public void setBeginTime(Date beginTime){
		this.beginTime = beginTime;
	}
	/**
	 *方法: 取得Date
	 *@return: Date  截止时间
	 */
	@Column(name ="END_TIME",nullable=true,length=15)
	public Date getEndTime(){
		return this.endTime;
	}

	/**
	 *方法: 设置Date
	 *@param: Date  截止时间
	 */
	public void setEndTime(Date endTime){
		this.endTime = endTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  发布人
	 */
	@Column(name ="HEAD",nullable=true,length=50)
	public java.lang.String getHead(){
		return this.head;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发布人
	 */
	public void setHead(java.lang.String head){
		this.head = head;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人
	 */
	@Column(name ="CREATE_USER_ID",nullable=true,length=40)
	public java.lang.String getCreateUserId(){
		return this.createUserId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人
	 */
	public void setCreateUserId(java.lang.String createUserId){
		this.createUserId = createUserId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人
	 */
	@Column(name ="UPDATE_USER_ID",nullable=true,length=40)
	public java.lang.String getUpdateUserId(){
		return this.updateUserId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人
	 */
	public void setUpdateUserId(java.lang.String updateUserId){
		this.updateUserId = updateUserId;
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
	 *@return: java.lang.String  部分ID
	 */
	@Column(name ="DEPART_ID",nullable=true,length=40)
	public java.lang.String getDepartId(){
		return this.departId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  部分ID
	 */
	public void setDepartId(java.lang.String departId){
		this.departId = departId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  跳转地址
	 */
	@Column(name ="URL",nullable=true,length=100)
	public java.lang.String getUrl(){
		return this.url;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  跳转地址
	 */
	public void setUrl(java.lang.String url){
		this.url = url;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  点击次数
	 */
	@Column(name ="CLICK_COUNT",nullable=true,precision=10,scale=0)
	public java.lang.Integer getClickCount(){
		return this.clickCount;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  点击次数
	 */
	public void setClickCount(java.lang.Integer clickCount){
		this.clickCount = clickCount;
	}
}
