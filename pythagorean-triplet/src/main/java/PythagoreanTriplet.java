import java.util.ArrayList;
import java.util.List;

class PythagoreanTriplet {
    private int a,b,c;
    PythagoreanTriplet(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    static TripletListBuilder makeTripletsList() {
        return new TripletListBuilder();
    }

    public boolean equals(Object o){
        if(this == o){
            return true;
        }else if(o instanceof PythagoreanTriplet){
            PythagoreanTriplet pt = (PythagoreanTriplet)o;
            return a == pt.a && b == pt.b && c == pt.c;
        }else {
            return  false;
        }
    }

    static class TripletListBuilder {
        private int sum;
        private int maxFactor = Integer.MAX_VALUE;
        private List<PythagoreanTriplet> triplets;
        TripletListBuilder thatSumTo(int sum) {
            this.sum = sum;
            return this;
        }

        TripletListBuilder withFactorsLessThanOrEqualTo(int maxFactor) {
            this.maxFactor = maxFactor;
            return this;
        }


        List<PythagoreanTriplet> build() {
            triplets = new ArrayList<PythagoreanTriplet>();
            for (int i = 1; i <= sum/3;i++){
                for (int j = i+1; j <= sum/2;j++){
                    int k = sum-i-j;
                    if ( i<= maxFactor && j <= maxFactor && k <= maxFactor && i < j && j < k )
                        if ( i*i + j*j == k*k ){
                            triplets.add(new PythagoreanTriplet(i,j,k));
                        }
                }
            }
            return triplets;
        }

    }

}