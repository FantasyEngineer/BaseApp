/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.hjg.base.utils;

import java.util.Collection;
import java.util.Map;

/**
 * 断言工具类
 */
public abstract class AssertUtils {

    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 断言这是 true，如果不是，抛出异常
     *
     * @param expression
     */
    public static void isTrue(boolean expression) {
        isTrue(expression, "[Assertion failed] - this expression must be true");
    }

    public static void isNull(Object object, String message) {
        if (object != null) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 断言object这是一个null
     *
     * @param object
     */
    public static void isNull(Object object) {
        isNull(object, "[Assertion failed] - the object argument must be null");
    }

    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 断言object不为null
     *
     * @param object
     */
    public static void notNull(Object object) {
        notNull(object,
                "[Assertion failed] - this argument is required; it must not be null");
    }

    public static void hasLength(String text, String message) {
        if (!StringUtils.hasLength(text)) {
            throw new IllegalArgumentException(message);
        }
    }


    /**
     * 断言text文本有长度，没长度抛出异常
     *
     * @param text
     */
    public static void hasLength(String text) {
        hasLength(
                text,
                "[Assertion failed] - this String argument must have length; it must not be null or empty");
    }

    public static void hasText(String text, String message) {
        if (!StringUtils.hasText(text)) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 断言是否有text文本
     *
     * @param text
     */
    public static void hasText(String text) {
        hasText(text,
                "[Assertion failed] - this String argument must have text; it must not be null, empty, or blank");
    }

    public static void doesNotContain(String textToSearch, String substring,
                                      String message) {
        if (StringUtils.hasLength(textToSearch)
                && StringUtils.hasLength(substring)
                && textToSearch.contains(substring)) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 断言是否含有
     *
     * @param textToSearch
     * @param substring
     */
    public static void doesNotContain(String textToSearch, String substring) {
        doesNotContain(textToSearch, substring,
                "[Assertion failed] - this String argument must not contain the substring ["
                        + substring + "]"
        );
    }

    public static void notEmpty(Object[] array, String message) {
        if ((array == null || array.length == 0)) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 断言array不为空
     *
     * @param array
     */
    public static void notEmpty(Object[] array) {
        notEmpty(
                array,
                "[Assertion failed] - this array must not be empty: it must contain at least 1 element");
    }

    public static void notEmpty(CharSequence text) {
        notEmpty(text,
                "[Assertion failed] - this string must not be null or empty.");
    }

    public static void notEmpty(CharSequence text, String message) {
        if (!StringUtils.hasLength(text)) {
            throw new IllegalArgumentException(message);
        }
    }

    public static <T extends CharSequence> T notBlank(final T argument, final String name) {
        if (argument == null) {
            throw new IllegalArgumentException(name + " may not be null");
        }
        if (StringUtils.isBlank(argument)) {
            throw new IllegalArgumentException(name + " may not be blank");
        }
        return argument;
    }

    public static void noNullElements(Object[] array, String message) {
        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == null) {
                    throw new IllegalArgumentException(message);
                }
            }
        }
    }

    public static void noNullElements(Object[] array) {
        noNullElements(array,
                "[Assertion failed] - this array must not contain any null elements");
    }

    public static void notEmpty(Collection<?> collection, String message) {
        if (collection == null || collection.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void notEmpty(Collection<?> collection) {
        notEmpty(
                collection,
                "[Assertion failed] - this collection must not be empty: it must contain at least 1 element");
    }

    public static void notEmpty(Map<?, ?> map, String message) {
        if (map == null || map.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void notEmpty(Map<?, ?> map) {
        notEmpty(
                map,
                "[Assertion failed] - this map must not be empty; it must contain at least one entry");
    }

    /**
     * 断言对象是否是特定类的一个实例
     *
     * @param clazz
     * @param obj
     */
    public static void isInstanceOf(Class<?> clazz, Object obj) {
        isInstanceOf(clazz, obj, "");
    }

    public static void isInstanceOf(Class<?> type, Object obj, String message) {
        notNull(type, "Type to check against must not be null");
        if (!type.isInstance(obj)) {
            throw new IllegalArgumentException(message + "Object of class ["
                    + (obj != null ? obj.getClass().getName() : "null")
                    + "] must be an instance of " + type);
        }
    }

    /**
     * 断言继承关系
     *
     * @param superType
     * @param subType
     */
    public static void isAssignable(Class<?> superType, Class<?> subType) {
        isAssignable(superType, subType, "");
    }

    public static void isAssignable(Class<?> superType, Class<?> subType,
                                    String message) {
        notNull(superType, "Type to check against must not be null");
        if (subType == null || !superType.isAssignableFrom(subType)) {
            throw new IllegalArgumentException(message + subType
                    + " is not assignable to " + superType);
        }
    }

}
