import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;



public class TEST {
    LinkedList<Student> list = new LinkedList<Student>();
    Iterator<Student> it = list.iterator();
    Student stu;
    public void addTestData ()
    {
    	try {
    		Scanner scanFile = new Scanner(new File("students.txt"));
    		while (scanFile.hasNext()) {
    			String[] tokens = scanFile.nextLine().split(" ");
    			Student student = new Student(tokens[0],tokens[1],Integer.parseInt(tokens[2]));
    			
    			list.add(student);
    			
    			
    				
    		}
    		scanFile.close();
    		}
    		catch (IOException e) {
    			e.printStackTrace(); 
    			}
    	
    }
    public void input() {
    	 Student[] students = new Student[list.size()];
       	students =  list.toArray(students);
    		if(list.size()>=10) {
    			System.out.print("size can't be over 10");
    			
    		}
    		else {
    			Scanner sc = new Scanner(System.in);
    	        stu = new Student(null, null, 0);
    	        System.out.print("Firstname : ");
    	        stu.setFirstName(sc.next());
    	        System.out.print("Lastname : ");
    	        stu.setLastName(sc.next());
    	        System.out.print("IDNumber : ");
    	        stu.setIDNo(sc.nextInt());
    	        
    	        list.add(stu);
    	      
    		}
    	}
        
        	
        
        
    
 
    public void output() {
    	Collections.sort(list);
        for (Student stu : list) {
        	 System.out.println(stu); //toString()
        }
    }
 
    public void search() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Search by Name : ");
        String n = sc.next();
               
        it = list.iterator(); //bring iterator
        while (it.hasNext()) { //Find 
            Student stu = it.next();
            if (stu.getFirstName().equals(n)) { //if inserted n is equals
                System.out.println(stu); //take list out of n
            }
            else if (stu.getLastName().equals(n)) {
            	System.out.println(stu);
            }
                       	
            
        }
    }
    public void search2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Search by ID number : ");
        int n = Integer.parseInt(sc.next());
        it = list.iterator(); 
        while (it.hasNext()) { 
            Student stu = it.next();
        	
            if (stu.getIDNo()==n) { 
                System.out.println(stu); 
            
            }
                       	
            
        }
        
        
    }
                 
                       	
            
        
    
   
 
    public void delete(){
        //To iterate the list and check the name
    	if (list.isEmpty()) 
            System.out.println("There is nothing to remove");
    	Scanner sc = new Scanner(System.in);
    	System.out.print("Remove by FirstName : ");
    	String n = sc.next();
    	
        for(Student stu : list){
            if(stu.getFirstName().equals(n)){
                list.remove(stu);
                break;
            }
        }
    }
    public void saveChange() {
    	Student[] students = new Student[list.size()];
    	students =  list.toArray(students);
    	for(int i=0; i<list.size(); i++) {
    		System.out.println(students[i]);
    	}
    }
    
    
    public void saveChanges() {
    	try {
    	Student[] students = new Student[list.size()];
    	students =  list.toArray(students);
    	
    	File save = new File("SAVING ROSTER");
    	FileWriter myWriter = new FileWriter(save);
    	for(int i=0; i< list.size(); i++) {
    		myWriter.write(students[i] + "\n");
    	}
    	myWriter.close();
    	}
    	catch(IOException e) {
    		e.printStackTrace();
    	}
    	}
    
    
 
    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);
        TEST g = new TEST();
       
        while (true) {
        	System.out.println();
            System.out.println("0.Load Roaster from the txt  1.ADD  2.Display  3.Search by name  4.Search by IDnumber  5.Remove by FirstName  6.SaveChanges 7.Save 8.Exit");
            System.out.print("Number choice : ");
            g.addTestData();
            int choose;
            choose = sc.nextInt();
            while (choose != 8) {
                switch (choose) {
                /*case 0: // load text file
                	g.addTestData();
                	System.out.print("Text File Loaded");
                	break;*/
                case 1: // Add students
                    g.input();
                    break;
 
                case 2: // Print all
                    g.output();
                    break;
 
                case 3: // search by first name
                    g.search();
                    break;
 
                case 4: // search by IDNumber
                    g.search2();
                    break;
 
                case 5: // delete
                    g.delete();
                    break;
                case 6: // save
                	g.saveChange();
                	break;
                case 7: // saveChanges
                	g.saveChanges();
                    break;
                case 8:
                	break;
                }
                break;
            }
        }
    }
}