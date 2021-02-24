import com.onezero.bll.account.User;
import com.onezero.bll.account.UserManager;
import com.onezero.datastructure.GenericResult;
import com.onezero.datastructure.NoneDataResult;
import com.onezero.datastructure.Page;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Collections;

public class UserTest {
    UserManager userManager;
    @Before
    public void init() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        userManager = ac.getBean(UserManager.class);
    }

    @Test
    public void create() {
        User user = new User();
        user.setEmail("642171493@qq.com");
        user.setDisplayName("onezero");
        user.setPassword("Aa123456");
        user.setAvatar("http://xuxuxuonezero.top/xut_1613217815000snow_man.jpg");
        user.setIntroduction("我是一个平平无奇的恋爱小天才");
        userManager.create(user);
        System.out.println(user.getId());
    }

    @Test
    public void search() {
        GenericResult<User> user = userManager.getUserByEmailAndPassword("642171493@qq.com", "12345678");
        System.out.println(user.getData().getDisplayName());

        GenericResult<Page<User>> page = userManager.search(null, null, 0, 1, Integer.MAX_VALUE);
        System.out.println(page.getData().getTotalCount());
    }

    @Test
    public void resetPassword() {
        NoneDataResult result = userManager.resetPassword(1, "12345678912345678");
        Assert.assertEquals(0, result.getCode());
    }

    @Test
    public void delete() {
        NoneDataResult res = userManager.delete(3);
        Assert.assertEquals(0, res.getCode());
    }

    @Test
    public void update() {
        User user = new User();
        user.setId(1);
        user.setEmail("642171493@qq.com");
        user.setDisplayName("onezero");
        user.setAvatar("http://xuxuxuonezero.top/xut_1613217815000snow_man.jpg");
        user.setIntroduction("我是一个平平无奇的恋爱小天才");
        NoneDataResult result = userManager.update(user);
        Assert.assertEquals(0, result.getCode());
    }
}
