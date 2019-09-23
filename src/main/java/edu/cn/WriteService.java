package edu.cn;

/**
 * @program WriteFileEx
 * @description:
 * @author:
 * @create:2019-09-23 09:18:44
 **/

public interface WriteService {
    public void init();
    public void write(String content);
    public void destroy();
}
