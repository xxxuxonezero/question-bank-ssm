import com.onezero.dal.TagMapper;
import com.onezero.dal.data.TagData;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TagTest {
    @Test
    public void batchCreate() {
        List<TagData> datas = new ArrayList<>();
        TagData tagData = new TagData();
        tagData.setName("1");
        TagData tagData1 = new TagData();
        tagData1.setName("2");
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        TagMapper mapper = ac.getBean(TagMapper.class);
        mapper.batchCreate(Arrays.asList(tagData, tagData1));

    }
}
