package ru.netology.domain;

import ru.netology.repository.ProductRepository;

public class ProductManager {

    //    Разработайте менеджера, который умеет добавлять Product'ы в репозиторий и
//    осуществлять поиск по ним.
//    Для этого вам нужно создать класс, конструктор которого будет принимать параметром репозиторий,
//    а также с методом publiс void add(Product product) и методом поиска
    private ProductRepository repo;

    protected ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public void add(Product product) {
        repo.save(product);
    }

    public Product[] findAll() {
        return repo.getProducts();
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product : repo.findAll()) {
            if (product.matches(text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }
}


