package org.jeecgframework.web.system.entity;

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
 * @Description: 模版管理
 * @author guanxf
 * @date 2016-05-15 23:43:02
 * @version V1.0
 *
 */
@Entity
@Table(name = "t_s_template", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class TemplateEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**模版编码*/
	private java.lang.String theme;
	/**模版名称*/
	private java.lang.String name;
	/**风格*/
	private java.lang.String style;
	/**模版图片*/
	private java.lang.String image;
	/**主页*/
	private java.lang.String pageMain;
	/**登录页面*/
	private java.lang.String pageLogin;
	/**状态0-未使用，1-使用*/
	private java.lang.Integer status;
	/**更新日期*/
	private java.util.Date updateDate;
	/**更新人编号*/
	private java.lang.String updateBy;
	/**更新人姓名*/
	private java.lang.String updateName;

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */

	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=32)
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
	 *@return: java.lang.String  模版编码
	 */
	@Column(name ="THEME",nullable=false,length=50)
	public java.lang.String getTheme(){
		return this.theme;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  模版编码
	 */
	public void setTheme(java.lang.String theme){
		this.theme = theme;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  模版名称
	 */
	@Column(name ="NAME",nullable=false,length=50)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  模版名称
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  风格
	 */
	@Column(name ="STYLE",nullable=true,length=16)
	public java.lang.String getStyle(){
		return this.style;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  风格
	 */
	public void setStyle(java.lang.String style){
		this.style = style;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  模版图片
	 */
	@Column(name ="IMAGE",nullable=false,length=500)
	public java.lang.String getImage(){
		return this.image;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  模版图片
	 */
	public void setImage(java.lang.String image){
		this.image = image;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主页
	 */
	@Column(name ="PAGE_MAIN",nullable=true,length=50)
	public java.lang.String getPageMain(){
		return this.pageMain;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主页
	 */
	public void setPageMain(java.lang.String pageMain){
		this.pageMain = pageMain;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  登录页面
	 */
	@Column(name ="PAGE_LOGIN",nullable=true,length=50)
	public java.lang.String getPageLogin(){
		return this.pageLogin;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  登录页面
	 */
	public void setPageLogin(java.lang.String pageLogin){
		this.pageLogin = pageLogin;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  状态0-未使用，1-使用
	 */
	@Column(name ="STATUS",nullable=false,precision=10,scale=0)
	public java.lang.Integer getStatus(){
		return this.status;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  状态0-未使用，1-使用
	 */
	public void setStatus(java.lang.Integer status){
		this.status = status;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新日期
	 */
	@Column(name ="UPDATE_DATE",nullable=true)
	public java.util.Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新日期
	 */
	public void setUpdateDate(java.util.Date updateDate){
		this.updateDate = updateDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人编号
	 */
	@Column(name ="UPDATE_BY",nullable=true,length=50)
	public java.lang.String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人编号
	 */
	public void setUpdateBy(java.lang.String updateBy){
		this.updateBy = updateBy;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人姓名
	 */
	@Column(name ="UPDATE_NAME",nullable=true,length=50)
	public java.lang.String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人姓名
	 */
	public void setUpdateName(java.lang.String updateName){
		this.updateName = updateName;
	}
}
