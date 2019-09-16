package com.base.base.config.db;

public class DatasourceContextHolder {
    private static final ThreadLocal<String> local = new ThreadLocal<String>();
    private static final ThreadLocal<String> local_current = new ThreadLocal<String>();

    public static ThreadLocal<String> getLocal() {
        return local;
    }


    public DatasourceContextHolder(){
        local.set(DatasourceType.write.getType());
    }
    /**
     * 读可能是多个库
     */
    public static void read() {

        local.set(DatasourceType.read.getType());
    }

    /**
     * 手动设置写库
     */
    public static void setCurrentDbWrite() {

        local.set(DatasourceType.write.getType());
        local_current.set(DatasourceType.write.getType());
    }

    /**
     * 手动设置读库
     */
    public static void setCurrentDbRead() {

        local.set(DatasourceType.read.getType());
        local_current.set(DatasourceType.read.getType());
    }


    /**
     * 手动设置读库
     */
    public static boolean isSeturrentDb() {
        return local_current.get()!=null;
    }


    /**
     * 手动设置读写库
     */
    public static void clearCurrentDbRead() {

        local_current.remove();
    }


    /**
     * 写只有一个库
     */
    public static void write() {
        local.set(DatasourceType.write.getType());
    }

    public static String getJdbcType() {
        return local.get();
    }



}
