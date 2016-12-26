package com.spearbothy.dao.impl;

import org.springframework.stereotype.Repository;

import com.spearbothy.dao.BaseDao;
import com.spearbothy.model.Blog;
import com.spearbothy.model.ResourceType;

@Repository
public class ResourceTypeDao  extends BaseDaoImpl<ResourceType>{
	
	
	/**
	 * 根据内容获取类型
	 * @param content
	 * @return
	 */
	public ResourceType getTypeByContent(String content){
		
		return (ResourceType) get("from ResourceType where type = '"+content+"'");
		
	}
}
