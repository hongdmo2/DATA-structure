import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Queue;



public class TEST {
    LinkedList<Student> list = new LinkedList<Student>();
    
    Queue<Student> Q = new LinkedList<Student>();
    Iterator<Student> it = Q.iterator();
    Student stu;
    Waitinglist w;
    Queue<Waitinglist> Q1 = new LinkedList<Waitinglist>();
    public void addTestData ()
    {
    	try {
    		Scanner scanFile = new Scanner(new File("students.txt"));
    		while (scanFile.hasNext()) {
    			String[] tokens = scanFile.nextLine().split(" ");
    			Student student = new Student(tokens[0],tokens[1],Integer.parseInt(tokens[2]));
    			
    			Q.add(student);
    			
    			
    				
    		}
    		scanFile.close();
    		}
    		catch (IOException e) {
    			e.printStackTrace(); 
    			}
    	
    	
    }
    public void input() {
    	
    	 Student[] students = new Student[Q.size()];
        	students =  Q.toArray(students);
        	
        	if(Q1.size()==10) {
        		System.out.println("Classroom is full and Waitinglist is also full");
        		System.out.println("\n");
        	}
        	else {
        	
    		
    		if(Q.size()<10) {
    			Scanner sc = new Scanner(System.in);
    	        stu = new Student(null, null, 0);
    	        System.out.print("Firstname : ");
    	        stu.setFirstName(sc.next());
    	        System.out.print("Lastname : ");
    	        stu.setLastName(sc.next());
    	        System.out.print("IDNumber : ");
    	        stu.setIDNo(sc.nextInt());
    	        
    	        Q.add(stu);
    	      
    		}
    		
    		else if(Q.size()>=10) {
    			Scanner sc = new Scanner(System.in);
    			w = new Waitinglist(null, null, 0);
    			
    	        System.out.print("Firstname : ");
    	        w.setFirstName(sc.next());
    	        System.out.print("Lastname : ");
    	        w.setLastName(sc.next());
    	        System.out.print("IDNumber : ");
    	        w.setIDNo(sc.nextInt());
    			
    	        Q1.add(w);
    	        
                	
                		
                		
                	
                
    	        
    			
    			//System.out.print("size can't be over 10");
    			
    		}
    		}
    		
    	}
 /*public void Qsort(Comparator<Student> comparator) 
 {
	 whiile (first!=null){
		 
	 }
 }*/
 
		
        
        
    
 
    public void output() {
    	
    	
    	//Collections.sort(list);
    	
        for (Student stu : Q) {
        	 System.out.println(stu); //toString()
        	 }
        System.out.println("-----------------Waitinglist------------------ ");
        if(Q1.size()==0) {
    		System.out.println("There is no Student in the waitinglist");
    		}
        for (Waitinglist w : Q1) {
        	
       	 System.out.println(w); //toString()
       }
       
        
    }
 
    public void search() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Search by Name : ");
        String n = sc.next();
               
        it = Q.iterator(); //bring iterator
        while (it.hasNext()) { //Find 
            Student stu = it.next();
            if (stu.getFirstName().equals(n)) { //if inserted n is equals
                System.out.println(stu); //take list out of n
                System.out.println("--------------------------------------------------");
            }
            else if (stu.getLastName().equals(n)) {
            	System.out.println(stu);
            	System.out.println("--------------------------------------------------");
            }
                       	
            
        }
    }
    public void search2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Search by ID number : ");
        int n = Integer.parseInt(sc.next());
        it = Q.iterator(); 
        while (it.hasNext()) { 
            Student stu = it.next();
        	
            if (stu.getIDNo()==n) { 
                System.out.println(stu); 
                System.out.println("--------------------------------------------------");
            
            }
                       	
            
        }
        
        
    }
                 
   public void dropstudent() {
	   
   }
            
        
    
   
 
    public void delete(){
        //To iterate the list and check the name
    	if (Q.isEmpty()) 
            System.out.println("There is nothing to remove");
    	Scanner sc = new Scanner(System.in);
    	System.out.print("Remove by FirstName : ");
    	String n = sc.next();
    	
        for(Student stu : Q){
            if(stu.getFirstName().equals(n)){
                Q.remove(stu);
                
                if(Q1.size()!=0) {
                	Waitinglist[] w1 = new Waitinglist[Q1.size()];
        	        w1 =  Q1.toArray(w1);
                	if(Q.size()<10) {
                		               		
            	        System.out.print("@@@@@@@@@@@@@@@@@\n");
                    	System.out.print(w1[0]);
                    	 
                    	Q.add(w1[0]);
                	}
                }
                break;
            }
        }
        
        	
        
        }
    
    public void saveChange() {
    	Student[] students = new Student[Q.size()];
    	students =  list.toArray(students);
    	for(int i=0; i<list.size(); i++) {
    		System.out.println(students[i]);
    	}
    }
    
    
    public void saveChanges() {
    	try {
    	Student[] students = new Student[Q.size()];
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
        g.addTestData();
        while (true) {
        	
            g.output();
        	System.out.println();
            System.out.println("  1.ADD 2.Search by name  3.Search by IDnumber  4.Remove by FirstName  5.SaveChange  6.Exit");
            System.out.print("Number choice : ");
            
            int choose;
            choose = sc.nextInt();
            while (choose != 6) {
                switch (choose) {
                /*case 0: // load text file
                	g.addTestData();
                	System.out.print("Text File Loaded");
                	break;*/
                case 1: // Add students
                    g.input();
                    break;
 
               /* case 2: // Print all
                    g.output();
                    break;*/
 
                case 2: // search by first name
                    g.search();
                    break;
 
                case 3: // search by IDNumber
                    g.search2();
                    break;
 
                case 4: // delete
                    g.delete();
                    break;
                case 5: // save
                	g.saveChange();
                	break;
                /*case 7: // saveChanges
                	g.saveChanges();
                    break;*/
                case 6:
                	break;
                }
                break;
            }
        }
    }
}