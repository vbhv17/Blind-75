class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        // Bruteforce : For Every element, iterate over the array and calculate the product of all elements, exclude self
        // {1, 2, 3, 4}
        
        int n = nums.length;

        int result[] = new int[n];
        
        for(int i = 0; i<n ; i++){
            int product = 1;
            for(int j = 0; j<n; j++){
                if(i!=j)                    //exclude self from product
                    product = product*nums[j];
            }

            result[i] = product;
        }

        return result;

/*
        Approach 2: Using Division 

        Approach : If we know the product of the entire array, we can simply divide this product by nums[i], at every i to get the answer
                    But if we have zeroes in the array,
                    1. In case of 1 zero in the array, total product would be 0, product at the zeros place would be product of entire array without including zero (product without zero)
                    2. In case of multiple zeroes in the array, total product would be 0, product at non zero element would be 0,
                    product at zero element would be
                        -> product without zero (if there is only one zero in the array)
                        -> 0 (if there are more than 1 zeroes in the array)

                    So we iterate once and calculate total product, count of zeroes, product without zeroes and then build our result array on the basis of above conditions

*/
        //Code: 
        
        int n = nums.length;

        int total_product = 1;
        int product_without_zero = 1;
        int count_of_zeroes = 0;

        for(int x : nums){
            if(x==0){
                count_of_zeroes++;
                total_product = 0;
            }
            else{
                total_product = total_product * x;
                product_without_zero = product_without_zero * x;
            }
        }

        int result[] = new int[n];

        for(int i = 0; i<n; i++){
            if(nums[i] == 0){
                if(count_of_zeroes>1){ //there is one more zero in the array which will make product 0
                    result[i] = 0;
                }
                else{
                    result[i] = product_without_zero; //there is only one zero in the array so result will be product_without_zero
                }
            }
            else{
                if(count_of_zeroes>0){ //for non zero element if atleast one zero is present then result will be 0
                    result[i] = 0;
                }
                else{
                    result[i] = total_product/nums[i]; //if no zeroes are present in the array
                }

            }
        }

        return result;


        /*Approach 3: 
        At every element, if we somehow know the total product at its left and also the total product at its right, we can multiply these two and find the result at i
        So, we precompute the left and right product in seperate arrays and build the result 
        */
        int n = nums.length;
        int left[] = new int[n];
        int right[] = new int[n];
        int result[] = new int[n];

        for(int i= 0; i<n; i++){
            
            if(i==0){
                left[i] = 1;  //nothing at left of first element, so we take 1
                continue;
            }

            left[i] = nums[i-1] * left[i-1];
        }

        for(int i = n-1; i>=0; i--){
            if(i==n-1){
                right[i] = 1; //nothing at right of last element, so we take 1
                continue;
            }

            right[i] = nums[i+1] * right[i+1];

        }

        for(int i=0 ; i<n; i++){
            result[i] = left[i] * right[i];
        }

        return result;


        /*
        Optimizing above approach 3:
        We are using two arrays left and right so SC is O(n), we want to do this in place
        Approach : We keep the left product in result array itself and then keep a right product variable and calculate our result at each i
        */
        int n = nums.length;
        int result[] = new int[n];

        for(int i = 0; i<n; i++){ //calculating left product and storing in result[i]
            if(i==0){
                result[i] = 1;
                continue;
            }

            result[i] = nums[i-1] * result[i-1];
        }

        int rp = 1; //right_product

        for(int i = n-1; i>=0; i--){
            if(i==n-1){
                result[i] = result[i] * rp;
                continue;
            }

            rp = rp*nums[i+1];  //calculating right product and multiplying with result[i] which is left product
            result[i] = result[i] * rp;
        }

        return result;

    }
}
