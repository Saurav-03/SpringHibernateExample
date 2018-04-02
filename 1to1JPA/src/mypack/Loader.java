package mypack;

import java.util.Scanner;

import javax.persistence.*;

public class Loader {

	public static void main(String[] args) {
		
		Scanner in =new Scanner(System.in);
		System.out.println("Enter Country Id: ");
		int id=in.nextInt();
		EntityManager manager=MyFactory.getEntityManager();
		Country c=(Country)
				manager.find(Country.class, id);
		System.out.println("Country Name:"+c.getName());
		HeadOfState hos=c.getHos();
		System.out.print("Head of state is: ");
		System.out.println(hos.getTitle()+"\t"+hos.getName());
		System.out.println("Enter HosId: ");
		id=in.nextInt();
		HeadOfState h=(HeadOfState)
				manager.find(HeadOfState.class, id);
		System.out.print("Head of state is: ");
		System.out.println(h.getTitle()+"\t"+h.getName());
		Country country=h.getCountry();
		System.out.println("Country is "+country.getName());
		in.close();
		manager.close();
	}

}
