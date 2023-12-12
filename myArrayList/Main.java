package com.myArrayList;

public class Main {

    public static void main(String[] args) {
      MyLinkedList<Language> test = new MyLinkedList();
      Language java = new Language("Java");
      Language go = new Language("Golang");

       test.add(java);
        test.add(go);

        System.out.println(test.get(0)+ " " +test.get(1));
        test.remove(0);
        System.out.println(test.get(0));
    }

    static class  Language {
        private String name;

        public Language(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
}
}
