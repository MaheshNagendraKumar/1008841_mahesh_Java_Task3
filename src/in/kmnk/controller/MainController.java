package in.kmnk.controller;

import java.util.Scanner;

import in.kmnk.dto.Customer;
import in.kmnk.dto.Feedback;

public class MainController {
	 Customer[]  customerStore = new Customer[5];
	 Feedback[]  feedbackStore = new Feedback[5];
	 Feedback[] feedbacksByCustomerId = new Feedback[5];
	 int customer_count=0;
	 int feedback_count=0;
	 int feedbacksByCustomerId_count=0;
	
	
//	1)add customer
	public void addCustomer(Customer customer) {
		if(customer!=null) {
			customerStore[customer_count]=customer;
			System.out.println("Customer Added Successfully");
			customer_count++;
		}
	}
	
	
//	1)add feedback
	public void addFeedback(Feedback feedback) {
		if(feedback!=null) {
			feedbackStore[feedback_count]=feedback;
			System.out.println("Feedback Added Successfully");
			feedback_count++;
		}
	}
	
//	2)find student by id
	public Feedback[] getFeedbacksByCustomerId(int cid) {	
		for(Feedback fs:feedbackStore) {
			if(fs!=null) {
				if(fs.getCustomer().getCid()==cid) {
					feedbacksByCustomerId[feedbacksByCustomerId_count]=fs;
					feedbacksByCustomerId_count++;
				}
			}
		}
		return feedbacksByCustomerId!=null? feedbacksByCustomerId:null;
	}
	
	public Customer getCustomerById(int cid) {	
		for(Customer customer:customerStore) {
			if(customer!=null) {
				if(customer.getCid()==cid) {
					return customer;
				}
			}
		}
		return null;
	}
	
	 //change name by id
		public void changeName(int id, String newName) {
			for(Customer customer:customerStore) {
				if(customer!=null) {
					if(customer.getCid()==id) {
						System.out.println("Before update name");
						System.out.println(customer);
						customer.setCnmae(newName);
						System.out.println("After update name");
						System.out.println(customer);
					}
				}
			}
		}

	public static void main(String[] args) {
		
		MainController mainController = new MainController();
		Scanner sc = new Scanner(System.in);
//		Student student = new Student();
		
		int option=0;
		while(option !=5) {
			System.out.println("1) register customer in customer store\n"
					+ "2) add feedback in feedback store\n"
					+ "3) fetch all feedbacks by customer id\n"
					+ "4) change customer name by id\n"
					+ "5) Exit\n");
			
			option = sc.nextInt();
			
			switch(option) {
			
			case 1:
				System.out.println("Enter customer id");
				int cid = sc.nextInt();
				System.out.println("Enter customer Name");
				String cname = sc.next();
				
				Customer customer = new Customer();
				customer.setCid(cid);
				customer.setCnmae(cname);
				mainController.addCustomer(customer);
				break;
			case 2: 
				System.out.println("Enter customer id under which customer name you want to give feedback");
				cid = sc.nextInt();
				Customer customerFound = mainController.getCustomerById(cid);
				if(customerFound != null) {
					System.out.println("Enter Feedback id");
					int fid = sc.nextInt();
					System.out.println("Enter Feddback Description");
					String fdescription = sc.next();
					
					Feedback feedback = new Feedback();
					feedback.setFid(fid);
					feedback.setFdescreption(fdescription);
					feedback.setCustomer(customerFound);
					
					mainController.addFeedback(feedback);
				}else {
					System.out.println("Customer not found with the given id to give the feedbacks");
				}
				
				break;
				
			case 3:
				System.out.println("Enter Customer id");
				cid = sc.nextInt();
				Feedback[] feedbacksFound = mainController.getFeedbacksByCustomerId(cid);	
				
				for(Feedback feedback:feedbacksFound) {
					if(feedback!=null) {
						System.out.println(feedback);
					}
				}
				mainController.feedbacksByCustomerId = new Feedback[5];
				break;
				
			case 4:
				boolean flag=true;
				while(flag) {
					System.out.println("Enter customer id which customer name you want to update");
					cid = sc.nextInt();
					
					Customer customerById = mainController.getCustomerById(cid);
					if(customerById!=null) {
						System.out.println("Enter new name for the given customer id");
						cname = sc.next();	
						mainController.changeName(cid, cname);	
						flag=false;
					}else {
						System.out.println("Customer not found with the given id to change name");
					}
				}
				break;
			}
		}		
		System.out.println("Thank you");	
		sc.close();
	}

}
