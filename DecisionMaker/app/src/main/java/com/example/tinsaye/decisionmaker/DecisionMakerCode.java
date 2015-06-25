package com.example.tinsaye.decisionmaker;
import java.util.*;
/**
 * Created by Tinsaye on 6/1/2015.
 * This is my side project
 */
public class DecisionMakerCode {
    private ArrayList<String> decisionList;
    private Random rand;
    private int count = 0;
    public DecisionMakerCode()
    {
        decisionList = new ArrayList<>();
        rand = new Random();
    }
    public void storeDecision(String input)
    {
            decisionList.add(input);
            count++;
    }
    public String chooseDecision(int size)
    {
        int index = rand.nextInt(size);
        return decisionList.get(index);
    }
    public int getSize()
    {
        return count;
    }
}
