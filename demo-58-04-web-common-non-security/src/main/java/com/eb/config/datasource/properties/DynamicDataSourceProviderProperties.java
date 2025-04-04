package com.eb.config.datasource.properties;

import com.baomidou.dynamic.datasource.provider.DynamicDataSourceProvider;
import com.eb.constant.DataSourceNames;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.validation.annotation.Validated;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

/**
 * @author suyh
 * @since 2024-03-20
 */
@ConfigurationProperties(prefix = DynamicDataSourceProviderProperties.PREFIX)
@Data
@Validated
public class DynamicDataSourceProviderProperties implements DynamicDataSourceProvider {
    // TODO: suyh - 正常情况下，我们不要使用 spring 作为配置项的前缀
    public static final String PREFIX = "spring.datasource.hikari";
//    public static final String PREFIX = "datasource.hikari";

    // TODO: suyh - 不明白为什么，直接使用 HikariDataSource idea 不识别配置项，并没有提示信息。
    //  所以暂时使用 HikariDataSourceShow 替代
    @NotNull
    @NestedConfigurationProperty
    private HikariDataSourceShow cdsMysql;

    // @NotNull
    @NestedConfigurationProperty
    private HikariDataSource cdsPgsql;

    private Map<String, DataSource> mapDatasource = new HashMap<>();

    @PostConstruct
    public void init() {
        mapDatasource.put(DataSourceNames.CDS_MYSQL, cdsMysql);
        if (cdsPgsql != null) {
            mapDatasource.put(DataSourceNames.CDS_PGSQL, cdsPgsql);
        }
    }

    @Override
    public synchronized Map<String, DataSource> loadDataSources() {
        return mapDatasource;
    }
}
