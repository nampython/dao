package com.example.Excercise1.utils;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.List;

import static com.example.Excercise1.constants.EntityConstants.PREFIX_GET_METHOD;
import static com.example.Excercise1.constants.EntityConstants.PREFIX_SET_METHOD;

@Component
public class LogicEntityImpl implements LogicEntity{
    @Override
    public <T> void setValue(Object o1, Object o2, List<T> objects) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<?> cls1 = o1.getClass();
        Class<?> cls2 = o2.getClass();
        Method method2 = null;
        Method method = null;
        Object o = null;

        for (T object : objects) {
            String nameOfMethod = (String) object;
            method = cls1.getMethod(PREFIX_GET_METHOD + nameOfMethod.substring(0, 1).toUpperCase() + nameOfMethod.substring(1));
            o = method.invoke(o1);
            method2 = this.getMethod(cls2, nameOfMethod);
            method2.invoke(o2, o);
        }
    }
    private Method getMethod(Class<?> cls, String nameField) throws NoSuchFieldException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Field field = cls.getDeclaredField((String)nameField);
//        Object o3 = field.getType().newInstance();
        Method method2 = null;
        String s = PREFIX_SET_METHOD + nameField.substring(0, 1).toUpperCase() + nameField.substring(1);

        if (String.class.equals(field.getType())) {
            method2 = cls.getMethod(s, String.class);
        }  else if (Integer.class.equals(field.getType())) {
            method2 = cls.getMethod(s, Integer.class);
        } else if (BigDecimal.class.equals(field.getType())) {
            method2 = cls.getMethod(s, BigDecimal.class);
        } else if (Short.class.equals(field.getType())) {
            method2 = cls.getMethod(s, Short.class);
        } else  {
            throw new RuntimeException("");
        }
        return method2;
    }
}
