// Пусть дан LinkedList с несколькими элементами.//Напишите класс LLTasks с методом revert,// который принимал бы на вход LinkedList и возвращает “перевернутый” список.// Дан// [1, One, 2, Two]// Вывод// [1, One, 2, Two]// [Two, 2, One, 1]package homeworks.hw4;import java.util.ArrayList;import java.util.Arrays;import java.util.Collections;import java.util.LinkedList;public class Task1 {    public static void main(String[] args) {        LinkedList<Object> list = new LinkedList<>(Arrays.asList(1, "One", 2, "Two"));        System.out.println(revert(list));    }    public static LinkedList<Object> revert(LinkedList<Object> ll) {        // Напишите свое решение ниже        System.out.println(ll);        Collections.reverse(ll);        // System.out.println(ll);        return ll;    }}