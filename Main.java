package org.example;

import java.lang.reflect.Constructor;
import java.sql.ResultSet;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        student.id=111;
        student.name="dad";
        student.say();
    }
    private static <T> T convert(ResultSet set,Class<T> clazz) throws SQLException{
        try{
            Constructor<T> constructor = clazz.getConstructor(clazz.getConstructors()[0].getParameterTypes());
            Class<?>[] param =constructor.getParameterTypes();
            Object[] params = new Object[param.length];
            for(int i=0;i<param.length;i++){
                params[i]=set.getObject(i+1);
                if(params[i].getClass()!=param[i]){
                    throw new SQLException("错误的类型转换"+params[i].getClass()+"->"+params[i]);
                }
            }return constructor.newInstance(params);
        }catch (ReflectiveOperationException | SQLException e){
            e.printStackTrace();
            return null;
        }

    }
    }
