package Lesson061;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Main {
    public static void main (String[] args) throws ClassNotFoundException, IOException {
        getInfo(args[0]);
        System.out.println(args[0]);
    }
    private static void getInfo(String path)throws ClassNotFoundException, IOException{
        List<String> classNames = new ArrayList<>();
        URLClassLoader plaginClassLoader = new URLClassLoader(new URL[]{new URL("file:"+path)});
        ZipInputStream zip = new ZipInputStream(new FileInputStream(path));
        for (ZipEntry entry = zip.getNextEntry(); entry != null; entry = zip.getNextEntry()) {
            if (!entry.isDirectory() && entry.getName().endsWith(".class")) {
                String className = entry.getName().replace('/', '.');
                classNames.add(className.substring(0, className.length() - ".class".length()));
                System.out.println(className);
            }
        }
        for(String name : classNames) {
            Class cl = plaginClassLoader.loadClass(name);
            System.out.println(cl.getSimpleName());
            Method[] method = cl.getDeclaredMethods();
            for (int i = 0; i < method.length; i++) System.out.println(method[i]);
            Field[] fields = cl.getDeclaredFields();
            for (int k = 0; k < fields.length; k++) System.out.println(fields[k]);
            Annotation[] annotations = cl.getAnnotations();
            for (int a = 0; a < annotations.length; a++) System.out.println(annotations[a]);
        }
    }
}