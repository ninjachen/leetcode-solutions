package rocks.ninjachen.leet_code_contest.bi_12;

import java.util.*;

class Leaderboard {
    // id, score
    Map<Integer, Integer> scoreMap = new HashMap<>();
    // score, set of ids
    Map<Integer, Set<Integer>> topMap = new HashMap<>();

    public Leaderboard() {

    }

    public void addScore(int playerId, int score) {
        int oldscore = scoreMap.getOrDefault(playerId, 0);
        int newscore = oldscore + score;
        scoreMap.put(playerId, newscore);
        topMap.putIfAbsent(oldscore, new HashSet<>());
        topMap.get(oldscore).remove(playerId);
        topMap.putIfAbsent(newscore, new HashSet<>());
        topMap.get(newscore).add(playerId);
    }

    public int top(int K) {
        int scoreSum = 0;
        int count = 0;
        List<Integer> scores = new ArrayList<>(topMap.keySet());
        Collections.sort(scores);
        // reserve visit
        for(int i = scores.size() - 1; i > 0; i--) {
            int score = scores.get(i);
            Set<Integer> playerIds = topMap.get(score);
            for(Integer id : playerIds) {
                count++;
                scoreSum += score;
                if(count == K) {
                    return scoreSum;
                }
            }
        }
        return scoreSum;
    }

    public void reset(int playerId) {
        int score = scoreMap.getOrDefault(playerId, 0);
        scoreMap.put(playerId, 0);
        Set<Integer> ids = topMap.get(score);
        if(ids != null) {
            ids.remove(playerId);
        }
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */