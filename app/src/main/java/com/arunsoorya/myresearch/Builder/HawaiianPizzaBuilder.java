package com.arunsoorya.myresearch.Builder;

/**
 * Created by T10778 on 13/04/2016.
 */
public class HawaiianPizzaBuilder extends PizzaBuilder {
    @Override
    public void buildDough() {
        pizza.setDough("pan baked");
    }

    @Override
    public void buildSauce() {
        pizza.setDough("pan buildSauce");
    }

    @Override
    public void buildTopping() {
        pizza.setDough("pan buildTopping");
    }
}
