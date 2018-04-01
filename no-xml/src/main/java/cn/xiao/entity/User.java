package cn.xiao.entity;

/**
 * Created by Smile on 2018/4/1.
 */
public class User {
    private String userId;
    private int age;
    private String name;
    private int offset;
    private int pageSize;

    void User()
    {
        this.offset = 1;
        this.pageSize = 10;
    }
    public String getUserId()
    {
        return this.userId;
    }
    public int getAge()
    {
        return this.age;
    }
    public String getName()
    {
        return this.name;
    }
    public int getOffset() { return this.offset; }
    public int getPageSize() { return this.pageSize; }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }
    public void setAge(int age)
    {
        this.age = age;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setOffset(int offset)
    {
        this.offset = offset;
    }
    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }
}
