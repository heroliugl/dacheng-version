package com.dacheng.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dacheng.entity.Agency;
import com.dacheng.entity.ImeiAuthor;
import com.dacheng.entity.Role;
import com.dacheng.entity.User;
import com.dacheng.entity.view.PageView;

public interface AgencyService {
	/**
	 * 保存客户、分销商信息
	 * @return 受影响行数
	 */
	public int saveAgency(Agency agency) throws Exception;

	/**
	 * 根据客户、分销商编号删除客户、分销商信息
	 * @param agencyId
	 * @return 受影响的行数
	 */
	public int deleteAgencyById(@Param("id") Long id) throws Exception;
	

	/**
	 * 更新agency信息
	 * @return 受影响的行数
	 */
	public int updateAgency(Agency agency) throws Exception;
	
	/**
	 * 根据客户、分销商编号查询客户、分销商信息
	 * @param ID 客户、分销商编号
	 * @return
	 */
	public Agency findAgencyById(@Param("id") Long id) throws Exception;

	/**
	 * 检查客户、分销商名称是否已经存在
	 * @return int
	 */
	public int checkAgencyNameIsExist(@Param("agencyName") String agencyName) throws Exception;
	
	/**
	 * 检查客户、分销商名称是否已经存在
	 * @return int
	 */
	public int checkAgencyCodeIsExist(@Param("agencyCode") String agencyCode) throws Exception;
	
	/**
	 * 查询客户、分销商列表
	 * @param agency
	 * @return
	 * @throws Exception
	 */
	public List<Agency> findAgencyList(Agency agency) throws Exception;
	
	/**
	 * 角色分页
	 * @return PageView
	 */
	public PageView<Agency> findPage(Integer pageNo, Integer pageSize,Agency agency) throws Exception;
	
}