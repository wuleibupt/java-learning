package com.sxt.deal;

import com.sxt.bean.Employee;

import java.io.*;

public class ObjectOutput {
    public static void main(String[] args) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(baos));
        oos.writeUTF("hello world");
        oos.writeBoolean(false);
        oos.writeObject(new Employee("张三",100));
        oos.flush();
        byte[] datas = baos.toByteArray();


        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
        System.out.println(ois.readUTF());
        System.out.println(ois.readBoolean());
        Object employee = ois.readObject();

        if (employee instanceof Employee) {
            System.out.println(employee);
        }

    }
}
