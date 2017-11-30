package cn.home.modules.transaction.boot;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * @author donald
 * 2017年11月30日
 * 下午10:05:05
 */
public class PlatformTransactionManagerDemo {
	public static void main(String[] args) {
		PlatformTransactionManager  txManager = new DataSourceTransactionManager();
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		// explicitly setting the transaction name is something that can only be done programmatically
		def.setName("SomeTxName");
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

		TransactionStatus status = txManager.getTransaction(def);
		try {
		  // execute your business logic here
		}
		catch (Exception ex) {
		  txManager.rollback(status);
		  throw ex;
		}
		txManager.commit(status);
	}
}
