package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.paging.pageble;

public interface INewService {
	List<NewsModel> findByCategoryId(Long categoryId);
	NewsModel save(NewsModel newsModel);
	NewsModel update(NewsModel updateNew);
	void delete(long[] ids);
	List<NewsModel> findAll(pageble pageble);
	int getTotalItem();
	NewsModel findOne(long id);
}
