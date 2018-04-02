package mypack;



import javax.persistence.*;


public class MyFactory {

	private static EntityManagerFactory	factory;
	
	static
	{
		//EntityManagerFactory object is created
		//with the help of Persistence class
		factory = 
		Persistence.createEntityManagerFactory("first");
		
	}
	
	//Method to return EntityManager
	public static EntityManager getEntityManager()
	{
		return factory.createEntityManager();
	}
}









