package ru.job4j.vacancies.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        System.setProperty("javax.net.ssl.trustStore", Main.class.getClassLoader().getResource("/vacanciesparser/sql.ru.jks").getPath());
        Document doc = Jsoup.connect("https://www.sql.ru/forum/job-offers").get();
        Elements table = doc.select("table.forumTable");
        Elements rows = table.select("tr");

        for (int index = 1; index < rows.size(); index++){
            Elements mainTd = rows.get(index).select("td.postslisttopic");
            String name = mainTd.text();
            String link = mainTd.select("a").first().attr("href");
            String date = rows.get(index).select("td.altCol").text();

            Document topicByLink = Jsoup.connect(link).get();





            Vacancy vacancy = new Vacancy();
            vacancy.setName(name);
            vacancy.setLink(link);
            vacancy.setDate(date);




            System.out.println(vacancy);
        }
    }
}
