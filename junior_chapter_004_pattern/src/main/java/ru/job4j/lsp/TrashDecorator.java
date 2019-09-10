package ru.job4j.lsp;

public class TrashDecorator extends Trash {
    private Reproduct reproduct;
    public TrashDecorator(Reproduct reproduct) {
        this.reproduct = reproduct;
    }

    @Override
    public boolean add(String key, Food food) {
        FoodDecorator foodDecorator = (FoodDecorator) food;
        return foodDecorator.isCanReproduct() ? this.reproduct.add(key, foodDecorator) : super.add(key, foodDecorator);
    }
}
