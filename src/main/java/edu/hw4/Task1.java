package edu.hw4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class Task1 {
    private Task1() {
    }

    public record Animal(
        String name,
        Type type,
        Sex sex,
        int age,
        int height,
        int weight,
        boolean bites
    ) {
        public enum Type {
            CAT, DOG, BIRD, FISH, SPIDER
        }

        public enum Sex {
            M, F
        }

        @SuppressWarnings("MagicNumber")
        public int paws() {
            return switch (type) {
                case CAT, DOG -> 4;
                case BIRD -> 2;
                case FISH -> 0;
                case SPIDER -> 8;
            };
        }
    }

    public record ValidationError(String field) {
    }

    public static class CompByHeight implements Comparator<Animal> {
        @Override
        public int compare(Animal o1, Animal o2) {
            return o1.height - o2.height;
        }
    }

    public static class CompByWeight implements Comparator<Animal> {
        @Override
        public int compare(Animal o1, Animal o2) {
            return o1.weight - o2.weight;
        }
    }

    public static class CompByAge implements Comparator<Animal> {
        @Override
        public int compare(Animal o1, Animal o2) {
            return o2.age - o1.age;
        }
    }

    public static class CompBySex implements Comparator<Animal> {
        private static int determineSex(Animal elem) {
            Animal.Sex[] sexes = {Animal.Sex.F, Animal.Sex.M};
            for (int i = 0; i < 2; ++i) {
                if (sexes[i] == elem.sex) {
                    return i;
                }
            }
            return -1;
        }

        @Override
        public int compare(Animal o1, Animal o2) {
            return determineSex(o1) - determineSex(o2);
        }
    }

    public static class CompByType implements Comparator<Animal> {
        private static int determineType(Animal elem) {
            Animal.Type[] types =
                {Animal.Type.CAT, Animal.Type.DOG, Animal.Type.BIRD, Animal.Type.FISH, Animal.Type.SPIDER};
            for (int i = 0; i < 2; ++i) {
                if (types[i] == elem.type) {
                    return i;
                }
            }
            return -1;
        }

        @Override
        public int compare(Animal o1, Animal o2) {
            return determineType(o1) - determineType(o2);
        }
    }

    public static class CompByName implements Comparator<Animal> {
        @Override
        public int compare(Animal o1, Animal o2) {
            return o1.name.compareTo(o2.name);
        }
    }

    public static List<Animal> sortByHeight(List<Animal> list) {
        list.sort(new CompByHeight());
        return list;
    }

    public static List<Animal> getKHeaviest(List<Animal> list, int k) {
        list.sort(new CompByWeight());
        return list.subList(0, k);
    }

    public static Map<Animal.Type, Integer> classifyByType(List<Animal> list) {
        Map<Animal.Type, Integer> animalMap = new HashMap<>();
        for (Animal animal : list) {
            Animal.Type nextType = animal.type();
            if (animalMap.containsKey(nextType)) {
                animalMap.put(nextType, animalMap.get(nextType) + 1);
            } else {
                animalMap.put(nextType, 1);
            }
        }
        return animalMap;
    }

    public static Animal getAnimalWithLongestName(List<Animal> list) {
        ListIterator<Animal> animalItr = list.listIterator();
        Animal animalWithLongestName = animalItr.next();
        while (animalItr.hasNext()) {
            Animal nextAnimal = animalItr.next();
            if (nextAnimal.name.length() > animalWithLongestName.name.length()) {
                animalWithLongestName = nextAnimal;
            }
        }
        return animalWithLongestName;
    }

    public static Animal.Sex getFrequentSex(List<Animal> list) {
        ListIterator<Animal> animalItr = list.listIterator();
        int m = 0;
        int f = 0;
        while (animalItr.hasNext()) {
            if (animalItr.next().sex == Animal.Sex.M) {
                ++m;
            } else {
                ++f;
            }
        }
        if (m > f) {
            return Animal.Sex.M;
        }
        return Animal.Sex.F;
    }

    public static Map<Animal.Type, Animal> getHeaviestTypes(List<Animal> list) {
        Map<Animal.Type, Animal> animalMap = new HashMap<>();
        for (Animal nextAnimal : list) {
            if (animalMap.containsKey(nextAnimal.type)) {
                if (nextAnimal.weight > animalMap.get(nextAnimal.type).weight) {
                    animalMap.put(nextAnimal.type, nextAnimal);
                }
            } else {
                animalMap.put(nextAnimal.type, nextAnimal);
            }
        }
        return animalMap;
    }

    public static Animal getAnimalKByAge(List<Animal> list, int k) {
        list.sort(new CompByAge());
        return list.get(k);
    }

    public static Optional<Animal> getHeaviestShorterK(List<Animal> list, int k) {
        list.sort(new CompByHeight());
        var binSearch = Collections.binarySearch(
            list,
            new Animal(null, null, null, 0, k - 1, 0, false),
            new CompByHeight()
        );
        if (binSearch == -1) {
            return Optional.empty();
        }
        if (binSearch < 0) {
            binSearch = list.size() - 1;
        }
        ListIterator<Animal> animalItr = list.listIterator();
        Animal animalHeaviestShorterK = animalItr.next();
        int i = 1;
        while (animalItr.hasNext() && i <= binSearch) {
            Animal nextAnimal = animalItr.next();
            if (nextAnimal.weight > animalHeaviestShorterK.weight) {
                animalHeaviestShorterK = nextAnimal;
            }
            ++i;
        }
        return Optional.ofNullable(animalHeaviestShorterK);
    }

    public static int sumPaws(List<Animal> list) {
        int paws = 0;
        for (Animal animal : list) {
            paws += animal.paws();
        }
        return paws;
    }

    public static List<Animal> getAgeNotEqualPawsAnimals(List<Animal> list) {
        List<Task1.Animal> animalList = new ArrayList<>();
        for (Animal animal : list) {
            if (animal.age != animal.paws()) {
                animalList.add(animal);
            }
        }
        return animalList;
    }

    public static List<Animal> getBitesHigher100(List<Animal> list) {
        List<Task1.Animal> animalList = new ArrayList<>();
        for (Animal animal : list) {
            if (animal.height > 100 && animal.bites) {
                animalList.add(animal);
            }
        }
        return animalList;
    }

    public static List<Animal> getAnimalWeightMoreThanHeight(List<Animal> list) {
        List<Task1.Animal> animalList = new ArrayList<>();
        for (Animal animal : list) {
            if (animal.weight > animal.height) {
                animalList.add(animal);
            }
        }
        return animalList;
    }

    public static List<Animal> getAnimalMoreThanTwoWords(List<Animal> list) {
        List<Task1.Animal> animalList = new ArrayList<>();
        for (Animal animal : list) {
            if (animal.name.split(" ", -1).length > 2) {
                animalList.add(animal);
            }
        }
        return animalList;
    }

    public static Boolean hasDogHigherK(List<Animal> list, int k) {
        for (Animal animal : list) {
            if (animal.type.equals(Animal.Type.DOG) && animal.height > k) {
                return true;
            }
        }
        return false;
    }

    public static Map<Animal.Type, Integer> sumWeightFromKToL(List<Animal> list, int k, int l) {
        Map<Animal.Type, Integer> animalMap = new HashMap<>();
        for (Animal nextAnimal : list) {
            if (animalMap.containsKey(nextAnimal.type) && nextAnimal.age >= k && nextAnimal.age <= l) {
                animalMap.put(nextAnimal.type, animalMap.get(nextAnimal.type) + nextAnimal.weight);
            } else if (nextAnimal.age >= k && nextAnimal.age <= l) {
                animalMap.put(nextAnimal.type, nextAnimal.weight);
            }
        }
        return animalMap;
    }

    public static List<Animal> sortByTypeSexName(List<Animal> list) {
        list.sort(new CompByType());
        list.sort(new CompBySex());
        list.sort(new CompByName());
        return list;
    }

    public static Boolean isSpiderBitMoreOftenThanDogs(List<Animal> list) {
        int bitsDogs = 0;
        int bitsSpiders = 0;
        for (Animal animal : list) {
            if (animal.type.equals(Animal.Type.DOG) && animal.bites) {
                ++bitsDogs;
            }
            if (animal.type.equals(Animal.Type.SPIDER) && animal.bites) {
                ++bitsSpiders;
            }
        }
        return bitsSpiders > bitsDogs;
    }

    @SafeVarargs public static Animal getHeaviestFish(List<Animal>... lists) {
        Animal heaviestFish = null;
        for (List<Animal> list : lists) {
            for (Animal animal : list) {
                if (animal.type == Animal.Type.FISH && (heaviestFish == null || animal.weight > heaviestFish.weight)) {
                    heaviestFish = animal;
                }
            }
        }
        return heaviestFish;
    }

    public static Map<String, Set<ValidationError>> findErrors(List<Animal> list) {
        Map<String, Set<ValidationError>> errorsMap = new HashMap<>();
        for (Animal animal : list) {
            errorsMap.put(animal.name, new HashSet<>());
            if (animal.type == null) {
                errorsMap.get(animal.name).add(new ValidationError("animal type is null"));
            }
            if (animal.sex == null) {
                errorsMap.get(animal.name).add(new ValidationError("animal sex is null"));
            }
            if (animal.age < 0 || animal.age > 40) {
                errorsMap.get(animal.name).add(new ValidationError("the animal's age is incorrect"));
            }
            if (animal.height < 0 || animal.height > 400) {
                errorsMap.get(animal.name).add(new ValidationError("the animal's height is incorrect"));
            }
            if (animal.weight < 0 || animal.weight > 200) {
                errorsMap.get(animal.name).add(new ValidationError("the animal's weight is incorrect"));
            }
        }
        return errorsMap;
    }

    public static Map<String, String> stringFindErrors(List<Animal> list) {
        Map<String, String> stringErrorsMap = new HashMap<>();
        var errors = findErrors(list);
        for (Map.Entry<String, Set<ValidationError>> entry : errors.entrySet()) {
            StringBuilder animalErrors = new StringBuilder();
            for (ValidationError error : entry.getValue()) {
                animalErrors.append(error.field).append(", ");
            }
            stringErrorsMap.put(entry.getKey(), animalErrors.toString());
        }
        return stringErrorsMap;
    }
}
