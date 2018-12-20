package com.xiao.JAVAManito.effective.implementmethod;

/**
 * Created by unclexiao on 27/05/2018.
 *
 *
 * equal方法、hashCode方法重写的标准流程
 */
public class EqualsHashCode {




    static class Person {
        private String name;
        private int age;

        //可以将hashcode缓存起来以提高性能，如果对象的Hash值经常需要被使用
        private int hashCode;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }


        /**
         * 重写equals方法的规范流程：
         * @param obj
         * @return
         */

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }

            if (!(obj instanceof Person)) {
                return false;
            }

            Person o = (Person) obj;

            //依次比较 重要的Field
            return o.name.equals(this.name) && o.age == this.age;
        }




        @Override
        public int hashCode() {
            int result = hashCode;
            if (result == 0) {

                //依次计算 重要Fields的Hashcode
                //lazily computing
                result = result * 31 + name.hashCode();
                result = result * 31 + Integer.hashCode(age);
            }
            return result;

        }


        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", hashCode=" + hashCode +
                    '}';
        }
    }

}
