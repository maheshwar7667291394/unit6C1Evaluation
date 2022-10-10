package Question3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DaoImplement implements AccountDao{
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("accountUnit");
	EntityManager em=emf.createEntityManager();

	@Override
	public Account findById(int id) {
		 Account ac= em.find(Account.class, id);
		 if(ac==null) {
			 System.out.println("acount details not found");
			 return null;
		 }
		return ac;
	}

	@Override
	public String save(Account account) {
		
		em.getTransaction().begin();
		em.persist(account);
		em.getTransaction().commit();
		em.close();
		return "accpount save sucussfull";
		
	}

	@Override
	public String deleteAccountById(int id) {
		String result=null;
		
		Account account=em.find(Account.class,id);
		if(account==null)
			result="no record found";
		else {
			em.getTransaction().begin();
			em.remove(account);
			em.getTransaction().commit();
			em.close();
			result="account delation sussusfull";
		}
		
		return result;
	}

	@Override
	public String withdraw(double amount, int accountId) {
		String result=null;
		Account account=em.find(Account.class,accountId);
		if(account==null) {
			result="no account found";
		}
		else {
			double amt=account.getBalance();
			if(amt<amount) {
				result="insufficent balac=nce";
			}
			else {
				result="withdrable amount is"+amount+" sucussfull";
				em.getTransaction().begin();
				account.setBalance(account.getBalance()-amount);
				em.getTransaction().commit();
				em.close();
			}
			
		}
		
		return result;
	}

	@Override
	public String deposit(double amount, int accountId) {
		String result=null;
		Account account=em.find(Account.class,accountId);
		if(account==null) {
			result="no account found";
		}
		else {
		
				result="deposited amount is"+amount+" sucussfull";
				em.getTransaction().begin();
				account.setBalance(account.getBalance()+amount);
				em.getTransaction().commit();
				em.close();
			
			
		}
		
		return result;
		
	}

}
