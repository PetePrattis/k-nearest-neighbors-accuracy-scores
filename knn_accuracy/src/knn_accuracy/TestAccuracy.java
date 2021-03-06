package knn_accuracy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;
import java.util.Collections;
import java.util.Random;

public class TestAccuracy {

public static int[][] ratings = new int[20][65];
static int correct=0;
static int zeroes=0;

	public static void main(String[] args){
		int[][] ratings = {                 
                {5,3,1,5,1,1,1,3,5,2,3,4,3,3,4,2,2,4,4,1,2,2,5,1,5,4,1,2,3,4,4,5,5,4,5,4,2,1,2,4,4,2,3,5,4,1,2,3,3,5,3,2,4,3,3,3,5,5,2,1,3,2,5,2,5}, 
                {5,2,2,3,5,5,1,3,2,5,1,5,4,1,5,5,4,4,2,5,5,5,3,3,1,4,2,4,3,1,4,2,4,5,2,4,2,1,4,1,4,2,2,1,3,5,4,5,3,2,2,4,3,3,3,5,1,2,5,3,2,1,2,1,4}, 
                {2,2,2,2,2,5,3,4,4,1,4,2,5,2,1,4,2,2,3,1,1,4,5,2,5,4,4,2,2,1,1,1,4,4,2,3,2,4,2,2,4,3,4,3,5,5,5,5,5,2,1,1,5,3,2,1,2,5,5,3,1,5,3,5,4}, 
                {3,5,2,4,3,4,5,5,1,1,5,4,5,1,5,5,5,4,2,4,2,4,1,5,1,1,5,4,5,5,1,1,4,4,4,4,1,5,2,1,4,5,5,1,1,4,3,3,2,5,4,5,3,2,5,4,5,2,4,4,5,1,4,3,3}, 
                {2,4,4,3,4,3,3,3,3,5,5,1,4,2,3,4,2,5,4,5,1,5,1,2,2,3,4,4,3,4,1,5,3,2,5,5,2,1,1,4,3,2,2,2,5,1,2,4,4,5,1,3,2,3,2,5,2,5,4,2,4,4,4,4,1},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,3,0,0,0,0,0,0,0,0,0,0},
                {3,1,5,3,3,4,5,3,1,2,2,1,1,1,2,2,2,3,1,2,2,4,2,1,5,2,5,4,3,1,3,1,3,1,3,5,1,1,2,5,2,2,4,2,1,1,5,3,4,5,5,3,1,3,2,3,4,1,2,3,4,1,4,3,5}, 
                {1,5,2,2,5,3,5,1,2,2,1,2,2,5,5,4,3,3,4,4,4,3,1,5,2,1,2,2,5,1,5,1,1,2,1,1,5,4,1,5,2,5,5,3,2,4,5,1,4,3,2,4,5,1,1,5,4,4,1,1,1,3,2,3,1},
                {5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5},
                {1,2,2,1,5,3,5,5,5,5,3,2,5,1,5,1,5,2,2,1,5,3,2,4,2,5,2,2,1,4,2,5,3,4,2,1,5,1,2,5,1,4,4,2,4,2,2,2,3,2,5,4,3,2,4,1,1,3,4,3,2,4,1,3,3},
                {2,4,1,2,4,2,5,1,5,4,3,1,2,3,3,1,2,1,1,1,5,2,2,3,3,3,5,1,4,4,3,4,4,1,3,5,4,5,3,1,3,1,5,1,5,4,2,1,2,5,3,5,1,2,1,5,2,3,5,1,1,4,5,5,1},
                {5,2,3,4,3,4,2,1,1,1,2,3,5,3,4,4,4,3,5,4,2,1,3,1,2,5,1,3,3,1,2,5,2,5,4,2,3,1,4,4,1,3,4,1,3,4,3,5,2,4,5,3,1,1,2,3,3,2,1,4,3,3,1,2,2}, 
                {1,5,2,2,5,3,5,1,2,2,1,2,2,5,5,4,3,3,4,4,4,3,1,5,2,1,2,2,5,1,5,1,1,2,1,1,5,4,1,5,2,5,5,3,2,4,5,1,4,3,2,4,5,1,1,5,4,4,1,1,1,3,2,3,1},
                {5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5},
                {1,2,2,1,5,3,5,5,5,5,3,2,5,1,5,1,5,2,2,1,5,3,2,4,2,5,2,2,1,4,2,5,3,4,2,1,5,1,2,5,1,4,4,2,4,2,2,2,3,2,5,4,3,2,4,1,1,3,4,3,2,4,1,3,3},
                {2,4,1,2,4,2,5,1,5,4,3,1,2,3,3,1,2,1,1,1,5,2,2,3,3,3,5,1,4,4,3,4,4,1,3,5,4,5,3,1,3,1,5,1,5,4,2,1,2,5,3,5,1,2,1,5,2,3,5,1,1,4,5,5,1},
                {5,2,3,4,3,4,2,1,1,1,2,3,5,3,4,4,4,3,5,4,2,1,3,1,2,5,1,3,3,1,2,5,2,5,4,2,3,1,4,4,1,3,4,1,3,4,3,5,2,4,5,3,1,1,2,3,3,2,1,4,3,3,1,2,2}, 
                {1,5,2,2,5,3,5,1,2,2,1,2,2,5,5,4,3,3,4,4,4,3,1,5,2,1,2,2,5,1,5,1,1,2,1,1,5,4,1,5,2,5,5,3,2,4,5,1,4,3,2,4,5,1,1,5,4,4,1,1,1,3,2,3,1},
                {5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5},
                {1,2,2,1,5,3,5,5,5,5,3,2,5,1,5,1,5,2,2,1,5,3,2,4,2,5,2,2,1,4,2,5,3,4,2,1,5,1,2,5,1,4,4,2,4,2,2,2,3,2,5,4,3,2,4,1,1,3,4,3,2,4,1,3,3},
                {2,4,1,2,4,2,5,1,5,4,3,1,2,3,3,1,2,1,1,1,5,2,2,3,3,3,5,1,4,4,3,4,4,1,3,5,4,5,3,1,3,1,5,1,5,4,2,1,2,5,3,5,1,2,1,5,2,3,5,1,1,4,5,5,1},
                {5,2,3,4,3,4,2,1,1,1,2,3,5,3,4,4,4,3,5,4,2,1,3,1,2,5,1,3,3,1,2,5,2,5,4,2,3,1,4,4,1,3,4,1,3,4,3,5,2,4,5,3,1,1,2,3,3,2,1,4,3,3,1,2,2},
                {1,2,2,1,5,3,5,5,5,5,3,2,5,1,5,1,5,2,2,1,5,3,2,4,2,5,2,2,1,4,2,5,3,4,2,1,5,1,2,5,1,4,4,2,4,2,2,2,3,2,5,4,3,2,4,1,1,3,4,3,2,4,1,3,3},
                {2,4,1,2,4,2,5,1,5,4,3,1,2,3,3,1,2,1,1,1,5,2,2,3,3,3,5,1,4,4,3,4,4,1,3,5,4,5,3,1,3,1,5,1,5,4,2,1,2,5,3,5,1,2,1,5,2,3,5,1,1,4,5,5,1},
                {5,2,3,4,3,4,2,1,1,1,2,3,5,3,4,4,4,3,5,4,2,1,3,1,2,5,1,3,3,1,2,5,2,5,4,2,3,1,4,4,1,3,4,1,3,4,3,5,2,4,5,3,1,1,2,3,3,2,1,4,3,3,1,2,2}, 
                {1,5,2,2,5,3,5,1,2,2,1,2,2,5,5,4,3,3,4,4,4,3,1,5,2,1,2,2,5,1,5,1,1,2,1,1,5,4,1,5,2,5,5,3,2,4,5,1,4,3,2,4,5,1,1,5,4,4,1,1,1,3,2,3,1},
                {5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5},
                {1,2,2,1,5,3,5,5,5,5,3,2,5,1,5,1,5,2,2,1,5,3,2,4,2,5,2,2,1,4,2,5,3,4,2,1,5,1,2,5,1,4,4,2,4,2,2,2,3,2,5,4,3,2,4,1,1,3,4,3,2,4,1,3,3},
                {2,4,1,2,4,2,5,1,5,4,3,1,2,3,3,1,2,1,1,1,5,2,2,3,3,3,5,1,4,4,3,4,4,1,3,5,4,5,3,1,3,1,5,1,5,4,2,1,2,5,3,5,1,2,1,5,2,3,5,1,1,4,5,5,1},
                {1,2,2,1,5,3,5,5,5,5,3,2,5,1,5,1,5,2,2,1,5,3,2,4,2,5,2,2,1,4,2,5,3,4,2,1,5,1,2,5,1,4,4,2,4,2,2,2,3,2,5,4,3,2,4,1,1,3,4,3,2,4,1,3,3},
                {2,4,1,2,4,2,5,1,5,4,3,1,2,3,3,1,2,1,1,1,5,2,2,3,3,3,5,1,4,4,3,4,4,1,3,5,4,5,3,1,3,1,5,1,5,4,2,1,2,5,3,5,1,2,1,5,2,3,5,1,1,4,5,5,1},
                {5,2,3,4,3,4,2,1,1,1,2,3,5,3,4,4,4,3,5,4,2,1,3,1,2,5,1,3,3,1,2,5,2,5,4,2,3,1,4,4,1,3,4,1,3,4,3,5,2,4,5,3,1,1,2,3,3,2,1,4,3,3,1,2,2}, 
                {1,5,2,2,5,3,5,1,2,2,1,2,2,5,5,4,3,3,4,4,4,3,1,5,2,1,2,2,5,1,5,1,1,2,1,1,5,4,1,5,2,5,5,3,2,4,5,1,4,3,2,4,5,1,1,5,4,4,1,1,1,3,2,3,1},
                {5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5},
                {1,2,2,1,5,3,5,5,5,5,3,2,5,1,5,1,5,2,2,1,5,3,2,4,2,5,2,2,1,4,2,5,3,4,2,1,5,1,2,5,1,4,4,2,4,2,2,2,3,2,5,4,3,2,4,1,1,3,4,3,2,4,1,3,3},
                {2,4,1,2,4,2,5,1,5,4,3,1,2,3,3,1,2,1,1,1,5,2,2,3,3,3,5,1,4,4,3,4,4,1,3,5,4,5,3,1,3,1,5,1,5,4,2,1,2,5,3,5,1,2,1,5,2,3,5,1,1,4,5,5,1},
                {1,2,2,1,5,3,5,5,5,5,3,2,5,1,5,1,5,2,2,1,5,3,2,4,2,5,2,2,1,4,2,5,3,4,2,1,5,1,2,5,1,4,4,2,4,2,2,2,3,2,5,4,3,2,4,1,1,3,4,3,2,4,1,3,3},
                {2,4,1,2,4,2,5,1,5,4,3,1,2,3,3,1,2,1,1,1,5,2,2,3,3,3,5,1,4,4,3,4,4,1,3,5,4,5,3,1,3,1,5,1,5,4,2,1,2,5,3,5,1,2,1,5,2,3,5,1,1,4,5,5,1},
                {5,2,3,4,3,4,2,1,1,1,2,3,5,3,4,4,4,3,5,4,2,1,3,1,2,5,1,3,3,1,2,5,2,5,4,2,3,1,4,4,1,3,4,1,3,4,3,5,2,4,5,3,1,1,2,3,3,2,1,4,3,3,1,2,2}, 
                {1,5,2,2,5,3,5,1,2,2,1,2,2,5,5,4,3,3,4,4,4,3,1,5,2,1,2,2,5,1,5,1,1,2,1,1,5,4,1,5,2,5,5,3,2,4,5,1,4,3,2,4,5,1,1,5,4,4,1,1,1,3,2,3,1},
                {5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5},
                {1,2,2,1,5,3,5,5,5,5,3,2,5,1,5,1,5,2,2,1,5,3,2,4,2,5,2,2,1,4,2,5,3,4,2,1,5,1,2,5,1,4,4,2,4,2,2,2,3,2,5,4,3,2,4,1,1,3,4,3,2,4,1,3,3},
                {2,4,1,2,4,2,5,1,5,4,3,1,2,3,3,1,2,1,1,1,5,2,2,3,3,3,5,1,4,4,3,4,4,1,3,5,4,5,3,1,3,1,5,1,5,4,2,1,2,5,3,5,1,2,1,5,2,3,5,1,1,4,5,5,1},
                {1,2,2,1,5,3,5,5,5,5,3,2,5,1,5,1,5,2,2,1,5,3,2,4,2,5,2,2,1,4,2,5,3,4,2,1,5,1,2,5,1,4,4,2,4,2,2,2,3,2,5,4,3,2,4,1,1,3,4,3,2,4,1,3,3},
                {2,4,1,2,4,2,5,1,5,4,3,1,2,3,3,1,2,1,1,1,5,2,2,3,3,3,5,1,4,4,3,4,4,1,3,5,4,5,3,1,3,1,5,1,5,4,2,1,2,5,3,5,1,2,1,5,2,3,5,1,1,4,5,5,1},
                {5,2,3,4,3,4,2,1,1,1,2,3,5,3,4,4,4,3,5,4,2,1,3,1,2,5,1,3,3,1,2,5,2,5,4,2,3,1,4,4,1,3,4,1,3,4,3,5,2,4,5,3,1,1,2,3,3,2,1,4,3,3,1,2,2}, 
                {1,5,2,2,5,3,5,1,2,2,1,2,2,5,5,4,3,3,4,4,4,3,1,5,2,1,2,2,5,1,5,1,1,2,1,1,5,4,1,5,2,5,5,3,2,4,5,1,4,3,2,4,5,1,1,5,4,4,1,1,1,3,2,3,1},
                {5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5},
                {1,2,2,1,5,3,5,5,5,5,3,2,5,1,5,1,5,2,2,1,5,3,2,4,2,5,2,2,1,4,2,5,3,4,2,1,5,1,2,5,1,4,4,2,4,2,2,2,3,2,5,4,3,2,4,1,1,3,4,3,2,4,1,3,3},
                {2,4,1,2,4,2,5,1,5,4,3,1,2,3,3,1,2,1,1,1,5,2,2,3,3,3,5,1,4,4,3,4,4,1,3,5,4,5,3,1,3,1,5,1,5,4,2,1,2,5,3,5,1,2,1,5,2,3,5,1,1,4,5,5,1},
                {1,2,2,1,5,3,5,5,5,5,3,2,5,1,5,1,5,2,2,1,5,3,2,4,2,5,2,2,1,4,2,5,3,4,2,1,5,1,2,5,1,4,4,2,4,2,2,2,3,2,5,4,3,2,4,1,1,3,4,3,2,4,1,3,3},
                {2,4,1,2,4,2,5,1,5,4,3,1,2,3,3,1,2,1,1,1,5,2,2,3,3,3,5,1,4,4,3,4,4,1,3,5,4,5,3,1,3,1,5,1,5,4,2,1,2,5,3,5,1,2,1,5,2,3,5,1,1,4,5,5,1},
                {5,2,3,4,3,4,2,1,1,1,2,3,5,3,4,4,4,3,5,4,2,1,3,1,2,5,1,3,3,1,2,5,2,5,4,2,3,1,4,4,1,3,4,1,3,4,3,5,2,4,5,3,1,1,2,3,3,2,1,4,3,3,1,2,2}, 
                {1,5,2,2,5,3,5,1,2,2,1,2,2,5,5,4,3,3,4,4,4,3,1,5,2,1,2,2,5,1,5,1,1,2,1,1,5,4,1,5,2,5,5,3,2,4,5,1,4,3,2,4,5,1,1,5,4,4,1,1,1,3,2,3,1},
                {5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5},
                {1,2,2,1,5,3,5,5,5,5,3,2,5,1,5,1,5,2,2,1,5,3,2,4,2,5,2,2,1,4,2,5,3,4,2,1,5,1,2,5,1,4,4,2,4,2,2,2,3,2,5,4,3,2,4,1,1,3,4,3,2,4,1,3,3},
                {2,4,1,2,4,2,5,1,5,4,3,1,2,3,3,1,2,1,1,1,5,2,2,3,3,3,5,1,4,4,3,4,4,1,3,5,4,5,3,1,3,1,5,1,5,4,2,1,2,5,3,5,1,2,1,5,2,3,5,1,1,4,5,5,1},
                {1,2,2,1,5,3,5,5,5,5,3,2,5,1,5,1,5,2,2,1,5,3,2,4,2,5,2,2,1,4,2,5,3,4,2,1,5,1,2,5,1,4,4,2,4,2,2,2,3,2,5,4,3,2,4,1,1,3,4,3,2,4,1,3,3},
                {2,4,1,2,4,2,5,1,5,4,3,1,2,3,3,1,2,1,1,1,5,2,2,3,3,3,5,1,4,4,3,4,4,1,3,5,4,5,3,1,3,1,5,1,5,4,2,1,2,5,3,5,1,2,1,5,2,3,5,1,1,4,5,5,1},
                {5,2,3,4,3,4,2,1,1,1,2,3,5,3,4,4,4,3,5,4,2,1,3,1,2,5,1,3,3,1,2,5,2,5,4,2,3,1,4,4,1,3,4,1,3,4,3,5,2,4,5,3,1,1,2,3,3,2,1,4,3,3,1,2,2}, 
                {1,5,2,2,5,3,5,1,2,2,1,2,2,5,5,4,3,3,4,4,4,3,1,5,2,1,2,2,5,1,5,1,1,2,1,1,5,4,1,5,2,5,5,3,2,4,5,1,4,3,2,4,5,1,1,5,4,4,1,1,1,3,2,3,1},
                {5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5},
                {1,2,2,1,5,3,5,5,5,5,3,2,5,1,5,1,5,2,2,1,5,3,2,4,2,5,2,2,1,4,2,5,3,4,2,1,5,1,2,5,1,4,4,2,4,2,2,2,3,2,5,4,3,2,4,1,1,3,4,3,2,4,1,3,3},
                {2,4,1,2,4,2,5,1,5,4,3,1,2,3,3,1,2,1,1,1,5,2,2,3,3,3,5,1,4,4,3,4,4,1,3,5,4,5,3,1,3,1,5,1,5,4,2,1,2,5,3,5,1,2,1,5,2,3,5,1,1,4,5,5,1},
                {1,2,2,1,5,3,5,5,5,5,3,2,5,1,5,1,5,2,2,1,5,3,2,4,2,5,2,2,1,4,2,5,3,4,2,1,5,1,2,5,1,4,4,2,4,2,2,2,3,2,5,4,3,2,4,1,1,3,4,3,2,4,1,3,3},
                {2,4,1,2,4,2,5,1,5,4,3,1,2,3,3,1,2,1,1,1,5,2,2,3,3,3,5,1,4,4,3,4,4,1,3,5,4,5,3,1,3,1,5,1,5,4,2,1,2,5,3,5,1,2,1,5,2,3,5,1,1,4,5,5,1},
                {5,2,3,4,3,4,2,1,1,1,2,3,5,3,4,4,4,3,5,4,2,1,3,1,2,5,1,3,3,1,2,5,2,5,4,2,3,1,4,4,1,3,4,1,3,4,3,5,2,4,5,3,1,1,2,3,3,2,1,4,3,3,1,2,2}, 
                {1,5,2,2,5,3,5,1,2,2,1,2,2,5,5,4,3,3,4,4,4,3,1,5,2,1,2,2,5,1,5,1,1,2,1,1,5,4,1,5,2,5,5,3,2,4,5,1,4,3,2,4,5,1,1,5,4,4,1,1,1,3,2,3,1},
                {5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5},
                {1,2,2,1,5,3,5,5,5,5,3,2,5,1,5,1,5,2,2,1,5,3,2,4,2,5,2,2,1,4,2,5,3,4,2,1,5,1,2,5,1,4,4,2,4,2,2,2,3,2,5,4,3,2,4,1,1,3,4,3,2,4,1,3,3},
                {2,4,1,2,4,2,5,1,5,4,3,1,2,3,3,1,2,1,1,1,5,2,2,3,3,3,5,1,4,4,3,4,4,1,3,5,4,5,3,1,3,1,5,1,5,4,2,1,2,5,3,5,1,2,1,5,2,3,5,1,1,4,5,5,1},
                {1,2,2,1,5,3,5,5,5,5,3,2,5,1,5,1,5,2,2,1,5,3,2,4,2,5,2,2,1,4,2,5,3,4,2,1,5,1,2,5,1,4,4,2,4,2,2,2,3,2,5,4,3,2,4,1,1,3,4,3,2,4,1,3,3},
                {2,4,1,2,4,2,5,1,5,4,3,1,2,3,3,1,2,1,1,1,5,2,2,3,3,3,5,1,4,4,3,4,4,1,3,5,4,5,3,1,3,1,5,1,5,4,2,1,2,5,3,5,1,2,1,5,2,3,5,1,1,4,5,5,1},
                {5,2,3,4,3,4,2,1,1,1,2,3,5,3,4,4,4,3,5,4,2,1,3,1,2,5,1,3,3,1,2,5,2,5,4,2,3,1,4,4,1,3,4,1,3,4,3,5,2,4,5,3,1,1,2,3,3,2,1,4,3,3,1,2,2}, 
                {1,5,2,2,5,3,5,1,2,2,1,2,2,5,5,4,3,3,4,4,4,3,1,5,2,1,2,2,5,1,5,1,1,2,1,1,5,4,1,5,2,5,5,3,2,4,5,1,4,3,2,4,5,1,1,5,4,4,1,1,1,3,2,3,1},
                {5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5},
                {1,2,2,1,5,3,5,5,5,5,3,2,5,1,5,1,5,2,2,1,5,3,2,4,2,5,2,2,1,4,2,5,3,4,2,1,5,1,2,5,1,4,4,2,4,2,2,2,3,2,5,4,3,2,4,1,1,3,4,3,2,4,1,3,3},
                {2,4,1,2,4,2,5,1,5,4,3,1,2,3,3,1,2,1,1,1,5,2,2,3,3,3,5,1,4,4,3,4,4,1,3,5,4,5,3,1,3,1,5,1,5,4,2,1,2,5,3,5,1,2,1,5,2,3,5,1,1,4,5,5,1},
                {1,2,2,1,5,3,5,5,5,5,3,2,5,1,5,1,5,2,2,1,5,3,2,4,2,5,2,2,1,4,2,5,3,4,2,1,5,1,2,5,1,4,4,2,4,2,2,2,3,2,5,4,3,2,4,1,1,3,4,3,2,4,1,3,3},
                {2,4,1,2,4,2,5,1,5,4,3,1,2,3,3,1,2,1,1,1,5,2,2,3,3,3,5,1,4,4,3,4,4,1,3,5,4,5,3,1,3,1,5,1,5,4,2,1,2,5,3,5,1,2,1,5,2,3,5,1,1,4,5,5,1},
                {5,2,3,4,3,4,2,1,1,1,2,3,5,3,4,4,4,3,5,4,2,1,3,1,2,5,1,3,3,1,2,5,2,5,4,2,3,1,4,4,1,3,4,1,3,4,3,5,2,4,5,3,1,1,2,3,3,2,1,4,3,3,1,2,2}, 
                {1,5,2,2,5,3,5,1,2,2,1,2,2,5,5,4,3,3,4,4,4,3,1,5,2,1,2,2,5,1,5,1,1,2,1,1,5,4,1,5,2,5,5,3,2,4,5,1,4,3,2,4,5,1,1,5,4,4,1,1,1,3,2,3,1},
                {5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5},
                {1,2,2,1,5,3,5,5,5,5,3,2,5,1,5,1,5,2,2,1,5,3,2,4,2,5,2,2,1,4,2,5,3,4,2,1,5,1,2,5,1,4,4,2,4,2,2,2,3,2,5,4,3,2,4,1,1,3,4,3,2,4,1,3,3},
                {2,4,1,2,4,2,5,1,5,4,3,1,2,3,3,1,2,1,1,1,5,2,2,3,3,3,5,1,4,4,3,4,4,1,3,5,4,5,3,1,3,1,5,1,5,4,2,1,2,5,3,5,1,2,1,5,2,3,5,1,1,4,5,5,1}

              };
		
				
		Scanner scan = new Scanner(System.in);
		System.out.println("Choose k: ");
		int k = scan.nextInt();
		//System.out.println(num);
		
		System.out.println("Choose test size between: 0-" + (ratings.length-1));
		int test_size = scan.nextInt();
		
		scan.close();
		
		ArrayList<Integer> user = new ArrayList<Integer>();
		ArrayList<Integer> suser = new ArrayList<Integer>(); //sorted
		ArrayList<Double> sim = new ArrayList<Double>();
		ArrayList<Double> ssim = new ArrayList<Double>(); //sorted 
		
		Random r = new Random();
		int [][] y_test = new int[test_size][ratings[0].length]; //real values of QUERY DATA. test_size, 65
		int [][] X_test = new int[test_size][ratings[0].length]; //QUERY DATA , test_size, 65
		int rnd=0,i,j;
		
		
		//y_test & X_test
		for (i=0;i<test_size;i++) { //for 3,4 sublists 
			rnd=r.nextInt(ratings.length-1); //random sublist
			for (j=0;j<ratings[0].length;j++) { //for 65 elements in sublists
				y_test[i][j] = ratings[rnd][j]; //for any k sublist copy and paste its 65 elements
				
				//ratings
	    		X_test[i][j] = ratings[rnd][j]; //simultaneous copy of y_test
	    		//System.out.println("OLD: " + y_test[i][j]);
			}
			ratings = removeElement(ratings,rnd);
			
		}
		System.out.println("y_test");
		System.out.println(Arrays.deepToString(y_test));
		

		System.out.println("NEW ratings without y_test");
		System.out.println(Arrays.deepToString(ratings));
		
		System.out.println("X_test");
		System.out.println(Arrays.deepToString(X_test));
		
		
		//X_test = y_test.clone();
		int percent90_y_test= 9*y_test[0].length/10;
		
		System.out.println("90% y_test");
		System.out.println(percent90_y_test);
		
		ArrayList<Integer> rndNum = new ArrayList<Integer>();
		//System.out.println(percent90_y_test);
		
		System.out.println("y test length");
		System.out.println(y_test.length);
		
		for (i=0;i<y_test[0].length;i++)
		{
			rndNum.add(i);
		}
		Collections.shuffle(rndNum);
		
		System.out.println("rndNum");
		System.out.println(rndNum);
		
		
		for (i=0;i<y_test.length;i++) //for each sublist
		{
			//int times=0;
			for (j=0;j<percent90_y_test;j++) //for 90% of y_test, for each item in a sublist (65)
			{//randomly choose some cells and set them 0
				
				X_test[i][rndNum.get(j)] = 0;
			}
		}
		
		System.out.println("X_test with 0's");
		System.out.println(Arrays.deepToString(X_test));
		
		System.out.println("X_test length");
		System.out.println(X_test.length);
		for (int test_i=0;test_i<test_size;test_i++) { //for test elements (4)
			for(int train_i=0; train_i<ratings.length; train_i++) {	//for every rating of the TRAIN DATASET
				//X_test = query values, ratings compare with X_test, train_i elements of ratings (1-1), test_i elemetns of X_test to compare
				//for RATING DATASET EUCL, COSINE
				//euclideanDist(ratings, num, i, user, sim, ssim);
				cosineSimilarity(ratings,X_test,train_i,test_i,user,sim,ssim); //calculate cosine similarity for all data of TEST DATASET which is the X_test
			
			}
		

		Collections.sort(ssim, Collections.reverseOrder());
	    
	    int remove = ssim.size() - k;
	    for (i =0; i<remove;i++) {
	    	ssim.remove(ssim.size()-1); //i want k users to remain
	    }
	    boolean once = true;
	    for (i=0; i<ssim.size(); i++) {
	    	for (j=0; j<sim.size(); j++) {
	    		if(Math.floor(ssim.get(i)*10000) == Math.floor(sim.get(j)*10000) && once && !suser.contains(user.get(j))) { // x10000 to display enough digits places to match
	    			once = false; 
	    			suser.add(user.get(j));
	    		}
	    	}
	    	once = true; 
	    }
	    
	    System.out.println(user);
	    System.out.println(sim);
	    System.out.println(suser);
	    System.out.println(ssim);
	    
	    //double[] recommended = new double[ratings[0].length];

    	ArrayList <Double> recommended = new ArrayList<Double>();
    	//ArrayList <String> recommended_name = new ArrayList<String>();
    	double weightedSum = 0; 
	    double similaritySum = 0;
	    
	    for(i=0; i<ratings[0].length; i++) {
	    	for(j=0; j<ratings.length-1; j++) {
	    		//if(ssim.contains(sim.get(j))) {
	    		if(suser.contains(user.get(j))) {
	    			if(X_test[test_i][i] == 0) { 
	    				weightedSum += ratings[j][i]*sim.get(j); 
	    				//System.out.println(user.get(j)+","+sim.get(j));
	    				similaritySum += sim.get(j);
	    			}
	    		}
	    		
	    	}
	    	if(weightedSum == 0) {
	    		double d = X_test[test_i][i]; 
	    		recommended.add(d);
	    		//when we already have rating we dont consider the prediction correct!
	    		correct-=1;
	    		
	    		//recommended[i] = d;
	    	}
	    	else {
		    	weightedSum /= similaritySum;
		    	recommended.add(weightedSum);
		    	//recommended[i] = weightedSum;
	    	}
	    	weightedSum=0;
	    	similaritySum=0;
	    }

	    correct+= accuracyScore(test_size,X_test,y_test,recommended);
	    //System.out.println(String.valueOf(accuracyScore(test_size,X_test,y_test,recommended)));

	    user.clear();
	    sim.clear();
	    suser.clear();
	    ssim.clear();
	    
		}
	    System.out.println(correct);
	    System.out.println(zeroes);
	    double ans = 8/27;
	    System.out.println(String.format("%.2f", ans));
	}
	
	
	public static int accuracyScore(int test_size,int [][] X_test,int [][] y_test,ArrayList <Double> recommended) {
		int i,j;
		
		//check if 90% is zeroes
		for (i=0;i<X_test.length;i++)
		{
			for (j=0;j<X_test[0].length;j++)
			{
				if (X_test[i][j] == 0)
					zeroes++;
			}
			//System.out.println("For " +i + " there are  " + zeroes + " zeroes");
		}
		
		
		
		
		int correct=0;
	    for (i=0;i<y_test.length;i++) //sublists 4
	    {
	    	for (j=0;j<y_test[0].length;j++) //content 65
	    	{
	    		if (Math.round(recommended.get(j)) == y_test[i][j] )
	    			correct++;
	    		//System.out.println("Predicted: " + Math.round(recommended.get(j)) + ", True: " + y_test[i][j] ); }//prediction}
	    		
	    	}
	    	
	    }
	    
	    return correct;
	    //return correct/(X_test[0].length*test_size);
	    
	}

	
	public static void cosineSimilarity(int [][] ratings,int[][] X_test, int train_i, int test_i, ArrayList<Integer> user,ArrayList<Double> sim,ArrayList<Double> ssim)
	{

		double sumProduct = 0;
		double sumASq = 0;
		double sumBSq = 0;
		double similarity;
		
		for(int j=0; j<ratings[0].length; j++) { 
			if(X_test[test_i][j]!=0 && ratings[train_i][j]!=0) { 
				sumProduct += X_test[test_i][j]*ratings[train_i][j];
				sumASq += X_test[test_i][j]*X_test[test_i][j];
				sumBSq += ratings[train_i][j] * ratings[train_i][j];
				}
		}
		if (sumASq == 0 && sumBSq == 0) {
			similarity = 0.0;
		}
		else {
			similarity = sumProduct / (Math.sqrt(sumASq) * Math.sqrt(sumBSq));
			//System.out.println("TEST user: "+test_i+" has similarity to TRAIN user: "+ train_i+" of value "+similarity);
		}
		
		
		user.add(train_i);
		sim.add(similarity);
		ssim.add(similarity);
		
	}
	
	public static int[][] removeElement(int[][] ratings, int rnd)
	{
		if (ratings == null || rnd <0 || rnd >= ratings.length)
			return ratings;
		int[][] rat2 = new int[ratings.length-1][ratings[0].length];
		
		//System.out.println(ratings[0].length);
		int k=0;
		for (int i=0;i<ratings.length;i++) {
			for (int j=0;j<ratings[0].length;j++)
			{
				if (i != rnd)
				{
					rat2[k][j] = ratings[i][j];
				}
			}
			if (i != rnd)
				k++;
		}

		//System.out.println("I: "+rat2.length);
		//System.out.println("J: "+rat2[0].length);
		return rat2;
		
	}
	
}