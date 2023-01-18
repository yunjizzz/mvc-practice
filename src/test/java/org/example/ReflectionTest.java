package org.example;

import org.example.annotation.Controller;
import org.example.annotation.Service;
import org.example.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.ClassBasedNavigableIterableAssert.assertThat;

public class ReflectionTest {

    private static final Logger logger = LoggerFactory.getLogger(ReflectionTest.class);

    @Test
    void controllerScan() {
        Set<Class<?>> beans = getTypesAnnotatedWith(List.of(Controller.class,Service.class));

        logger.debug("beans : [{}]", beans);
    }

    private static Set<Class<?>> getTypesAnnotatedWith(List<Class<? extends Annotation>> annotations) {
        Reflections reflections = new Reflections("org.example");

        Set<Class<?>> beans = new HashSet<>();
        annotations.forEach(annotation -> beans.addAll(reflections.getTypesAnnotatedWith(annotation)));

        return beans;
    }

    @Test
    void showClass() {
        Class<User> clazz = User.class;
        logger.debug(clazz.getName());
        logger.debug("User all declared fields: {}", Arrays.stream(clazz.getDeclaredFields()).collect(Collectors.toList()));
        logger.debug("User all declared constructors: {}", Arrays.stream(clazz.getDeclaredConstructors()).collect(Collectors.toList()));
        logger.debug("User all declared methods: {}", Arrays.stream(clazz.getDeclaredMethods()).collect(Collectors.toList()));
    }

    // heap 영역에 로드 되어있는 객체를 가지고 오는 방법
    @Test
    void load() throws ClassNotFoundException {
        // 1번
        Class<User> clazz = User.class;

        // 2번
        User user = new User("yunji", "yunji");
        Class<? extends User> clazz2 = user.getClass();

        // 3번
        Class<?> clazz3 = Class.forName("org.example.model.User");

        logger.debug("clazz1 : {}", clazz);
        logger.debug("clazz2 : {}", clazz2);
        logger.debug("clazz3 : {}", clazz3);


        // heap 영역에 올라간 클래스들을 다양하게 불러왔을 때 모두 같은 객체일까?
        Assertions.assertEquals(clazz , clazz2);
        Assertions.assertEquals(clazz2 , clazz3);
        Assertions.assertEquals(clazz , clazz3);
    }
}
