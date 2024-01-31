class Solution {
    public int solution(int chicken) {
        int coupon = chicken;
        int addCoupon = 0;
        int service = 0;
        while(coupon >= 10){
            service+= coupon/10;
            coupon = (int)coupon/10 + coupon%10;
        }
        return service;
    }
}