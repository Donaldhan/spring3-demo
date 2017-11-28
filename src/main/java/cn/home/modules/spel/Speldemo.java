package cn.home.modules.spel;

import java.util.List;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class Speldemo {
	public static void main(String[] args) {
		ExpressionParser parser = new SpelExpressionParser();
		// evals to "Hello World"
		String helloWorld = (String) parser.parseExpression("'Hello World'").getValue();
		double avogadrosNumber = (Double) parser.parseExpression("6.0221415E+23").getValue();
		// evals to 2147483647
		int maxValue = (Integer) parser.parseExpression("0x7FFFFFFF").getValue();
		boolean trueValue = (Boolean) parser.parseExpression("true").getValue();
		Object nullValue = parser.parseExpression("null").getValue();
		/**
		 * // evals to 1856 int year = (Integer) parser.parseExpression(
		 * "Birthdate.Year + 1900").getValue(context); // String city = (String)
		 * // parser.parseExpression("placeOfBirth.City").getValue(context); //
		 * Inventions Array StandardEvaluationContext teslaContext = new
		 * StandardEvaluationContext(tesla); // evaluates to "Induction motor"
		 * String invention =
		 * parser.parseExpression("inventions[3]").getValue(teslaContext,
		 * String.class); // Members List StandardEvaluationContext
		 * societyContext = new StandardEvaluationContext(ieee); // evaluates to
		 * "Nikola Tesla" String name =
		 * parser.parseExpression("Members[0].Name").getValue(societyContext,
		 * String.class); // List and Array navigation // evaluates to
		 * "Wireless communication" String invention1 =
		 * parser.parseExpression("Members[0].Inventions[6]").getValue(
		 * societyContext, String.class); // Officer's Dictionary Inventor pupin
		 * = parser.parseExpression("Officers['president']").getValue(
		 * societyContext, Inventor.class); // evaluates to "Idvor" String city
		 * = parser.parseExpression("Officers['president'].PlaceOfBirth.City").
		 * getValue(societyContext, String.class); // setting values
		 * parser.parseExpression("Officers['advisors'][0].PlaceOfBirth.Country"
		 * ).setValue(societyContext, "Croatia"); // evaluates to a Java list
		 * containing the four numbers List numbers = (List)
		 * parser.parseExpression("{1,2,3,4}").getValue(context); List
		 * listOfLists = (List)
		 * parser.parseExpression("{{'a','b'},{'x','y'}}").getValue(context);
		 * int[] numbers1 = (int[]) parser.parseExpression("new int[4]"
		 * ).getValue(context); // Array with initializer int[] numbers2 =
		 * (int[]) parser.parseExpression("new int[]{1,2,3}").getValue(context);
		 * // Multi dimensional array int[][] numbers3 = (int[][])
		 * parser.parseExpression("new int[4][5]").getValue(context); // string
		 * literal, evaluates to "bc" String c = parser.parseExpression(
		 * "'abc'.substring(2, 3)").getValue(String.class); // evaluates to true
		 * boolean isMember = parser.parseExpression("isMember('Mihajlo Pupin')"
		 * ).getValue(societyContext, Boolean.class);
		 **/
		// evaluates to true
		boolean trueValue1 = parser.parseExpression("2 == 2").getValue(Boolean.class);
		// evaluates to false
		boolean falseValue = parser.parseExpression("2 < -5.0").getValue(Boolean.class);
		// evaluates to true
		boolean trueValue2 = parser.parseExpression("'black' < 'block'").getValue(Boolean.class);
		// evaluates to false
		boolean falseValue1 = parser.parseExpression("'xyz' instanceof T(int)").getValue(Boolean.class);
		// evaluates to true
		boolean trueValue3 = parser.parseExpression("'5.00' matches '^-?\\d+(\\.\\d{2})?$'").getValue(Boolean.class);
		// evaluates to false
		boolean falseValue3 = parser.parseExpression("'5.0067' matches '^-?\\d+(\\.\\d{2})?$'").getValue(Boolean.class);
		/**
		 * // -- AND --
		 * 
		 * // evaluates to false boolean falseValue = parser.parseExpression(
		 * "true and false").getValue(Boolean.class);
		 * 
		 * // evaluates to true String expression =
		 * "isMember('Nikola Tesla') and isMember('Mihajlo Pupin')"; boolean
		 * trueValue =
		 * parser.parseExpression(expression).getValue(societyContext,
		 * Boolean.class);
		 * 
		 * // -- OR --
		 * 
		 * // evaluates to true boolean trueValue = parser.parseExpression(
		 * "true or false").getValue(Boolean.class);
		 * 
		 * // evaluates to true String expression =
		 * "isMember('Nikola Tesla') or isMember('Albert Einstein')"; boolean
		 * trueValue =
		 * parser.parseExpression(expression).getValue(societyContext,
		 * Boolean.class);
		 * 
		 * // -- NOT --
		 * 
		 * // evaluates to false boolean falseValue =
		 * parser.parseExpression("!true").getValue(Boolean.class);
		 * 
		 * 
		 * // -- AND and NOT -- String expression =
		 * "isMember('Nikola Tesla') and !isMember('Mihajlo Pupin')"; boolean
		 * falseValue =
		 * parser.parseExpression(expression).getValue(societyContext,
		 * Boolean.class);
		 **/
		// Addition
		int two = parser.parseExpression("1 + 1").getValue(Integer.class); // 2

		String testString = parser.parseExpression("'test' + ' ' + 'string'").getValue(String.class); // 'test
																										// string'

		// Subtraction
		int four = parser.parseExpression("1 - -3").getValue(Integer.class); // 4

		double d = parser.parseExpression("1000.00 - 1e4").getValue(Double.class); // -9000

		// Multiplication
		int six = parser.parseExpression("-2 * -3").getValue(Integer.class); // 6

		double twentyFour = parser.parseExpression("2.0 * 3e0 * 4").getValue(Double.class); // 24.0

		// Division
		int minusTwo = parser.parseExpression("6 / -3").getValue(Integer.class); // -2

		double one = parser.parseExpression("8.0 / 4e0 / 2").getValue(Double.class); // 1.0

		// Modulus
		int three = parser.parseExpression("7 % 4").getValue(Integer.class); // 3

		int one1 = parser.parseExpression("8 / 5 % 2").getValue(Integer.class); // 1

		// Operator precedence
		int minusTwentyOne = parser.parseExpression("1+2-3*8").getValue(Integer.class); // -21
		
		Class dateClass = parser.parseExpression("T(java.util.Date)").getValue(Class.class);

		Class stringClass = parser.parseExpression("T(String)").getValue(Class.class);

		boolean trueValue5 =
		   parser.parseExpression("T(java.math.RoundingMode).CEILING < T(java.math.RoundingMode).FLOOR")
		  .getValue(Boolean.class);
	}
}
