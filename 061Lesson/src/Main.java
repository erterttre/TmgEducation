import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class Main {

    //file:D:/CHTY/Studing/new/Lesson06/Lesson06/Lesson06.jar

    public static void main (String[] args) throws MalformedURLException, ClassNotFoundException {
        URLClassLoader plaginClassLoader = new URLClassLoader(new URL[]{new URL("file:Lesson06.jar")});
        Class cl = plaginClassLoader.loadClass("Lesson06.Main");
        System.out.println(cl.getSimpleName());
        Method []method = cl.getDeclaredMethods();
        for(int i=0;i<method.length;i++)System.out.println(method[i]);
        Field []fields = cl.getDeclaredFields();
        for(int k=0;k<fields.length;k++)System.out.println(fields[k]);
        Annotation []annotations = cl.getAnnotations();
        for(int a=0;a<annotations.length;a++)System.out.println(annotations[a]);
    }

}
