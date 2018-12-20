package com.xiao.JAVAManito.effective.creation;

import javax.annotation.PostConstruct;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/**
 * Created by unclexiao on 16/05/2018.
 */
public abstract class Pizza {

    public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}

    final Set<Topping> toppings;

    protected Pizza(PizzaBuilder<?> builder){
        this.toppings = builder.toppings.clone();
    }

    abstract static class PizzaBuilder<T extends PizzaBuilder<T>>{
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        protected PizzaBuilder(Topping topping){
            this.toppings.add(topping);
        }

        public PizzaBuilder addTopping(Topping topping){
            this.toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        protected abstract T self();
        abstract Pizza build();
    }

     void print(){
        Iterator itr = this.toppings.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
