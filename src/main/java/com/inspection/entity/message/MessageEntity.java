package com.inspection.entity.message;

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
 * @Description: 廉情公示消息
 * @author zhangdaihao
 * @date 2018-06-26 22:32:09
 * @version V1.0   
 *
 */
@Entity
@Table(name = "jc_message", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class MessageEntity implements java.io.Serializable {
	/**主键ID*/
	private java.lang.String id;
	/**标题*/
	private java.lang.String title;
	/**具体内容*/
	private java.lang.String content;
	/**创建人ID*/
	private java.lang.String createUserId;
	/**创建时间*/
	private java.util.Date createTime;
	/**更新时间*/
	private java.util.Date updateTime;
	/**D表示删除，E表示正常*/
	private java.lang.String status;
	/**点击次数*/
	private java.lang.Integer clickCount;
	/**类型，0表示述廉报告，1表示法规展示*/
	private java.lang.Integer type;
	
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
	 *@return: java.lang.String  标题
	 */
	@Column(name ="TITLE",nullable=true,length=250)
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
	 *@return: java.lang.String  具体内容
	 */
	@Column(name ="CONTENT",nullable=true,length=65535)
	public java.lang.String getContent(){
		return this.content;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  具体内容
	 */
	public void setContent(java.lang.String content){
		this.content = content;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人ID
	 */
	@Column(name ="CREATE_USER_ID",nullable=true,length=40)
	public java.lang.String getCreateUserId(){
		return this.createUserId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人ID
	 */
	public void setCreateUserId(java.lang.String createUserId){
		this.createUserId = createUserId;
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
	 *@return: java.lang.String  D表示删除，E表示正常
	 */
	@Column(name ="STATUS",nullable=true,length=2)
	public java.lang.String getStatus(){
		return this.status;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  D表示删除，E表示正常
	 */
	public void setStatus(java.lang.String status){
		this.status = status;
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
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  类型，0表示述廉报告，1表示法规展示
	 */
	@Column(name ="TYPE",nullable=true,precision=10,scale=0)
	public java.lang.Integer getType(){
		return this.type;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  类型，0表示述廉报告，1表示法规展示
	 */
	public void setType(java.lang.Integer type){
		this.type = type;
	}
}
