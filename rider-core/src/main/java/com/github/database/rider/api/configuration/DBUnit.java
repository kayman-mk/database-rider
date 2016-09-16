package com.github.database.rider.api.configuration;

import com.github.database.rider.dataset.DataSetExecutorImpl;

import java.lang.annotation.*;

/**
 * Created by rafael-pestano on 30/08/2016.
 * 
 * This annotation configures DBUnit properties
 * (http://dbunit.sourceforge.net/properties.html) for a given dataset executor.
 * 
 * It can be used at class or method level.
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface DBUnit {

    /**
     * 
     * @return executor id for which the properties will be setup.
     */
    String executor() default DataSetExecutorImpl.DEFAULT_EXECUTOR_ID;


    /**
     *
     * @return if true database connection will be reused among tests
     */
    boolean cacheConnection() default true;


    boolean cacheTableNames() default true;

    /**
     *
     * @return if true will activate connection leak detection.
     */
    boolean leakHunter() default false;
    

    /**
     * @return value which configures DatabaseConfig.FEATURE_QUALIFIED_TABLE_NAMES. Defaults to false.
     */
    boolean qualifiedTableNames() default false;
    
    /**
     * 
     * @return value which configures DatabaseConfig.FEATURE_BATCHED_STATEMENTS
     */
    boolean batchedStatements() default false;

    /**
     *
     * Enable or disable case sensitive table names. If enabled, Dbunit handles all table names in a case sensitive way.
     *
     * @since 0.15.0
     * @return  value which configures DatabaseConfig.FEATURE_BATCHED_STATEMENTS
     */
    boolean caseSensitiveTableNames() default false;

    /**
     * Allow to call INSERT/UPDATE with empty strings ('').
     * @return value which configures DatabaseConfig.FEATURE_ALLOW_EMPTY_FIELDS. Defaults to false.
     *
     */
    boolean allowEmptyFields() default false;  
    
    /**
     * 
     * @return value which configures DatabaseConfig.PROPERTY_FETCH_SIZE. Defaults to 100
     */
    int fetchSize() default 100;
    
    /**
     * @return value which configures DatabaseConfig.PROPERTY_BATCH_SIZE. Defaults to 100
     */
    int batchSize() default 100;
    
    /**
     * Allows schema, table and column names escaping. The property value is an escape pattern where the ?
     * is replaced by the name. For example, the pattern "[?]" is expanded as "[MY_TABLE]" for a table named "MY_TABLE".
     * The most common escape pattern is "\"?\"" which surrounds the table name with quotes (for the above example it would result in "\"MY_TABLE\"").
     * As a fallback if no questionmark is in the given String and its length is one it is used to surround the table name on the left and right side.
     * For example the escape pattern "\"" will have the same effect as the escape pattern "\"?\"".
     * @return value which configures DatabaseConfig.PROPERTY_ESCAPE_PATTERN. Defaults to none
     */
    String escapePattern() default "";

    /**
     * @since 0.15.0
     * @return driver class name. Used for declarative connections. Don't needed for drivers that implement jdbc 4.
     */
    String driver() default "";

    /**
     *
     * @since 0.15.0
     * @return Database url. Used for declarative connections.
     */
    String url() default "";

    /**
     * @since 0.15.0
     * @return Username owner of database connection. Used for declarative connection.
     */
    String user() default "";

    /**
     * @since 0.15.0
     * @return Password of owner of database connection. Used for declarative connection.
     */
    String password() default "";

}