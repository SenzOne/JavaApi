// Задание
//Подумать над структурой класса Ноутбук (Laptop) для магазина техники - выделить поля и методы. Реализовать в java.
//Создать множество ноутбуков Set<Laptop>. (добиться чтобы во множестве не было одинаковых ноутбуков)
//(*) Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
// отвечающие фильтру. Критерии фильтрации можно хранить в Map.
// Например: “Введите цифру, соответствующую необходимому критерию:
//1 - ОЗУ
//2 - Объем ЖД
//3 - Операционная система
//4 - Цвет …
//Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
//Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.

package homeworks.hw6;

import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;
import java.util.*;

public class Laptop {
    private String title;
    private String os;
    private String color;
    private int ram;
    private int ssd;


    public Laptop(String title, int ram, int SSD, String os, String color) {
        this.title = title;
        this.ram = ram;
        this.ssd = SSD;
        this.os = os;
        this.color = color;
    }


    @Override
    public String toString() {
        return String.format("%s, %s ram, %s ssd, color: %s", title, ram, ssd, color);
    }

    public boolean equals(Object laptop) {
        Laptop newLaptop = (Laptop) laptop;
        return this.title.equals(newLaptop.title) &&
                Objects.equals(this.os, newLaptop.os) &&
                Objects.equals(this.color, newLaptop.color) &&
                this.ram == newLaptop.ram &&
                this.ssd == newLaptop.ssd;
    }

    public int hashCode() {
        return (this.title.hashCode() + this.os.hashCode() + this.color.hashCode()
                + this.ram + this.ssd);
    }

    /*
    // метод создает список обьектов и проверяет соответствие критерия полю, а так же соответствие
    // значения критерия значению поля.
     */
    public static void filter(String criteria, String criteriaValute, Laptop... laptops) {
        LinkedList<Laptop> lll = new LinkedList<>(List.of(laptops));
        HashSet<Laptop> laptopHashSet = new HashSet<>();

        for (Laptop laptop : lll) {
            if (criteria.equals("title") && Objects.equals(laptop.title, criteriaValute)) {
                laptopHashSet.add(laptop);
            } else if (criteria.equals("color") && Objects.equals(laptop.color, criteriaValute)) {
                laptopHashSet.add(laptop);
            } else if (criteria.equals("os") && Objects.equals(laptop.os, criteriaValute)) {
                laptopHashSet.add(laptop);
            }
        }
        if (laptopHashSet.isEmpty()) {
            System.out.println("Ничего не найдено");
        } else {
            printResult(laptopHashSet);
        }
    }

    private static void printResult(HashSet<Laptop> laptopHashSet) {
        for (Laptop i : laptopHashSet) {
            System.out.println(i);
        }
    }

    /*
    // метод filter переопределен для значений типа int
     */
    public static void filter(String criteria, int criteriaValute, Laptop... laptops) {
        LinkedList<Laptop> lll = new LinkedList<>(List.of(laptops));
        HashSet<Laptop> laptopHashSet = new HashSet<>();
        for (Laptop laptop : lll) {
            if (criteria.equals("ram") && (laptop.ram >= criteriaValute)) {
                laptopHashSet.add(laptop);
            } else if (criteria.equals("ssd") && (laptop.ssd >= criteriaValute)) {
                laptopHashSet.add(laptop);
            }
        }

        if (laptopHashSet.isEmpty()) {
            System.out.println("Ничего не найдено");
        } else {
            printResult(laptopHashSet);
        }
    }
}
