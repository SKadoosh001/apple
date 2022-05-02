package iceyang;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

//学生管理系统
public class StudentManager {
    public static void main(String[] args) {
//        定义一个学生集合
        ArrayList<Student> array = new ArrayList<Student>();
//        用输出语句完成主界面的编写
        while (true) {
            System.out.println("--------欢迎来到学生管理系统--------");
            System.out.println("1.添加学生");
            System.out.println("2.删除学生");
            System.out.println("3.修改学生");
            System.out.println("4.查看所有学生");
            System.out.println("5.退出");
            System.out.println("请输入你的选择：");

            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();

            switch (line) {
                case "1":
//                    System.out.println("添加学生:");
                    addStudent(array);
                    break;
                case "2":
//                    System.out.println("删除学生");
                    deleteStudent(array);
                    break;
                case "3":
//                    System.out.println("修改学生");
                    changeStudent(array);
                    break;
                case "4":
//                    System.out.println("查看所有学生");
                    findAllStudent(array);
                    break;
                case "5":
                    System.out.println("谢谢使用！");
//                break;
                    System.exit(0);//JVM退出
                default:
                    System.out.println("404 not find!");
                    break;
            }
        }
    }

    //    添加学生的方法
    public static void addStudent(ArrayList<Student> array) {
//        键盘录入学生数据
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入学生姓名：");
        String name = sc.nextLine();
        System.out.println("请输入学生学号：");
        String id;
        while (true){
            id = sc.nextLine();
            boolean flag = false;
            flag = isUsed(array,id);
            if (flag){
                System.out.println("该学号已被使用，请重新输入：");
            }else {
                break;
            }
        }
        System.out.println("请输入学生年龄：");
        String age = sc.nextLine();
        System.out.println("请输入学生住址：");
        String address = sc.nextLine();
//        创建学生对象，把录入的值赋给成员变量
        Student s = new Student();
        s.setName(name);
        s.setId(id);
        s.setAge(age);
        s.setAddress(address);
//        把对象加到集合中
        array.add(s);
//        finish
        System.out.println("OK!");
    }

//判断学号是否被占用
    public static boolean isUsed(ArrayList<Student> arrayList, String id){
        boolean flag = false;
        for (int i = 0; i < arrayList.size(); i++){
            Student s = arrayList.get(i);
            if (s.getId().equals(id)){
                flag = true;
                break;
            }
        }
        return flag;
    }

    //    查看学生的方法
    public static void findAllStudent(ArrayList<Student> array) {
//        判断集合是否有数据
        if (array.size() == 0){
            System.out.println("无信息，请先添加信息再查询！！");
        }else {
//        打印表头
            System.out.println("姓名\t\t学号\t\t年龄\t\t住址");
            for (int i = 0; i < array.size(); i++) {
                Student s = array.get(i);
                System.out.println(s.getName() + "\t" + s.getId() + "\t" + s.getAge() + "岁\t" + s.getAddress());
            }
        }

    }

//    删除学生方法
    public static void deleteStudent(ArrayList<Student> array){
        Scanner sc = new Scanner(System.in);
//        录入要删除学生的id
        System.out.println("请输入你要删除学生的id：");
        String id = sc.nextLine();
        int indx = -1;

        for (int i = 0; i < array.size(); i++){
            Student s = array.get(i);
            if (s.getId().equals(id)) {
                indx = i;
            }
        }
        if (indx == -1){
            System.out.println("输入信息不存在，请重新输入！！！");
        }else {
            array.remove(indx);
            System.out.println("OK!");
        }
    }

//    修改学生信息
    public static void changeStudent(ArrayList<Student> array){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改学生的学号：");
        String id = sc.nextLine();

//        遍历集合，找到要修改的学生对象
        int indx = -1;
        for (int i = 0; i < array.size(); i++){
            Student student = array.get(i);
            if (student.getId().equals(id)){
                indx = i;
                break;
            }
        }
        if (indx == -1){
            System.out.println("查找学生不存在，请重新输入！！");
        }else{
            //        创建一个新的学生对象,给新的学生对象 赋上新的值
            Student s = new Student();
            System.out.println("请输入新的姓名：");
            String name = sc.nextLine();
            System.out.println("请输入新的学号：");
            String id1 = sc.nextLine();
            System.out.println("请输入新的年龄：");
            String age = sc.nextLine();
            System.out.println("请输入新的地址：");
            String address = sc.nextLine();

            s.setName(name);
            s.setId(id1);
            s.setAge(age);
            s.setAddress(address);
            array.set(indx,s);
            System.out.println("OK!");
        }

//        for(int i = 0; i < array.size(); i++){
//            Student student = array.get(i);
//            if (student.getId().equals(id)){
//                array.set(i,s);
//                break;
//            }
//        }
//        System.out.println("OK!");
    }
}