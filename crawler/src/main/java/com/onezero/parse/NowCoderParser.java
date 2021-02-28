package com.onezero.parse;

import com.onezero.bll.question.Option;
import com.onezero.bll.question.Question;
import com.onezero.bll.question.QuestionManager;
import com.onezero.entity.nowcoder.PaperInfo;
import com.onezero.model.QuestionTypeEnum;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NowCoderParser extends AbstractParser {
    @Autowired
    private QuestionManager questionManager;
    @Override
    public Object parseHtml(String html) {
        Document document = Jsoup.parse(html);
        Question question = new Question();
        String type = document.select(".subject-box .js-title").first().text();
        type = type.substring(1, type.length() - 1);
        question.setType(QuestionTypeEnum.getId(type));
        String content = document.select(".subject-main .subject-des .nc-post-content").html();
        question.setContent(content);
        Elements options = document.select(".subject-main .subject-des .subject-des-list li");
        List<Option> optionList = new ArrayList<>();
        if (options != null && !options.isEmpty()) {
            for (int i = 0; i < options.size(); i++) {
                optionList.add(new Option(Option.labels[i], options.get(i).html()));
            }
        }
        question.setOptions(optionList);
        questionManager.create(question);
        return null;
    }

    public void getPaperInfo(String html, PaperInfo info) {
        Document document = Jsoup.parse(html);
        Elements el = document.select(".pagination > .pagination > ul");
        String size = el.first().attr("data-total");
        el = document.select(".no-border-table td > a");
        try {
            info.setPageNum(Integer.parseInt(size));
            for (Element element : el) {
                String href = element.attr("href");
                info.add(href);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
