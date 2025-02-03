package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGeneration {
    private DataGeneration() {
    }

    public static String generateData(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity() {
        String[] cities = new String[]{"Майкоп", "Горно-Алтайск", "Уфа", "Улан-Удэ", "Махачкала",
                "Нальчик", "Элиста", "Черкесск", "Петрозаводск", "Сыктывкар", "Симферополь", "Йошкар-Ола",
                "Саранск", "Якутск", "Владикавказ", "Казань", "Кызыл", "Ижевск", "Абакан", "Грозный",
                "Чебоксары", "Барнаул", "Чита", "Петропавловск-Камчатский", "Краснодар", "Красноярск",
                "Пермь", "Владивосток", "Ставрополь", "Хабаровск", "Благовещенск", "Архангельск",
                "Астрахань", "Белгород", "Брянск", "Владимир", "Волгоград", "Вологда", "Воронеж",
                "Иваново", "Орёл", "Иркутск", "Калининград", "Калуга", "Кемерово", "Киров", "Кострома",
                "Курган", "Курск", "Санкт-Петербург", "Липецк", "Магадан", "Москва", "Мурманск", "Нижний Новгород",
                "Великий Новгород", "Новосибирск", "Омск", "Оренбург", "Пенза", "Псков", "Салехард",
                "Ростов-на-Дону", "Рязань", "Самара", "Саратов", "Южно-Сахалинск", "Екатеринбург",
                "Смоленск", "Тамбов", "Тверь", "Томск", "Тула", "Тюмень", "Ульяновск", "Челябинск",
                "Ярославль", "Севастополь", "Биробиджан", "Нарьян-Мар", "Ханты-Мансийск", "Анадырь"};
        return cities[new Random().nextInt(cities.length)];
    }

    public static String genetareName() {
        Faker faker = new Faker(new Locale("ru"));
        return  faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generatePhone() {
        Faker faker = new Faker(new Locale("ru"));
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {
        }

        public static DataGeneration.UserInfo generateUser() {
            return new DataGeneration.UserInfo(generateCity(), genetareName(), generatePhone());
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }

}
