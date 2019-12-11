package lab3;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import com.google.gson.*;


public class Program {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Gson gson = new Gson();
        int selector = 0;
        String s ="";
        
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Book> books_new = new ArrayList<>();
        
        while (!"7".equals(s)) {
        	System.out.print("0 - ��������� ����\n"
        			+ "1 - ������� ������ ����\n"
        			+ "2 - �������� ������ ���� ����������� ������(������ ������ ��� �������)\n"
    				+ "3 - �������� ������ ����, �� ����� ���������� ������������(������ �����������)\n"
    				+ "4 - �������� ������ ����, ������� ����� ��������� ����(������ ��)\n"
    				+ "5 - ³���������� ����� �� �������������\n"
    				+ "6 - �������� � ����\n"
    				+ "7 - �����\n");
            s = scan.next();
                        
            try {
                selector = Integer.parseInt(s);
            }
            catch (NumberFormatException e) {
                System.out.println("������� �����");
            }
            
            
            String search, filename;
            switch (selector) {
            	case 0:
            		filename = scan.nextLine();
            		if(filename.contentEquals("")) {
                		System.out.println("�� �� ������� ��'� �����");
                		break;
                	}
            		try (Scanner file_sc = new Scanner(new File(filename.substring(1)))) {
            			books = new ArrayList<>();
                		while (file_sc.hasNext()) {
                			String fin = file_sc.nextLine();
                			Book b1 = gson.fromJson(fin, Book.class);
                			books.add(b1);
                		}
                		file_sc.close();
                	}
                	catch(IOException ex) {
                        System.out.println(ex.getMessage());
                    }
            		break;
            		
            	case 1:
            		books_new = new ArrayList<>();
            		for(Book b : books) {
                		System.out.println(b.toString());
                		books_new.add(b);
                	}
            		/*for(Book b : books_new) {
        				System.out.println(b.toString());
        			}*/
                	System.out.println();
            		break;
            		
                case 2:
                	search = scan.nextLine();
                	if(search.contentEquals("")) {
                		System.out.println("�� �� ������� ������. �������: 2 ���� ����");
                	}
                	else {
                		books_new = new ArrayList<>();
                		for(Book b : books) {
                    		if(b.GetAuthor().contains((CharSequence)search.substring(1))) {
                    			System.out.println(b.toString());
                    			books_new.add(b);
                    		}
                    	}
                		
                    	System.out.println();
                	}
                    break;
                    
                case 3:
                	search = scan.nextLine();
                	if(search.contentEquals("")) {
                		System.out.println("�� �� ������� �����������. �������: 3 ������");
                	}
                	else {
                		books_new = new ArrayList<>();
                		for(Book b : books) {
                    		if(b.GetEdition().contains((CharSequence)search.substring(1))) {
                    			System.out.println(b.toString());
                    			books_new.add(b);
                    		}
                    	}
                    	System.out.println();
                	}
                    break;
                    
                case 4:
                	search = scan.nextLine();
                	if(search.contentEquals("")) {
                		System.out.println("�� �� ������� ��. �������: 4 2019");
                	}
                	else {
                		books_new = new ArrayList<>();
                		for(Book b : books) {
                    		if(b.GetYear() >= Integer.parseInt(search.substring(1))) {
                    			System.out.println(b.toString());
                    			books_new.add(b);
                    		}
                    	}
                    	System.out.println();
                	}
                	break;
                	
                case 5:
                	EditionComparator ed_comp = new EditionComparator();
                	books.sort(ed_comp);
                	books_new = books;
                	for(Book b : books) {
                		System.out.println(b.toString());
                	}
                	System.out.println();
                	break;
                	
                case 6:
            		filename = scan.nextLine();
            		if(filename.contentEquals("")) {
                		System.out.println("�� �� ������� ��'� �����");
                		break;
                	}
            		try(FileWriter writer = new FileWriter(filename.substring(1), false))
                    {
            			for(Book b : books_new) {
            				System.out.println(b.toString());
            				writer.write(gson.toJson(b) + "\n");
            			}                                             
                        writer.flush();
                    }
                    catch(IOException ex){
                        System.out.println(ex.getMessage());
                    } 
            		break;
            }
        }
        System.out.println("���������� �������� ���������.");
        scan.close();
    }
}
