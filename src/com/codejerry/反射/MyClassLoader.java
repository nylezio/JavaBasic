package com.codejerry.反射;

import java.io.*;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/07/11 15:37
 */
public class MyClassLoader extends ClassLoader {
    private String path;
    private String classLoaderName;


    public MyClassLoader(String path, String classLoaderName) {
        this.path = path;
        this.classLoaderName = classLoaderName;
    }

//    用于寻找类文件
    @Override
    protected Class findClass(String name) throws ClassNotFoundException {
        byte[] b = loadClassDate(name);
        return defineClass(name, b, 0, b.length);
    }
//  用于加载类文件
    private byte[] loadClassDate(String name) {
        name = path + name + ".class";
        InputStream in = null;
        ByteArrayOutputStream out = null;
        try {
            in = new FileInputStream(new File(name));
            out = new ByteArrayOutputStream();
            int i = 0;
            while ((i = in.read()) != -1) {
                out.write(i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return out.toByteArray();

    }
}
