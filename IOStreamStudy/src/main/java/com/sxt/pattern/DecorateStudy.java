package com.sxt.pattern;

/**
 * 模拟咖啡
 * 1、抽象组件:需要装饰的抽象对象(接口或抽象父类)
 * 2、具体组件:需要装饰的对象
 * 3、抽象装饰类:包含了对抽象组件的引用以及装饰着共有的方法
 * 4、具体装饰类:被装饰的对象
 * @author wulei
 *
 */

public class DecorateStudy {

    public static void main(String[] args) {
        Drink coffe = new Coffe();
        Drink suger = new Suger(coffe);
        System.out.println(suger.info() + "--> " + suger.coust());

        Milk milk = new Milk(coffe);
        System.out.println(milk.info() + "--> " + milk.coust());

        milk = new Milk(suger);
        System.out.println(milk.info() + "--> " + milk.coust());

    }
}

interface Drink {
    double coust();
    String info();
}

class Coffe implements Drink {
    private String name = "原味咖啡";

    @Override
    public double coust() {
        return 10;
    }

    @Override
    public String info() {
        return name;
    }
}

abstract class Decorate implements Drink {
    private Drink drink;

    public Decorate(Drink drink) {
        this.drink = drink;
    }

    @Override
    public double coust() {
        return this.drink.coust();
    }

    @Override
    public String info() {
        return this.drink.info();
    }
}

class Milk extends Decorate {
    public Milk(Drink drink) {
        super(drink);
    }

    @Override
    public double coust() {
        return super.coust() *4;
    }

    @Override
    public String info() {
        return super.info() + "加入牛奶";
    }
}

class Suger extends Decorate {
    public Suger(Drink drink) {
        super(drink);
    }

    @Override
    public double coust() {
        return super.coust()*2;
    }

    @Override
    public String info() {
        return super.info() + "加入糖";
    }
}