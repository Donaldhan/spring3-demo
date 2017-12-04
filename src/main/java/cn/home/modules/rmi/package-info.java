/**
 * Using the RmiServiceExporter, we can expose the interface of our
 * AccountService object as RMI object. The interface can be accessed by using
 * RmiProxyFactoryBean, or via plain RMI in case of a traditional RMI service.
 * The RmiServiceExporter explicitly supports the exposing of any non-RMI
 * services via RMI invokers
 * 
 * RmiServiceExporter
 * 
 * Using Hessian or Burlap to remotely call services via HTTP
 * 
 * Spring provides full support for standard Java web services APIs:
 * 
 * Exposing web services using JAX-RPC
 * Accessing web services using JAX-RPC
 * Exposing web services using JAX-WS
 * Accessing web services using JAX-WS
 * 
 * RestTemplate 
 * JdbcTemplate 
 * JmsTemplate 
 * 
 * restTemplate.getForObject("http://example.com/hotel list", String.class);
 * 
 * @author donald 2017年12月4日 下午12:45:06
 */
package cn.home.modules.rmi;