package fr.lernejo.tester.internal;

import fr.lernejo.tester.SomeLernejoTests;
import fr.lernejo.tester.internal.TestClassDescription;

import java.lang.reflect.Method;
import java.util.List;

public class TestClassDescriptionLernejoTests {


    public static void main(String[] args) {
        //Class<SomeLernejoTests> testClass = SomeLernejoTests.class;

        TestClassDescription classToTest = new TestClassDescription(SomeLernejoTests.class);
        List<Method> listOfMethods = classToTest.listTestMethods();
        for (Method method: listOfMethods) {
            System.out.println(method.getName());
        }
    }
}
