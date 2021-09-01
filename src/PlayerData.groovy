class PlayerData {
    def getPlayersData () {
        // Reading Data from File
        String inputFilePath = "/home/tracxn-lp-458/IdeaProjects/Groovy_Assignment_Subham/src/Document/PlayerPositionInput"
        File playerInputFile = new File(inputFilePath)
        def playerData = playerInputFile as String[]

        // Creating MAP for Position
        def positionMap = [:]
        def positionData = playerData[0].split('=')[1].split(',')
        for (position in positionData) {
            positionMap.put(position.toLowerCase(), position)
        }

        // Creating MAP for Position and Vacancy
        def playersVacancyMap = [:]
        def vacancyDetails = playerData[1].split(',')
        for (vacancy in vacancyDetails) {
            def vacancyData = vacancy.split('=');
            playersVacancyMap.put(vacancyData[0].toLowerCase(), vacancyData[1])
        }

        // Player Count
        def playerCount = playerData[2].split('=')[1]

        // Creating MAP for Player Details
        def playerDetailList = []
        int i = 3;
        while (i < playerData.length) {
            def player = playerData[i].split(',')
            def playerDetails = [:]
            playerDetails.put('name', player[0])
            playerDetails.put('position', player[1])
            playerDetails.put('battingAvg', player[2])
            playerDetails.put('battingSR', player[3])
            playerDetails.put('bowlingAvg', player[4])
            playerDetails.put('bowlingSR', player[5])
            playerDetails.put('battingScore', CalculateScore.getBattingScore(
                    Utils.getDataInDoubleFormat(player[2]),
                    Utils.getDataInDoubleFormat(player[3])
            ))
            playerDetails.put('bowlingScore', CalculateScore.getBowlingScore(
                    Utils.getDataInDoubleFormat(player[4]),
                    Utils.getDataInDoubleFormat(player[5])
            ))
            playerDetails.put('allrounderScore', CalculateScore.getAllrounderScore(
                    Utils.getDataInDoubleFormat(player[2]),
                    Utils.getDataInDoubleFormat(player[3]),
                    Utils.getDataInDoubleFormat(player[4]),
                    Utils.getDataInDoubleFormat(player[5])
            ))
            playerDetailList.add(playerDetails)
            i++
        }

        // Selecting top players for each position

        // Separating players Position wise
        def batsmanDetailList = []
        def bowlerDetailList = []
        def allrounderDetailList = []
        playerDetailList.each { it ->
            if (it.position == 'Batsman') {
                batsmanDetailList.add(it)
            } else  if (it.position == 'Bowler') {
                bowlerDetailList.add(it)
            } else if (it.position == 'Allrounder') {
                allrounderDetailList.add(it)
            }
        }

        // Selecting Top Batsman
        String topBatsman = TopPlayers.getTopBatsman(batsmanDetailList, Utils.getDataInIntegerFormat(playersVacancyMap.batsman))

        // Selecting Top Bowler
        String topBowler = TopPlayers.getTopBowler(bowlerDetailList, Utils.getDataInIntegerFormat(playersVacancyMap.bowler))

        // Selecting Top Allrounder
        String topAllrounder = TopPlayers.getTopAllrounder(allrounderDetailList, Utils.getDataInIntegerFormat(playersVacancyMap.allrounder))

        // Concatenating All Results
        String result = "${topBatsman}\n${topBowler}\n${topAllrounder}"
        // Writing Data to File
        String outputFilePath = "/home/tracxn-lp-458/IdeaProjects/Groovy_Assignment_Subham/src/Document/PlayerPositionOutput"
        File playerOutputFile = new File(outputFilePath)
        playerOutputFile.text = result
    }
}