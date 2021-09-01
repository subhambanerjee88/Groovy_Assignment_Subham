class TopPlayers {
    static def getTopBatsman (ArrayList playerList, int numberOfValuesToReturn) {
        def sortedPlayerList = playerList.sort({m1, m2 -> m1.battingScore <=> m2.battingScore}).reverse()
        String topBatsmanNames = 'Batsman'
        int i = 0
        while (i < numberOfValuesToReturn) {
            if (!topBatsmanNames) {
                topBatsmanNames = sortedPlayerList[i].name
            } else {
                topBatsmanNames = topBatsmanNames.concat(" ${sortedPlayerList[i].name}")
            }
            i++;
        }
        return topBatsmanNames
    }

    static def getTopBowler (ArrayList playerList, int numberOfValuesToReturn) {
        def sortedPlayerList = playerList.sort({m1, m2 -> m1.bowlingScore <=> m2.bowlingScore}).reverse()
        String topBowlerNames = 'Bowler'
        int i = 0
        while (i < numberOfValuesToReturn) {
            if (!topBowlerNames) {
                topBowlerNames = sortedPlayerList[i].name
            } else {
                topBowlerNames = topBowlerNames.concat(" ${sortedPlayerList[i].name}")
            }
            i++;
        }
        return topBowlerNames
    }

    static def getTopAllrounder (ArrayList playerList, int numberOfValuesToReturn) {
        def sortedPlayerList = playerList.sort({m1, m2 -> m1.allrounderScore <=> m2.allrounderScore}).reverse()
        String topAllrounderNames = 'Allrounder'
        int i = 0
        while (i < numberOfValuesToReturn) {
            if (!topAllrounderNames) {
                topAllrounderNames = sortedPlayerList[i].name
            } else {
                topAllrounderNames = topAllrounderNames.concat(" ${sortedPlayerList[i].name}")
            }
            i++;
        }
        return topAllrounderNames
    }
}
