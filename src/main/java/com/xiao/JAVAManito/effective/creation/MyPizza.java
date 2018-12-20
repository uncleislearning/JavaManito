package com.xiao.JAVAManito.effective.creation;


/**
 * Created by unclexiao on 16/05/2018.
 */
public class MyPizza extends Pizza{

    private MyPizza(MyPizzaBuilder builder) {
         super(builder);
    }

    static class MyPizzaBuilder extends Pizza.PizzaBuilder<MyPizzaBuilder>{

        private MyPizzaBuilder(Topping topping) {
            super(topping);
        }

        @Override
        protected MyPizzaBuilder self() {
            return this;
        }

        @Override
        MyPizza build() {
            return new MyPizza(this);
        }
    }




    public static void main(String[] args) {
        Pizza myPizza = new MyPizza.MyPizzaBuilder(Topping.HAM).addTopping(Topping.MUSHROOM).build();

        myPizza.print();
    }



}
