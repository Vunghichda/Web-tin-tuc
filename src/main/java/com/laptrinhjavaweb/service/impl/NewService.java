package com.laptrinhjavaweb.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.ICategoryDAO;
import com.laptrinhjavaweb.dao.INewDAO;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.paging.pageble;
import com.laptrinhjavaweb.service.INewService;

public class NewService implements INewService{
	@Inject
	private INewDAO newDao;
	@Inject
	private ICategoryDAO categoryDAO;

	@Override
	public List<NewsModel> findByCategoryId(Long categoryId) {
		return newDao.findByCategoryId(categoryId);
	}
	@Override
	public NewsModel save(NewsModel newsModel) {
		newsModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		CategoryModel category = categoryDAO.findOneByCode(newsModel.getCategoryCode());
		newsModel.setCategoryId(category.getId());
		Long newId = newDao.save(newsModel);
		return newDao.findOne(newId);
	}
	@Override
	public NewsModel update(NewsModel updateNew) {
		NewsModel oldNew = newDao.findOne(updateNew.getId());
		updateNew.setCreatedDate(oldNew.getCreatedDate());
		updateNew.setCreatedBy(oldNew.getCreatedBy());
		updateNew.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		CategoryModel category = categoryDAO.findOneByCode(updateNew.getCategoryCode());
		updateNew.setCategoryId(category.getId());
		newDao.update(updateNew);
		return newDao.findOne(updateNew.getId());
		
	}
	@Override
	public void delete(long[] ids) {
		for (long id: ids) {
			//1.delete comment (khoa ngoai new_id)
			//2.delete news
			newDao.delete(id);
		}
	}
	@Override
	public List<NewsModel> findAll(pageble pageble) {
		return newDao.findAll(pageble);
	}
	@Override
	public int getTotalItem() {
		return newDao.getTotalItem();
	}
	@Override
    public NewsModel findOne(long id) {
		NewsModel newModel = newDao.findOne(id);
		CategoryModel categoryModel = categoryDAO.findOne(newModel.getCategoryId());
		newModel.setCategoryCode(categoryModel.getCode());
        return newModel;
    }
	

}
