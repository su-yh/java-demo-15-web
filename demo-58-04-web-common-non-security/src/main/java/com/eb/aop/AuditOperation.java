package com.eb.aop;

import org.intellij.lang.annotations.Language;
import org.springframework.security.access.prepost.PostAuthorize;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 本来是用来做审计日志记录的，但是突然发现 spring-security 的 {@link PostAuthorize} 注解已经有相关的功能，而且实现得更好。
 * 更关键的是idea 是可以识别到相关参数的。但是
 *
 *
 * @author suyh
 * @since 2024-10-10
 * @deprecated 使用 @{@link PostAuthorize} 替代即可
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface AuditOperation {
    @Language("SpEL")
    String value();
}
