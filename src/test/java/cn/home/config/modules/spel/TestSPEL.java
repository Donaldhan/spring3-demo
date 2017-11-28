package cn.home.config.modules.spel;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class TestSPEL {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression("'Hello World'");
		String message = (String) exp.getValue();
	}

	@Test
	public void test1() {
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression("'Hello World'.concat('!')");
		String message = (String) exp.getValue();
	}

	@Test
	public void test2() {
		ExpressionParser parser = new SpelExpressionParser();
		// invokes 'getBytes()'
		Expression exp = parser.parseExpression("'Hello World'.bytes");
		byte[] bytes = (byte[]) exp.getValue();
	}

	@Test
	public void test3() {
		ExpressionParser parser = new SpelExpressionParser();
		// invokes 'getBytes().length'
		Expression exp = parser.parseExpression("'Hello World'.bytes.length");
		int length = (Integer) exp.getValue();
	}
	@Test
	public void test4() {
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression("new String('hello world').toUpperCase()");
		String message = exp.getValue(String.class);
		
	}
	
}
