package testutils;

import java.lang.reflect.Field;

public class TestUtils {

    public static void setRestrictedField(Class<?> clazz, String name, Object obj, Object value) throws Exception {
        while (null != clazz) {
            Field f;
            try {
                f = clazz.getDeclaredField(name);
            } catch (NoSuchFieldException ex) {
                clazz = clazz.getSuperclass();
                continue;
            }
            f.setAccessible(true);
            f.set(obj, value);
            return;
        }
        throw new NoSuchFieldException();
    }

}
