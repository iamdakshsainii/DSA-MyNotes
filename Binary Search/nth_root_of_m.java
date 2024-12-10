//                                  ****** Problem Statement *********

// You are given 2 numbers (n , m); the task is to find n√m (nth root of m).
// Input: n = 2, m = 9
// Output: 3
// Explanation: 3^2 = 9

//                                        >>>>>Learning <<<<<<<<<
                                    //    Power function niklna sikha


//                              *********** Approch (1 method)*************

// >phle ek function lenge power niklene k liye
// >ab dusre function m loop chalenge and check from 1 to m for answer

                            //    *********** Code *************

class nth_root_of_m
{
    public int NthRoot(int n, int m)
    {
     
      for(int i=1;i<=m;i++){
          if(power(i,n)==m){
              return i;
          }
          if(power(i,n)>m) break;
      }
      return -1;
    }
        int power(int base, int exp){
            int ans=1;
            
            while(exp>0 ){
                if(exp %2==1){
                    ans=ans*base;
                    exp-=1;
                }
                else{
                    exp=exp/2;
                    base=base*base;
                }
            }
            return ans;
        }
}
