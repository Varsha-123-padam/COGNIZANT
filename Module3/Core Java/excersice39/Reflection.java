import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Modifier;

public class Reflection {
    public static void main(String[] args) {
        try {
            // Load the class using reflection
            Class<?> clazz = Class.forName("SampleClass");
            System.out.println("Class: " + clazz.getName());

            // Get all declared methods (including private ones)
            System.out.println("\nDeclared Methods:");
            Method[] methods = clazz.getDeclaredMethods();
            
            for (Method method : methods) {
                // Print method modifiers (public, private, etc)
                System.out.print(Modifier.toString(method.getModifiers()));
                
                // Print return type and method name
                System.out.print(" " + method.getReturnType().getSimpleName());
                System.out.print(" " + method.getName() + "(");
                
                // Print parameter types
                Parameter[] params = method.getParameters();
                for (int i = 0; i < params.length; i++) {
                    System.out.print(params[i].getType().getSimpleName());
                    System.out.print(" " + params[i].getName());
                    if (i < params.length - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println(")");
            }

            // Create instance and invoke method dynamically
            Object obj = clazz.getDeclaredConstructor().newInstance();
            Method setMessageMethod = clazz.getMethod("setMessage", String.class);
            setMessageMethod.invoke(obj, "Hello from Reflection!");
            
            // Access and invoke private method
            Method printMessageMethod = clazz.getDeclaredMethod("printMessage");
            printMessageMethod.setAccessible(true);
            System.out.println("\nInvoking private printMessage method:");
            printMessageMethod.invoke(obj);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}