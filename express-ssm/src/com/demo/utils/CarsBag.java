package com.demo.utils;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by
 */
public class CarsBag {
    public static int bagCap = 600;//背包容量
    public static int bagCount = 50;//物品数量
    public static CarsBag[][] carsBags = null;
    public List<BagItem> Items = new ArrayList<BagItem>();// 包里的物品集合
    CarsBag() {
    }
    int geCap() {// 包中物品的总重量
        Double value = 0.0;
        for (BagItem item : Items) {
            value += item.cap;
        }
        return value.intValue();
    }
    public String toString() {
        return String.valueOf(this.geCap()) + " ";
    }
    public static void init(int cap, int bagCount) {
        CarsBag.bagCap = cap;
        CarsBag.bagCount = bagCount;
        carsBags = new CarsBag[bagCount + 1][bagCap + 1];
        for (int i = 0; i < bagCap + 1; i++) {
            carsBags[0][i] = new CarsBag();
        }
        for (int i = 0; i < bagCount + 1; i++) {
            carsBags[i][0] = new CarsBag();
        }
    }
    public static CarsBag doBag(int cap, BagItem[] sourceItems) {
        init(cap, sourceItems.length);
        for (int iItem = 1; iItem <= bagCount; iItem++) {//容量
            for (int curBagSize = 1; curBagSize <= bagCap; curBagSize++) {//重量
                carsBags[iItem][curBagSize] = new CarsBag();
                if (sourceItems[iItem - 1].cap > curBagSize) {// 当前物品大于包空间.肯定不能放入包中.
                    carsBags[iItem][curBagSize].Items.addAll(carsBags[iItem - 1][curBagSize].Items);
                } else {
                    if(carsBags[iItem - 1] != null){
                        int notIncludeValue = carsBags[iItem - 1][curBagSize].geCap();// 不放当前物品包的体积
                        int freeSize = curBagSize - sourceItems[iItem - 1].cap.intValue();// 放当前物品包剩余空间
                        int includeValue = sourceItems[iItem - 1].cap.intValue() + carsBags[iItem - 1][freeSize].geCap();// 当前物品价值+放了当前物品后剩余包空间能放物品的价值
                        if (notIncludeValue < includeValue) {// 放了价值更大就放入.
                            carsBags[iItem][curBagSize].Items.addAll(carsBags[iItem - 1][freeSize].Items);
                            carsBags[iItem][curBagSize].Items.add(sourceItems[iItem - 1]);
                        } else {// 否则不放入当前物品
                            carsBags[iItem][curBagSize].Items.addAll(carsBags[iItem - 1][curBagSize].Items);
                        }
                    }
                }
            }
        }
        return carsBags[bagCount][bagCap];
    }
}
