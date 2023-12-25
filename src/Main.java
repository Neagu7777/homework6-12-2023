import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        Method[] methods = obj.getClass().getMethods();

        for (Method method : methods) {
            ClassAnnotation annotation = method.getAnnotation(ClassAnnotation.class);
            if (annotation != null) {
                System.out.println("Annotation value: " + annotation.value());
            }
        }
        // Пример создания объекта через рефлексию
        createObjectUsingReflection();

        // Пример получения и использования аннотаций
        processAnnotations(MyClass.class);

        // Пример получения и использования конструкторов
        processConstructors(MyClass.class);

        // Пример получения и использования полей
        processFields(MyClass.class);

        // Пример получения и использования методов
        processMethods(MyClass.class);
    }

    private static void createObjectUsingReflection() {
        try {
            Class<?> clazz = MyClass.class;
            Object instance = clazz.newInstance();
            System.out.println("Object created using reflection: " + instance);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static void processAnnotations(Class<?> clazz) {
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("Annotation on class: " + annotation);
        }
    }

    private static void processConstructors(Class<?> clazz) {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("Constructor: " + constructor);
        }
    }

    private static void processFields(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("Field: " + field);
        }
    }

    private static void processMethods(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("Method: " + method);
        }
    }
}