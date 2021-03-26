import com.fasterxml.jackson.core.JsonProcessingException;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.onezero.mongo.OJQuestionDal;
import com.onezero.mongo.OJQuestionMapper;
import com.onezero.mongo.QuestionDal;
import com.onezero.mongo.data.OJQuestionData;
import com.onezero.mongo.data.OptionData;
import com.onezero.mongo.data.QuestionData;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MongoTest {
    @Test
    public void demo() throws JsonProcessingException {
        MongoClient mongoClient = MongoClients.create();
        MongoDatabase database = mongoClient.getDatabase("question-bank");
        MongoCollection<Document> collection = database.getCollection("question");
        Bson bson = Filters.eq("_id", new ObjectId("603641f7fc37f911dbf56d93"));
        FindIterable<Document> docs = collection.find(bson);
        if (docs != null) {
            MongoCursor<Document> iterator = docs.iterator();
            while (iterator.hasNext()) {
                Document soc = iterator.next();
                System.out.println(soc.get("_id"));
            }
        }
    }

    @Test
    public void demo2() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("application-common.xml");
        QuestionDal dal = ac.getBean(QuestionDal.class);
        QuestionData data = new QuestionData();
        data.setDifficulty(1.0);
        data.setContent("jgowjgp");
        List<OptionData> options = new ArrayList<>();
        options.add(new OptionData("A", "gwioj"));
        options.add(new OptionData("B", "gwhioi"));
        data.setOptions(options);
        QuestionData insert = dal.insert(data);
        System.out.println(insert);
    }

    @Test
    public void insertMany() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("application-common.xml");
        QuestionDal dal = ac.getBean(QuestionDal.class);
        List<QuestionData> list = new ArrayList<>();
        QuestionData data = new QuestionData();
        data.setDifficulty(1.0);
        data.setContent("jgowjgp");
        List<OptionData> options = new ArrayList<>();
        options.add(new OptionData("A", "gwioj"));
        options.add(new OptionData("B", "gwhioi"));
        data.setOptions(options);

        list.add(data);
        list.add(data);
        list.add(data);
        list.add(data);

        dal.insertMany(list);
    }

    @Test
    public void delete() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("application-common.xml");
        QuestionDal dal = ac.getBean(QuestionDal.class);
        QuestionData data = new QuestionData();
        dal.delete("60366df35770153e957f3f7a");
    }


    @Test
    public void search() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("application-common.xml");
        QuestionDal dal = ac.getBean(QuestionDal.class);
        dal.find(null, "网络", 1, 1,5);
        dal.find(Arrays.asList("603780bb556cca1681061224"), null, null, 1, 5);
    }

    @Test
    public void toDocument() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("application-common.xml");
        OJQuestionMapper mapper = ac.getBean(OJQuestionMapper.class);
        OJQuestionData data = new OJQuestionData();
        Document doc = mapper.toDocument(data);
        OJQuestionData data1 = mapper.toData(doc);
        System.out.println(doc);
    }

    @Test
    public void oj() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("application-common.xml");
        OJQuestionDal b = ac.getBean(OJQuestionDal.class);
        List<OJQuestionData> byIds = b.getByIds(Arrays.asList("603b6c8dad6190297cc5ec25", "603b6c8dad6190297cc5ec2e"));
        System.out.println(byIds);
    }
}
