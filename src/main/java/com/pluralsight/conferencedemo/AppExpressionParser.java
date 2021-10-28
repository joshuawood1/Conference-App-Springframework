package com.pluralsight.conferencedemo;

import com.pluralsight.conferencedemo.models.User;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class AppExpressionParser {
    public static void main(String[] args){
        SpelExpressionParser parser = new SpelExpressionParser();

        Expression exp1 = parser.parseExpression("'Hello World'");
        String message = (String) exp1.getValue();
        System.out.println(message);

        Expression exp2 = parser.parseExpression("'Hello World'.length()");
        System.out.println(exp2.getValue());

        Expression exp3 = parser.parseExpression("'Hello World'.length()*10");
        System.out.println(exp3.getValue());

        Expression exp4 = parser.parseExpression("'Hello World'.length()>10");
        System.out.println(exp4.getValue());

        Expression exp5 = parser.parseExpression("'Hello World'.length()>10 and 'Hello World'.length()<20");
        System.out.println(exp5.getValue());

        StandardEvaluationContext ec1 = new StandardEvaluationContext();
        ec1.setVariable("greeting", "hello you");
        String msg = (String) parser.parseExpression("#greeting.substring(6)").getValue(ec1);
        System.out.println(msg);
        System.out.println("------------------------------------------------\n");

        User user = new User();
        StandardEvaluationContext userContext = new StandardEvaluationContext(user);//once root object is specified SpEL knows how to resolve its properties.

        parser.parseExpression("country").setValue(userContext, "England");
        System.out.println(user.getCountry());

        parser.parseExpression("name").setValue(userContext, "Josh Wood");
        System.out.println(user.getName());
    }
}
