public class Search_2D {
    public static void main(String [] args){
        int [][] arr={{1,3,5,7},{10,11,16,20},{23,30,34,60}};

        System.out.println(searchMatrix(arr,30));
    }
    public boolean searchMatrix(int[][] matrix, int target) {

        int i=0;
        int j=matrix[0].length-1;

        while(i < matrix.length  && j >= 0 ){
            int mid=matrix[i][j];

            if(mid==target){
                return true;
            }

            if(mid > target){
                j--;
            }

            if(mid < target){
                i++;
            }
        }
        return false;
    }
}