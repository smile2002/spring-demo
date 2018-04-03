package cn.hiber.dao;

import cn.hiber.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA Repository
 *    声明式持久化操作
 *    需要JDK1.8+
 * Spring Data 提供的 Repository 接口类型：
 *   1. CrudRepository              (extends Repository)
 *   2. PagingAndSortingRepository  (extends Crud)
 *   3. JpaRepository               (extends Paging)
 */

/**
 * 由配置类的 @EnableJpaRepositories(basePackages=...)
 * 启用自动扫描，不需要添加注解
 */
@Repository
public interface UserRepository3 extends JpaRepository<User, Long> {
    User getUserById(int id);
}
