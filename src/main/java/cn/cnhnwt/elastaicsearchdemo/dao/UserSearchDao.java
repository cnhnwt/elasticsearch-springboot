package cn.cnhnwt.elastaicsearchdemo.dao;

import cn.cnhnwt.elastaicsearchdemo.elastaticSearchBean.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
public interface UserSearchDao extends ElasticsearchRepository<User,String> {
    Page<User> findByAbout(String about, Pageable pageable);

}
