package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.awt.desktop.OpenFilesEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task1Test {
    @Test
    @DisplayName("Тестирование сортировки по росту")
    void sortByHeightTest() {
        // given
        List<Task1.Animal> animalList = new ArrayList<>();
        animalList.add(new Task1.Animal("2", Task1.Animal.Type.FISH, Task1.Animal.Sex.F, 12, 2, 3, false));
        animalList.add(new Task1.Animal("6", Task1.Animal.Type.CAT, Task1.Animal.Sex.F, 12, 6, 7, false));
        animalList.add(new Task1.Animal("1", Task1.Animal.Type.SPIDER, Task1.Animal.Sex.F, 12, 1, 1, false));
        animalList.add(new Task1.Animal("4", Task1.Animal.Type.BIRD, Task1.Animal.Sex.F, 12, 4, 5, false));
        animalList.add(new Task1.Animal("5", Task1.Animal.Type.CAT, Task1.Animal.Sex.F, 12, 5, 4, false));
        animalList.add(new Task1.Animal("3", Task1.Animal.Type.BIRD, Task1.Animal.Sex.F, 12, 3, 2, false));
        animalList.add(new Task1.Animal("7", Task1.Animal.Type.DOG, Task1.Animal.Sex.F, 12, 7, 6, false));

        // when
        List<Task1.Animal> sortedAnimalList = Task1.sortByHeight(animalList);

        //then
        ListIterator<Task1.Animal> animalItr = sortedAnimalList.listIterator();
        int i = 0;
        while (animalItr.hasNext()) {
            ++i;
            assertEquals(i, animalItr.next().height());
        }
    }

    @Test
    @DisplayName("Тестирование сортировки по весу")
    void sortByWeightTest() {
        // given
        List<Task1.Animal> animalList = new ArrayList<>();
        animalList.add(new Task1.Animal("2", Task1.Animal.Type.FISH, Task1.Animal.Sex.F, 12, 2, 3, false));
        animalList.add(new Task1.Animal("6", Task1.Animal.Type.CAT, Task1.Animal.Sex.F, 12, 6, 7, false));
        animalList.add(new Task1.Animal("1", Task1.Animal.Type.SPIDER, Task1.Animal.Sex.F, 12, 1, 1, false));
        animalList.add(new Task1.Animal("4", Task1.Animal.Type.BIRD, Task1.Animal.Sex.F, 12, 4, 5, false));
        animalList.add(new Task1.Animal("5", Task1.Animal.Type.CAT, Task1.Animal.Sex.F, 12, 5, 4, false));
        animalList.add(new Task1.Animal("3", Task1.Animal.Type.BIRD, Task1.Animal.Sex.F, 12, 3, 2, false));
        animalList.add(new Task1.Animal("7", Task1.Animal.Type.DOG, Task1.Animal.Sex.F, 12, 7, 6, false));

        // when
        List<Task1.Animal> sortedAnimalList = Task1.getKHeaviest(animalList, 4);

        //then
        ListIterator<Task1.Animal> animalItr = sortedAnimalList.listIterator();
        int i = 0;
        while (animalItr.hasNext()) {
            ++i;
            assertEquals(i, animalItr.next().weight());
        }
        assertEquals(4, i);
    }

    @Test
    @DisplayName("Тестирование подсчета типов")
    void classifyByTypeTest() {
        // given
        List<Task1.Animal> animalList = new ArrayList<>();
        animalList.add(new Task1.Animal("2", Task1.Animal.Type.FISH, Task1.Animal.Sex.F, 12, 2, 3, false));
        animalList.add(new Task1.Animal("6", Task1.Animal.Type.CAT, Task1.Animal.Sex.F, 12, 6, 7, false));
        animalList.add(new Task1.Animal("1", Task1.Animal.Type.SPIDER, Task1.Animal.Sex.F, 12, 1, 1, false));
        animalList.add(new Task1.Animal("4", Task1.Animal.Type.BIRD, Task1.Animal.Sex.F, 12, 4, 5, false));
        animalList.add(new Task1.Animal("5", Task1.Animal.Type.CAT, Task1.Animal.Sex.F, 12, 5, 4, false));
        animalList.add(new Task1.Animal("3", Task1.Animal.Type.BIRD, Task1.Animal.Sex.F, 12, 3, 2, false));
        animalList.add(new Task1.Animal("7", Task1.Animal.Type.DOG, Task1.Animal.Sex.F, 12, 7, 6, false));

        // when
        var classifyByType = Task1.classifyByType(animalList);

        //then
        assertEquals(2, classifyByType.get(Task1.Animal.Type.BIRD));
        assertEquals(1, classifyByType.get(Task1.Animal.Type.FISH));
        assertEquals(2, classifyByType.get(Task1.Animal.Type.CAT));
        assertEquals(1, classifyByType.get(Task1.Animal.Type.SPIDER));
        assertEquals(1, classifyByType.get(Task1.Animal.Type.DOG));
    }

    @Test
    @DisplayName("Тестирование взятия самого длинного имени")
    void getLongestNameTest() {
        // given
        List<Task1.Animal> animalList = new ArrayList<>();
        animalList.add(new Task1.Animal("aboba", Task1.Animal.Type.FISH, Task1.Animal.Sex.F, 12, 2, 3, false));
        animalList.add(new Task1.Animal("tarakanus", Task1.Animal.Type.CAT, Task1.Animal.Sex.F, 12, 6, 7, false));
        animalList.add(new Task1.Animal("gigabituson", Task1.Animal.Type.SPIDER, Task1.Animal.Sex.F, 12, 1, 1, false));
        animalList.add(new Task1.Animal("klarkent", Task1.Animal.Type.BIRD, Task1.Animal.Sex.F, 12, 4, 5, false));
        animalList.add(new Task1.Animal("voleyboleydubdibub", Task1.Animal.Type.CAT, Task1.Animal.Sex.F, 12, 5, 4, false));
        animalList.add(new Task1.Animal("vacok", Task1.Animal.Type.BIRD, Task1.Animal.Sex.F, 12, 3, 2, false));
        animalList.add(new Task1.Animal("mikukakuliris", Task1.Animal.Type.DOG, Task1.Animal.Sex.F, 12, 7, 6, false));

        // when
        var animalWithLongestName = Task1.getAnimalWithLongestName(animalList);

        //then
        assertEquals("voleyboleydubdibub", animalWithLongestName.name());
    }

    @Test
    @DisplayName("Тестирование взятия самого частого пола")
    void getFrequentSexTest() {
        // given
        List<Task1.Animal> animalList = new ArrayList<>();
        animalList.add(new Task1.Animal("aboba", Task1.Animal.Type.FISH, Task1.Animal.Sex.F, 12, 2, 3, false));
        animalList.add(new Task1.Animal("tarakanus", Task1.Animal.Type.CAT, Task1.Animal.Sex.M, 12, 6, 7, false));
        animalList.add(new Task1.Animal("gigabituson", Task1.Animal.Type.SPIDER, Task1.Animal.Sex.F, 12, 1, 1, false));
        animalList.add(new Task1.Animal("klarkent", Task1.Animal.Type.BIRD, Task1.Animal.Sex.M, 12, 4, 5, false));
        animalList.add(new Task1.Animal("voleyboleydubdibub", Task1.Animal.Type.CAT, Task1.Animal.Sex.F, 12, 5, 4, false));
        animalList.add(new Task1.Animal("vacok", Task1.Animal.Type.BIRD, Task1.Animal.Sex.F, 12, 3, 2, false));
        animalList.add(new Task1.Animal("mikukakuliris", Task1.Animal.Type.DOG, Task1.Animal.Sex.M, 12, 7, 6, false));

        List<Task1.Animal> animalList2 = new ArrayList<>();
        animalList2.add(new Task1.Animal("aboba", Task1.Animal.Type.FISH, Task1.Animal.Sex.M, 12, 2, 3, false));
        animalList2.add(new Task1.Animal("tarakanus", Task1.Animal.Type.CAT, Task1.Animal.Sex.M, 12, 6, 7, false));
        animalList2.add(new Task1.Animal("gigabituson", Task1.Animal.Type.SPIDER, Task1.Animal.Sex.F, 12, 1, 1, false));
        animalList2.add(new Task1.Animal("klarkent", Task1.Animal.Type.BIRD, Task1.Animal.Sex.M, 12, 4, 5, false));
        animalList2.add(new Task1.Animal("voleyboleydubdibub", Task1.Animal.Type.CAT, Task1.Animal.Sex.F, 12, 5, 4, false));
        animalList2.add(new Task1.Animal("vacok", Task1.Animal.Type.BIRD, Task1.Animal.Sex.F, 12, 3, 2, false));
        animalList2.add(new Task1.Animal("mikukakuliris", Task1.Animal.Type.DOG, Task1.Animal.Sex.M, 12, 7, 6, false));

        // when
        var frequentSex = Task1.getFrequentSex(animalList);
        var frequentSex2 = Task1.getFrequentSex(animalList2);

        //then
        assertEquals(Task1.Animal.Sex.F, frequentSex);
        assertEquals(Task1.Animal.Sex.M, frequentSex2);
    }

    @Test
    @DisplayName("Тестирование взятия самых тяжелых каждого вида")
    void getHeaviestTypesTes() {
        // given
        List<Task1.Animal> animalList = new ArrayList<>();
        animalList.add(new Task1.Animal("aboba", Task1.Animal.Type.FISH, Task1.Animal.Sex.F, 12, 2, 3, false));
        animalList.add(new Task1.Animal("tarakanus", Task1.Animal.Type.CAT, Task1.Animal.Sex.M, 12, 6, 7, false));
        animalList.add(new Task1.Animal("gigabituson", Task1.Animal.Type.SPIDER, Task1.Animal.Sex.F, 12, 1, 1, false));
        animalList.add(new Task1.Animal("klarkent", Task1.Animal.Type.BIRD, Task1.Animal.Sex.M, 12, 4, 5, false));
        animalList.add(new Task1.Animal("voleyboleydubdibub", Task1.Animal.Type.CAT, Task1.Animal.Sex.F, 12, 5, 4, false));
        animalList.add(new Task1.Animal("vacok", Task1.Animal.Type.BIRD, Task1.Animal.Sex.F, 12, 3, 2, false));
        animalList.add(new Task1.Animal("mikukakuliris", Task1.Animal.Type.DOG, Task1.Animal.Sex.M, 12, 7, 6, false));
        animalList.add(new Task1.Animal("aboba", Task1.Animal.Type.FISH, Task1.Animal.Sex.F, 12, 2, 5, false));
        animalList.add(new Task1.Animal("tarakanus", Task1.Animal.Type.CAT, Task1.Animal.Sex.M, 12, 6, 5, false));
        animalList.add(new Task1.Animal("gigabituson", Task1.Animal.Type.SPIDER, Task1.Animal.Sex.F, 12, 1, 3, false));
        animalList.add(new Task1.Animal("klarkent", Task1.Animal.Type.BIRD, Task1.Animal.Sex.M, 12, 4, 7, false));
        animalList.add(new Task1.Animal("voleyboleydubdibub", Task1.Animal.Type.CAT, Task1.Animal.Sex.F, 12, 5, 3, false));
        animalList.add(new Task1.Animal("vacok", Task1.Animal.Type.BIRD, Task1.Animal.Sex.F, 12, 3, 5, false));
        animalList.add(new Task1.Animal("mikukakuliris", Task1.Animal.Type.DOG, Task1.Animal.Sex.M, 12, 7, 3, false));

        // when
        var heaviestTypes = Task1.getHeaviestTypes(animalList);

        //then
        assertEquals(7, heaviestTypes.get(Task1.Animal.Type.BIRD).weight());
        assertEquals(5, heaviestTypes.get(Task1.Animal.Type.FISH).weight());
        assertEquals(7, heaviestTypes.get(Task1.Animal.Type.CAT).weight());
        assertEquals(3, heaviestTypes.get(Task1.Animal.Type.SPIDER).weight());
        assertEquals(6, heaviestTypes.get(Task1.Animal.Type.DOG).weight());
    }

    @Test
    @DisplayName("Тестирование взятия k-го по возрасту")
    void getAnimalKByAgeTest() {
        // given
        List<Task1.Animal> animalList = new ArrayList<>();
        animalList.add(new Task1.Animal("aboba", Task1.Animal.Type.FISH, Task1.Animal.Sex.F, 13, 2, 3, false));
        animalList.add(new Task1.Animal("tarakanus", Task1.Animal.Type.CAT, Task1.Animal.Sex.M, 2, 6, 7, false));
        animalList.add(new Task1.Animal("gigabituson", Task1.Animal.Type.SPIDER, Task1.Animal.Sex.F, 11, 1, 1, false));
        animalList.add(new Task1.Animal("klarkent", Task1.Animal.Type.BIRD, Task1.Animal.Sex.M, 4, 4, 5, false));
        animalList.add(new Task1.Animal("voleyboleydubdibub", Task1.Animal.Type.CAT, Task1.Animal.Sex.F, 9, 5, 4, false));
        animalList.add(new Task1.Animal("vacok", Task1.Animal.Type.BIRD, Task1.Animal.Sex.F, 6, 3, 2, false));
        animalList.add(new Task1.Animal("mikukakuliris", Task1.Animal.Type.DOG, Task1.Animal.Sex.M, 7, 7, 6, false));
        animalList.add(new Task1.Animal("aboba", Task1.Animal.Type.FISH, Task1.Animal.Sex.F, 8, 2, 5, false));
        animalList.add(new Task1.Animal("tarakanus", Task1.Animal.Type.CAT, Task1.Animal.Sex.M, 5, 6, 5, false));
        animalList.add(new Task1.Animal("gigabituson", Task1.Animal.Type.SPIDER, Task1.Animal.Sex.F, 10, 1, 3, false));
        animalList.add(new Task1.Animal("klarkent", Task1.Animal.Type.BIRD, Task1.Animal.Sex.M, 3, 4, 7, false));
        animalList.add(new Task1.Animal("voleyboleydubdibub", Task1.Animal.Type.CAT, Task1.Animal.Sex.F, 12, 5, 3, false));
        animalList.add(new Task1.Animal("vacok", Task1.Animal.Type.BIRD, Task1.Animal.Sex.F, 1, 3, 5, false));
        animalList.add(new Task1.Animal("mikukakuliris", Task1.Animal.Type.DOG, Task1.Animal.Sex.M, 14, 7, 3, false));

        // when
        var animal3ByAge = Task1.getAnimalKByAge(animalList, 3);
        var animal6ByAge = Task1.getAnimalKByAge(animalList, 6);
        var animal9ByAge = Task1.getAnimalKByAge(animalList, 9);

        //then
        assertEquals(11, animal3ByAge.age());
        assertEquals(8, animal6ByAge.age());
        assertEquals(5, animal9ByAge.age());
    }

    @Test
    @DisplayName("Тестирование взятия самого тяжелого животного среди животных ниже k см")
    void getHeaviestShorterKTest() {
        // given
        List<Task1.Animal> animalList = new ArrayList<>();
        animalList.add(new Task1.Animal("aboba", Task1.Animal.Type.FISH, Task1.Animal.Sex.F, 13, 2, 3, false));
        animalList.add(new Task1.Animal("tarakanus", Task1.Animal.Type.CAT, Task1.Animal.Sex.M, 2, 6, 7, false));
        animalList.add(new Task1.Animal("gigabituson", Task1.Animal.Type.SPIDER, Task1.Animal.Sex.F, 11, 1, 1, false));
        animalList.add(new Task1.Animal("klarkent", Task1.Animal.Type.BIRD, Task1.Animal.Sex.M, 4, 4, 5, false));
        animalList.add(new Task1.Animal("voleyboleydubdibub", Task1.Animal.Type.CAT, Task1.Animal.Sex.F, 9, 5, 4, false));
        animalList.add(new Task1.Animal("vacok", Task1.Animal.Type.BIRD, Task1.Animal.Sex.F, 6, 3, 2, false));
        animalList.add(new Task1.Animal("mikukakuliris", Task1.Animal.Type.DOG, Task1.Animal.Sex.M, 7, 7, 6, false));
        animalList.add(new Task1.Animal("aboba", Task1.Animal.Type.FISH, Task1.Animal.Sex.F, 8, 2, 5, false));
        animalList.add(new Task1.Animal("tarakanus", Task1.Animal.Type.CAT, Task1.Animal.Sex.M, 5, 6, 5, false));
        animalList.add(new Task1.Animal("gigabituson", Task1.Animal.Type.SPIDER, Task1.Animal.Sex.F, 10, 1, 3, false));
        animalList.add(new Task1.Animal("klarkent", Task1.Animal.Type.BIRD, Task1.Animal.Sex.M, 3, 4, 7, false));
        animalList.add(new Task1.Animal("voleyboleydubdibub", Task1.Animal.Type.CAT, Task1.Animal.Sex.F, 12, 5, 3, false));
        animalList.add(new Task1.Animal("vacok", Task1.Animal.Type.BIRD, Task1.Animal.Sex.F, 1, 3, 5, false));
        animalList.add(new Task1.Animal("mikukakuliris", Task1.Animal.Type.DOG, Task1.Animal.Sex.M, 14, 7, 3, false));

        // when
        var heaviestShorter1 = Task1.getHeaviestShorterK(animalList, 1);
        var heaviestShorter3 = Task1.getHeaviestShorterK(animalList, 3);
        var heaviestShorter6 = Task1.getHeaviestShorterK(animalList, 6);
        var heaviestShorter9 = Task1.getHeaviestShorterK(animalList, 9);

        //then
        assertEquals(Optional.empty(), heaviestShorter1);
        heaviestShorter3.ifPresent(animal -> assertEquals(3, animal.weight()));
        heaviestShorter6.ifPresent(animal -> assertEquals(7, animal.weight()));
        heaviestShorter9.ifPresent(animal -> assertEquals(7, animal.weight()));
    }

    @Test
    @DisplayName("Тестирование подсчета суммы количества лап")
    void sumPawsTest() {
        // given
        List<Task1.Animal> animalList = new ArrayList<>();
        animalList.add(new Task1.Animal("aboba", Task1.Animal.Type.FISH, Task1.Animal.Sex.F, 13, 2, 3, false));
        animalList.add(new Task1.Animal("tarakanus", Task1.Animal.Type.CAT, Task1.Animal.Sex.M, 2, 6, 7, false));
        animalList.add(new Task1.Animal("gigabituson", Task1.Animal.Type.SPIDER, Task1.Animal.Sex.F, 11, 1, 1, false));
        animalList.add(new Task1.Animal("klarkent", Task1.Animal.Type.BIRD, Task1.Animal.Sex.M, 4, 4, 5, false));
        animalList.add(new Task1.Animal("voleyboleydubdibub", Task1.Animal.Type.CAT, Task1.Animal.Sex.F, 9, 5, 4, false));
        animalList.add(new Task1.Animal("vacok", Task1.Animal.Type.BIRD, Task1.Animal.Sex.F, 6, 3, 2, false));
        animalList.add(new Task1.Animal("mikukakuliris", Task1.Animal.Type.DOG, Task1.Animal.Sex.M, 7, 7, 6, false));
        animalList.add(new Task1.Animal("aboba", Task1.Animal.Type.FISH, Task1.Animal.Sex.F, 8, 2, 5, false));
        animalList.add(new Task1.Animal("tarakanus", Task1.Animal.Type.CAT, Task1.Animal.Sex.M, 5, 6, 5, false));
        animalList.add(new Task1.Animal("gigabituson", Task1.Animal.Type.SPIDER, Task1.Animal.Sex.F, 10, 1, 3, false));
        animalList.add(new Task1.Animal("klarkent", Task1.Animal.Type.BIRD, Task1.Animal.Sex.M, 3, 4, 7, false));
        animalList.add(new Task1.Animal("voleyboleydubdibub", Task1.Animal.Type.CAT, Task1.Animal.Sex.F, 12, 5, 3, false));
        animalList.add(new Task1.Animal("vacok", Task1.Animal.Type.BIRD, Task1.Animal.Sex.F, 1, 3, 5, false));
        animalList.add(new Task1.Animal("mikukakuliris", Task1.Animal.Type.DOG, Task1.Animal.Sex.M, 14, 7, 3, false));

        // when
        var sumPaws = Task1.sumPaws(animalList);

        //then
        assertEquals(48, sumPaws);
    }

    @Test
    @DisplayName("Тестирование подсчета животных, возраст которых не совпадает с количеством лап")
    void getAgeNotEqualPawsAnimalsTest() {
        // given
        List<Task1.Animal> animalList = new ArrayList<>();
        animalList.add(new Task1.Animal("aboba", Task1.Animal.Type.FISH, Task1.Animal.Sex.F, 13, 2, 3, false));
        animalList.add(new Task1.Animal("tarakanus", Task1.Animal.Type.CAT, Task1.Animal.Sex.M, 4, 6, 7, false));
        animalList.add(new Task1.Animal("gigabituson", Task1.Animal.Type.SPIDER, Task1.Animal.Sex.F, 11, 1, 1, false));
        animalList.add(new Task1.Animal("klarkent", Task1.Animal.Type.BIRD, Task1.Animal.Sex.M, 4, 4, 5, false));
        animalList.add(new Task1.Animal("voleyboleydubdibub", Task1.Animal.Type.CAT, Task1.Animal.Sex.F, 9, 5, 4, false));
        animalList.add(new Task1.Animal("vacok", Task1.Animal.Type.BIRD, Task1.Animal.Sex.F, 6, 3, 2, false));
        animalList.add(new Task1.Animal("mikukakuliris", Task1.Animal.Type.DOG, Task1.Animal.Sex.M, 7, 7, 6, false));
        animalList.add(new Task1.Animal("aboba", Task1.Animal.Type.FISH, Task1.Animal.Sex.F, 8, 2, 5, false));
        animalList.add(new Task1.Animal("tarakanus", Task1.Animal.Type.CAT, Task1.Animal.Sex.M, 5, 6, 5, false));
        animalList.add(new Task1.Animal("gigabituson", Task1.Animal.Type.SPIDER, Task1.Animal.Sex.F, 8, 1, 3, false));
        animalList.add(new Task1.Animal("klarkent", Task1.Animal.Type.BIRD, Task1.Animal.Sex.M, 3, 4, 7, false));
        animalList.add(new Task1.Animal("voleyboleydubdibub", Task1.Animal.Type.CAT, Task1.Animal.Sex.F, 12, 5, 3, false));
        animalList.add(new Task1.Animal("vacok", Task1.Animal.Type.BIRD, Task1.Animal.Sex.F, 1, 3, 5, false));
        animalList.add(new Task1.Animal("mikukakuliris", Task1.Animal.Type.DOG, Task1.Animal.Sex.M, 14, 7, 3, false));

        // when
        var ageNotEqualPawsAnimals = Task1.getAgeNotEqualPawsAnimals(animalList);

        //then
        assertEquals(12, ageNotEqualPawsAnimals.toArray().length);
    }

    @Test
    @DisplayName("Тестирование подсчета кусающихся животных выше 100")
    void getBitesHigher100Test() {
        // given
        List<Task1.Animal> animalList = new ArrayList<>();
        animalList.add(new Task1.Animal("aboba", Task1.Animal.Type.FISH, Task1.Animal.Sex.F, 13, 102, 3, false));
        animalList.add(new Task1.Animal("tarakanus", Task1.Animal.Type.CAT, Task1.Animal.Sex.M, 4, 101, 7, true));
        animalList.add(new Task1.Animal("gigabituson", Task1.Animal.Type.SPIDER, Task1.Animal.Sex.F, 11, 101, 1, false));
        animalList.add(new Task1.Animal("klarkent", Task1.Animal.Type.BIRD, Task1.Animal.Sex.M, 4, 100, 5, true));
        animalList.add(new Task1.Animal("voleyboleydubdibub", Task1.Animal.Type.CAT, Task1.Animal.Sex.F, 9, 105, 4, false));
        animalList.add(new Task1.Animal("vacok", Task1.Animal.Type.BIRD, Task1.Animal.Sex.F, 6, 103, 2, true));
        animalList.add(new Task1.Animal("mikukakuliris", Task1.Animal.Type.DOG, Task1.Animal.Sex.M, 7, 107, 6, false));
        animalList.add(new Task1.Animal("aboba", Task1.Animal.Type.FISH, Task1.Animal.Sex.F, 8, 100, 5, true));
        animalList.add(new Task1.Animal("tarakanus", Task1.Animal.Type.CAT, Task1.Animal.Sex.M, 5, 106, 5, false));
        animalList.add(new Task1.Animal("gigabituson", Task1.Animal.Type.SPIDER, Task1.Animal.Sex.F, 8, 101, 3, true));
        animalList.add(new Task1.Animal("klarkent", Task1.Animal.Type.BIRD, Task1.Animal.Sex.M, 3, 104, 7, false));
        animalList.add(new Task1.Animal("voleyboleydubdibub", Task1.Animal.Type.CAT, Task1.Animal.Sex.F, 12, 99, 3, true));
        animalList.add(new Task1.Animal("vacok", Task1.Animal.Type.BIRD, Task1.Animal.Sex.F, 1, 103, 5, false));
        animalList.add(new Task1.Animal("mikukakuliris", Task1.Animal.Type.DOG, Task1.Animal.Sex.M, 14, 100, 3, true));

        // when
        var bitesHigher100 = Task1.getBitesHigher100(animalList);

        //then
        assertEquals(3, bitesHigher100.toArray().length);
    }

    @Test
    @DisplayName("Тестирование подсчета животных, чей вес больше роста")
    void getAnimalWeightMoreThanHeightTest() {
        // given
        List<Task1.Animal> animalList = new ArrayList<>();
        animalList.add(new Task1.Animal("aboba", Task1.Animal.Type.FISH, Task1.Animal.Sex.F, 13, 102, 3, false));
        animalList.add(new Task1.Animal("tarakanus", Task1.Animal.Type.CAT, Task1.Animal.Sex.M, 4, 101, 7, true));
        animalList.add(new Task1.Animal("gigabituson", Task1.Animal.Type.SPIDER, Task1.Animal.Sex.F, 11, 101, 1, false));
        animalList.add(new Task1.Animal("klarkent", Task1.Animal.Type.BIRD, Task1.Animal.Sex.M, 4, 100, 101, true));
        animalList.add(new Task1.Animal("voleyboleydubdibub", Task1.Animal.Type.CAT, Task1.Animal.Sex.F, 9, 105, 4, false));
        animalList.add(new Task1.Animal("vacok", Task1.Animal.Type.BIRD, Task1.Animal.Sex.F, 6, 103, 2, true));
        animalList.add(new Task1.Animal("mikukakuliris", Task1.Animal.Type.DOG, Task1.Animal.Sex.M, 7, 107, 6, false));
        animalList.add(new Task1.Animal("aboba", Task1.Animal.Type.FISH, Task1.Animal.Sex.F, 8, 100, 101, true));
        animalList.add(new Task1.Animal("tarakanus", Task1.Animal.Type.CAT, Task1.Animal.Sex.M, 5, 106, 5, false));
        animalList.add(new Task1.Animal("gigabituson", Task1.Animal.Type.SPIDER, Task1.Animal.Sex.F, 8, 101, 3, true));
        animalList.add(new Task1.Animal("klarkent", Task1.Animal.Type.BIRD, Task1.Animal.Sex.M, 3, 104, 105, false));
        animalList.add(new Task1.Animal("voleyboleydubdibub", Task1.Animal.Type.CAT, Task1.Animal.Sex.F, 12, 99, 3, true));
        animalList.add(new Task1.Animal("vacok", Task1.Animal.Type.BIRD, Task1.Animal.Sex.F, 1, 103, 5, false));
        animalList.add(new Task1.Animal("mikukakuliris", Task1.Animal.Type.DOG, Task1.Animal.Sex.M, 14, 100, 3, true));

        // when
        var animals = Task1.getAnimalWeightMoreThanHeight(animalList);

        //then
        assertEquals(3, animals.toArray().length);
    }

    @Test
    @DisplayName("Тестирование подсчета животных, чье имя больше чем из дву слов")
    void getAnimalMoreThanTwoWordsTest() {
        // given
        List<Task1.Animal> animalList = new ArrayList<>();
        animalList.add(new Task1.Animal("aboba", Task1.Animal.Type.FISH, Task1.Animal.Sex.F, 13, 102, 3, false));
        animalList.add(new Task1.Animal("tarak anus", Task1.Animal.Type.CAT, Task1.Animal.Sex.M, 4, 101, 7, true));
        animalList.add(new Task1.Animal("gig abi tuson", Task1.Animal.Type.SPIDER, Task1.Animal.Sex.F, 11, 101, 1, false));
        animalList.add(new Task1.Animal("klarkent", Task1.Animal.Type.BIRD, Task1.Animal.Sex.M, 4, 100, 101, true));
        animalList.add(new Task1.Animal("voley boleydubdibub", Task1.Animal.Type.CAT, Task1.Animal.Sex.F, 9, 105, 4, false));
        animalList.add(new Task1.Animal("vacok", Task1.Animal.Type.BIRD, Task1.Animal.Sex.F, 6, 103, 2, true));
        animalList.add(new Task1.Animal("mikuka kulir is", Task1.Animal.Type.DOG, Task1.Animal.Sex.M, 7, 107, 6, false));
        animalList.add(new Task1.Animal("ab oba", Task1.Animal.Type.FISH, Task1.Animal.Sex.F, 8, 100, 101, true));
        animalList.add(new Task1.Animal("tarakanus", Task1.Animal.Type.CAT, Task1.Animal.Sex.M, 5, 106, 5, false));
        animalList.add(new Task1.Animal("gigab ituson", Task1.Animal.Type.SPIDER, Task1.Animal.Sex.F, 8, 101, 3, true));
        animalList.add(new Task1.Animal("klarkent", Task1.Animal.Type.BIRD, Task1.Animal.Sex.M, 3, 104, 105, false));
        animalList.add(new Task1.Animal("vo leyboleydubdibub", Task1.Animal.Type.CAT, Task1.Animal.Sex.F, 12, 99, 3, true));
        animalList.add(new Task1.Animal("v ac ok", Task1.Animal.Type.BIRD, Task1.Animal.Sex.F, 1, 103, 5, false));
        animalList.add(new Task1.Animal("mikukaku liris", Task1.Animal.Type.DOG, Task1.Animal.Sex.M, 14, 100, 3, true));

        // when
        var animals = Task1.getAnimalMoreThanTwoWords(animalList);

        //then
        assertEquals(3, animals.toArray().length);
    }

    @Test
    @DisplayName("Тестирование есть ли в списке собака ростом более k")
    void hasDogHigherKTest() {
        // given
        List<Task1.Animal> animalList = new ArrayList<>();
        animalList.add(new Task1.Animal("aboba", Task1.Animal.Type.FISH, Task1.Animal.Sex.F, 13, 102, 3, false));
        animalList.add(new Task1.Animal("tarak anus", Task1.Animal.Type.CAT, Task1.Animal.Sex.M, 4, 101, 7, true));
        animalList.add(new Task1.Animal("gig abi tuson", Task1.Animal.Type.SPIDER, Task1.Animal.Sex.F, 11, 101, 1, false));
        animalList.add(new Task1.Animal("klarkent", Task1.Animal.Type.BIRD, Task1.Animal.Sex.M, 4, 100, 101, true));
        animalList.add(new Task1.Animal("voley boleydubdibub", Task1.Animal.Type.CAT, Task1.Animal.Sex.F, 9, 105, 4, false));
        animalList.add(new Task1.Animal("vacok", Task1.Animal.Type.BIRD, Task1.Animal.Sex.F, 6, 103, 2, true));
        animalList.add(new Task1.Animal("mikuka kulir is", Task1.Animal.Type.DOG, Task1.Animal.Sex.M, 7, 107, 6, false));
        animalList.add(new Task1.Animal("ab oba", Task1.Animal.Type.FISH, Task1.Animal.Sex.F, 8, 100, 101, true));
        animalList.add(new Task1.Animal("tarakanus", Task1.Animal.Type.CAT, Task1.Animal.Sex.M, 5, 106, 5, false));
        animalList.add(new Task1.Animal("gigab ituson", Task1.Animal.Type.SPIDER, Task1.Animal.Sex.F, 8, 101, 3, true));
        animalList.add(new Task1.Animal("klarkent", Task1.Animal.Type.BIRD, Task1.Animal.Sex.M, 3, 104, 105, false));
        animalList.add(new Task1.Animal("vo leyboleydubdibub", Task1.Animal.Type.CAT, Task1.Animal.Sex.F, 12, 99, 3, true));
        animalList.add(new Task1.Animal("v ac ok", Task1.Animal.Type.BIRD, Task1.Animal.Sex.F, 1, 103, 5, false));
        animalList.add(new Task1.Animal("mikukaku liris", Task1.Animal.Type.DOG, Task1.Animal.Sex.M, 14, 100, 3, true));

        // when
        var higher108 = Task1.hasDogHigherK(animalList, 108);
        var higher107 = Task1.hasDogHigherK(animalList, 107);
        var higher106 = Task1.hasDogHigherK(animalList, 106);

        //then
        assertFalse(higher108);
        assertFalse(higher107);
        assertTrue(higher106);
    }

    @Test
    @DisplayName("Тестирование нахождение суммарного веса животных каждого вида, которым от k до l лет -")
    void sumWeightFromKToLTest() {
        // given
        List<Task1.Animal> animalList = new ArrayList<>();
        animalList.add(new Task1.Animal("aboba", Task1.Animal.Type.FISH, Task1.Animal.Sex.F, 13, 102, 3, false));
        animalList.add(new Task1.Animal("tarak anus", Task1.Animal.Type.CAT, Task1.Animal.Sex.M, 4, 101, 7, true));
        animalList.add(new Task1.Animal("gig abi tuson", Task1.Animal.Type.SPIDER, Task1.Animal.Sex.F, 11, 101, 1, false));
        animalList.add(new Task1.Animal("klarkent", Task1.Animal.Type.BIRD, Task1.Animal.Sex.M, 4, 100, 101, true));
        animalList.add(new Task1.Animal("voley boleydubdibub", Task1.Animal.Type.CAT, Task1.Animal.Sex.F, 9, 105, 4, false));
        animalList.add(new Task1.Animal("vacok", Task1.Animal.Type.BIRD, Task1.Animal.Sex.F, 6, 103, 2, true));
        animalList.add(new Task1.Animal("mikuka kulir is", Task1.Animal.Type.DOG, Task1.Animal.Sex.M, 7, 107, 6, false));
        animalList.add(new Task1.Animal("ab oba", Task1.Animal.Type.FISH, Task1.Animal.Sex.F, 8, 100, 101, true));
        animalList.add(new Task1.Animal("tarakanus", Task1.Animal.Type.CAT, Task1.Animal.Sex.M, 5, 106, 5, false));
        animalList.add(new Task1.Animal("gigab ituson", Task1.Animal.Type.SPIDER, Task1.Animal.Sex.F, 8, 101, 3, true));
        animalList.add(new Task1.Animal("klarkent", Task1.Animal.Type.BIRD, Task1.Animal.Sex.M, 3, 104, 105, false));
        animalList.add(new Task1.Animal("vo leyboleydubdibub", Task1.Animal.Type.CAT, Task1.Animal.Sex.F, 12, 99, 3, true));
        animalList.add(new Task1.Animal("v ac ok", Task1.Animal.Type.BIRD, Task1.Animal.Sex.F, 1, 103, 5, false));
        animalList.add(new Task1.Animal("mikukaku liris", Task1.Animal.Type.DOG, Task1.Animal.Sex.M, 14, 100, 3, true));

        // when
        var sums = Task1.sumWeightFromKToL(animalList, 4, 8);

        //then
        assertEquals(103, sums.get(Task1.Animal.Type.BIRD));
        assertEquals(12, sums.get(Task1.Animal.Type.CAT));
        assertEquals(6, sums.get(Task1.Animal.Type.DOG));
        assertEquals(3, sums.get(Task1.Animal.Type.SPIDER));
        assertEquals(101, sums.get(Task1.Animal.Type.FISH));
    }

    @Test
    @DisplayName("Тестирование сортировки по типу, полу и имени")
    void sortByTypeSexNameTest() {
        // given
        List<Task1.Animal> animalList = new ArrayList<>();
        animalList.add(new Task1.Animal("aboba", Task1.Animal.Type.FISH, Task1.Animal.Sex.F, 13, 102, 3, false));
        animalList.add(new Task1.Animal("tarakanus", Task1.Animal.Type.CAT, Task1.Animal.Sex.F, 4, 101, 7, true));
        animalList.add(new Task1.Animal("gigabituson", Task1.Animal.Type.SPIDER, Task1.Animal.Sex.F, 11, 101, 1, false));
        animalList.add(new Task1.Animal("klarkent", Task1.Animal.Type.BIRD, Task1.Animal.Sex.F, 4, 100, 101, true));
        animalList.add(new Task1.Animal("voleyboleydubdibub", Task1.Animal.Type.CAT, Task1.Animal.Sex.F, 9, 105, 4, false));
        animalList.add(new Task1.Animal("vacok", Task1.Animal.Type.BIRD, Task1.Animal.Sex.F, 6, 103, 2, true));
        animalList.add(new Task1.Animal("mikukakuliris", Task1.Animal.Type.DOG, Task1.Animal.Sex.F, 7, 107, 6, false));
        animalList.add(new Task1.Animal("aboba", Task1.Animal.Type.FISH, Task1.Animal.Sex.M, 8, 100, 101, true));
        animalList.add(new Task1.Animal("tarakanus", Task1.Animal.Type.CAT, Task1.Animal.Sex.M, 5, 106, 5, false));
        animalList.add(new Task1.Animal("gigabituson", Task1.Animal.Type.SPIDER, Task1.Animal.Sex.M, 8, 101, 3, true));
        animalList.add(new Task1.Animal("klarkent", Task1.Animal.Type.BIRD, Task1.Animal.Sex.M, 3, 104, 105, false));
        animalList.add(new Task1.Animal("voleyboleydubdibub", Task1.Animal.Type.CAT, Task1.Animal.Sex.M, 12, 99, 3, true));
        animalList.add(new Task1.Animal("vacok", Task1.Animal.Type.BIRD, Task1.Animal.Sex.M, 1, 103, 5, false));
        animalList.add(new Task1.Animal("mikukakuliris", Task1.Animal.Type.DOG, Task1.Animal.Sex.M, 14, 100, 3, true));

        // when
        var sortedAnimals = Task1.sortByTypeSexName(animalList);

        //then
        assertEquals("aboba", sortedAnimals.get(0).name());
        assertEquals("aboba", sortedAnimals.get(1).name());
        assertEquals("gigabituson", sortedAnimals.get(2).name());
        assertEquals("gigabituson", sortedAnimals.get(3).name());
        assertEquals("klarkent", sortedAnimals.get(4).name());
        assertEquals("klarkent", sortedAnimals.get(5).name());
        assertEquals("mikukakuliris", sortedAnimals.get(6).name());
        assertEquals("mikukakuliris", sortedAnimals.get(7).name());
        assertEquals("tarakanus", sortedAnimals.get(8).name());
        assertEquals("tarakanus", sortedAnimals.get(9).name());
        assertEquals("vacok", sortedAnimals.get(10).name());
        assertEquals("vacok", sortedAnimals.get(11).name());
        assertEquals("voleyboleydubdibub", sortedAnimals.get(12).name());
        assertEquals("voleyboleydubdibub", sortedAnimals.get(13).name());

        assertEquals(Task1.Animal.Sex.F, sortedAnimals.get(0).sex());
        assertEquals(Task1.Animal.Sex.M, sortedAnimals.get(1).sex());
        assertEquals(Task1.Animal.Sex.F, sortedAnimals.get(2).sex());
        assertEquals(Task1.Animal.Sex.M, sortedAnimals.get(3).sex());
        assertEquals(Task1.Animal.Sex.F, sortedAnimals.get(4).sex());
        assertEquals(Task1.Animal.Sex.M, sortedAnimals.get(5).sex());
        assertEquals(Task1.Animal.Sex.F, sortedAnimals.get(6).sex());
        assertEquals(Task1.Animal.Sex.M, sortedAnimals.get(7).sex());
        assertEquals(Task1.Animal.Sex.F, sortedAnimals.get(8).sex());
        assertEquals(Task1.Animal.Sex.M, sortedAnimals.get(9).sex());
        assertEquals(Task1.Animal.Sex.F, sortedAnimals.get(10).sex());
        assertEquals(Task1.Animal.Sex.M, sortedAnimals.get(11).sex());
        assertEquals(Task1.Animal.Sex.F, sortedAnimals.get(12).sex());
        assertEquals(Task1.Animal.Sex.M, sortedAnimals.get(13).sex());
    }

    @Test
    @DisplayName("Тестирование кусаются ли пауки чаще собак")
    void isSpiderBitMoreOftenThanDogsTest() {
        // given
        List<Task1.Animal> animalList = new ArrayList<>();
        animalList.add(new Task1.Animal("aboba", Task1.Animal.Type.FISH, Task1.Animal.Sex.F, 13, 102, 3, false));
        animalList.add(new Task1.Animal("tarakanus", Task1.Animal.Type.CAT, Task1.Animal.Sex.F, 4, 101, 7, true));
        animalList.add(new Task1.Animal("gigabituson", Task1.Animal.Type.SPIDER, Task1.Animal.Sex.F, 11, 101, 1, true));
        animalList.add(new Task1.Animal("klarkent", Task1.Animal.Type.BIRD, Task1.Animal.Sex.F, 4, 100, 101, true));
        animalList.add(new Task1.Animal("voleyboleydubdibub", Task1.Animal.Type.CAT, Task1.Animal.Sex.F, 9, 105, 4, false));
        animalList.add(new Task1.Animal("vacok", Task1.Animal.Type.BIRD, Task1.Animal.Sex.F, 6, 103, 2, true));
        animalList.add(new Task1.Animal("mikukakuliris", Task1.Animal.Type.DOG, Task1.Animal.Sex.F, 7, 107, 6, false));
        animalList.add(new Task1.Animal("aboba", Task1.Animal.Type.FISH, Task1.Animal.Sex.M, 8, 100, 101, true));
        animalList.add(new Task1.Animal("tarakanus", Task1.Animal.Type.CAT, Task1.Animal.Sex.M, 5, 106, 5, false));
        animalList.add(new Task1.Animal("gigabituson", Task1.Animal.Type.SPIDER, Task1.Animal.Sex.M, 8, 101, 3, true));
        animalList.add(new Task1.Animal("klarkent", Task1.Animal.Type.BIRD, Task1.Animal.Sex.M, 3, 104, 105, false));
        animalList.add(new Task1.Animal("voleyboleydubdibub", Task1.Animal.Type.CAT, Task1.Animal.Sex.M, 12, 99, 3, true));
        animalList.add(new Task1.Animal("vacok", Task1.Animal.Type.BIRD, Task1.Animal.Sex.M, 1, 103, 5, false));
        animalList.add(new Task1.Animal("mikukakuliris", Task1.Animal.Type.DOG, Task1.Animal.Sex.M, 14, 100, 3, true));

        List<Task1.Animal> animalList2 = new ArrayList<>();
        animalList2.add(new Task1.Animal("aboba", Task1.Animal.Type.FISH, Task1.Animal.Sex.F, 13, 102, 3, false));
        animalList2.add(new Task1.Animal("tarakanus", Task1.Animal.Type.CAT, Task1.Animal.Sex.F, 4, 101, 7, true));
        animalList2.add(new Task1.Animal("gigabituson", Task1.Animal.Type.SPIDER, Task1.Animal.Sex.F, 11, 101, 1, false));
        animalList2.add(new Task1.Animal("klarkent", Task1.Animal.Type.BIRD, Task1.Animal.Sex.F, 4, 100, 101, true));
        animalList2.add(new Task1.Animal("voleyboleydubdibub", Task1.Animal.Type.CAT, Task1.Animal.Sex.F, 9, 105, 4, false));
        animalList2.add(new Task1.Animal("vacok", Task1.Animal.Type.BIRD, Task1.Animal.Sex.F, 6, 103, 2, true));
        animalList2.add(new Task1.Animal("mikukakuliris", Task1.Animal.Type.DOG, Task1.Animal.Sex.F, 7, 107, 6, false));
        animalList2.add(new Task1.Animal("aboba", Task1.Animal.Type.FISH, Task1.Animal.Sex.M, 8, 100, 101, true));
        animalList2.add(new Task1.Animal("tarakanus", Task1.Animal.Type.CAT, Task1.Animal.Sex.M, 5, 106, 5, false));
        animalList2.add(new Task1.Animal("gigabituson", Task1.Animal.Type.SPIDER, Task1.Animal.Sex.M, 8, 101, 3, true));
        animalList2.add(new Task1.Animal("klarkent", Task1.Animal.Type.BIRD, Task1.Animal.Sex.M, 3, 104, 105, false));
        animalList2.add(new Task1.Animal("voleyboleydubdibub", Task1.Animal.Type.CAT, Task1.Animal.Sex.M, 12, 99, 3, true));
        animalList2.add(new Task1.Animal("vacok", Task1.Animal.Type.BIRD, Task1.Animal.Sex.M, 1, 103, 5, false));
        animalList2.add(new Task1.Animal("mikukakuliris", Task1.Animal.Type.DOG, Task1.Animal.Sex.M, 14, 100, 3, true));

        // when
        var isSpiderBitMoreOftenThanDogs = Task1.isSpiderBitMoreOftenThanDogs(animalList);
        var isSpiderBitMoreOftenThanDogs2 = Task1.isSpiderBitMoreOftenThanDogs(animalList2);

        //then
        assertTrue(isSpiderBitMoreOftenThanDogs);
        assertFalse(isSpiderBitMoreOftenThanDogs2);
    }

    @Test
    @DisplayName("Тестирование нахождения самой тяжелой рыбы")
    void getHeaviestFishTest() {
        // given
        List<Task1.Animal> animalList = new ArrayList<>();
        animalList.add(new Task1.Animal("aboba", Task1.Animal.Type.FISH, Task1.Animal.Sex.F, 13, 102, 28, false));
        animalList.add(new Task1.Animal("tarakanus", Task1.Animal.Type.CAT, Task1.Animal.Sex.F, 4, 101, 7, true));
        animalList.add(new Task1.Animal("gigabituson", Task1.Animal.Type.SPIDER, Task1.Animal.Sex.F, 11, 101, 1, true));
        animalList.add(new Task1.Animal("klarkent", Task1.Animal.Type.BIRD, Task1.Animal.Sex.F, 4, 100, 101, true));
        animalList.add(new Task1.Animal("voleyboleydubdibub", Task1.Animal.Type.CAT, Task1.Animal.Sex.F, 9, 105, 4, false));
        animalList.add(new Task1.Animal("vacok", Task1.Animal.Type.BIRD, Task1.Animal.Sex.F, 6, 103, 2, true));
        animalList.add(new Task1.Animal("mikukakuliris", Task1.Animal.Type.DOG, Task1.Animal.Sex.F, 7, 107, 6, false));

        List<Task1.Animal> animalList2 = new ArrayList<>();
        animalList2.add(new Task1.Animal("aboba", Task1.Animal.Type.FISH, Task1.Animal.Sex.M, 8, 100, 302, true));
        animalList2.add(new Task1.Animal("tarakanus", Task1.Animal.Type.CAT, Task1.Animal.Sex.M, 5, 106, 5, false));
        animalList2.add(new Task1.Animal("gigabituson", Task1.Animal.Type.SPIDER, Task1.Animal.Sex.M, 8, 101, 3, true));
        animalList2.add(new Task1.Animal("klarkent", Task1.Animal.Type.BIRD, Task1.Animal.Sex.M, 3, 104, 105, false));
        animalList2.add(new Task1.Animal("voleyboleydubdibub", Task1.Animal.Type.CAT, Task1.Animal.Sex.M, 12, 99, 3, true));
        animalList2.add(new Task1.Animal("vacok", Task1.Animal.Type.BIRD, Task1.Animal.Sex.M, 1, 103, 5, false));
        animalList2.add(new Task1.Animal("mikukakuliris", Task1.Animal.Type.DOG, Task1.Animal.Sex.M, 14, 100, 3, true));

        List<Task1.Animal> animalList3 = new ArrayList<>();
        animalList3.add(new Task1.Animal("aboba", Task1.Animal.Type.FISH, Task1.Animal.Sex.F, 13, 102, 303, false));
        animalList3.add(new Task1.Animal("tarakanus", Task1.Animal.Type.CAT, Task1.Animal.Sex.F, 4, 101, 7, true));
        animalList3.add(new Task1.Animal("gigabituson", Task1.Animal.Type.SPIDER, Task1.Animal.Sex.F, 11, 101, 1, false));
        animalList3.add(new Task1.Animal("klarkent", Task1.Animal.Type.BIRD, Task1.Animal.Sex.F, 4, 100, 101, true));
        animalList3.add(new Task1.Animal("voleyboleydubdibub", Task1.Animal.Type.CAT, Task1.Animal.Sex.F, 9, 105, 4, false));
        animalList3.add(new Task1.Animal("vacok", Task1.Animal.Type.BIRD, Task1.Animal.Sex.F, 6, 103, 2, true));
        animalList3.add(new Task1.Animal("mikukakuliris", Task1.Animal.Type.DOG, Task1.Animal.Sex.F, 7, 107, 6, false));

        List<Task1.Animal> animalList4 = new ArrayList<>();
        animalList4.add(new Task1.Animal("aboba", Task1.Animal.Type.FISH, Task1.Animal.Sex.M, 8, 100, 101, true));
        animalList4.add(new Task1.Animal("tarakanus", Task1.Animal.Type.CAT, Task1.Animal.Sex.M, 5, 106, 5, false));
        animalList4.add(new Task1.Animal("gigabituson", Task1.Animal.Type.SPIDER, Task1.Animal.Sex.M, 8, 101, 3, true));
        animalList4.add(new Task1.Animal("klarkent", Task1.Animal.Type.BIRD, Task1.Animal.Sex.M, 3, 104, 105, false));
        animalList4.add(new Task1.Animal("voleyboleydubdibub", Task1.Animal.Type.CAT, Task1.Animal.Sex.M, 12, 99, 3, true));
        animalList4.add(new Task1.Animal("vacok", Task1.Animal.Type.BIRD, Task1.Animal.Sex.M, 1, 103, 5, false));
        animalList4.add(new Task1.Animal("mikukakuliris", Task1.Animal.Type.DOG, Task1.Animal.Sex.M, 14, 100, 3, true));

        // when
        var heaviestFish = Task1.getHeaviestFish(animalList, animalList2, animalList3, animalList4);

        //then
        assertEquals(303, heaviestFish.weight());
    }

    @Test
    @DisplayName("Тестирование нахождения ошибок полей")
    void findErrorsTest() {
        // given
        List<Task1.Animal> animalList = new ArrayList<>();
        animalList.add(new Task1.Animal("aboba", Task1.Animal.Type.FISH, Task1.Animal.Sex.F, 130, -102, 28, false));
        animalList.add(new Task1.Animal("tarakanus", null, Task1.Animal.Sex.F, 4, 101, 7, true));
        animalList.add(new Task1.Animal("gigabituson", Task1.Animal.Type.SPIDER, Task1.Animal.Sex.F, 13411, 101, -1, true));
        animalList.add(new Task1.Animal("klarkent", Task1.Animal.Type.BIRD, Task1.Animal.Sex.F, 4, -100, 12301, true));
        animalList.add(new Task1.Animal("voleyboleydubdibub", Task1.Animal.Type.CAT, Task1.Animal.Sex.F, 9, 105, 4, false));
        animalList.add(new Task1.Animal("vacok", Task1.Animal.Type.BIRD, null, -123, 103, 2, true));
        animalList.add(new Task1.Animal("mikukakuliris", null, Task1.Animal.Sex.F, 734, 107, -6, false));

        // when
        var errors = Task1.findErrors(animalList);

        //then
        assertEquals(2, errors.get("aboba").size());
        assertEquals(1, errors.get("tarakanus").size());
        assertEquals(2, errors.get("gigabituson").size());
        assertEquals(2, errors.get("klarkent").size());
        assertEquals(0, errors.get("voleyboleydubdibub").size());
        assertEquals(2, errors.get("vacok").size());
        assertEquals(3, errors.get("mikukakuliris").size());
    }

    @Test
    @DisplayName("Тестирование красивого нахождения ошибок полей")
    void stringFindErrorsTest() {
        // given
        List<Task1.Animal> animalList = new ArrayList<>();
        animalList.add(new Task1.Animal("aboba", Task1.Animal.Type.FISH, Task1.Animal.Sex.F, 130, -102, 28, false));
        animalList.add(new Task1.Animal("tarakanus", null, Task1.Animal.Sex.F, 4, 101, 7, true));
        animalList.add(new Task1.Animal("gigabituson", Task1.Animal.Type.SPIDER, Task1.Animal.Sex.F, 13411, 101, -1, true));
        animalList.add(new Task1.Animal("klarkent", Task1.Animal.Type.BIRD, Task1.Animal.Sex.F, 4, -100, 12301, true));
        animalList.add(new Task1.Animal("voleyboleydubdibub", Task1.Animal.Type.CAT, Task1.Animal.Sex.F, 9, 105, 4, false));
        animalList.add(new Task1.Animal("vacok", Task1.Animal.Type.BIRD, null, -123, 103, 2, true));
        animalList.add(new Task1.Animal("mikukakuliris", null, Task1.Animal.Sex.F, 734, 107, -6, false));

        // when
        var errors = Task1.stringFindErrors(animalList);

        //then
        assertEquals("the animal's height is incorrect, the animal's age is incorrect", errors.get("aboba"));
        assertEquals("animal type is null", errors.get("tarakanus"));
        assertEquals("the animal's age is incorrect, the animal's weight is incorrect", errors.get("gigabituson"));
        assertEquals("the animal's height is incorrect, the animal's weight is incorrect", errors.get("klarkent"));
        assertEquals("", errors.get("voleyboleydubdibub"));
        assertEquals("animal sex is null, the animal's age is incorrect", errors.get("vacok"));
        assertEquals("animal type is null, the animal's age is incorrect, the animal's weight is incorrect", errors.get("mikukakuliris"));
    }
}
