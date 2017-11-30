/**
 * Global transactions via EJB CMT (Container Managed Transaction): CMT is a
 * form of declarative transaction management (as distinguished from
 * programmatic transaction management). Local transactions Spring Framework
 * provides both declarative and programmatic transaction management
 * 
 * PlatformTransactionManager TransactionException TransactionStatus
 * TransactionDefinition
 * 
 * DataSourceTransactionManager -> DataSource 
 * HibernateTransactionManager -> SessionFactory
 * 
 * JdbcTemplate DataSourceUtils (for JDBC), EntityManagerFactoryUtils (for JPA),
 * SessionFactoryUtils (for Hibernate), PersistenceManagerFactoryUtils (for JDO)
 * 
 * 
 * TransactionAwareDataSourceProxy 
 * TransactionProxyFactoryBean spring2.0
 * 
 * 
 * @Transactional 
 * @EnableTransactionManagement
 * TransactionInterceptor 
 * 
 * @author donald 2017年11月30日 下午3:28:33
 */
package cn.home.modules.transaction;