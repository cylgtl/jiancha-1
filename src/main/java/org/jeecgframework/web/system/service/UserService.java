package org.jeecgframework.web.system.service;

import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.CommonService;
import org.jeecgframework.web.system.entity.TSUser;
import org.jeecgframework.web.system.vo.ExlUserVo;

import java.util.List;

/**
 * 
 * @author  张代浩
 *
 */
public interface UserService extends CommonService{
	
	public TSUser checkUserExits(TSUser user);
	public String getUserRole(TSUser user);
	public void pwdInit(TSUser user, String newPwd);
	/**
	 * 判断这个角色是不是还有用户使用
	 *@Author JueYue
	 *@date   2013-11-12
	 *@param id
	 *@return
	 */
	public int getUsersOfThisRole(String id);

	List<ExlUserVo> getExlUserList(DataGrid dataGrid, TSUser user, CriteriaQuery cq);
	
	
	/**
	 *<b>获取代理人所用的客户ID</b>
	 *<p>
	 *</p>
	 * @param userId
	 * @return
	 */
	public List<String> queryIdByUserId(String userId);
}
