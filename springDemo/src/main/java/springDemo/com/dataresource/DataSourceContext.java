package springDemo.com.dataresource;

public class DataSourceContext {

	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    public static void setDataSource(String value) {
        contextHolder.set(value);
    }

    public static String getDataSource() {
        return contextHolder.get();
    }

    public static void clearDataSource() {
        contextHolder.remove();
    }
}
