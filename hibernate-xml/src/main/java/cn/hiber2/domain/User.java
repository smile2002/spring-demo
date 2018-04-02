package cn.hiber2.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Smile on 2018/4/2.
 */

@Entity
@Table(name="user2")
public class User {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "age")
    private int age;

    @Column(name = "name")
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
