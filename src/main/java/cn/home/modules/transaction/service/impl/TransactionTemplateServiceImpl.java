package cn.home.modules.transaction.service.impl;

import org.junit.Assert;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import cn.home.modules.transaction.exeption.BusinessExeption;
import cn.home.modules.transaction.service.TransactionTemplateService;

/**
 * @author donald 2017年11月30日 下午9:49:21
 */
public class TransactionTemplateServiceImpl implements TransactionTemplateService {
	// single TransactionTemplate shared amongst all methods in this instance
	private final TransactionTemplate transactionTemplate;

	// use constructor-injection to supply the PlatformTransactionManager
	public TransactionTemplateServiceImpl(PlatformTransactionManager transactionManager) {
		Assert.assertNotNull("The 'transactionManager' argument must not be null.", transactionManager);
		this.transactionTemplate = new TransactionTemplate(transactionManager);
		// the transaction settings can be set here explicitly if so desired
	    this.transactionTemplate.setIsolationLevel(TransactionDefinition.ISOLATION_READ_UNCOMMITTED);
	    this.transactionTemplate.setTimeout(30); // 30 seconds
	    // and so forth...
	}

	/**
	 * 事务回调
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object someServiceMethod() {
		return transactionTemplate.execute(new TransactionCallback() {

			// the code in this method executes in a transactional context
			public Object doInTransaction(TransactionStatus status) {
				updateOperation1();
				return resultOfUpdateOperation2();
			}
		});
	}

	protected Object resultOfUpdateOperation2() {
		return null;
	}

	protected void updateOperation1() {

	}

	/**
	 * 无返回结果事务
	 */
	@SuppressWarnings("unchecked")
	public void someServiceMethodWithoutResult() {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus transactionstatus) {
				updateOperation1();
				updateOperation3();
			}
		});
	}

	protected void updateOperation3() {

	}

	/**
	 * 回滚事务
	 */
	public void someServiceMethodRollBack() {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {

			  protected void doInTransactionWithoutResult(TransactionStatus status) {
			    try {
			      updateOperation1();
			      updateOperation4();
			    } catch (BusinessExeption ex) {
			      status.setRollbackOnly();
			    }
			  }
		});
	}

	protected void updateOperation4() throws BusinessExeption{
		
	}
}
