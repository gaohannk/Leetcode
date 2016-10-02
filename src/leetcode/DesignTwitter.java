package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/*Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:

postTweet(userId, tweetId): Compose a new tweet.
getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
follow(followerId, followeeId): Follower follows a followee.
unfollow(followerId, followeeId): Follower unfollows a followee.
Example:

Twitter twitter = new Twitter();

// User 1 posts a new tweet (id = 5).
twitter.postTweet(1, 5);

// User 1's news feed should return a list with 1 tweet id -> [5].
twitter.getNewsFeed(1);

// User 1 follows user 2.
twitter.follow(1, 2);

// User 2 posts a new tweet (id = 6).
twitter.postTweet(2, 6);

// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
twitter.getNewsFeed(1);

// User 1 unfollows user 2.
twitter.unfollow(1, 2);

// User 1's news feed should return a list with 1 tweet id -> [5],
// since user 1 is no longer following user 2.
twitter.getNewsFeed(1);
*/
public class DesignTwitter {
	public static class Twitter {
		HashMap<Integer, LinkedList<Integer>> follow = new HashMap<>();
		HashMap<Integer, LinkedList<Integer>> tweet = new HashMap<>();
		int globalStamp;
		HashMap<Integer, Integer> map = new HashMap<>();

		/** Initialize your data structure here. */
		public Twitter() {
			globalStamp = 0;
		}

		/** Compose a new tweet. */
		public void postTweet(int userId, int tweetId) {
			if (!tweet.containsKey(userId)) {
				LinkedList<Integer> tweetList = new LinkedList<Integer>();
				tweetList.add(globalStamp);
				tweet.put(userId, tweetList);
			} else {
				tweet.get(userId).add(globalStamp);
			}
			map.put(globalStamp, tweetId);
			globalStamp++;
		}

		/**
		 * Retrieve the 10 most recent tweet ids in the user's news feed. Each
		 * item in the news feed must be posted by users who the user followed
		 * or by the user herself. Tweets must be ordered from most recent to
		 * least recent.
		 */
		public List<Integer> getNewsFeed(int userId) {
			List<Integer> feed = new LinkedList<>();
			HashSet<Integer> user = new HashSet<>();
			user.add(userId);
			if (follow.get(userId) != null) {
				for (Integer userid : follow.get(userId)) {
					user.add(userid);
				}
			}
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					if (o1 - o2 < 0)
						return 1;
					else if (o1 > o2)
						return -1;
					return 0;
				}
			});
			// HashMap<Integer, LinkedList<Integer>> tweetDup = new
			// HashMap<>(tweet);
			for (int i = 1; i <= 10; i++) {
				for (Integer u : user) {
					if (tweet.get(u) == null)
						continue;
					int num = tweet.get(u).size();
					if (num - i < 0)
						continue;
					pq.add(tweet.get(u).get(num - i));
				}
			}
			int num = 10;
			while (pq.peek() != null || num > 0) {
				feed.add(map.get(pq.poll()));
				num--;
			}
			return feed;
		}

		/**
		 * Follower follows a followee. If the operation is invalid, it should
		 * be a no-op.
		 */
		public void follow(int followerId, int followeeId) {
			if (!follow.containsKey(followerId)) {
				LinkedList<Integer> followee = new LinkedList<Integer>();
				followee.add(followeeId);
				follow.put(followerId, followee);
			} else {
				if (!follow.get(followerId).contains(followeeId))
					follow.get(followerId).add(followeeId);
			}
		}

		/**
		 * Follower unfollows a followee. If the operation is invalid, it should
		 * be a no-op.
		 */
		public void unfollow(int followerId, int followeeId) {
			if (follow.get(followerId) != null) {
				follow.get(followerId).remove((Integer) followeeId);
			}
		}
	}

	public static void main(String[] args) {
		Twitter obj = new Twitter();
		obj.postTweet(2, 5);
		obj.follow(1, 2);
		obj.follow(1, 2);
		List<Integer> param_2 = obj.getNewsFeed(1);
		for (Integer i : param_2) {
			System.out.print(i + ",");
		}
	}

	/**
	 * Your Twitter object will be instantiated and called as such: Twitter obj
	 * = new Twitter(); obj.postTweet(userId,tweetId); List<Integer> param_2 =
	 * obj.getNewsFeed(userId); obj.follow(followerId,followeeId);
	 * obj.unfollow(followerId,followeeId);
	 */
}
