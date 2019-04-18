package cn.cnhnwt.elastaicsearchdemo;

import cn.cnhnwt.elastaicsearchdemo.dao.UserSearchDao;
import cn.cnhnwt.elastaicsearchdemo.elastaticSearchBean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ElastaicsearchDemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ElastaicsearchDemoApplicationTests {

    @Autowired
    private UserSearchDao userSearchDao;

    @Test
    public void contextLoads() {
    }

    @Test
    public void elasticSave(){
        userSearchDao.save(new User("3","bon","jackson",30,"I like to eat apple"));
    }

    @Test
    public void elasticSearch(){
        System.out.println(userSearchDao.findByAbout("I like",PageRequest.of(0,1)).getContent().get(0));
    }

}
