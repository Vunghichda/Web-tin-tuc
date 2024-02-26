package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.paging.pageble;
import com.laptrinhjavaweb.model.NewsModel;

public interface INewDAO extends GenericDAO<NewsModel>{
	NewsModel findOne(Long id);
	List<NewsModel> findByCategoryId(Long categoryId);
	Long save(NewsModel newsModel);
	void update(NewsModel updateNew);
	void delete(long id);
	List<NewsModel> findAll(pageble pageble);
	int getTotalItem();
}
