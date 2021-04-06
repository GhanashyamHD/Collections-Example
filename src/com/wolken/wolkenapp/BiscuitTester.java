package com.wolken.wolkenapp;

import java.util.Scanner;
import com.wolken.wolkenapp.dao.BiscuitsDAO;
import com.wolken.wolkenapp.dao.BiscuitsDAOImpl;
import com.wolken.wolkenapp.dto.BiscuitsDTO;
import com.wolken.wolkenapp.services.BiscuitsService;
import com.wolken.wolkenapp.services.BiscuitsServiceImpl;

public class BiscuitTester {
	
	BiscuitsDAO biscuitsDAO = new BiscuitsDAOImpl();
	
	public void enterDeets() {
		
		BiscuitsDTO biscuitsDTO2 = new BiscuitsDTO();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter ID");
		String id = sc.next();
		biscuitsDTO2.setId(id);

		System.out.println("Enter Brand");
		String brand = sc.next();
		biscuitsDTO2.setBrand(brand);

		System.out.println("Enter Name");
		String name = sc.next();
		biscuitsDTO2.setName(name);

		System.out.println("Enter Price");
		double price = sc.nextDouble();
		biscuitsDTO2.setPrice(price);

		System.out.println("Enter Quantity");
		int qty = sc.nextInt();		
		biscuitsDTO2.setQty(qty);
		
		BiscuitsService biscuitsService = new BiscuitsServiceImpl(biscuitsDAO);
		biscuitsService.validateAndService(biscuitsDTO2);
	}

	public static void main(String[] args) {
		
		BiscuitTester biscuitTester = new BiscuitTester();
		
		while(true) {
			System.out.println("\nList of options :\n1 - Add a new item\n2 - Update Brand and Quantity\n3 - Update Price\n4 - Update Name\n5 - Delete by Name\n6 - Display all it"
					+ "ems\n7 - Delete all items\n8 - Exit\nEnter your choice : ");
			Scanner sc = new Scanner(System.in);
			int ch = sc.nextInt();
			switch(ch) {
			
			case 1: biscuitTester.enterDeets();
					break;
					
			case 2: System.out.println("Enter Price of item to be updated : ");
					double price = sc.nextDouble();
					biscuitTester.biscuitsDAO.updateBrandAndQtyByPrice(price);
					break;
					
			case 3: System.out.println("Enter Brand and Name of item to be updated : ");
					String brand1 = sc.next();
					String name1 = sc.next();
					biscuitTester.biscuitsDAO.updatePriceByBrandAndName(brand1, name1);
					break;
					
			case 4: System.out.println("Enter Brand of item to be updated : ");
					String brand2 = sc.next();
					biscuitTester.biscuitsDAO.updateNameByBrand(brand2);
					break;
					
			case 5: System.out.println("Enter Name of item to be deleted :");
					String name2 = sc.next();
					biscuitTester.biscuitsDAO.deleteByName(name2);
					break;
			
			case 6: biscuitTester.biscuitsDAO.getAll();
					break;
			
			case 7: biscuitTester.biscuitsDAO.deleteAll();
					break;
			
			case 8: System.exit(0);
					break;
			
			default: System.out.println("This choice does not exist !!");
					 break;
					 
			}
		}

//		BiscuitsDTO biscuitsDTO = new BiscuitsDTO();
//		biscuitsDTO.setId(2);
//		biscuitsDTO.setBrand("Parle");
//		biscuitsDTO.setName("HideAndSeek");
//		biscuitsDTO.setPrice(40);
//		biscuitsDTO.setQty(500);
//
//		BiscuitsDTO biscuitsDTO2 = new BiscuitsDTO();
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("Enter ID");
//		int id = sc.nextInt();
//		biscuitsDTO2.setId(id);
//
//		System.out.println("Enter Brand");
//		String brand = sc.next();
//		biscuitsDTO2.setBrand(brand);
//
//		System.out.println("Enter Name");
//		String name = sc.next();
//		biscuitsDTO2.setName(name);
//
//		System.out.println("Enter Price");
//		double price = sc.nextDouble();
//		biscuitsDTO2.setPrice(price);
//
//		System.out.println("Enter Quantity");
//		int qty = sc.nextInt();		
//		biscuitsDTO2.setQty(qty);
//		
//		BiscuitsDAO biscuitsDAO = new BiscuitsDAOImpl();
//
//		BiscuitsService biscuitsService = new BiscuitsServiceImpl(biscuitsDAO);
//		biscuitsService.validateAndService(biscuitsDTO);
//		biscuitsService.validateAndService(biscuitsDTO2);
//		
//		sc.close();

	}
}

