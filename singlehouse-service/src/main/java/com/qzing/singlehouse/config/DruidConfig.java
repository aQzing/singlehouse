package com.qzing.singlehouse.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.google.common.collect.Lists;

@Configuration
public class DruidConfig {
	@ConfigurationProperties(prefix="spring.druid")
	@Bean(initMethod="init",destroyMethod="close")
	public DruidDataSource dataSource(Filter statFilter) {
		DruidDataSource druidDataSource = new DruidDataSource();
		druidDataSource.setProxyFilters(Lists.newArrayList(statFilter()));
		return druidDataSource;
	}
	@Bean
	public Filter statFilter() {
		StatFilter statFilter = new StatFilter();
		//设置多长时间算慢sql
		statFilter.setSlowSqlMillis(30000);
		//是否打印慢sql
		statFilter.setLogSlowSql(true);
		statFilter.setMergeSql(true);
		return statFilter;
	}
	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		return new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
	}
}
