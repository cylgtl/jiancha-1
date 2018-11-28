package com.inspection.entity.report;

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
 * @Description: 信访举报
 * @author zhangdaihao
 * @date 2018-06-25 20:51:21
 * @version V1.0   
 *
 */
@Entity
@Table(name = "jc_report", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class ReportEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**标题*/
	private java.lang.String title;
	/**内容*/
	private java.lang.String content;
	/**提交人ID*/
	private java.lang.String createUserId;
	/**审核角色ID*/
	private java.lang.String roleId;
	/**状态，W待回复，E已回复*/
	private java.lang.String status;
	/**回复人id*/
	private java.lang.String replayUserId;
	/**创建时间*/
	private java.util.Date createTime;
	/**回复时间*/
	private java.util.Date replyTime;
	/**回复内容*/
	private java.lang.String replyContent;
	/**举报人姓名*/
	private java.lang.String personName;
	/**举报人姓名*/
	private java.lang.String personPhone;
	/**0表示匿名,1表示实名*/
	private java.lang.String anonymous;
	/**来源地址*/
	private java.lang.String url;

	/**类型：监督纠错 情况反映*/
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private String type;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
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
	 *@param: java.lang.String  id
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  标题
	 */
	@Column(name ="TITLE",nullable=true,length=100)
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
	 *@return: java.lang.String  提交人ID
	 */
	@Column(name ="CREATE_USER_ID",nullable=true,length=40)
	public java.lang.String getCreateUserId(){
		return this.createUserId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  提交人ID
	 */
	public void setCreateUserId(java.lang.String createUserId){
		this.createUserId = createUserId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  审核角色ID
	 */
	@Column(name ="ROLE_ID",nullable=true,length=40)
	public java.lang.String getRoleId(){
		return this.roleId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审核角色ID
	 */
	public void setRoleId(java.lang.String roleId){
		this.roleId = roleId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  状态，W待回复，E已回复
	 */
	@Column(name ="STATUS",nullable=true,length=5)
	public java.lang.String getStatus(){
		return this.status;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  状态，W待回复，E已回复
	 */
	public void setStatus(java.lang.String status){
		this.status = status;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  回复人id
	 */
	@Column(name ="REPLAY_USER_ID",nullable=true,length=40)
	public java.lang.String getReplayUserId(){
		return this.replayUserId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  回复人id
	 */
	public void setReplayUserId(java.lang.String replayUserId){
		this.replayUserId = replayUserId;
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
	 *@return: java.util.Date  回复时间
	 */
	@Column(name ="REPLY_TIME",nullable=true)
	public java.util.Date getReplyTime(){
		return this.replyTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  回复时间
	 */
	public void setReplyTime(java.util.Date replyTime){
		this.replyTime = replyTime;
	}
	/**
	 *方法: 取得java.lang.Object
	 *@return: java.lang.Object  回复内容
	 */
	@Column(name ="REPLY_CONTENT",nullable=true,length=65535)
	public java.lang.String getReplyContent(){
		return this.replyContent;
	}

	/**
	 *方法: 设置java.lang.Object
	 *@param: java.lang.Object  回复内容
	 */
	public void setReplyContent(java.lang.String replyContent){
		this.replyContent = replyContent;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  举报人姓名
	 */
	@Column(name ="PERSON_NAME",nullable=true,length=100)
	public java.lang.String getPersonName(){
		return this.personName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  举报人姓名
	 */
	public void setPersonName(java.lang.String personName){
		this.personName = personName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  举报人姓名
	 */
	@Column(name ="PERSON_PHONE",nullable=true,length=20)
	public java.lang.String getPersonPhone(){
		return this.personPhone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  举报人姓名
	 */
	public void setPersonPhone(java.lang.String personPhone){
		this.personPhone = personPhone;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  0表示匿名,1表示实名
	 */
	@Column(name ="ANONYMOUS",nullable=true)
	public java.lang.String getAnonymous(){
		return this.anonymous;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  0表示匿名,1表示实名
	 */
	public void setAnonymous(java.lang.String anonymous){
		this.anonymous = anonymous;
	}

	/**
	 * @return the url
	 */
	@Column(name ="URL",nullable=true,length=500)
	public java.lang.String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(java.lang.String url) {
		this.url = url;
	}
}
