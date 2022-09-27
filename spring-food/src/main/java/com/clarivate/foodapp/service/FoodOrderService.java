package com.clarivate.foodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.clarivate.foodapp.dao.FoodOrderDao;
import com.clarivate.foodapp.dto.ResponseStructure;
import com.clarivate.foodapp.dto.FoodOrder;

@Service
public class FoodOrderService {
	@Autowired
	FoodOrderDao FoodOrderDao;

	public ResponseStructure<FoodOrder> saveFoodOrder(FoodOrder FoodOrder) {
		ResponseStructure<FoodOrder> rp = new ResponseStructure<FoodOrder>();
		FoodOrder FoodOrder1 = FoodOrderDao.saveOrder(FoodOrder);
		if (FoodOrder1 != null) {
			rp.setStatus(HttpStatus.CREATED.value());
			rp.setMsg("person added");
			rp.setData(FoodOrder1);
		} else {
			rp.setStatus(HttpStatus.NOT_FOUND.value());
			rp.setMsg("person data missing");
			rp.setData(FoodOrder1);

		}
		return rp;
	}

	public ResponseStructure<List<FoodOrder>> listFoodOrder() {
		ResponseStructure<List<FoodOrder>> rp = new ResponseStructure<List<FoodOrder>>();
		List<FoodOrder> list = FoodOrderDao.getAllFoodOrdersData();

		if (list.isEmpty()) {
			rp.setStatus(HttpStatus.NOT_FOUND.value());
			rp.setMsg("person data missing");
			rp.setData(list);

		} else {
			rp.setStatus(HttpStatus.CREATED.value());
			rp.setMsg("person are");
			rp.setData(list);

		}
		return rp;

	}
	public ResponseStructure<FoodOrder> getFoodOrderById(int id) {
		ResponseStructure<FoodOrder> rp = new ResponseStructure<FoodOrder>();
		FoodOrder u1 = FoodOrderDao.getByFoodOrderId(id);
		if (u1==null) {
			rp.setStatus(HttpStatus.NOT_FOUND.value());
			rp.setMsg("person data missing");
			rp.setData(u1);

		} else {
			rp.setStatus(HttpStatus.CREATED.value());
			rp.setMsg("person is");
			rp.setData(u1);

		}
		return rp;

	}
	public ResponseStructure<String> delFoodOrder(int id) {
		ResponseStructure<String> rp = new ResponseStructure<String>();
		String string = FoodOrderDao.deleteFoodOrder(id);
		if (string=="invalid FoodOrder") {
			rp.setStatus(HttpStatus.NOT_FOUND.value());
			rp.setMsg("person data missing");
			rp.setData(string);

		} else {
			rp.setStatus(HttpStatus.CREATED.value());
			rp.setMsg("person is deleted");
			rp.setData(string);

		}
		return rp;

	}
	
	public ResponseStructure<FoodOrder> updateFoodOrder(FoodOrder FoodOrder) {
		ResponseStructure<FoodOrder> rp = new ResponseStructure<FoodOrder>();
		FoodOrder u1 = FoodOrderDao.getByFoodOrderId(FoodOrder.getId());
		if (u1==null) {
			rp.setStatus(HttpStatus.NOT_FOUND.value());
			rp.setMsg("person data missing");
			rp.setData(null);

		} else {
			rp.setStatus(HttpStatus.FOUND.value());
			rp.setMsg("FoodOrder is present");
			rp.setData(FoodOrderDao.updateFoodOrder(FoodOrder));

		}
		return rp;

	}

	
}
