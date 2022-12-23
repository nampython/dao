package com.example.Excercise1.utils;

import com.example.Excercise1.exceptions.CannotSetValueException;
import com.example.Excercise1.exceptions.SetParameterException;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import static com.example.Excercise1.constants.EntityConstants.PREFIX_GET_METHOD;
import static com.example.Excercise1.constants.EntityConstants.PREFIX_SET_METHOD;

@Component
public class LogicEntityImpl implements LogicEntity {

    @Override
    public <T> void setValue(Object o1, Object o2, List<T> objects) {
        Class<?> cls1 = o1.getClass();
        Class<?> cls2 = o2.getClass();
        Method method1 = null;
        Method method2 = null;
        Object value = null;

        Iterator<T> elements = objects.iterator();
        try {
            while (elements.hasNext()) {
                method1 = this.processMethodGetWithFieldName(cls1, (String) elements.next());
                value = method1.invoke(o1);
                method2 = this.processMethodSetWithFieldName(cls2, (String) elements.next());
                method2.invoke(o2, value);
            }
        }catch (NoSuchFieldException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new CannotSetValueException("Cannot set value from object " + o1.getClass().getSimpleName() + " into " + "object " + o2.getClass().getSimpleName());
        }
    }

    private <T extends  String> Method processMethodGetWithFieldName(Class<?> cls, T fieldName) throws NoSuchMethodException {
        String methodGet = PREFIX_GET_METHOD + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
        return cls.getMethod(methodGet);
    }

    private <T extends  String> Method processMethodSetWithFieldName(Class<?> cls, String fieldName) throws NoSuchFieldException, NoSuchMethodException {
        String s = PREFIX_SET_METHOD + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
        Field field = cls.getDeclaredField((String) fieldName);
        Class<?> typeField = field.getType();
        return this.setParameterGetMethod(cls, typeField, s);
    }

    public Method setParameterGetMethod(Class<?> cls, Class<?> typeParameter, String nameOfMethod) throws NoSuchMethodException {
        Method method = null;

        if (String.class.equals(typeParameter)) {
            method = cls.getMethod(nameOfMethod, String.class);
        } else if (Integer.class.equals(typeParameter)) {
            method = cls.getMethod(nameOfMethod, Integer.class);
        } else if (BigDecimal.class.equals(typeParameter)) {
            method = cls.getMethod(nameOfMethod, BigDecimal.class);
        } else if (Short.class.equals(typeParameter)) {
            method = cls.getMethod(nameOfMethod, Short.class);
        } else {
            throw new SetParameterException("Error in processing parameters for class " + cls.getSimpleName() + "with method" + nameOfMethod);
        }
        return method;
    }
}
