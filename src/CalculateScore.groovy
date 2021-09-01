class CalculateScore {
    static def getBowlingScore (double bowlingAvg, double bowlingSR) {
        if (bowlingAvg && bowlingSR) {
            return (1000 / (bowlingAvg * bowlingSR)).round(2)
        }
        return 0;
    }

    static def getBattingScore (double battingAvg, double battingSR) {
        if (battingAvg && battingSR) {
            return (battingAvg * battingSR).round(2)
        }
        return 0;
    }

    static def getAllrounderScore (double battingAvg, double battingSR, double bowlingAvg, double bowlingSR) {
        if (battingAvg && battingSR && bowlingAvg && bowlingSR) {
            return ((battingAvg * battingSR *1000) / (bowlingAvg * bowlingSR)).round(2)
        }
        return 0;
    }

}
