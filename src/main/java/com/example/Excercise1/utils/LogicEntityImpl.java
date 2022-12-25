package com.example.Excercise1.utils;

import com.example.Excercise1.exceptions.CannotSetValueException;
import com.example.Excercise1.valueUtils.SetValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

import static com.example.Excercise1.constants.EntityConstants.PREFIX_GET_METHOD;
import static com.example.Excercise1.constants.EntityConstants.PREFIX_SET_METHOD;

@Component
public class LogicEntityImpl implements LogicEntity {

    private final SetValue setValue;
    @Autowired
    public LogicEntityImpl(SetValue setValue) {
        this.setValue = setValue;
    }


    /**
     * Auto set values from o1 to o2 object
     * For example:
     * o1.setOrder(o2.getOrder())
     * o1.setProductLine(o2.getProductLine())
     * we can easily handle it by calling this function:
     * setValue(o1, o2, Arrays.asList("order", "productLine"))
     * @param o1 Object you want to get values
     * @param o2 Object you want to set values
     * @param objects List parameters we want to set
     * @param <T> Type of List of parameter
     */
    @Override
    public <T> void setValue(Object o1, Object o2, List<T> objects) {
        // TODO: process with many Objects
        Class<?> cls1 = o1.getClass();
        Class<?> cls2 = o2.getClass();
        Method method1 = null;
        Method method2 = null;
        Object value = null;

        Iterator<T> elements = objects.iterator();
        try {
            while (elements.hasNext()) {
                T ele = elements.next();
                method1 = this.processMethodGetWithFieldName(cls1, ele);
                value = method1.invoke(o1);
                method2 = this.processMethodSetWithFieldName(cls2, ele);
                method2.invoke(o2, value);
            }
        } catch (NoSuchFieldException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new CannotSetValueException("Cannot set value from object " + o1.getClass().getSimpleName() + " into " + "object " + o2.getClass().getSimpleName());
        }
    }

    private <T> Method processMethodGetWithFieldName(Class<?> cls, T fieldName) throws NoSuchMethodException {
        String methodGet = PREFIX_GET_METHOD + ((String) fieldName).substring(0, 1).toUpperCase() + ((String) fieldName).substring(1);
        return cls.getMethod(methodGet);
    }

    private <T> Method processMethodSetWithFieldName(Class<?> cls, T fieldName) throws NoSuchFieldException, NoSuchMethodException {
        String s = PREFIX_SET_METHOD + ((String)fieldName).substring(0, 1).toUpperCase() + ((String)fieldName).substring(1);
        Field field = cls.getDeclaredField((String) fieldName);
        Class<?> typeField = field.getType();
        return this.setParameterGetMethod(cls, typeField, s);
    }

    public Method setParameterGetMethod(Class<?> cls, Class<?> typeParameter, String nameOfMethod) throws NoSuchMethodException {
        return this.setValue.setParamsGetMethod(cls, typeParameter, nameOfMethod);
    }
}
