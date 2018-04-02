package mypack;

import javax.persistence.*;

public class Saver {

	public static void main(String[] args) {
		
		Country c1=new Country("India",
				new HeadOfState("President","R.N.Kovind"));
		Country c2=new Country("UK",
				new HeadOfState("Queen","Elizabeth II"));
	
		System.out.println(
		"Saving country objects...");
		EntityManager manager=MyFactory.getEntityManager();
		EntityTransaction t=manager.getTransaction();
		t.begin();
		manager.persist(c1);
		manager.persist(c2);
		t.commit();
		manager.close();
		System.out.println("Successfully saved.");
	}

}
