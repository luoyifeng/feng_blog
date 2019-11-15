package com.jd.popc.datasource;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

/**
 * @author yangsong on 2018/11/29.
 */
@Configuration
@MapperScan(basePackages = "com.jd.popc.mapper.mysql", sqlSessionTemplateRef  = "sqlSessionTemplate1")
public class PopcDataSourceConfig1 implements WebMvcConfigurer {

    public static final String Mapper_Location = "classpath:/com/jd/popc/mapper/mysql/*.xml";

    @Bean(name = "dataSource1")
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    @Primary
    public javax.sql.DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setValidationQuery("select 1");
        dataSource.setTestWhileIdle(true);
        return dataSource;
    }

    @Bean(name = "sqlSessionFactory1")
    @Primary
    public SqlSessionFactory sqlSessionFactoryBean(@Qualifier("dataSource1") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(Mapper_Location));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "transactionManager1")
    @Primary
    public PlatformTransactionManager transactionManager(@Qualifier("dataSource1") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "sqlSessionTemplate1")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("sqlSessionFactory1") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
