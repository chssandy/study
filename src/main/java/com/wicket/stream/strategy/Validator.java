package com.wicket.stream.strategy;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Validator
 * @description TODO
 * @date 2020/9/23 10:17
 */
public class Validator {
    private final ValidationStrategy strategy;

    public Validator(ValidationStrategy v){
        this.strategy = v;
    }

    public boolean validate(String s){
        return strategy.execute(s);
    }

    public static void main(String[] args) {
        Validator numericValidator = new Validator(new IsNumeric());
        boolean b1 = numericValidator.validate("aaaa");
        System.out.println(b1);

        Validator lowerCaseValidator = new Validator(new IsAllLowerCase());
        boolean b2 = lowerCaseValidator.validate("bbbb");
        System.out.println(b2);

        Validator numericValidatorL = new Validator((String s) -> s.matches("[a-z]+"));
        boolean b11 = numericValidatorL.validate("aaaa");
        System.out.println(b11);

        Validator lowerCaseValidatorL = new Validator((String s) -> s.matches("\\d+"));
        boolean b22 = lowerCaseValidatorL.validate("bbbb");
        System.out.println(b22);


    }

}
