package ru.job4j.lsp;

public class ControlQuality {
    private final double limLeft = 25.0f;
    private final double limRight = 75.0f;
    private final double limTrash = 100.0f;
    private final Shop shop;
    private final Warehouse warehouse;
    private final Trash trash;

    public ControlQuality() {
        this.trash = new Trash();
        this.shop = new Shop();
        this.warehouse = new Warehouse();
    }
    public ControlQuality(Shop shop, Warehouse warehouse, Trash trash) {
        this.shop = shop;
        this.warehouse = warehouse;
        this.trash = trash;
    }

    public void put(String key, Food food) {

        if(food != null) {
            long exp = valid(food);
            if (exp < limLeft) {
                warehouse.add(key, food);
            } else if (exp >= limLeft && exp <= limRight) {
                shop.add(key, food);
            } else if (exp >= limTrash) {
                trash.add(key, food);
            } else if (exp > limRight) {
                food.changeDisscount(50);
                shop.add(key, food);
            }
        }
    }

    private long valid(Food food) {
        long create = food.createDate().getTime();
        return  (System.currentTimeMillis() - create) * 100 / (food.expaireDate().getTime() - create);
    }

    public Trash trash() {
        return this.trash;
    }

    public Shop shop() {
        return this.shop;
    }

    public Warehouse warehouse() {
        return this.warehouse;
    }
}
