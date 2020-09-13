/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.dubbo.config.support;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Parameter
 *
 * 配置在对象的 getter 方法上
 * todo
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Parameter {

    /**
     * 键名，作为 URL 参数的键名
     */
    String key() default "";

    /**
     * getter 方法的返回值是否必须，不可以为空
     */
    boolean required() default false;

    /**
     * 是否忽略
     * 不会将 getter 方法的返回值添加到 URL 参数中
     */
    boolean excluded() default false;

    /**
     * 是否需要转义
     * 调用 java.net.URLEncoder#encode(java.lang.String, java.lang.String)
     */
    boolean escaped() default false;

    /**
     * 是否属性
     * 用到的地方，只有事件通知 http://dubbo.apache.org/zh-cn/docs/user/demos/events-notify.html
     */
    boolean attribute() default false;

    /**
     * 是否拼接
     * 如果 URL 参数中，已经存在相同键名的 entry
     */
    boolean append() default false;

}