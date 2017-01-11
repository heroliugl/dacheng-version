package com.dacheng.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dacheng.entity.ImeiAuthor;
import com.dacheng.entity.view.PageView;
import com.github.pagehelper.PageInfo;
/**
 * 授权imei类型接口
 * @author Administrator
 *
 */
public interface ImeiAuthorService {
	/**
	 * 保存授权Imei信息
	 * @return 受影响行数
	 */
	public int saveImeiAuthor(ImeiAuthor imeiAuthor) throws Exception;
	
	/**
	 * 根据授权imei查询授权imei信息
	 * @return 授权imei信息
	 */
	public int deleteImeiAuthorByImei(@Param("imei") String imei) throws Exception;
	

	/**
	 * 根据授权imei更新授权imei信息
	 * @return 授权imei信息
	 */
	public int updateImeiAuthor(ImeiAuthor imeiAuthor) throws Exception;
	
	/**
	 * 根据授权ImeiID查询
	 * @return 授权Imei信息
	 */
	public ImeiAuthor findImeiAuthorByImei(@Param("imei") String imei) throws Exception;
	
	/**
	 * 根据授权imei说明ID查询授权imei说明信息
	 * @return 授权imei说明信息
	 */
	public List<ImeiAuthor> findImeiAuthorList(ImeiAuthor imeiAuthor) throws Exception;
	
	/**
	 * 根据授权imei查询授权imei信息
	 * @return 授权imei信息
	 */
	public PageView<ImeiAuthor> findPage(Integer pageNo, Integer pageSize,ImeiAuthor imeiAuthor) throws Exception;
	
	
	public PageInfo<ImeiAuthor> queryByPage(Integer pageNo,Integer pageSize,ImeiAuthor imeiAuthor) throws Exception;
	

	
}