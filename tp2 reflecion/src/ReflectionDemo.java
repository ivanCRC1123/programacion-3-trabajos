import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionDemo {
    public static void main(String[] args) {
        try {

            Class<?> personaClass = Class.forName("Persona");

            Constructor<?>[] constructors = personaClass.getDeclaredConstructors();
            System.out.println("Constructores:");
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor);
            }

            Object persona = personaClass.getDeclaredConstructor().newInstance();

            Field nombreField = personaClass.getDeclaredField("nombre");
            nombreField.setAccessible(true);
            nombreField.set(persona, "Juan");

            Method mostrarInfoMethod = personaClass.getDeclaredMethod("mostrarInfo");
            mostrarInfoMethod.invoke(persona);

            Method saludarMethod = personaClass.getDeclaredMethod("Saludar");


            saludarMethod.setAccessible(true);

            String saludo = (String) saludarMethod.invoke(persona);
            System.out.println("Saludo: " + saludo);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
