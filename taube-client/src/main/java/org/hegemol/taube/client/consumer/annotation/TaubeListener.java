package org.hegemol.taube.client.consumer.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 消息消费注解
 *
 * @author KevinClair
 **/
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface TaubeListener {

    /**
     * 消费主题
     * @return 主题
     */
    String topic();

    /**
     * 主题的tag
     *
     * @return
     */
    String tag() default "";
}
