package system.rate_limit;

/**
 * @Author : wzq
 * @Date : 2023/3/13
 * @Version : 1.0
 * @Description : 固定时间窗口限流算法
 **/
public class FixedWindows {

    public static Integer counter = 0;  //统计请求数
    public static long lastAcquireTime =  0L;
    public static final Long windowUnit = 1000L ; //假设固定时间窗口是1000ms
    public static final Integer threshold = 10; // 窗口阀值是10

    public synchronized boolean fixedWindowsTryAcquire() {
        long currentTime = System.currentTimeMillis();  //获取系统当前时间
        if (currentTime - lastAcquireTime > windowUnit) {  //检查是否在时间窗口内
            counter = 0;  // 计数器清0
            lastAcquireTime = currentTime;  //开启新的时间窗口
        }
        if (counter < threshold) {  // 小于阀值
            counter++;  //计数统计器加1
            return true;
        }

        return false;
    }
}
