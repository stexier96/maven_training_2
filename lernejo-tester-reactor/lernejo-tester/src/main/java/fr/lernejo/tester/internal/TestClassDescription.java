package fr.lernejo.tester.internal;

import fr.lernejo.tester.api.TestMethod;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

public class TestClassDescription {

    Class<?> testClass;

    public TestClassDescription(Class<?> p_class){
        this.testClass = p_class;
    }

    @TestMethod
    public List<Method> listTestMethods(){
        //testClass.getDeclaredMethods();

        List<Method> listOfMethods= new ArrayList<Method>(List.of(testClass.getDeclaredMethods()));
        List<Method> returnlistOfMethods= new ArrayList<>();
        for (Method method: listOfMethods) {

            if (method.getReturnType().equals(Void.TYPE)
                && method.getParameterCount() == 0
                && Modifier.isPublic(method.getModifiers())
                && method.isAnnotationPresent(TestMethod.class)) {
                    returnlistOfMethods.add(method);
            }

        }
        
        return returnlistOfMethods;
    }
}
