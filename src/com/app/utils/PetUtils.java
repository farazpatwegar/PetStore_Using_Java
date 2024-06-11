package com.app.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.app.custom_exception.AuthorizationException;
import com.app.custom_exception.OutOfStockException;
import com.app.entity.Category;
import com.app.entity.Order;
import com.app.entity.Pet;
import com.app.entity.Status;

public class PetUtils {

	public static Order orderPet(int petId, int qty, List<Pet> petList) {
		System.out.println("in order pet");
//		for (Pet p : petList)
//			if (p.getPetId() == petId && p.getStock() >= qty) {
//				return new Order(p, qty);
//			}
//		throw new OutOfStockException("no pets!!");

		for (Pet p : petList) {
			if (p.getPetId() == petId && p.getStock() >= qty) {
				p.setStock(p.getStock() - qty);
			
				return new Order(p, qty);
			}
		}
		throw new OutOfStockException("out of stock !!");

	}

	public static void chkOrderStatus(int orderId, List<Order> orderPet) {
		for (Order o : orderPet) {
			if (o.getOrderId() == orderId) {
				System.out.println(o.getStatus());
			}
		}
	}

	public static void updateOrderStatus(int orderId, String status, List<Order> orderPet) {
		for (Order order : orderPet) {
			order.setStatus(Status.valueOf(status));
		}

	}

	public static List<Pet> populatedPetList() {
		List<Pet> petList = new ArrayList<Pet>();
		// petId, name, category, unitPrice, stocks
		petList.add(new Pet(101, "Bull Dog", Category.DOG, 1000, 50));
		petList.add(new Pet(102, "Persian Cat", Category.CAT, 700, 40));
		petList.add(new Pet(103, "Rohu Fish", Category.FISH, 600, 225));
		petList.add(new Pet(104, "Rex Rabbit", Category.RABBIT, 460, 78));
		petList.add(new Pet(105, "German Shefard Dog", Category.DOG, 2250, 36));
		petList.add(new Pet(106, "Bengal Cat", Category.CAT, 500, 25));

		return petList;
	}

}
