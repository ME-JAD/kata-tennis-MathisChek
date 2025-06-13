
public class TennisGame1 implements TennisGame {

    public static final int SCORE_MAX = 4;

    public static final int LOVE_EQUALITY = 0;
    public static final int FIFTEEN_EQUALITY = 1;
    public static final int THIRTY_EQUALITY = 2;

    public static final int EARNING_POINT = 1;
    public static final int NO_POINT = 0;
    public static final int FIRST_POINT = 1;
    public static final int SECOND_POINT = 2;
    public static final int LAST_POINT = 3;

    private int player1_score = 0;
    private int player2_score = 0;

    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            player1_score += EARNING_POINT;
        else
            player2_score += EARNING_POINT;
    }

    public String getScore() {
        String score = "";
        int tempScore=0;
        if (player1_score == player2_score) {
            return getEqualScore(player1_score);
        } else if (isStateOfAdvantage(player1_score, player2_score)) {
            return getAdvantageScore(player1_score, player2_score);
        } else {
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = player1_score;
                else { score+="-"; tempScore = player2_score;}
                score += getPlayerScore(tempScore);
            }
        }
        return score;
    }

    public String getEqualScore(int player_score) {
        String result = "";
        switch (player_score)
        {
            case LOVE_EQUALITY:
                result = "Love-All";
                return result;
            case FIFTEEN_EQUALITY:
                result = "Fifteen-All";
                return result;
            case THIRTY_EQUALITY:
                result = "Thirty-All";
                return result;
            default:
                result = "Deuce";
                return result;
        }
    }

    public boolean isStateOfAdvantage(int player1Score, int player2Score) {
        return player1_score >= SCORE_MAX || player2_score >= SCORE_MAX;
    }

    public String getAdvantageScore(int player1Score, int player2Score) {
        int minusResult = player1_score - player2_score;
        switch (minusResult)
        {
            case 1:
                return "Advantage player1";
            case -1:
                return "Advantage player2";
            default:
                return (minusResult >= 2) ? "Win for player1" : "Win for player2";
        }
    }

    public String getPlayerScore(int playerScore) {
        switch(playerScore)
        {
            case NO_POINT:
                return "Love";
            case FIRST_POINT:
                return "Fifteen";
            case SECOND_POINT:
                return "Thirty";
            case LAST_POINT:
                return "Forty";
        }
        return "";
    }
}