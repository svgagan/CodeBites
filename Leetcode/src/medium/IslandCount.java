package medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 200. Number of Islands
 *
 * Write a function, island_count, that takes in a grid containing Ws and Ls. W represents water and L represents land.
 * The function should return the number of islands on the grid. An island is a vertically or horizontally connected region of land.
 *
 * */
public class IslandCount {

    public static class Pair {
        int firstIndex;
        int secondIndex;

        public Pair(int firstIndex, int secondIndex) {
            this.firstIndex = firstIndex;
            this.secondIndex = secondIndex;
        }
    }

    public int numIslands(char[][] region) {
        int islandCount = 0;
        if(region.length < 1 || region[0].length < 1) {
            return islandCount;
        }

        int rows = region.length;
        int columns = region[0].length;
        Set<String> visitedPositionSet = new HashSet<>();

        for(int r=0; r<rows; r++) {
            for(int c=0; c<columns; c++){
                if(region[r][c] == 'L' && !visitedPositionSet.contains(r + "," + c)) {
                    searchConnectedLandsUsingBFS(region, r, c, visitedPositionSet);
                    islandCount +=1;
                }
            }
        }
        return islandCount;
    }

    private void searchConnectedLandsUsingBFS(char[][] region, int r, int c, Set<String> visitedPositionSet) {
        visitedPositionSet.add(r + "," + c);
        Queue<Pair> positions = new LinkedList<>();
        positions.add(new Pair(r,c));
        int[] rowDir = {0, 1, -1, 0};
        int[] colDir = {1, 0, 0, -1};
        while(!positions.isEmpty()) {

            Pair poll = positions.poll();
            int pollRow = poll.firstIndex;
            int pollColumn = poll.secondIndex;

            for(int i=0; i<4; i++) {
                int adjRow = pollRow + rowDir[i];
                int adjCol = pollColumn + colDir[i];

                if(isIndexesValid(adjRow, adjCol, region) && region[adjRow][adjCol] == 'L' &&  !visitedPositionSet.contains(adjRow + "," + adjCol)) {
                    positions.add(new Pair(adjRow,adjCol));
                    visitedPositionSet.add(adjRow + "," + adjCol);
                }
            }
        }
    }

    private boolean isIndexesValid(int adjRow, int adjCol, char[][] region) {
        if(adjRow < 0 || adjCol < 0 || adjRow >= region.length || adjCol >= region[0].length){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        char [][] region = {{'L', 'L', 'W'}, {'L', 'W', 'W'}, {'L', 'L', 'W'}}; //1
        char [][] region2 = {{'L', 'L', 'W', 'W', 'W'}, {'L', 'L', 'W', 'W', 'W'}, {'W', 'W', 'L', 'W', 'W'}, {'W', 'W', 'W', 'L', 'L'}}; //3
        char [][] region3 = {{'L', 'L', 'L', 'L', 'W'}, {'L', 'L', 'W', 'L', 'W'}, {'L', 'L', 'W', 'W', 'W'}, {'W', 'W', 'W', 'W', 'W'}}; //1
        char [][] region4 = {{'L', 'L', 'W'}, {'L', 'W', 'L'}, {'W', 'L', 'W'}}; //3
        char [][] region5 = {{'L', 'L', 'W', 'L', 'W'}, {'L', 'L', 'L', 'W', 'L'}, {'L', 'W', 'L', 'L', 'W'}, {'L', 'L', 'L', 'W', 'L'}}; //4
        IslandCount islandCount = new IslandCount();
        System.out.println(islandCount.numIslands(region));
        System.out.println(islandCount.numIslands(region2));
        System.out.println(islandCount.numIslands(region3));
        System.out.println(islandCount.numIslands(region4));
        System.out.println(islandCount.numIslands(region5));
    }
}