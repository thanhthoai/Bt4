package category;

import java.util.List;
import shop.Shop;


public class Category {
        private String nameCategory;
        private List<Shop> shops;

        public Category(String nameCategory, List<Shop> shops) {
            this.nameCategory = nameCategory;
            this.shops = shops;
        }

        public String getNameCategory() {
            return nameCategory;
        }

        public void setNameCategory(String nameCategory) {
            this.nameCategory = nameCategory;
        }

        public List<Shop> getShops() {
            return shops;
        }

        public void setShops(List<Shop> shops) {
            this.shops = shops;
        }
    }

