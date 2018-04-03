package cn.mb.domain;


/**
 * Created by Smile on 2018/4/3.
 */

public class User {

    private int id;
    private int age;
    private String name;

    /*private int offset;
    private int pageSize;

    void User()
    {
        this.offset = 1;
        this.pageSize = 10;
    }*/
    public int getId()
    {
        return this.id;
    }
    public int getAge()
    {
        return this.age;
    }
    public String getName()
    {
        return this.name;
    }

    /*public int getOffset() { return this.offset; }
    public int getPageSize() { return this.pageSize; }
    */

    public void setId(int id) {this.id = id; }
    public void setAge(int age)
    {
        this.age = age;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    /*public void setOffset(int offset)
    {
        this.offset = offset;
    }
    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }
    */
}