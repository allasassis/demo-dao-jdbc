package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {

	public static void main(String[] args) {

Scanner sc = new Scanner(System.in);
		
		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		
		System.out.println("==== TEST 1: department findById ====");
		Department dep = depDao.findById(3);
		System.out.println(dep);
		
		System.out.println();
		System.out.println("==== TEST 2: department findByAll ====");
		List<Department> list = depDao.findAll();
		
		for (Department x : list) {
			System.out.println(x.toString());
		}
		
		System.out.println();
		System.out.println("==== TEST 3: department insert ====");
		Department dep1 = new Department(null, "Food");
		depDao.insert(dep1);
		System.out.println("Inserted! New ID: " + dep1.getId());
		System.out.println();
		
		System.out.println("==== TEST 4: department update ====");
		dep1 = depDao.findById(1);
		dep1.setName("Phones");
		depDao.update(dep1);
		System.out.println("Update completed! ");
		
		System.out.println();
		System.out.println("==== TEST 5: seller delete ====");
		System.out.println("Enter id for delete test: ");
		int idTest = sc.nextInt();
		depDao.deleteById(idTest);
		System.out.println("Deleted!");
		
		sc.close();

	}

}
