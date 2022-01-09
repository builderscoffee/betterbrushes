package eu.builderscoffee.betterbrushes;

import com.thevoxelbox.voxelsniper.brush.type.AbstractBrush;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class Reflections {
    public static Method[] a(final Method[] array, final String[] array2) {
        final Method[] array3 = new Method[3];
        for (int i = 0; i < 3; ++i) {
            for (Method method : array) {
                if (method.getName().equals(array2[i])) {
                    (array3[i] = method).setAccessible(true);
                    break;
                }
            }
        }
        return array3;
    }

    public static void a(final Method method, final AbstractBrush brush, final Object array) {
        try {
            method.invoke(brush, array);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void setField(final Field field, final Object instance, final Object value) {
        try {
            field.setAccessible(true);
            field.set(instance, value);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Field[] a(final Field[] array, final String[] array2) {
        final Field[] array3 = {null};
        for (int i = 0; i <= 0; ++i) {
            for (Field field : array) {
                if (field.getName().equals(array2[0])) {
                    (array3[0] = field).setAccessible(true);
                    break;
                }
            }
        }
        return array3;
    }

}
