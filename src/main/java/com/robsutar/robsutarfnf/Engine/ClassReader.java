package com.robsutar.robsutarfnf.Engine;

import com.robsutar.robsutarfnf.Engine.Files.FileManager;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ClassReader {
    public ClassReader() {
        try {
            File pathToJar = new File(FileManager.phasesPath + "\\lianna\\ExternalMod.jar");

            JarFile jarFile;
            jarFile = new JarFile(pathToJar);
            Enumeration<JarEntry> e = jarFile.entries();

            URL[] urls = {new URL("jar:file:" + pathToJar + "!/")};
            URLClassLoader cl = URLClassLoader.newInstance(urls);

            while (e.hasMoreElements()) {
                JarEntry je = e.nextElement();
                if(je.isDirectory() || !je.getName().endsWith(".class")) {
                    continue;
                }
                // -6 because of .class
                String className = je.getName().substring(0, je.getName().length() - 6);
                className = className.replace('/', '.');
                Class<?> c = cl.loadClass(className);

                try {
                    // public static void start(String args1){}
                    String s = "c a";
                    Method method = c.getMethod("start",String.class);
                    method.invoke(s,s);
                } catch (SecurityException | NoSuchMethodException | IllegalAccessException | InvocationTargetException s) { s.printStackTrace(); }

            }
        } catch (IOException | ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}
