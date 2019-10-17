package wayfair;

import java.util.*;

/*
Exercise Goals:
 
    - The goal of this exercise is to sh‍‍‍‌‍‌‍‍‌‌‍‍‌‌‍‌ow us how you apply software engineering
    principles to create a maintainable software solution.
 
    How to approach this:
 
            - Don't worry about persistence. It would make sense here, but for this
            exercise only use in-memory data structures.
            - Don't worry about tricks or "gotchyas", as there aren't any.
            - Just focus on writing clean maintainable code.
 
 
 
Specification:
 
    Create a class LeaderBoard whose interface includes the following methods:
 
    Method Name: add_score
 
        - Add a new score to the player's average. If a player doesn't exist in the
        LeaderBoard, they will be automatically added.
 
        Args:
 
                player_id (Integer): The player's ID.
                score (Integer): The score to record for the player
 
        Returns:
 
                Double: The new average score for the given player
 
    Method Name: top
 
        - Get the top player_ids on the leaderboard ordered by their average scores
        from highest to lowest
 
        Args:
 
                num_players (Integer): The maximum number of player_ids to return
 
        Returns:
 
                List<Integer>: a list of player_ids
 
    Method Name: reset
 
        - Removes any scoring information for a player, effectively
        resetting them to 0
 
        Args:
 
                player_id (Integer): The player's ID.
 
Example Usage:
 
 
    // Create a new LeaderBoard Instance
    LeaderBoard leader_board = new LeaderBoard();
 
    // Add scores for players to the LeaderBoard
    leader_board.add_score(1, 50); // 50.0
    leader_board.add_score(2, 80); // 80.0
    leader_board.add_score(2, 70); // 75.0
    leader_board.add_score(2, 60); // 70.0
    leader_board.add_score(3, 90); // 90.0
    leader_board.add_score(3, 85); // 87.5
 
    // Get top positions for the leaderboard
    leader_board.top(3); // [3, 2, 1]
    leader_board.top(2); // [3, 2]
    leader_board.top(1); // [3]
 
    // Reset a player 3's scores
    leader_board.reset(3); // void
 
    // Player 3 is now at the bottom of the leaderboard
    leader_board.top(3); // [2, 1, 3]
 
Expected values
 
    - Player IDs will always be positive integers small enough to be
    stored as a signed 32-bit integer Scores are integers ranging from 0-100
 
 
We have provided stubbed out code and tests for you below. Please note that these tests are not exhaustive and do not cover all corner cases. We recommend extending the given tests to ensure your code is correct.
*/
public class Solution {
    static class LeaderBoard {
        PriorityQueue<player> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.average_score < o2.average_score) {
                return 1;
            } else if (o1.average_score > o2.average_score)
                return -1;
            else
                return 0;
        });

        class player {
            int player_id;
            int num_score = 0;
            int total_score = 0;
            double average_score = 0;

            public player(int player_id) {
                this.player_id = player_id;
            }
        }

        public List<Integer> top(Integer max) {
            List<Integer> res = new LinkedList<>();
            PriorityQueue<player> copy = new PriorityQueue<>(pq);
            for (int i = 0; i < max; i++) {
                if(copy.peek() !=null) {
                    res.add(copy.poll().player_id);
                }
            }
            return res;
        }

        public void reset(Integer player_id) {
            for (player p : pq) {
                if (p.player_id == player_id) {
                    p.average_score =0;
                    p.num_score = 0;
                    p.total_score =0;
                    return;
                }
            }
        }

        public double add_score(int player_id, int score) {
            for (player p : pq) {
                if (p.player_id == player_id) {
                    p.num_score++;
                    p.total_score += score;
                    p.average_score = (double) (p.total_score) / p.num_score;
                    return p.average_score;
                }
            }
            player p = new player(player_id);
            p.num_score++;
            p.total_score += score;
            p.average_score = (double) (p.total_score) / p.num_score;
            pq.add(p);
            return p.average_score;
        }
    }

    public static void main(String[] args) {
        LeaderBoard leaderBoard = new LeaderBoard();
        System.out.println(leaderBoard.add_score(1, 50) == 50);
        System.out.println(leaderBoard.add_score(2, 80) == 80);
        System.out.println(leaderBoard.add_score(2, 70) == 75);
        System.out.println(leaderBoard.add_score(2, 60) == 70);
        System.out.println(leaderBoard.add_score(3, 90) == 90);
        System.out.println(leaderBoard.add_score(3, 85) == 87.5);

        System.out.println(leaderBoard.top(3));
        System.out.println(leaderBoard.top(2));
        System.out.println(leaderBoard.top(1));


        System.out.println(leaderBoard.top(3).equals(Arrays.asList(3, 2, 1)));
        System.out.println(leaderBoard.top(2).equals(Arrays.asList(3, 2)));

        leaderBoard.reset(3);
        System.out.println(leaderBoard.top(3));
        System.out.println(leaderBoard.top(3).equals(Arrays.asList(2, 1, 3)));
    }
}