package ru.job4j.lsp;

public class TrashDecorator extends Trash {
    private Reproduct reproduct;

    public TrashDecorator(Reproduct reproduct) {
        this.reproduct = reproduct;
    }

    public boolean add(String key, FoodDecorator food) {
        return food.isCanReproduct() ? this.reproduct.add(key, food) : super.add(key, food);
    }
}
