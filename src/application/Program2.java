package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("===TESTE 1: department findById===");
		Department department = departmentDao.findById(1);
		System.out.println(department);
		
		System.out.println("\n===TESTE 2: department findAll===");
		List<Department> list = departmentDao.findAll();
		
		for (Department d : list) {
			System.out.println(d);
		}
		
		System.out.println("\n===TESTE 3: department Insert===");
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted: new Id = " + newDepartment.getId());
		
		System.out.println("\n===TESTE 4: department Update===");
		Department department2 = departmentDao.findById(1);
		department2.setName("Food");
		departmentDao.update(department2);
		System.out.println("Update completed!");
		
		System.out.println("\n===TESTE 5: department Delete===");
		System.out.println("Enter ID for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed.");

		sc.close();
	}
}
