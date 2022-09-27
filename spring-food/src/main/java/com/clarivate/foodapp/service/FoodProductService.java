package com.clarivate.foodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.clarivate.foodapp.dao.FoodProductDao;
import com.clarivate.foodapp.dto.ResponseStructure;
import com.clarivate.foodapp.dto.FoodProduct;

@Service

	public class FoodProductService {
		@Autowired
		FoodProductDao FoodProductDao;

		public ResponseStructure<FoodProduct> saveFoodProduct(FoodProduct FoodProduct) {
			ResponseStructure<FoodProduct> rp = new ResponseStructure<FoodProduct>();
			FoodProduct FoodProduct1 = FoodProductDao.saveProduct(FoodProduct);
			if (FoodProduct1 != null) {
				rp.setStatus(HttpStatus.CREATED.value());
				rp.setMsg("person added");
				rp.setData(FoodProduct1);
			} else {
				rp.setStatus(HttpStatus.NOT_FOUND.value());
				rp.setMsg("person data missing");
				rp.setData(FoodProduct1);

			}
			return rp;
		}

		public ResponseStructure<List<FoodProduct>> listFoodProduct() {
			ResponseStructure<List<FoodProduct>> rp = new ResponseStructure<List<FoodProduct>>();
			List<FoodProduct> list = FoodProductDao.getAllFoodProductsData();;

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
		public ResponseStructure<FoodProduct> getFoodProductById(int id) {
			ResponseStructure<FoodProduct> rp = new ResponseStructure<FoodProduct>();
			FoodProduct u1 = FoodProductDao.getByFoodProductId(id);
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
		public ResponseStructure<String> delFoodProduct(int id) {
			ResponseStructure<String> rp = new ResponseStructure<String>();
			String string = FoodProductDao.deleteFoodProduct(id);
			if (string=="invalid FoodProduct") {
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
		
		public ResponseStructure<FoodProduct> updateFoodProduct(FoodProduct FoodProduct) {
			ResponseStructure<FoodProduct> rp = new ResponseStructure<FoodProduct>();
			FoodProduct u1 = FoodProductDao.getByFoodProductId(FoodProduct.getId());
			if (u1==null) {
				rp.setStatus(HttpStatus.NOT_FOUND.value());
				rp.setMsg("person data missing");
				rp.setData(null);

			} else {
				rp.setStatus(HttpStatus.FOUND.value());
				rp.setMsg("FoodProduct is present");
				rp.setData(FoodProductDao.updateFoodProduct(FoodProduct));

			}
			return rp;

		}

		
	}



