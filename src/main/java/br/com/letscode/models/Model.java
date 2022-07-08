package br.com.letscode.models;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Model<T> {

    public void setId(T id) {
        try {
            for (Field field : this.getAllClassFields()) {
                if (field.isAnnotationPresent(br.com.letscode.models.Id.class)) {
                    field.setAccessible(true);
                    field.set(this, id);
                    break;
                }
            }
        } catch (IllegalAccessException | IllegalArgumentException e) {
           throw new RuntimeException(e);
        }
    }

    public T getId() {
        try {
            for (Field field : this.getAllClassFields()) {
                if (field.isAnnotationPresent(br.com.letscode.models.Id.class)) {
                    field.setAccessible(true);
                    return (T) field.get(this);                }
            }
        } catch (IllegalAccessException | IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private List<Field> getAllClassFields(){
        Class c = this.getClass();
        List<Field> fields = new ArrayList<>();

        while(c.getSuperclass() != null) {
            fields.addAll(Arrays.asList(c.getDeclaredFields()));
            c = c.getSuperclass();
        }

        return fields;
    }
}