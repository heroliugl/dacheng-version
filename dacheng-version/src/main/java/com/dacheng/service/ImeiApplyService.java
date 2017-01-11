package com.dacheng.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dacheng.entity.ImeiApply;
import com.dacheng.entity.view.PageView;
import com.github.pagehelper.PageInfo;
/**
 * 授权imei类型接口
 * @author Administrator
 *
 */
public interface ImeiApplyService {

	/**
	 * 根据授权imei查询授权imei信息
	 * @return 授权imei信息
	 */
	public int deleteImeiApplyByImei(@Param("imei") String imei) throws Exception;
	
	/**
	 * 根据授权imei查询授权imei信息
	 * @return 授权imei信息
	 */
	public int deleteImeiApplyByApplyId(@Param("applyId") String applyId) throws Exception;
	
	/**
	 * 根据授权ImeiID查询
	 * @return 授权Imei信息
	 */
	public ImeiApply findImeiApplyByApplyId(@Param("applyId") String applyId) throws Exception;
	
	/**
	 * 根据授权imei说明ID查询授权imei说明信息
	 * @return 授权imei说明信息
	 */
	public List<ImeiApply> findImeiApplyList(ImeiApply imeiApply) throws Exception;
	
	/**
	 * 根据授权imei查询授权imei信息
	 * @return 授权imei信息
	 */
	public PageView<ImeiApply> findPage(Integer pageNo, Integer pageSize,ImeiApply imeiApply) throws Exception;
	
	
	public PageInfo<ImeiApply> queryByPage(Integer pageNo,Integer pageSize,ImeiApply imeiApply) throws Exception;
	

	
}